package schedule.cist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import schedule.models.University;

import java.io.IOException;

/**
 * @author Vladyslav Dovhopol
 * @see UniversityStructureApi
 */
@Service
class UniversityStructure implements UniversityStructureApi{

    private final RestTemplate restTemplate;

    @Autowired
    public UniversityStructure(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public University fetchProfessors() throws IOException {
        String professorsResponse = restTemplate.getForObject("/P_API_PODR_JSON", String.class);
        return new UniversityStructureJson().mapToModel(professorsResponse);
    }

    @Override
    public University fetchGroups() throws IOException {
        String groupsResponse = restTemplate.getForObject("/P_API_GROUP_JSON", String.class);
        return new UniversityStructureJson().mapToModel(groupsResponse);
    }

    @Override
    public University fetchClassrooms() throws IOException {
        String classroomsResponse = restTemplate.getForObject("/P_API_AUDITORIES_JSON", String.class);
        return new UniversityStructureJson().mapToModel(classroomsResponse);
    }
}
