package EdTech.manager;
import EdTech.model.*;
import java.util.*;
public class VirtualClassroomManager {
    

    private final Map<String, Classroom> classrooms = new HashMap<>();
    private final Map<String, List<String>> submissions = new HashMap<>();

    public void addClassroom(String className) {
        try {
            if (classrooms.containsKey(className)) {
                System.out.println("Classroom already exists: " + className);
                return;
            }
            classrooms.put(className, new Classroom(className));
            System.out.println("Classroom " + className + " has been created.");
        } catch (Exception e) {
            System.out.println("Error adding classroom: " + e.getMessage());
        }
    }

    public void addStudent(String studentId, String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom not found: " + className);
            return;
        }
        Student student = new Student(studentId);
        if (classroom.addStudent(student)) {
            System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
        } else {
            System.out.println("Student " + studentId + " already enrolled in " + className + ".");
        }
    }

    public void scheduleAssignment(String className, String detail) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom not found: " + className);
            return;
        }
        classroom.addAssignment(new Assignment(detail));
        System.out.println("Assignment for " + className + " has been scheduled.");
    }

    public void submitAssignment(String studentId, String className, String detail) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom not found: " + className);
            return;
        }
        boolean enrolled = classroom.getStudents().stream()
                .anyMatch(s -> s.getId().equals(studentId));
        if (!enrolled) {
            System.out.println("Student " + studentId + " is not enrolled in " + className);
            return;
        }
        String key = studentId + "@" + className;
        submissions.putIfAbsent(key, new ArrayList<>());
        submissions.get(key).add(detail);
        System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
    }

    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available.");
        } else {
            System.out.println("Classrooms:");
            classrooms.keySet().forEach(c -> System.out.print(" - " + c));
        }
    }

    public void listStudents(String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom not found: " + className);
            return;
        }
        if (classroom.getStudents().isEmpty()) {
            System.out.println("No students enrolled in " + className);
        } else {
            System.out.println("Students in " + className + ":");
            classroom.getStudents().forEach(s -> System.out.print(" - " + s.getId()));
        }
    }

    public void removeClassroom(String className) {
        if (classrooms.remove(className) != null) {
            submissions.keySet().removeIf(k -> k.endsWith("@" + className));
            System.out.println("Classroom " + className + " has been removed.");
        } else {
            System.out.println("Classroom not found: " + className);
        }
    }
}

