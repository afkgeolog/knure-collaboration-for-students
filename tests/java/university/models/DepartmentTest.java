package university.models;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author Vladyslav Dovhopol
 */
@SpringBootTest
public class DepartmentTest {

    @Test
    public void addProfessors_TwoEqual_FirstKept() {
        Department department = new Department(Short.valueOf("1"), "dep", "department");
        final Integer professorId = 1;
        department.addProfessor(new Professor(professorId, "first", ""));
        department.addProfessor(new Professor(professorId, "second", ""));

        assertThat(department.getProfessors(), hasSize(1));
        assertThat(department.getProfessors().iterator().next().getShortName(), equalTo("first"));
    }
}
