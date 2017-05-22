package schedule.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Vladyslav Dovhopol
 */
public class University {

    /**
     * If the name of the university is "Kharkiv National University of Radioelectronics", abbreviation would look like
     * "KNURE"
     */
    private final String abbreviation;

    private final String name;

    private final Set<Faculty> faculties = new HashSet<>();

    private final Set<Building> buildings = new HashSet<>();

    @JsonCreator
    public University(@JsonProperty(value = "short_name", required = true) String abbreviation,
                      @JsonProperty("full_name") String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public Collection<Faculty> getFaculties() {
        return faculties;
    }

    @JsonSetter("faculties")
    public void addFaculties(Iterable<Faculty> faculties) {
        for (Faculty faculty : faculties) {
            addFaculty(faculty);
        }
    }

    private void addBuilding(Building building) {
        this.buildings.add(building);
    }

    @JsonSetter("buildings")
    public void addBuildings(Iterable<Building> buildings) {
        for (Building building : buildings) {
            addBuilding(building);
        }
    }

    public Collection<Building> getBuildings() {
        return buildings;
    }
}
