package schedule.unit.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import schedule.models.Professor;

/**
 * @author Vladyslav Dovhopol
 */
@SpringBootTest
public class ProfessorTest {

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Professor.class)
                .usingGetClass()
                .withIgnoredFields("nameWithInitials", "fullName")
                .verify();
    }
}
