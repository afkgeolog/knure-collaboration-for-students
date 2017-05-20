package university.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Vladyslav Dovhopol
 */
//Property "short_name" at the moment of removal duplicated id.
@JsonIgnoreProperties("short_name")
public class Building {

    private final String id;

    private final String fullName;

    private final Set<Classroom> classrooms = new HashSet<>();

    @JsonCreator
    public Building(@JsonProperty(value = "id", required = true) String id,
                    @JsonProperty(value = "full_name") String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void addClassroom(Classroom classroom) {
        this.classrooms.add(classroom);
    }

    @JsonSetter("auditories")
    public void addClassrooms(Iterable<Classroom> classrooms) {
        for (Classroom classroom : classrooms) {
            addClassroom(classroom);
        }
    }

    public Collection<Classroom> getClassrooms() {
        return classrooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return Objects.equals(id, building.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
