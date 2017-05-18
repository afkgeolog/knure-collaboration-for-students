package schedule.cist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import university.models.University;

import java.io.IOException;

/**
 * @author Vladyslav Dovhopol
 */
@Service
class UniversityStructure implements UniversityStructureApi{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public University fetchProfessors() throws IOException {
        String facultiesResponse = restTemplate.getForObject("/P_API_PODR_JSON", String.class);
        University university = new UniversityStructureJson().mapToModel(facultiesResponse);

        return university;
    }

    @Override
    public University fetchGroups() {
        throw new UnsupportedOperationException("The operation is not supported.");
    }

    @Override
    public University fetchAuditories() {
        throw new UnsupportedOperationException("The operation not supported.");
    }
}
