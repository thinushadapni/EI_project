
package EdTech.model;

import java.util.Objects;

public class Student {
    private final String id;

    public Student(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Student ID cannot be null or empty");
        }
        this.id = id.trim();
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
