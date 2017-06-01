package infrastructure.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import schedule.cist.UniversityStructureApi;
import schedule.dao.ClassroomDao;
import schedule.dao.ClassroomTypeDao;
import schedule.models.Building;
import schedule.models.Classroom;
import schedule.models.University;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author Vladyslav Dovhopol
 */
@Component
final class InitializeUniversityStructureTask implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private UniversityStructureApi universityStructure;

    @Autowired
    private ClassroomTypeDao classroomTypeDao;

    @Autowired
    private ClassroomDao classroomDao;

    @Transactional
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            University university = universityStructure.fetchClassrooms();
            Logger.getAnonymousLogger().info("University structure has been downloaded.");

            for (final Building building : university.getBuildings()) {
                for (final Classroom classroom : building.getClassrooms()) {
//                    classroomDao.insert(classroom);
                }
            }
            Logger.getAnonymousLogger().info("Classroom types have been saved.");
        } catch (IOException e) {
            Logger.getAnonymousLogger().severe("University structure hasn't been loaded.");
        }
    }
}
