package com.wcode.conference.data.show;

import com.wcode.conference.model.Conference;
import com.wcode.conference.model.Talk;
import com.wcode.conference.model.Track;
import com.wcode.conference.utils.CsvWriterSimple;
import com.wcode.conference.utils.LoggingConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static com.wcode.conference.constant.ConferenceConstant.*;
import static com.wcode.conference.utils.Utils.createTimeToDate;

public class ShowData {

    private static Logger logger = LoggingConfiguration.getLOGGER();
    private Conference conference;

    private static final String[] HEADER = {"Hora", "Titulo de la presentacion", "Duraccion"};


    public ShowData(Conference conference) {
        this.conference = conference;
    }

    public void showDataConsole() throws Exception {
        logger.info(LOG_ORGANIZATION_CONFERENCE + conference.getTittle());
        int trackCount = 1;

        System.out.println(Arrays.toString(HEADER));
        for(Track track : conference.getTracks()){
            System.out.println(TRACKS + trackCount);

            createScheduleConsole(createTimeToDate(track.getMorningSession().TIME_START_SESSION, PATTERNS_HHMMSS)
                    ,track.getMorningSession().getTalksList());

            createScheduleConsole(createTimeToDate(track.getAfternoonSession().TIME_START_SESSION, PATTERNS_HHMMSS)
                    ,track.getAfternoonSession().getTalksList());

            trackCount += 1;
        }

    }

    public void printDataCvs(String path) throws Exception{

        logger.info(LOG_GENERATION_CSV);

        int trackCount = 1;
        List<String[]> output = new ArrayList<>();

        String[] tracks = new String[1];


        output.add(HEADER);
        for(Track track : conference.getTracks()){
            tracks[0] = TRACKS + trackCount;

            output.addAll(createScheduleCsv(createTimeToDate(track.getMorningSession().TIME_START_SESSION, PATTERNS_HHMMSS)
                    ,track.getMorningSession().getTalksList()));

            output.addAll(createScheduleCsv(createTimeToDate(track.getAfternoonSession().TIME_START_SESSION, PATTERNS_HHMMSS)
                    ,track.getAfternoonSession().getTalksList()));

            trackCount += 1;
        }

        CsvWriterSimple writer = new CsvWriterSimple();
        writer.writeToCsvFile(output, new File(path));

        logger.info(LOG_RESULT_FILE + path);



    }

    private List<String[]> createScheduleCsv(Date date, List<Talk> talkList) throws Exception {
        List<String[]> list = new ArrayList<>();

        for(Talk talk : talkList){
            date.setMinutes(date.getMinutes()+talkList.get(0).getDuration());
            String[] addTalk = {date.getHours()+":"+date.getMinutes()+":"+date.getSeconds(), talk.getTittle(), String.valueOf(talk.getDuration())};
            list.add(addTalk);
        }

        return list;

    }

    private void createScheduleConsole(Date date, List<Talk> talkList) throws Exception {

        for(Talk talk : talkList){
            String[] addTalk = {date.getHours()+":"+date.getMinutes()+":"+date.getSeconds(), talk.getTittle(), String.valueOf(talk.getDuration())};
            System.out.println(Arrays.toString(addTalk));
            date.setMinutes(date.getMinutes()+talkList.get(0).getDuration());
        }


    }





}
