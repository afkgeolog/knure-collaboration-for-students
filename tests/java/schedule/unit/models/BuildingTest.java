package schedule.unit.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import schedule.models.Building;
import schedule.models.Classroom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author Vladyslav Dovhopol
 */
@SpringBootTest
public class BuildingTest {

    @Test
    public void addClassrooms_TwoEqual_KeptFirst() {
        Building building = new Building("a", "");
        Integer classroomId = 1;
        building.addClassroom(new Classroom(classroomId, "first", (byte) 1));
        building.addClassroom(new Classroom(classroomId, "second", (byte) 1));

        assertThat(building.getClassrooms(), hasSize(1));
        assertThat(building.getClassrooms().iterator().next().getName(), equalTo("first"));
    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Building.class)
                .usingGetClass()
                .withIgnoredFields("fullName", "classrooms")
                .verify();
    }
}
