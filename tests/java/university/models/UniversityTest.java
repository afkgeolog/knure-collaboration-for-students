package university.models;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;

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
        final Short facultyId = 1;
        Faculty firstFaculty = new Faculty(facultyId, "first", "");
        Faculty secondFaculty = new Faculty(facultyId, "second", "");
        Collection<Faculty> facultyCollection = Arrays.asList(firstFaculty, secondFaculty);

        University university = new University("", "");
        university.addFaculties(facultyCollection);

        assertThat(university.getFaculties(), hasSize(1));
        assertThat(university.getFaculties().iterator().next().getShortName(), equalTo("first"));
    }
}
