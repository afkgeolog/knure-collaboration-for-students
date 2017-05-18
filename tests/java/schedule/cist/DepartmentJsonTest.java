package schedule.cist;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import university.models.Department;
import utils.JsonFileContent;

import java.io.IOException;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author Vladyslav Dovhopol
 */
@SpringBootTest
public class DepartmentJsonTest {

    @Test
    public void mapDepartments_JsonArray_Valid() throws IOException {
        JsonNode facultiesJson = new JsonFileContent(Directory.PATH + "departments.json").read();
        Collection<Department> departments = new DepartmentJson().mapToObjects(facultiesJson);
        Department department = departments.iterator().next();

        assertThat(departments, hasSize(2));
        assertThat(department.getId(), equalTo((short) 4));
        assertThat(department.getShortName(), equalTo("ВМ"));
        assertThat(department.getFullName(), equalTo("Кафедра вищої математики"));
        assertThat(department.getProfessors(), hasSize(1));
    }
}
