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

    private String shortName;
    private String fullName;
    private Set<Faculty> faculties = new HashSet<>();

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

    private void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    @JsonSetter("faculties")
    public void addFaculties(Iterable<Faculty> faculties) {
        for (Faculty faculty : faculties) {
            addFaculty(faculty);
        }
    }
}
