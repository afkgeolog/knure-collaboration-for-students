package university.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * @author Vladyslav Dovhopol
 */
public class Professor {

    private final Integer id;

    private String shortName;

    private String fullName;

    @JsonCreator
    public Professor(@JsonProperty(value = "id", required = true) Integer id,
                     @JsonProperty("short_name") String shortName,
                     @JsonProperty("full_name") String fullName) {
        this.id = id;
        this.shortName = shortName;
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(getId(), professor.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
