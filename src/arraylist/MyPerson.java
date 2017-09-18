package arraylist;

import java.util.Arrays;

public class MyPerson {

	int size = 0;
	int initSize = 4;
	Person[] persons;
	
	public MyPerson()
	{
		persons = new Person[initSize];
	}
	
	
	public void add(Person p)
	{
		if(size >= persons.length)
			resize();
		persons[size++] = p;
	}
	
	public Person get(int i)
	{
		if(i>= 0 && i <= size)
			return persons[i];
		else
		{
			System.out.println("Item Not found");
			return null;
		}
			
	}
	
	public int find(Person p)
	{
		int index = 0;
		for(Person pp: persons)
		{
			if(p.getLast().equals(pp.getLast()) )
			{
				return index;
			}
			else
				index++;
		}
		return -1;
	}
	
	public void insert(Person p, int pos){
		if(pos > size) return;
		if(pos >= persons.length || size+1> persons.length)
		{
			resize();
		}
			
		Person[] temp = new Person[persons.length+1];
		System.arraycopy(persons, 0, temp, 0, pos);
		temp[pos] = p;
		System.arraycopy(persons, pos, temp, pos+1, persons.length-pos);
		persons = temp;
		++size;
	}
	

	
	public void remove(Person p)
	{
		int pos = 0;
		if(persons != null)
			if(find(p) != -1)
				for(int i=0; i< persons.length; i++)
				{
					if(persons[i].getLast().equals(p.getLast()))
					{
						Person[] temp = new Person[persons.length-1];
						System.arraycopy(persons, 0, temp, 0, i);
						System.arraycopy(persons, i+1, temp, i, persons.length-i-1);
						persons = temp;
						size--;
						return;
					}
			}
		System.out.println("The item is not available");
	}
	public void resize()
	{
		int newLen = persons.length * 2;
		Arrays.copyOf(persons, initSize);
	}
	
	
	public int size()
	{
		return size;
	}
	
	
	@Override
	public String toString() {
		return "" + Arrays.toString(persons) + "";
	}


	public static void main(String[] args)
	{
		MyPerson p = new MyPerson();
		Person a = new Person("Alice", "Samson", 25);
		p.add(a);
		Person b = new Person("Bob", "John", 35);
		p.add(b);
		Person c = new Person("Cindy", "Mariam", 37);
		p.add(c);
		Person d = new Person("Dadi", "Paul", 41);
		Person e = new Person("Elicen", "April", 52);
		//p.add(d);
		p.add(e);
		System.out.println(p);
		p.insert(d, 1);
		
		System.out.println(p);
		
		p.remove(c);
		
		
		System.out.println(p);
		System.out.println(p.find(d));
		System.out.println(p.find(e));
	} 

}


class Person {
	private String lastName;
	private String firstName;
	private int age;

	// --------------------------------------------------------------
	public Person(String last, String first, int a) { // constructor
		lastName = last;
		firstName = first;
		age = a;
	}

	// --------------------------------------------------------------
	public String getLast() // get last name
	{
		return lastName;
	}

	@Override
	public String toString() {
		return "Person [lastName=" + lastName + " FirstName=" + firstName
				+ " Age=" + age + "]\n";
	}
} // end class Person

/*
 * 
 * Output
 * [Person [lastName=Alice FirstName=Samson Age=25]
, Person [lastName=Bob FirstName=John Age=35]
, Person [lastName=Cindy FirstName=Mariam Age=37]
, Person [lastName=Elicen FirstName=April Age=52]
]
[Person [lastName=Alice FirstName=Samson Age=25]
, Person [lastName=Dadi FirstName=Paul Age=41]
, Person [lastName=Bob FirstName=John Age=35]
, Person [lastName=Cindy FirstName=Mariam Age=37]
, Person [lastName=Elicen FirstName=April Age=52]
]
[Person [lastName=Alice FirstName=Samson Age=25]
, Person [lastName=Dadi FirstName=Paul Age=41]
, Person [lastName=Bob FirstName=John Age=35]
, Person [lastName=Elicen FirstName=April Age=52]
]
1
3
 */
