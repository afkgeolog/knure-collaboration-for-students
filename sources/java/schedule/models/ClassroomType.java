package schedule.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author Vladyslav Dovhopol
 */
@Entity
@Table(name="ClassroomType", schema = "schedule")
public class ClassroomType {

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private final Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonCreator
    public ClassroomType(@JsonProperty(value = "id", required = true) Integer id,
                         @JsonProperty(value = "short_name") String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    @JsonSetter("full_name")
    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassroomType that = (ClassroomType) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ClassroomType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
