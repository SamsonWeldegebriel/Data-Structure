package linkedList;

import java.util.*;

public class Marketing {
	private String employeename;
	private String productname;
	 double salesamount;
	
	public Marketing(String employeename, String productname, double salesamount) {
		this.employeename = employeename;
		this.productname = productname;
		this.salesamount = salesamount;
	}
	
	
	
	@Override
	public String toString() {
		return "Marketing [employeename=" + employeename + ", productname="
				+ productname + ", salesamount=" + salesamount + "]";
	}



	public static void main(String[] args) {
		ArrayList<Marketing> marketing = new ArrayList<Marketing>();
		marketing.add(new Marketing("Steve", "Iphone", 200));
		marketing.add(new Marketing("Jobs", "Dell", 500));
		marketing.add(new Marketing("Abdu", "Acer", 700));
		marketing.add(new Marketing("Lookman", "HP", 9000));
		marketing.add(new Marketing("Bitew", "Desktop", 10000));
		marketing.add(new Marketing("Biakal", "Toshiba", 400));
		System.out.println(marketing);
		
		marketing.remove(1);
		System.out.println(marketing);
		
		marketing.set(0, new Marketing("AAAA", "BBBBB", 300));
		System.out.println(marketing);
		
		System.out.println(marketing.size());
		
		marketing.sort(new SalesamountComparator());
		System.out.println(marketing);
		
		List<Marketing> marketingMoreThan1000 = listMoreThan1000(marketing);
		Collections.sort(marketingMoreThan1000, new SalesamountComparator());
		System.out.println(marketingMoreThan1000);
	}
	
	public static List<Marketing> listMoreThan1000(List<Marketing> list){
		 // Implement a body
		
		List<Marketing> morethan1000 = new ArrayList<Marketing>();
		
		for(Marketing mar: list)
		{
			
			if(Double.compare(mar.salesamount, 1000.00) == 1 )
			{
				morethan1000.add(mar);
			}
		}
		return morethan1000;
		}
	
	

}

/*
 * 
 * 
 * 
 * [Marketing [employeename=Steve, productname=Iphone, salesamount=200.0], Marketing [employeename=Jobs, productname=Dell, salesamount=500.0], Marketing [employeename=Abdu, productname=Acer, salesamount=700.0], Marketing [employeename=Lookman, productname=HP, salesamount=9000.0], Marketing [employeename=Bitew, productname=Desktop, salesamount=10000.0], Marketing [employeename=Biakal, productname=Toshiba, salesamount=400.0]]
[Marketing [employeename=Steve, productname=Iphone, salesamount=200.0], Marketing [employeename=Abdu, productname=Acer, salesamount=700.0], Marketing [employeename=Lookman, productname=HP, salesamount=9000.0], Marketing [employeename=Bitew, productname=Desktop, salesamount=10000.0], Marketing [employeename=Biakal, productname=Toshiba, salesamount=400.0]]
[Marketing [employeename=AAAA, productname=BBBBB, salesamount=300.0], Marketing [employeename=Abdu, productname=Acer, salesamount=700.0], Marketing [employeename=Lookman, productname=HP, salesamount=9000.0], Marketing [employeename=Bitew, productname=Desktop, salesamount=10000.0], Marketing [employeename=Biakal, productname=Toshiba, salesamount=400.0]]
5
[Marketing [employeename=AAAA, productname=BBBBB, salesamount=300.0], Marketing [employeename=Biakal, productname=Toshiba, salesamount=400.0], Marketing [employeename=Abdu, productname=Acer, salesamount=700.0], Marketing [employeename=Lookman, productname=HP, salesamount=9000.0], Marketing [employeename=Bitew, productname=Desktop, salesamount=10000.0]]
[Marketing [employeename=Lookman, productname=HP, salesamount=9000.0], Marketing [employeename=Bitew, productname=Desktop, salesamount=10000.0]]

 */
