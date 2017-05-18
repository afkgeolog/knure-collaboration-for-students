package university.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Vladyslav Dovhopol
 */
public class Faculty {

    private final Short id;
    private String shortName;
    private String fullName;
    private Set<Department> departments = new HashSet<>();

    public Faculty(@JsonProperty(value = "id", required = true) Short id,
                   @JsonProperty("short_name") String shortName,
                   @JsonProperty("full_name") String fullName) {
        this.id = id;
        this.shortName = shortName;
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public Short getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    private void addDepartment(Department department) {
        this.departments.add(department);
    }

    @JsonSetter("departments")
    public void addDepartments(Iterable<Department> departments) {
        for (Department department : departments) {
            addDepartment(department);
        }
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(getId(), faculty.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
