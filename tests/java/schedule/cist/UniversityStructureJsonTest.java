package schedule.cist;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import university.models.University;
import utils.FileContent;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author Vladyslav Dovhopol
 */
@SpringBootTest
public class UniversityStructureJsonTest {

    private final UniversityStructureJson parser = new UniversityStructureJson();

    @Test
    public void mapFacultiesResponse_JsonObject_Valid() throws IOException {
        String universityJson = new FileContent(Directory.PATH + "universityStructureFaculties.json").read();
        University university = parser.mapToModel(universityJson);

        assertThat(university.getShortName(), equalTo("ХНУРЕ"));
        assertThat(university.getFullName(), equalTo("Харківський Національний Університет Радіоелектроніки"));
        assertThat(university.getFaculties(), hasSize(1));
    }
}
