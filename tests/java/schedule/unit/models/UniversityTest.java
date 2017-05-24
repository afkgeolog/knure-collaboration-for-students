package schedule.unit.models;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import schedule.models.Faculty;
import schedule.models.University;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

/**
 * @author Vladyslav Dovhopol
 */
@SpringBootTest
public class UniversityTest {

    @Test
    public void addFaculties_TwoEqual_FirstKept() {
        University university = new University("", "");
        final Short facultyId = 1;
        university.addFaculty(new Faculty(facultyId, "first", ""));
        university.addFaculty(new Faculty(facultyId, "second", ""));

        assertThat(university.getFaculties(), hasSize(1));
        assertThat(university.getFaculties().iterator().next().getAbbreviation(), equalTo("first"));
    }
}
