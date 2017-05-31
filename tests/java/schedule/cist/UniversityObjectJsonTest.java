package schedule.cist;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import schedule.models.ClassroomType;
import utils.FileContent;
import utils.TestClassDirectory;

import java.io.IOException;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

/**
 * @author Vladyslav Dovhopol
 */
@SpringBootTest
public class UniversityObjectJsonTest {

    private final String DIRECTORY = TestClassDirectory.getPath(getClass());
    private final UniversityObjectJson universityObjectJson = new UniversityObjectJson();

    @Test
    public void mapClassroomTypesToModel_CistResponse_Valid() throws IOException {
        String universityJson = new FileContent(DIRECTORY + "universityObjectClassroomTypes.json").read();
        Collection<ClassroomType> classroomTypes = universityObjectJson.mapClassroomTypesToModels(universityJson);

        assertThat(classroomTypes, hasSize(42));
        assertThat(classroomTypes.iterator().next().getId(), equalTo(33));
        assertThat(classroomTypes.iterator().next().getName(), equalTo("ОП"));
    }
}
