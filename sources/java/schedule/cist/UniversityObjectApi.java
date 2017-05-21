package schedule.cist;

import university.models.ClassroomType;

import java.io.IOException;
import java.util.Collection;

/**
 * @author Vladyslav Dovhopol
 */
public interface UniversityObjectApi {

    Collection<ClassroomType> fetchClassroomTypes() throws IOException;
}
