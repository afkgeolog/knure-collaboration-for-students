package schedule.cist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import schedule.models.ClassroomType;

import java.io.IOException;
import java.util.Collection;

/**
 * Fetch concrete object or array of objects from university structure.
 * @author Vladyslav Dovhopol
 */
@Service
public class UniversityObject implements UniversityObjectApi {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Collection<ClassroomType> fetchClassroomTypes() throws IOException {
        String response = restTemplate.getForObject("/P_API_AUDITORY_TYPES_JSON", String.class);
        return new UniversityObjectJson().mapClassroomTypesToModels(response);
    }
}
