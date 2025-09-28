package EdTech.util;

import EdTech.manager.VirtualClassroomManager;


import java.util.Scanner;
//

public class InputHandler {
    // private static final Logger logger = Logger.getLogger(InputHandler.class.getName());
    private final VirtualClassroomManager manager = new VirtualClassroomManager();
    private boolean running = true;

    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Virtual Classroom Manager ===");
        System.out.println("Available commands:");
        System.out.println(" add_classroom <ClassName>");
        System.out.println(" add_student <StudentID> <ClassName>");
        System.out.println(" schedule_assignment <ClassName> <AssignmentDetail>");
        System.out.println(" submit_assignment <StudentID> <ClassName> <AssignmentDetail>");
        System.out.println(" list_classrooms");
        System.out.println(" list_students <ClassName>");
        System.out.println(" remove_classroom <ClassName>");
        System.out.println(" exit");

        while (running) {
            System.out.println("\nEnter command: ");
            String line = sc.nextLine().trim();
            handleCommand(line);
        }

        sc.close();
    }

    private void handleCommand(String line) {
        if (line.equalsIgnoreCase("exit")) {
            System.out.println("Exiting Virtual Classroom Manager...");
            running = false;
            return;
        }

        String[] parts = line.split(" ", 2);
        if (parts.length == 0) return;

        String command = parts[0];
        String argsLine = parts.length > 1 ? parts[1] : "";

        try {
            switch (command) {
                case "add_classroom":
                    manager.addClassroom(argsLine);
                    break;
                case "add_student": {
                    String[] tokens = argsLine.split(" ");
                    if (tokens.length == 2) {
                        manager.addStudent(tokens[0], tokens[1]);
                    } else {
                        System.out.println("Usage: add_student <StudentID> <ClassName>");
                    }
                    break;
                }
                case "schedule_assignment": {
                    String[] tokens = argsLine.split(" ", 2);
                    if (tokens.length == 2) {
                        manager.scheduleAssignment(tokens[0], tokens[1]);
                    } else {
                        System.out.println("Usage: schedule_assignment <ClassName> <AssignmentDetail>");
                    }
                    break;
                }
                case "submit_assignment": {
                    String[] tokens = argsLine.split(" ", 3);
                    if (tokens.length == 3) {
                        manager.submitAssignment(tokens[0], tokens[1], tokens[2]);
                    } else {
                        System.out.println("Usage: submit_assignment <StudentID> <ClassName> <AssignmentDetail>");
                    }
                    break;
                }
                case "list_classrooms":
                    manager.listClassrooms();
                    break;
                case "list_students":
                    manager.listStudents(argsLine);
                    break;
                case "remove_classroom":
                    manager.removeClassroom(argsLine);
                    break;
                default:
                    System.out.println("Unknown command. Try again.");
            }
        } catch (Exception e) {
            System.out.println("Error handling command: " + e.getMessage());
        }
    }
}
