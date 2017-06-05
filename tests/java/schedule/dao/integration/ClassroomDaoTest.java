package schedule.dao.integration;

import infrastructure.config.HibernateConfiguration;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import schedule.dao.ClassroomDao;

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
public class ClassroomDaoTest {

    @Autowired
    private ClassroomDao dao;

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("JpaQlInspection")
    @Before
    public void deleteAllClassrooms() {
        Query query = entityManager.createQuery("DELETE FROM Classroom");
        query.executeUpdate();
    }
}
