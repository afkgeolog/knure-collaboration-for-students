package university.models;

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
    private String shortName;
    private String fullName;
    private Set<Professor> professors = new HashSet<>();

    @JsonCreator
    public Department(@JsonProperty(value = "id", required = true) Short id,
                      @JsonProperty("short_name") String shortName,
                      @JsonProperty("full_name") String fullName) {
        this.id = id;
        this.shortName = shortName;
        this.fullName = fullName;
    }

    private void addProfessor(Professor professor) {
        professors.add(professor);
    }

    @JsonSetter("teachers")
    public void addProfessors(Collection<Professor> professors) {
        for (Professor professor : professors) {
            addProfessor(professor);
        }
    }

    public Short getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
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
