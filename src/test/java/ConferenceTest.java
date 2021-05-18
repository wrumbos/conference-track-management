import com.wcode.conference.core.CoreConference;
import com.wcode.conference.model.Conference;
import com.wcode.conference.utils.ConfigProperties;
import com.wcode.conference.utils.LoggingConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ConferenceTest {

    CoreConference coreConference;

    @BeforeEach
    public void setUp() throws Exception {
        LoggingConfiguration.getInstance();
        ConfigProperties.getInstance();
        this.coreConference = new CoreConference();
    }

    @Test
    @DisplayName("Crear Conferencia - Datos correctos")
    public void conferenceSucessfull() {
        Conference conference =  coreConference.createConference("resources/file.csv");
        int trackSize = conference.getTracks().size();
        assertEquals(2, trackSize,
                "La Conferencia debe poseer dos (2) Tracks");
    }

    @Test
    @DisplayName("Crear Conferencia - Excede el tiempo Maximo")
    public void conferenceMoreData() {
        Conference conference =  coreConference.createConference("resources/MoreData.csv");
        int trackSize = conference.getTracks().size();
        assertEquals(0, trackSize,
                "La Conferencia no deber poseer mas de 840 minutos de charlas");
    }

    @Test
    @DisplayName("Crear Conferencia - Carecer el tiempo de las charlas")
    public void conferenceLessData() {
        Conference conference =  coreConference.createConference("resources/LessData.csv");
        int trackSize = conference.getTracks().size();
        assertEquals(0, trackSize,
                "La Conferencia no deber poseer mas de 840 minutos de charlas");
    }

    @Test
    @DisplayName("Crear Conferencia - Titulos con numeros")
    public void conferenceWrongTittle() {
        Conference conference =  coreConference.createConference("resources/WrongDataTittle.csv");
        int trackSize = conference.getTracks().size();
        assertEquals(0, trackSize,
                "La Conferencia no deber poseer datos numericos en los titulos de las charlas");
    }

    @Test
    @DisplayName("Crear Conferencia - Charlas menores de 5 minutos")
    public void conferenceWrongTime() {
        Conference conference =  coreConference.createConference("resources/WrongDataTime.csv");
        int trackSize = conference.getTracks().size();
        assertEquals(0, trackSize,
                "La Conferencia no deber poseer charlas menores de 5 minutos");
    }

    @Test
    @DisplayName("Crear Conferencia - Tipo de tiempo correcto")
    public void conferenceWrongTypeTime() {
        Conference conference =  coreConference.createConference("resources/WrongDataTypeTime.csv");
        int trackSize = conference.getTracks().size();
        assertEquals(0, trackSize,
                "La Conferencia no deber poseer tiempos que no sea el indicado");
    }

}
