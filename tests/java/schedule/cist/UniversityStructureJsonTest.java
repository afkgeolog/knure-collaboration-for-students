package schedule.cist;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import schedule.models.*;
import utils.FileContent;
import utils.TestClassDirectory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author Vladyslav Dovhopol
 */
@SpringBootTest
public class UniversityStructureJsonTest {

    private final String DIRECTORY = TestClassDirectory.getPath(getClass());

    private final UniversityStructureJson universityStructureJson = new UniversityStructureJson();

    @Test
    public void mapProfessorsResponse_JsonObject_Valid() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String universityJson = new FileContent(DIRECTORY + "universityStructureProfessors.json").read();
        University university = universityStructureJson.mapToModel(universityJson);

        assertThat(university.getAbbreviation(), equalTo("ХНУРЕ"));
        assertThat(university.getName(), equalTo("Харківський Національний Університет Радіоелектроніки"));

        final List<Faculty> faculties = new ArrayList<>(university.getFaculties());
        assertThat(faculties, hasSize(2));
        assertThat(faculties.get(0).getId(), equalTo((short) 56));
        assertThat(faculties.get(0).getAbbreviation(), equalTo("ITM"));
        assertThat(faculties.get(0).getName(),
                   equalTo("Факультет інформаційно - аналітичних технологій та менеджменту"));

        final List<Department> departments = new ArrayList<>(faculties.get(0).getDepartments());
        assertThat(departments, hasSize(2));
        assertThat(departments.get(0).getId(), equalTo((short) 4));
        assertThat(departments.get(0).getAbbreviation(), equalTo("ВМ"));
        assertThat(departments.get(0).getName(), equalTo("Кафедра вищої математики"));


        final List<Professor> professors = new ArrayList<>(departments.get(0).getProfessors());
        assertThat(professors, hasSize(2));
        assertThat(professors.get(1).getId(), equalTo(394));
        assertThat(professors.get(1).getNameWithInitials(), equalTo("Афанасьєв В. О."));
        assertThat(professors.get(1).getFullName(), equalTo("Афанасьєв Вадім Олексійович"));
    }

    @Test
    public void mapClassroomsResponse_JsonObject_Valid() throws IOException {
        String universityJson = new FileContent(DIRECTORY + "universityStructureClassrooms.json").read();
        University university = universityStructureJson.mapToModel(universityJson);

        final List<Building> buildings = new ArrayList<>(university.getBuildings());
        assertThat(buildings, hasSize(2));
        assertThat(buildings.get(1).getId(), equalTo("а"));
        assertThat(buildings.get(1).getFullName(), equalTo("корпус \"а\""));

        final List<Classroom> classrooms = new ArrayList<>(buildings.get(1).getClassrooms());
        assertThat(classrooms, hasSize(2));
        assertThat(classrooms.get(0).getId(), equalTo((97)));
        assertThat(classrooms.get(0).getName(), equalTo("287"));
        assertThat(classrooms.get(0).getFloor(), equalTo((byte) 2));
        assertThat(classrooms.get(0).isHasPowerSocket(), is(true));


        final List<ClassroomType> classroomTypes = new ArrayList<>(classrooms.get(0).getTypes());
        assertThat(classroomTypes, hasSize(2));
        assertThat(classroomTypes.get(0).getId(), equalTo(20));
        assertThat(classroomTypes.get(0).getName(), equalTo("Каф_ВЦ"));
    }

    @Test
    public void mapGroupsResponse_JsonObject_Valid() throws IOException {
        String universityJson = new FileContent(DIRECTORY + "universityStructureGroups.json").read();
        University university = universityStructureJson.mapToModel(universityJson);

        final List<Faculty> faculties = new ArrayList<>(university.getFaculties());
        assertThat(faculties, hasSize(1));

        final List<Direction> directions = new ArrayList<>(faculties.get(0).getDirections());
        assertThat(directions, hasSize(1));
        assertThat(directions.get(0).getId(), equalTo(36));
        assertThat(directions.get(0).getName(), equalTo("Безпека інформаційних і комунікаційних систем"));
        assertThat(directions.get(0).getAbbreviation(), equalTo("БІКС"));

        final List<Group> directionGroups = new ArrayList<>(directions.get(0).getGroups());
        assertThat(directionGroups, hasSize(2));
        assertThat(directionGroups.get(0).getId(), equalTo(3803011));
        assertThat(directionGroups.get(0).getName(), equalTo("БІКС-12-1"));

        final List<Speciality> specialities = new ArrayList<>(directions.get(0).getSpecialities());
        assertThat(specialities, hasSize(1));
        assertThat(specialities.get(0).getName(), equalTo("БДІР"));
        assertThat(specialities.get(0).getAbbreviation(), equalTo("БДІР"));

        final List<Group> specialityGroups = new ArrayList<>(specialities.get(0).getGroups());
        assertThat(specialityGroups, hasSize(2));
        assertThat(specialityGroups.get(0).getId(), equalTo(3802977));
        assertThat(specialityGroups.get(0).getName(), equalTo("БІКС-12-2"));
    }
}
