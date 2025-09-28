

//package com.edtech.virtualclassroom.model;
package EdTech.model;

import java.util.*;

public class Classroom {
    private final String name;
    private final Set<Student> students = new HashSet<>();
    private final List<Assignment> assignments = new ArrayList<>();

    public Classroom(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Classroom name cannot be null or empty");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }

    public List<Assignment> getAssignments() {
        return Collections.unmodifiableList(assignments);
    }

    public boolean addStudent(Student student) {
        return students.add(student);
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }
}

