package arraylist;
import java.util.*;
public class Statistics {
	/** 
	 * Polymorphically computes and returns the sum
	 * of all the salaries of all the staff/teachers in the list.
	 */
	public static double computeSumOfSalaries(List<EmployeeData> aList) {
		double sumOfSalary = 0.0;
		for(EmployeeData e: aList)
		{
			sumOfSalary += e.getSalary();
		}
		return sumOfSalary;
		//implement
		//compute sum of all salaries of people in aList and return
	}
}
