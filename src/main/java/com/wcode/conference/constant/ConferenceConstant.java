package com.wcode.conference.constant;

public interface ConferenceConstant {

    //Path resources/file.csv"
    String PATH_RESOURCES_FILE = "resources/file.csv";
    String PATH_RESOURCES_CONFERENCE = "resources/conferences.csv";
    String PATH_CONFIG_PROPERTIES = "src/main/resources/config.properties";
    String PATH_LOG_PROPERTIES = "logging.properties";


    //TALKS
    String TALK_LUNCH_TIME = "Lunch Time";
    String TALK_NETWORKIN = "Networking Event";
    String TALK_TITTLE = "Nro. 185 de informatica";


    //LOGS
    String LOG_COUNT_ELEMENTS = "La Cantidad de elemtos no cumple con los requerimientos";
    String LOG_ORGANIZATION_CONFERENCE = "Organizacion de la conferencia: ";
    String LOG_GENERATION_CSV = "Generando resultado de la conferencia en archivo CVS";
    String LOG_RESULT_FILE = "El Resultado de la Conferencia se encuentran en el archivo:";
    String LOG_ERROR_PROCESS_TALKS = "Ha ocurrido un problema procesando la charla: ";
    String LOG_TRY_AGAIN = "Por favor vuelva a intentarlo";


    //EXCEPTION
    String ERROR_COUNT_TALK = "Error en la Cantidad de Charlas";
    String ERROR_CONFERENCE = "Ha ocurrido un error creando la conferencia";
    String ERROR_DATA = "Error con la data";

    //PATTERNS
    String PATTERNS_HHMMSS = "HH:mm:ss";
    String PATTERNS_NOT_NUMBERS = ".+[0-9]+.+";

    //OTHERS
    String TRACKS = "Track: ";
    String COMMA = ",";
    String TYPE_TIME_VALIDATE = "datavalidation.typetime";


}
