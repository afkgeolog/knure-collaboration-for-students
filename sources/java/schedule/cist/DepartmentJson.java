package schedule.cist;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import university.models.Department;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Vladyslav Dovhopol
 */
class DepartmentJson {

    public Collection<Department> mapToObjects(@NotNull JsonNode departmentsJson) throws IOException {
        Collection<Department> result = new ArrayList<>();
        ObjectReader departmentReader = new ObjectMapper().readerFor(Department.class);
        for (JsonNode departmentJson : departmentsJson) {
            Department department = departmentReader.readValue(departmentJson);
            result.add(department);
        }
        return result;
    }
}
