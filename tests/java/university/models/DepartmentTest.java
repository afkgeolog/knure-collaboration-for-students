package university.models;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;

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
        final Integer id = 1;
        Professor firstProfessor = new Professor(id, "first", "");
        Professor secondProfessor = new Professor(id, "second", "");
        Collection<Professor> professorCollection = Arrays.asList(firstProfessor, secondProfessor);

        Department department = new Department(Short.valueOf("1"), "dep", "department");
        department.addProfessors(professorCollection);

        assertThat(department.getProfessors(), hasSize(1));
        assertThat(department.getProfessors().iterator().next().getShortName(), equalTo("first"));
    }
}
