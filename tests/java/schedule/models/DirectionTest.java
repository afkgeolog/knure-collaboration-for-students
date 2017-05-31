package schedule.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Vladyslav Dovhopol
 */
@SpringBootTest
public class DirectionTest {

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Direction.class)
                .usingGetClass()
                .withIgnoredFields("abbreviation", "name", "bachelorGroups", "specialities")
                .verify();
    }
}
