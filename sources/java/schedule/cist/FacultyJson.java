package schedule.cist;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import university.models.Faculty;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Vladyslav Dovhopol
 */
class FacultyJson {

    public Collection<Faculty> mapToObjects(@NotNull JsonNode facultiesJson) throws IOException {
        List<Faculty> result = new ArrayList<>();
        ObjectReader facultyReader = new ObjectMapper().readerFor(Faculty.class);
        for (JsonNode facultyJson : facultiesJson) {
            Faculty faculty = facultyReader.readValue(facultyJson);
            result.add(faculty);
        }
        return result;
    }
}
