package schedule.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author Vladyslav Dovhopol
 */
@SpringBootTest
public class ClassroomTest {

    @Test
    public void addTypes_TwoEqual_FirstKept() {
        Classroom classroom = new Classroom(1, "", (byte) 1);
        final Integer classroomTypeId = 1;
        classroom.addType(new ClassroomType(classroomTypeId, "PI"));
        classroom.addType(new ClassroomType(classroomTypeId, "CS"));

        assertThat(classroom.getTypes(), hasSize(1));
        assertThat(classroom.getTypes().iterator().next().getName(), equalTo("PI"));
    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Classroom.class)
                .usingGetClass()
                .withIgnoredFields("name", "floor", "hasPowerSocket", "types")
                .verify();
    }
}
