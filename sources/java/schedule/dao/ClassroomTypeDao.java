package schedule.dao;

import org.springframework.stereotype.Component;
import schedule.models.ClassroomType;

/**
 * @author Vladyslav Dovhopol
 */
@Component
public class ClassroomTypeDao extends Dao {

    /**
     * Insert new classroom type to the database.
     * @param classroomType new classroom type.
     * @return True if object has been inserted, otherwise - false.
     */
    public boolean insert(ClassroomType classroomType) {
        if (!doesEntityExist(ClassroomType.class, classroomType, classroomType.getId())) {
            entityManager.persist(classroomType);
            return true;
        } else {
            return false;
        }
    }

    public void insert(Iterable<ClassroomType> classroomTypes) {
        for (ClassroomType type : classroomTypes) {
            insert(type);
        }
    }
}
