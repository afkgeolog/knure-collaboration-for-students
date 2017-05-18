package schedule.cist;

import university.models.University;

import java.io.IOException;

/**
 * API to fetch information about university structure.
 * @author Vladyslav Dovhopol
 */
public interface UniversityStructureApi {

    /**
     * Fetch university info, faculties, departments and professors.
     */
    University fetchProfessors() throws IOException;

    /**
     * Fetch university info, faculties, directions, specialities and groups.
     * Directions include only bachelors' groups. Specialities contain groups for masters and specialists.
     */
    University fetchGroups();

    /**
     * Fetch university info, buildings and auditories. Auditories are placed in buildings.
     * Each auditory may be of 0..N types.
     */
    University fetchAuditories();
}
