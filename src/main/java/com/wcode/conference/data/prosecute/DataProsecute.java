package com.wcode.conference.data.prosecute;

import com.wcode.conference.core.Core;
import com.wcode.conference.data.validate.DataValidate;
import com.wcode.conference.model.MatchInput;
import com.wcode.conference.model.Talk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataProsecute {

    public List<Talk> getTalkSession(Map<Integer, List<MatchInput>> data, int lineTime, int[] time,
                                            int[] profit, int[] timeUnid){

        Map<Integer, Integer> conferences = processDataCore(lineTime, time, profit, timeUnid);

        List<Talk> talksList = new ArrayList<>();

        for (Map.Entry<Integer,Integer> entry : conferences.entrySet()){

            int value = (entry.getValue() < data.get(entry.getKey()).size())
                    ? entry.getValue() : data.get(entry.getKey()).size();
            int count = 1;

            while (count <= value){
                if(!data.get(entry.getKey()).isEmpty()){
                    String tittle = data.get(entry.getKey()).get(0).getTittle();
                    int duration = data.get(entry.getKey()).get(0).getTime();
                    talksList.add(new Talk(tittle, duration));
                    data.get(entry.getKey()).remove(0);
                    count += 1;
                }
            }

        }
        return talksList;
    }



    public Map<Integer, Integer> processDataCore(int lineTime, int[] time, int[] profit, int[] timeUnid){
        Core core = new Core();
        int[][] allCombinations = core.calculateConferences(lineTime, time, profit);
        Map<Integer, Integer> bestOptions = core.processConferences(lineTime, time, timeUnid,allCombinations);

        return bestOptions;
    }

    public List<Talk> getListTalks(int time, Map<Integer, List<MatchInput>> data, Talk lastTalk){
        DataValidate dataValidate = new DataValidate();
        dataValidate.setMapPossibleTimeCombinations(data, time);
        dataValidate.possibleTimeCombinations();

        List<Talk> talks = getTalkSession(data, time,
                dataValidate.getTime(), dataValidate.getProfit(), dataValidate.getTimeUnid());

        talks.add(lastTalk);

        return talks;

    }

}
