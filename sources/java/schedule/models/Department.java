package schedule.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Vladyslav Dovhopol
 */
public class Department {

    private final Short id;

    /**
     * If the department name is "Department of Applied Mathematics", abbreviation would look like "AM".
     */
    private final String abbreviation;

    private final String name;

    private final Set<Professor> professors = new HashSet<>();

    @JsonCreator
    public Department(@JsonProperty(value = "id", required = true) Short id,
                      @JsonProperty("short_name") String abbreviation,
                      @JsonProperty("full_name") String name) {
        this.id = id;
        this.abbreviation = abbreviation;
        this.name = name;
    }

    public Short getId() {
        return id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    @JsonSetter("teachers")
    public void addProfessors(Collection<Professor> professors) {
        for (Professor professor : professors) {
            addProfessor(professor);
        }
    }

    public Collection<Professor> getProfessors() {
        return professors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
