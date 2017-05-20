package schedule.cist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import university.models.University;

import java.io.IOException;

/**
 * @author Vladyslav Dovhopol
 * @see UniversityStructureApi
 */
@Service
class UniversityStructure implements UniversityStructureApi{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public University fetchProfessors() throws IOException {
        String professorsResponse = restTemplate.getForObject("/P_API_PODR_JSON", String.class);
        return new UniversityStructureJson().mapToModel(professorsResponse);
    }

    @Override
    public University fetchGroups() {
        throw new UnsupportedOperationException("The operation not supported.");
    }

    @Override
    public University fetchClassrooms() throws IOException {
        String classroomsResponse = restTemplate.getForObject("/P_API_AUDITORIES_JSON", String.class);
        return new UniversityStructureJson().mapToModel(classroomsResponse);
    }
}
