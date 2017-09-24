package hashtables.account;

import java.util.List;

public class AccountManager {
	public static double computeAccountBalanceSum(List<Employee> emps) {
		double sum = 0;
		
		for(Employee e: emps)
		{
			List<Account> accounts = e.getAccounts();
			
			for(Account next: accounts)
			{
				sum += next.getBalance();
			}
		}
		return sum;
	}
}
