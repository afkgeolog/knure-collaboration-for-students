package schedule.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * @author Vladyslav Dovhopol
 */
public class SpecialityTest {

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Speciality.class)
                .usingGetClass()
                .withIgnoredFields("abbreviation", "name", "groups")
                .verify();
    }
}
