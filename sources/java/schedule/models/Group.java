package schedule.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Immutable;

import java.util.Objects;

/**
 * @author Vladyslav Dovhopol
 */
@Immutable
public class Group {

    private final Integer id;

    private final String name;

    public Group(@JsonProperty(value = "id", required = true) Integer id,
                 @JsonProperty(value = "name") String name) {
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
        Group group = (Group) o;
        return Objects.equals(getId(), group.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
