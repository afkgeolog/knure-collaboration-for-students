package schedule.cist;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import university.models.Professor;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Vladyslav Dovhopol
 */
class ProfessorJson {

    public Collection<Professor> mapToObjects(@NotNull JsonNode professorsJson) throws IOException {
        Collection<Professor> result = new ArrayList<>();
        ObjectReader professorReader = new ObjectMapper().readerFor(Professor.class);
        for (JsonNode professorJson : professorsJson) {
            Professor professor = professorReader.readValue(professorJson);
            result.add(professor);
        }
        return result;
    }
}
