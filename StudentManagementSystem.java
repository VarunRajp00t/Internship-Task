package com.task1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentManagementSystem {

	private static ArrayList<Student> studentList = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Initializing with sample data
		studentList.add(new Student(1, "Alice", "A"));
		studentList.add(new Student(2, "Bob", "B"));
		studentList.add(new Student(3, "Charlie", "C"));

		int choice;
		do {
			showMenu();
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine(); 

			switch (choice) {
			case 1:
				addStudent();
				break;
			case 2:
				removeStudent();
				break;
			case 3:
				displayStudents();
				break;
			case 4:
				System.out.println("Exiting program. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
			System.out.println(); 
		} while (choice != 4);

		scanner.close();
	}

	private static void showMenu() {
		System.out.println("--- Student Management System ---");
		System.out.println("1. Add a new student");
		System.out.println("2. Remove a student by ID");
		System.out.println("3. Display all students");
		System.out.println("4. Exit");
		System.out.println("---------------------------------");
	}

	private static void addStudent() {
		System.out.print("Enter student ID: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		System.out.print("Enter student name: ");
		String name = scanner.nextLine();

		System.out.print("Enter student grade: ");
		String grade = scanner.nextLine();
		scanner.nextLine(); // Consume newline

		Student newStudent = new Student(id, name, grade);
		studentList.add(newStudent);
		System.out.println("Student added successfully!");
	}

	private static void removeStudent() {
		System.out.print("Enter the ID of the student to remove: ");
		int idToRemove = scanner.nextInt();
		scanner.nextLine(); 

		boolean removed = false;
		Iterator<Student> iterator = studentList.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			if (student.getId() == idToRemove) {
				iterator.remove();
				removed = true;
				System.out.println("Student with ID " + idToRemove + " removed successfully.");
				break;
			}
		}

		if (!removed) {
			System.out.println("Student with ID " + idToRemove + " not found.");
		}
	}

	private static void displayStudents() {
		if (studentList.isEmpty()) {
			System.out.println("No students to display.");
		} else {
			System.out.println("--- List of Students ---");
			for (Student student : studentList) {
				System.out.println(student);
			}
			System.out.println("------------------------");
		}
	}
}
