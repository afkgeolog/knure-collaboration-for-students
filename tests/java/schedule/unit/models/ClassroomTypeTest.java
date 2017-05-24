package schedule.unit.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import schedule.models.ClassroomType;

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
