package studentApp;

public class Course {
	private String name;
	private double cost = 600.00;
	
	public Course(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void printInfo() {
		System.out.println(name);
	}
}
