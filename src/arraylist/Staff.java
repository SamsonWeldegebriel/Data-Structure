package arraylist;

public final class Staff implements EmployeeData {
	private String name;
	private double salary;
	private int numDependants;
	public Staff(String name, double salary, int numDependants) {
		this.name = name;
		this.salary = salary;
		this.numDependants = numDependants;
	}
	
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public int getNumDependants() {
		return numDependants;
	}

	@Override
	public String toString() {
		return "Staff [name=" + name + ", salary=" + salary
				+ ", numDependants=" + numDependants + "]";
	}
	
}
