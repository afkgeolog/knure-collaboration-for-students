package schedule.unit.cist;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import schedule.cist.UniversityObjectJson;
import schedule.models.ClassroomType;
import utils.FileContent;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

/**
 * @author Vladyslav Dovhopol
 */
@SpringBootTest
public class UniversityObjectJsonTest {

    private final UniversityObjectJson universityObjectJson;

    public UniversityObjectJsonTest() throws IllegalAccessException, InvocationTargetException, InstantiationException,
                                             NoSuchMethodException {
        Constructor constructor = UniversityObjectJson.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        universityObjectJson = (UniversityObjectJson) constructor.newInstance();
        constructor.setAccessible(false);
    }

    @Test
    public void mapClassroomTypesToModel_CistResponse_Valid() throws IOException {
        String universityJson = new FileContent(Directory.PATH + "universityObjectClassroomTypes.json").read();
        Collection<ClassroomType> classroomTypes = universityObjectJson.mapClassroomTypesToModels(universityJson);

        assertThat(classroomTypes, hasSize(42));
        assertThat(classroomTypes.iterator().next().getId(), equalTo(33));
        assertThat(classroomTypes.iterator().next().getName(), equalTo("ОП"));
    }
}
