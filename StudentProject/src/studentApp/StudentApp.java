package studentApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class StudentApp {
	
	private static ArrayList<Student> students = new ArrayList<Student>();
	private static ArrayList<Course> courses = new ArrayList<Course>();

	public ArrayList<Student> getStudents() {
		return students;
	}
	
	public static String getYear() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter student year (1, 2, 3, or 4): ");
		return s.next();
	}

	public static void addStudents() {
		System.out.print("How many new students will be added to the database?  ");
		Scanner s = new Scanner(System.in);
		int numberOfStudents = s.nextInt();
		for (int i=0; i<numberOfStudents; i++) {
			System.out.print("Enter student first name:  ");
			String fname = s.next();
			System.out.print("Enter student last name:  ");
			String lname = s.next();
			String year = getYear();
			ArrayList<String> years = new ArrayList<String>();
			Collections.addAll(years, "1", "2", "3", "4");
			while (!years.contains(year)) {
				System.out.println("Year is not valid.  Year must be 1, 2, 3 or 4.");
				year = getYear();
			}
			Student newStudent = new Student(fname, lname, year);
			students.add(newStudent);
			newStudent.printInfo();
		}
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public static void addCourses() {
		String[] courseNames = {"History 101", "Mathematics 101", "English 101",
		                        "Chemistry 101", "Computer Science 101"};
		for (int i = 0; i< courseNames.length; i++) {
			Course newCourse = new Course(courseNames[i], 600.00);
			courses.add(newCourse);		
		}
	}
	
	public static int enterStudentId() {
		System.out.print("Enter a student id: " );
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}
	
	public static Student findStudent(int id) {
		for (Student x: students) {
			if (id == x.getId()) {
				return x;
			}
		}
		return null;
	}
	
	public static void showStudent() {
		if (students.isEmpty()) {
			System.out.println("No Students Available to Display.");
		}
		else {
			System.out.print("To display student info, ");
			int sid = enterStudentId();
			Student s = findStudent(sid);
			if (s != null) {
				s.printInfo();
			} 
			else {
			System.out.println("Student not found.");
			}
		}

	}
	
	public static void printCourses() {
		for (Course c: courses) {
			System.out.println(c.getName());
		}

	}
	
	public static void enrollStudent() {
		System.out.print("To enroll student in a course, ");
		int sid = enterStudentId();
		Student s = findStudent(sid);
		if (s != null) {
			s.enrollInCourses(courses);
			s.printInfo();
		}
		else {System.out.println("Student not found.");}	

	}
	
	public static void payTuition() {
		System.out.print("To pay tuition, ");
		int sid = enterStudentId();
		Student s = findStudent(sid);
		if (s != null) {
			s.payTuition();
		} else {System.out.println("Student not found.");}

	}
	
	public static void pressAnyKey() {
		System.out.println("Press any key to continue.");
		Scanner s = new Scanner(System.in);
		s.nextLine();
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addCourses();
		String select = "";
		do {
			System.out.println("Select an action:  ");
			System.out.println("1 Add Students");
			System.out.println("2 Display Student");
			System.out.println("3 Enroll Student in Courses");
			System.out.println("4 Pay Tuition");
			System.out.println("5 Display Available Course");
			System.out.println("E Exit");
			System.out.print("Selection:  ");
			Scanner s = new Scanner(System.in);
			select = s.next();
			switch (select) {
			case "1": {addStudents(); break;}
			case "2": {showStudent(); break;}
			case "3": {enrollStudent(); break;}
			case "4": {payTuition(); break;}
			case "5": {printCourses(); break;}
			case "E": {System.out.println("Exit"); System.exit(0); break;}
			case "e": {System.out.println("Exit"); System.exit(0); break;}
			default: {System.out.println("Invalid choice.");}
			} 
			pressAnyKey();
		} while (select != "E" && select != "e");
	}

}
