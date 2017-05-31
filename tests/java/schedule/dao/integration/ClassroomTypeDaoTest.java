package schedule.dao.integration;

import infrastructure.config.HibernateConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import schedule.dao.ClassroomTypeDao;
import schedule.models.ClassroomType;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author Vladyslav Dovhopol
 */
@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"classpath:application.properties"})
@ContextConfiguration(classes = {HibernateConfiguration.class})
@Transactional
@Commit
public class ClassroomTypeDaoTest {

    @Autowired
    private ClassroomTypeDao dao;

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("JpaQlInspection")
    @Before
    public void deleteAllClassroomTypes() {
        Query query = entityManager.createQuery("DELETE FROM ClassroomType");
        query.executeUpdate();
    }

    @Test
    public void insert_ValidType_Saved() {
        ClassroomType type = new ClassroomType(1, "classroomType");
        dao.insert(type);
    }

    @Test(expected = EntityExistsException.class)
    @Rollback
    public void insert_TwoEqualTypes_Exception() {
        dao.insert(new ClassroomType(1, "firstType"));
        dao.insert(new ClassroomType(1, "secondType"));
    }
}
