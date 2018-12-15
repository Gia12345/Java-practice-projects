package studentApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private String year;
	private int id;
	private ArrayList<Course> courses = new ArrayList<Course>();
	private static int currentId = 1000;
	private double balance = 0;
	
	public Student(String fname, String lname, String year) {
		this.firstName = fname;
		this.lastName = lname;
		this.year = year;
		this.id = createId(year);
	}
		
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void addCourse(Course c) {
		this.courses.add(c);
	}
	public void addTuition(double t) {
		balance += t;
	}

	private int createId(String year) {
		currentId += 1;
		String newId =  String.valueOf(currentId);
		newId = year + newId;
		return Integer.parseInt(newId);
	}
	public void printInfo() {
		System.out.println("Name:  "+firstName+" "+lastName);
		System.out.println("Student Id:  "+id);
		System.out.println("Tuition Balance: "+balance);
		if (!courses.isEmpty()) {
			for (Course c: courses) {
				c.printInfo();
			}
		}
		else {System.out.println("Student is not currently enrolled in a course.");
		}
		
	}
	public void enrollInCourses(ArrayList<Course> c) {
		System.out.println("Select the number of the course or 0 for none:  ");
		Scanner s = new Scanner(System.in);
		for (int i=0; i<c.size(); i++) {
			System.out.println(i+1 +" "+ (c.get(i).getName()));
		}
		System.out.println("0 None");
		int newCourseNumber = s.nextInt();
		while (newCourseNumber > c.size()) {
			System.out.print("Invalid choice.  Make another choice:  ");
			newCourseNumber = s.nextInt();
		}	
		for (int i=0; i<c.size(); i++) {
			if (newCourseNumber == (i+1) && courses.contains(c.get(i))) {
				System.out.println("Student is already enrolled in that course.");
			}
			else if (newCourseNumber == (i+1)) {
				Course newCourse = c.get(i);
				addCourse(newCourse);
				addTuition(newCourse.getCost());
				break;
			}
		}
		
	}
	
	public void payTuition() {
		System.out.println("Tuition balacne is "+balance);
		System.out.print("How much would you like to pay?  ");
		Scanner s = new Scanner(System.in);
		double payment = s.nextDouble();
		while (payment > balance) {
			System.out.print("Payment is too high.  Enter a smaller amount:  ");
			payment = s.nextDouble();
		}
		balance -= payment;
		System.out.println("New balance is "+balance+".");
	}

}
