package tree;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	
	
	public static void main(String[] args) {
		Person p1 = new Person("Rooney", 31);
		Person p2 = new Person("Zlatan", 31);
		Person p3 = new Person("Marshal", 31);
		Person p4 = new Person("Smalling", 31);
		Person p5 = new Person("Jones", 31);
		
		TreeSet<Person> set = new TreeSet<Person>();
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		set.add(p5);
		
		Iterator<Person> it = set.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		
		
		
	}
}

class Person implements Comparable<Person>
{
	private String name;
	private Integer age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}



	@Override
	public int compareTo(Person p) {
		
		/*if(this.age > p.age)
			return 1;
		else if(this.age < p.age)
			return -1;
		else
			return 0;*/
		
		int j = p.age;
		if (this.age < j) {
		return -1;
		} else if (this.age == j) {
		return 0;
		} else {
		return 1;
		}
	}
	
	
	
	
}
