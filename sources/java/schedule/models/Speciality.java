package schedule.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Speciality is relevant to masters and specialists. Bachelor's groups are in {@link Direction}.
 * @author Vladyslav Dovhopol
 */
public class Speciality {

    private final Integer id;

    private final String name;

    private final String abbreviation;

    private final Set<Group> groups = new HashSet<>();

    public Speciality(Integer id, String name, String abbreviation) {
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
        this.groups.add(group);
    }

    public void addGroups(Iterable<Group> groups) {
        for (final Group group : groups) {
            addGroup(group);
        }
    }

    public Set<Group> getGroups() {
        return groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speciality that = (Speciality) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
