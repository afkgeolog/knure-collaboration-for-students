package schedule.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Vladyslav Dovhopol
 */
public class Direction {

    private final Integer id;

    private final String name;

    private final String abbreviation;

    private final Set<Group> bachelorGroups = new HashSet<>();

    private final Set<Speciality> specialities = new HashSet<>();

    public Direction(@JsonProperty(value = "id", required = true) Integer id,
                     @JsonProperty("full_name") String name,
                     @JsonProperty("short_name") String abbreviation) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void addGroup(Group group) {
        this.bachelorGroups.add(group);
    }

    @JsonSetter("groups")
    public void addGroups(Iterable<Group> groups) {
        for (final Group group : groups) {
            addGroup(group);
        }
    }

    public Set<Group> getGroups() {
        return bachelorGroups;
    }

    public void addSpeciality(Speciality speciality) {
        this.specialities.add(speciality);
    }

    public void addSpecialities(Iterable<Speciality> specialities) {
        for (final Speciality speciality : specialities) {
            addSpeciality(speciality);
        }
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return Objects.equals(getId(), direction.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
