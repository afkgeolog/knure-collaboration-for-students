package schedule.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import schedule.models.Classroom;
import schedule.models.ClassroomType;

import java.util.Collection;

/**
 * @author Vladyslav Dovhopol
 */
@Component
public class ClassroomDao extends Dao {

    private final ClassroomTypeDao typeDao;

    @Autowired
    public ClassroomDao(ClassroomTypeDao typeDao) {
        this.typeDao = typeDao;
    }

    public boolean insert(Classroom classroom) {
        if (!doesEntityExist(Classroom.class, classroom, classroom.getId())) {
            Collection<ClassroomType> types = classroom.getTypes();
            typeDao.insert(types);

            entityManager.persist(classroom);
            return true;
        } else {
            return false;
        }
    }
}
