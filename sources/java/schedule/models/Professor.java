package schedule.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Immutable;

import java.util.Objects;

/**
 * Presents professor at Kharkiv National University of Radioelectronics. It has name constraints. Full name is
 * described by pattern "Surname Name Patronymic".
 * @author Vladyslav Dovhopol
 */
@Immutable
public class Professor {

    private final Integer id;

    /**
     * Surname of the person and the initials.
     * For example, if the full name is "Romashkin Vladimir Igorevich". Then name with initials will look like
     * "Romashkin V.I.".
     *
     * However, this field duplicates {@link #fullName} and can be replaced with appropriate method. It has been
     * inherited from API provided by resource cist.nure.ua. For the sake of DRY principle, should be removed.
     */
    private final String nameWithInitials;

    /**
     * Surname name and patronymic separated by single whitespace. Full name parts are expected to be used in this order, although this constraint
     * isn't enforced. Also, some parts of name may be missing.
     * Example String: "Romashkin Vladimir Igorevich"
     */
    private final String fullName;

    @JsonCreator
    public Professor(@JsonProperty(value = "id", required = true) Integer id,
                     @JsonProperty("short_name") String nameWithInitials,
                     @JsonProperty("full_name") String fullName) {
        this.id = id;
        this.nameWithInitials = nameWithInitials;
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public String getNameWithInitials() {
        return nameWithInitials;
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
