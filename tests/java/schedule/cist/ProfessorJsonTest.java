package schedule.cist;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import university.models.Professor;
import utils.JsonFileContent;

import java.io.IOException;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * @author Vladyslav Dovhopol
 */
@SpringBootTest
public class ProfessorJsonTest {

    @Test
    public void mapProfessors_JsonArray_Valid() throws IOException {
        JsonNode professorsJson = new JsonFileContent(Directory.PATH + "professors.json").read();
        Collection<Professor> professors = new ProfessorJson().mapToObjects(professorsJson);
        Professor professor = professors.iterator().next();

        assertThat(professors, hasSize(2));
        assertThat(professor.getId(), equalTo(394));
        assertThat(professor.getShortName(), equalTo("Афанасьєв В. О."));
        assertThat(professor.getFullName(), equalTo("Афанасьєв Вадім Олексійович"));
    }

    @Test(expected = IOException.class)
    public void mapProfessor_WithoutId_Exception() throws IOException {
        JsonNode professorsJson = new JsonFileContent(Directory.PATH + "professorWithoutId.json").read();
        new ProfessorJson().mapToObjects(professorsJson);
    }

    @Test
    public void mapProfessor_WithoutShortName_Valid() throws IOException {
        JsonNode professorsJson = new JsonFileContent(Directory.PATH + "professorWithoutShortName.json").read();
        Collection<Professor> professors = new ProfessorJson().mapToObjects(professorsJson);
        Professor professor = professors.iterator().next();

        assertThat(professor.getShortName(), is(nullValue()));
        assertThat(professor.getFullName(), equalTo("Афанасьєв Вадім Олексійович"));
    }
}
