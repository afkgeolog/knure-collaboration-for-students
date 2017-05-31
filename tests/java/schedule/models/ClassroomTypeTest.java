package schedule.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * @author Vladyslav Dovhopol
 */
public class ClassroomTypeTest {

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(ClassroomType.class)
                .usingGetClass()
                .withIgnoredFields("name")
                .verify();
    }
}
