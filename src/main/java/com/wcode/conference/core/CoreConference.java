package com.wcode.conference.core;

import com.wcode.conference.data.match.DataMatch;
import com.wcode.conference.data.prosecute.DataProsecute;
import com.wcode.conference.model.*;
import com.wcode.conference.utils.LoggingConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.wcode.conference.constant.ConferenceConstant.*;

public class CoreConference {

    private static Logger logger = LoggingConfiguration.getLOGGER();

    public Conference createConference(String path){

        Conference conference = new Conference();
        List<Track> trackList = new ArrayList<>();

        try{
            DataMatch dataMatch = new DataMatch(path);

            dataMatch.processDataMatch(conference.MAX_TIME_TALKS);

            int totalTime = dataMatch.getTotalTime();
            int maxTrack = conference.MAXI_TIME_CONFERENCE;
            int minTrack = conference.MINI_TIME_CONFERENCE;
            int countTrack = 1;

            if(totalTime <= maxTrack && totalTime >= minTrack){

                while(totalTime >= minTrack && countTrack <= conference.MAX_COUNT_TRACKS){

                    MorningSession morningSession = new MorningSession();
                    AfternoonSession afternoonSession = new AfternoonSession();

                    int timeMorning = 0;
                    int timeAfternoon = 0;

                    if(totalTime >= maxTrack){
                        timeMorning = morningSession.MAXI_TIME_SESSION;
                        timeAfternoon = afternoonSession.MAXI_TIME_SESSION;
                    }else{
                        timeMorning = morningSession.MINI_TIME_SESSION;
                        timeAfternoon = afternoonSession.MINI_TIME_SESSION;
                    }

                    DataProsecute dateProsecute = new DataProsecute();

                    List<Talk> talkMorningSession =
                            dateProsecute.getListTalks(timeMorning, dataMatch.getData(),
                                    new Talk(TALK_LUNCH_TIME, 60));

                    morningSession.setTalkList(talkMorningSession);


                    List<Talk> lastAfternoonTalkTalks =
                            dateProsecute.getListTalks(timeAfternoon, dataMatch.getData(),
                                    new Talk(TALK_NETWORKIN, 60));


                    afternoonSession.setTalkList(lastAfternoonTalkTalks);

                    trackList.add(new Track(morningSession, afternoonSession));


                    totalTime -= timeMorning + timeAfternoon;
                    countTrack += 1;

                }

                conference.setTittle(TALK_TITTLE);
            }else{
                logger.info(LOG_COUNT_ELEMENTS);
                throw new Exception(ERROR_COUNT_TALK);
            }

        } catch (Exception e) {
            logger.info(ERROR_CONFERENCE);
            e.printStackTrace();
        }

        conference.setTracks(trackList);

        return conference;
    }

}
