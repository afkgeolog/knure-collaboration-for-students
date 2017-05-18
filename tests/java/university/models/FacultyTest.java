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
public class FacultyTest {

    @Test
    public void addDepartments_TwoEqual_FirstKept() {
        Short departmentId = Short.valueOf("1");
        Department firstDepartment = new Department(departmentId, "first", "");
        Department secondDepartment = new Department(departmentId, "second", "");
        Collection<Department> departmentCollection = Arrays.asList(firstDepartment, secondDepartment);

        Faculty faculty = new Faculty(Short.valueOf("1"), "", "");
        faculty.addDepartments(departmentCollection);

        assertThat(faculty.getDepartments(), hasSize(1));
        assertThat(faculty.getDepartments().iterator().next().getShortName(), equalTo("first"));
    }
}
