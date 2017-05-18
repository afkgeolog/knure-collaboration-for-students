package schedule.cist;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import university.models.Faculty;
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
public class FacultyJsonTest {

    @Test
    public void mapFaculties_JsonArray_Valid() throws IOException {
        JsonNode facultiesJson = new JsonFileContent(Directory.PATH + "faculties.json").read();
        Collection<Faculty> faculties = new FacultyJson().mapToObjects(facultiesJson);
        Faculty faculty = faculties.iterator().next();

        assertThat(faculties, hasSize(2));
        assertThat(faculty.getId(), equalTo((short) 56));
        assertThat(faculty.getShortName(), equalTo("ITM"));
        assertThat(faculty.getFullName(), equalTo("Факультет інформаційно - аналітичних технологій та менеджменту"));
        assertThat(faculty.getDepartments(), hasSize(1));
    }
}
