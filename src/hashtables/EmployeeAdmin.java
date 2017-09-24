package hashtables;

import java.util.*;

import java.util.HashMap;
import java.util.List;
import java.util.Comparator;

public class EmployeeAdmin {
	
	/**
		Returns a list of Employees whose social security number is on the input list socSecNums
		and whose salary is > 80000. The list must be ordered by social security number,
		from lowest to highest. To sort, you must use a Collections sorting method
		and you must define your own Comparator to be used to compare Employees by ssn. 
	*/
	public static List<Employee> prepareReport(HashMap<String, Employee> table, List<String> socSecNums) {
		
		List<Employee> emp = new LinkedList();		
		Iterator it = socSecNums.iterator();
		
		while(it.hasNext())
		{
			String cur = it.next().toString();
			if(table.get(cur) != null && table.get(cur).getSalary() > 80000)
			{
				emp.add(table.get(cur));
			}
		}
		
		Collections.sort(emp, new compareSSN());
		
		return emp;
		
	}
	
}

	class compareSSN implements Comparator
	{

		@Override
		public int compare(Object e1, Object e2) {
			Employee emp1 = (Employee) e1;
			Employee emp2 = (Employee) e2;
			
			return emp1.getSsn().compareTo(emp2.getSsn());
		}

		
	}
