package com.wcode.conference.data.match;

import com.wcode.conference.model.MatchInput;
import com.wcode.conference.utils.LoggingConfiguration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.logging.Logger;

import static com.wcode.conference.constant.ConferenceConstant.*;

public class DataMatch {

    private Map<Integer, List<MatchInput>> data = new HashMap<>();
    private int totalTime = 0;
    private String path;

    private static DataMatchController dataMatchController;

    private static Logger logger = LoggingConfiguration.getLOGGER();

    public DataMatch(String path){
        this.path = path;
    }

    private static void initDataMatch(){
        dataMatchController = new DataMatchController();
        DataMatchMiddleware dataMatchMiddleware = new TypeTimeCheck(dataMatchController);
        dataMatchMiddleware.linkWith(new NumberCheck(dataMatchController));
        dataMatchController.setDataValidationMiddleware(dataMatchMiddleware);
    }



    public void processDataMatch(int maxTime) throws Exception{
        initDataMatch();

        boolean validation;

        BufferedReader br = new BufferedReader(new FileReader(this.path));

        String line;

        while ((line = br.readLine()) != null) {
            String[] values = line.split(COMMA);
            validation = dataMatchController.processData(values[0], values[1], values[2], maxTime);
            if(validation){
                int time = Integer.parseInt(values[1]);
                this.setData(values[0], time);
                totalTime += time;
            }else{
                logger.info(LOG_ERROR_PROCESS_TALKS + Arrays.toString(values));
                logger.info(LOG_TRY_AGAIN);
                throw new Exception(ERROR_DATA);
            }
        }

    }

    public void setData(String tittle, int time) {
        if(this.data.containsKey(time)){
            MatchInput matchInput = new MatchInput(tittle, time);
            this.data.get(time).add(matchInput);
        }else{
            List<MatchInput> list = new ArrayList<>();
            MatchInput matchInput = new MatchInput(tittle, time);
            list.add(matchInput);
            this.data.put(time, list);
        }
    }

    public Map<Integer, List<MatchInput>> getData() {
        return data;
    }

    public int getTotalTime() {
        return totalTime;
    }


}
