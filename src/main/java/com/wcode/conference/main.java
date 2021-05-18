package com.wcode.conference;

import com.wcode.conference.core.CoreConference;
import com.wcode.conference.data.show.ShowData;
import com.wcode.conference.utils.ConfigProperties;
import com.wcode.conference.utils.LoggingConfiguration;

import java.util.logging.Logger;

import static com.wcode.conference.constant.ConferenceConstant.*;

public class main {

    private static Logger logger = LoggingConfiguration.getLOGGER();

    public static void main(String[] args) throws Exception {
        LoggingConfiguration.getInstance();
        ConfigProperties.getInstance();

        CoreConference coreConference = new CoreConference();

        ShowData showData = new ShowData(coreConference.createConference(PATH_RESOURCES_FILE));
        showData.printDataCvs(PATH_RESOURCES_CONFERENCE);
        showData.showDataConsole();



    }

}
