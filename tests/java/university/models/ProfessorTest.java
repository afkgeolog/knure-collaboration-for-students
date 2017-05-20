package university.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Vladyslav Dovhopol
 */
@SpringBootTest
public class ProfessorTest {

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Professor.class)
                .usingGetClass()
                .withIgnoredFields("shortName", "fullName")
                .verify();
    }
}
