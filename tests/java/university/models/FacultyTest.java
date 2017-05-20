package university.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

/**
 * @author Vladyslav Dovhopol
 */
@SpringBootTest
public class FacultyTest {

    @Test
    public void addDepartments_TwoEqual_FirstKept() {
        Faculty faculty = new Faculty(Short.valueOf("1"), "", "");
        Short departmentId = Short.valueOf("1");
        faculty.addDepartment(new Department(departmentId, "first", ""));
        faculty.addDepartment(new Department(departmentId, "second", ""));

        assertThat(faculty.getDepartments(), hasSize(1));
        assertThat(faculty.getDepartments().iterator().next().getAbbreviation(), equalTo("first"));
    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Faculty.class)
                .usingGetClass()
                .withIgnoredFields("abbreviation", "name", "departments")
                .verify();
    }
}
