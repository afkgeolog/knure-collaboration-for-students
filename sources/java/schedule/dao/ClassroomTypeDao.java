package schedule.dao;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import schedule.models.ClassroomType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Vladyslav Dovhopol
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ClassroomTypeDao {

    @PersistenceContext
    private EntityManager entityManager;

    //TODO: Calling persist is not enough to insert entity.
    /* What if the entity is already in persistence context and need to be merged. What if entity is detached.
       JPA entity lifecycle states other than "new" aren't managed.
     */

    /**
     * Insert new classroom type to the database.
     * @param classroomType new classroom type.
     * @throws javax.persistence.EntityExistsException when entity with the same key is already persisted.
     */
    public void insert(ClassroomType classroomType) {
        entityManager.persist(classroomType);
    }
}
