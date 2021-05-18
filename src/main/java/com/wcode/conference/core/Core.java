package com.wcode.conference.core;

import java.util.HashMap;
import java.util.Map;

public class Core {


    public int[][] calculateConferences(int totalTime, int[] time, int[] profit){

        int lenghtArray = time.length;

        int[][] result = new int[lenghtArray][(totalTime / 5) + 1];

        for(int i = 0; i < lenghtArray; i++){
            for(int w = 0; w <= totalTime; w+= 5){
                if(i == 0 || w == 0){
                    result[i][w / 5] = 0;
                }else if(time[i] <= w){
                    int beforeElement = result[i-1][w/5];
                    int element = (profit[i] + result[i-1][(w-time[i])/5]);
                    result[i][w/5] = Math.max(beforeElement, element);
                }else{
                    result[i][w / 5] = result[i-1][w/5];
                }
            }
        }

        return result;
    }

    public Map<Integer, Integer> processConferences(int totalTime, int[] time, int[] timeUnid, int[][] allPosibilites){
        int rows = time.length - 1;
        int columns = totalTime / 5;

        Map<Integer, Integer> response = new HashMap<>();

        while(rows > 0 && columns > 0){
            if(allPosibilites[rows][columns] == allPosibilites[rows-1][columns]){
                rows -= 1;
            }else{
                if(response.containsKey(timeUnid[rows])){
                    response.put(timeUnid[rows], response.get(timeUnid[rows]) +
                            (allPosibilites[rows][columns] / timeUnid[rows]));
                }else{
                    response.put(timeUnid[rows], (allPosibilites[rows][columns] / timeUnid[rows]));
                }
                columns = columns - time[rows];
                rows -= 1;

            }
        }
        return response;

    }

    public static void print(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

}
