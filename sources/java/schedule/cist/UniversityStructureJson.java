package schedule.cist;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import schedule.models.University;

import java.io.IOException;

/**
 * @author Vladyslav Dovhopol
 */
final class UniversityStructureJson {

    public University mapToModel(String jsonString) throws IOException {
        JsonNode jsonNode = new ObjectMapper().reader().readTree(jsonString);
        JsonNode universityNode = jsonNode.get("university");
        ObjectReader universityReader = new ObjectMapper().readerFor(University.class);

        return universityReader.readValue(universityNode);
    }
}
