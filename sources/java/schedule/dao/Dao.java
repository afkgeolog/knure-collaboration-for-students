package schedule.dao;

import schedule.models.ClassroomType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Vladyslav Dovhopol
 */
abstract class Dao {

    @PersistenceContext
    protected EntityManager entityManager;

    //FIXME: this code doesn't manage removed or detached objects.
    protected final boolean doesEntityExist(Class entityClass, Object entity, Object entityId) {
        return entityManager.contains(entity) || entityManager.find(ClassroomType.class, entityId) != null;
    }
}
