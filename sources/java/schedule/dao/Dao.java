package schedule.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Vladyslav Dovhopol
 */
abstract class Dao {

    @PersistenceContext
    EntityManager entityManager;

    //FIXME: this code doesn't manage removed or detached objects.
    final boolean doesEntityExist(Object entity, Object entityId) {
        return entityManager.contains(entity) || entityManager.find(entity.getClass(), entityId) != null;
    }
}
