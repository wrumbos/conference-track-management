package com.wcode.conference.data.validate;

import com.wcode.conference.model.MatchInput;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataValidate {

    Map<Integer, Integer> mapPossibleTimeCombinations;
    int[] time;
    int[] profit;
    int[] timeUnid;

    public void possibleTimeCombinations(){

        int sizeArrays = mapPossibleTimeCombinations.values().stream().reduce(0, Integer::sum) + 1;
        int countArray = 1;


        int[] time = new int[sizeArrays];
        int[] profit = new int[sizeArrays];
        int[] timeUnid = new int[sizeArrays];

        time[0] = 0;
        profit[0] = 0;
        timeUnid[0] = 0;

        for (Map.Entry<Integer,Integer> entry : mapPossibleTimeCombinations.entrySet()){
            int value = entry.getValue();
            int count = 1;
            while (count <= value){
                time[countArray] = entry.getKey() * count;
                profit[countArray] = time[countArray] + count;
                timeUnid[countArray] = entry.getKey();
                count += 1;
                countArray += 1;
            }

        }

        Arrays.sort(time);
        Arrays.sort(profit);
        Arrays.sort(timeUnid);

        this.time = time;
        this.profit = profit;
        this.timeUnid = timeUnid;

    }


    public void setMapPossibleTimeCombinations(Map<Integer, List<MatchInput>> data, int maxTime) {
        Map<Integer, Integer> response = new HashMap<>();

        data.forEach((k, v) ->{
            if(k <= maxTime){
                if( k * v.size() <= maxTime){
                    response.put(k, v.size());
                }else{
                    response.put(k, maxTime / k);
                }
            }
        });
        this.mapPossibleTimeCombinations = response;
    }

    public Map<Integer, Integer> getMapPossibleTimeCombinations() {
        return mapPossibleTimeCombinations;
    }

    public int[] getTime() {
        return time;
    }

    public void setTime(int[] time) {
        this.time = time;
    }

    public int[] getProfit() {
        return profit;
    }

    public void setProfit(int[] profit) {
        this.profit = profit;
    }

    public int[] getTimeUnid() {
        return timeUnid;
    }

    public void setTimeUnid(int[] timeUnid) {
        this.timeUnid = timeUnid;
    }




}
