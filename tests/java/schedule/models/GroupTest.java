package schedule.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Vladyslav Dovhopol
 */
@SpringBootTest
public class GroupTest {

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Group.class)
                .usingGetClass()
                .withIgnoredFields("name")
                .verify();
    }
}
