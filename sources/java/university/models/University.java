package university.models;

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

    private final String shortName;

    private final String fullName;

    private final Set<Faculty> faculties = new HashSet<>();

    private final Set<Building> buildings = new HashSet<>();

    @JsonCreator
    public University(@JsonProperty(value = "short_name", required = true) String shortName,
                      @JsonProperty("full_name") String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public Collection<Faculty> getFaculties() {
        return faculties;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
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
