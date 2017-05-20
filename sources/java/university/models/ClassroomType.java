package university.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * @author Vladyslav Dovhopol
 */
public class ClassroomType {

    private final Integer id;

    private String name;

    @JsonCreator
    public ClassroomType(@JsonProperty(value = "id", required = true) Integer id,
                         @JsonProperty(value = "short_name", required = true)String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
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
}
