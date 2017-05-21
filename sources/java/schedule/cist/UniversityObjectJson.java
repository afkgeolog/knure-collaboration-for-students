package schedule.cist;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import university.models.ClassroomType;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

/**
 * Maps json responses to domain models.
 * @see UniversityObjectApi
 *
 * @author Vladyslav Dovhopol
 */
class UniversityObjectJson {

    public Collection<ClassroomType> mapClassroomTypesToModels(String cistResponse) throws IOException {
        JsonNode jsonNode = new ObjectMapper().reader().readTree(cistResponse);
        JsonNode classroomTypesNode = jsonNode.get("auditory_types");
        ObjectReader typeReader = new ObjectMapper().readerFor(ClassroomType.class);

        Collection<ClassroomType> result = new HashSet<>();
        for (JsonNode typeNode : classroomTypesNode) {
            ClassroomType type = typeReader.readValue(typeNode);
            result.add(type);
        }
        return result;
    }
}
