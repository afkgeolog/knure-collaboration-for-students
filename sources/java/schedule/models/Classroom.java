package schedule.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import infrastructure.deserialization.IntToBooleanDeserializer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Vladyslav Dovhopol
 */
public class Classroom {

    private final Integer id;

    private final String name;

    private final Byte floor;

    private boolean hasPowerSocket = false;

    private final Set<ClassroomType> types = new HashSet<>();

    @JsonCreator
    public Classroom(@JsonProperty(value = "id", required = true) Integer id,
                     @JsonProperty(value = "short_name", required = true) String name,
                     @JsonProperty(value = "floor", required = true) Byte floor) {
        this.id = id;
        this.name = name;
        this.floor = floor;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Byte getFloor() {
        return floor;
    }

    public boolean isHasPowerSocket() {
        return hasPowerSocket;
    }

    @JsonSetter("is_have_power")
    @JsonDeserialize(using = IntToBooleanDeserializer.class)
    public void setHasPowerSocket(boolean hasPowerSocket) {
        this.hasPowerSocket = hasPowerSocket;
    }

    public void addType(ClassroomType type) {
        this.types.add(type);
    }

    @JsonSetter("auditory_types")
    public void addTypes(Collection<ClassroomType> types) {
        for (ClassroomType type : types) {
            addType(type);
        }
    }

    public Collection<ClassroomType> getTypes() {
        return types;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return Objects.equals(id, classroom.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
