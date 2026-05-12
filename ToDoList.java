package com.mycompany.todolist;
import java.util.Scanner;
import java.util.ArrayList;

enum TaskPriority {LOW, MEDIUM, HIGH}

public class ToDoList {
    public static void main(String[] args) {

        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<TaskPriority> taskPriorities = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 6) {

            System.out.println("=========TO DO LIST MENU=========");
            System.out.println("1. Add Task");
            System.out.println("2. Display All Tasks");
            System.out.println("3. Search For A Task");
            System.out.println("4. Update A Task");
            System.out.println("5. Delete Tasks");
            System.out.println("6. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter a description: ");
                    String task = scanner.nextLine().toLowerCase().trim();
                    tasks.add(task);
                    System.out.println("Task added!");
                    System.out.println("Choose priority: 1 = LOW, 2 = MEDIUM, 3 = HIGH");
                    int priorityChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (priorityChoice == 1) {
                        taskPriorities.add(TaskPriority.LOW);
                    } else if (priorityChoice == 2) {
                        taskPriorities.add(TaskPriority.MEDIUM);
                    } else if (priorityChoice == 3) {
                        taskPriorities.add(TaskPriority.HIGH);
                    } else {
                        taskPriorities.add(TaskPriority.LOW); 
                        System.out.println("Invalid priority, defaulting to LOW.");
                    }
                    break;

                case 2:
                    System.out.println("View All Tasks");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks yet.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println("Task " + (i + 1) + ": " + tasks.get(i) + " | Priority: " + taskPriorities.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.println("Search For Task");
                    System.out.println("Enter search word: ");
                    String keyword = scanner.nextLine().toLowerCase().trim();
                    boolean found = false;
                    for (int j = 0; j < tasks.size(); j++) {
                        if (tasks.get(j).contains(keyword)) {
                            System.out.println("Found - Task " + (j + 1) + ": " + tasks.get(j) + " | Priority: " + taskPriorities.get(j));
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No tasks found matching: " + keyword);
                    }
                    break;

                case 4:
                    System.out.println("Enter Task Number To Update");
                    int taskNum = -1;

                    while (taskNum < 1 || taskNum > tasks.size()) {
                        try {
                            taskNum = scanner.nextInt();
                            scanner.nextLine();
                            if (taskNum < 1 || taskNum > tasks.size()) {
                                System.out.println("Invalid! Enter a number between 1 and " + tasks.size());
                            }
                        } catch (Exception e) {
                            System.out.println("Please enter a valid number only!");
                            scanner.nextLine();
                        }
                    }

                    System.out.println("Current task: " + tasks.get(taskNum - 1));
                    System.out.println("Enter new description: ");
                    String newTask = scanner.nextLine().toLowerCase().trim();
                    tasks.set(taskNum - 1, newTask);
                    System.out.println("Task updated to: " + newTask);
                    break;

                case 5:
                    System.out.println("Delete");
                    System.out.println("Enter Task Number To Delete (1-" + tasks.size() + ")");
                    int deleteNum = scanner.nextInt();
                    scanner.nextLine();

                    if (deleteNum < 1 || deleteNum > tasks.size()) {
                        System.out.println("Invalid task number.");
                        break;
                    }

                    System.out.println("Task to delete: " + tasks.get(deleteNum - 1));

                    String confirm;
                    do {
                        System.out.println("Are you sure you want to delete this task? yes / no");
                        confirm = scanner.nextLine().toLowerCase().trim();
                    } while (!confirm.equals("yes") && !confirm.equals("no"));

                    if (confirm.equals("yes")) {
                        tasks.remove(deleteNum - 1);
                        taskPriorities.remove(deleteNum - 1);
                        System.out.println("Task successfully deleted.");
                    } else {
                        System.out.println("Delete cancelled.");
                    }
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1-6.");
            }
        }
    }
}
