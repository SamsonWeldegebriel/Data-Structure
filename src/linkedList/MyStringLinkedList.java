package linkedList;

public class MyStringLinkedList {
	Node header;

	MyStringLinkedList() {
		header = null;
	}

	public void addFront(String item) {
		if (header == null)
			header = new Node(null, item, null);
		else {
			Node n = new Node(null, item, header);
		    	header.previous = n;
		    	header = n;
		}
	}

// Implement the code

	public void addLast(String item) {
		Node temp = new Node(null, item, null);
		
		if(header == null)
			header = temp;
		else
		{
			Node last = header;
			while(last.next != null){
				last = last.next; 
			}
			
			last.next = temp;
			temp.previous = last;
		}
	}


	// implement the code
	public void postAddNode(Node n, String value){
			if(n == null)
			{
				System.out.println("The node doesn't exist");
				return;
			}
			else
			{
				Node temp = new Node(n,value,n.next);
				n.next = temp;
			}
			
					
	}
// implement the code

       public int Size(){
    	   int size = 0;
    	   if(header == null)
    		   size = 0;
    	   else if(header.next == null)
    		   size = 1;
    	   else
    	   {
    		   Node lastNode = header;
    		   while(lastNode != null)
    		   {
    			   size++;
    			   lastNode = lastNode.next;
    		   }
    		   
    	   }
    	   
    	   return size;
       }

// implement code
    public boolean isEmpty()
	{
    	return header == null;
	}  

    public Object getFirst(){
    	if(header != null)
    		return header;
    	else 
    		return "";
    }
 
    public Object getLast(){
    	if(header == null)
			return null;
		else
		{
			Node last = header;
			while(last.next != null){
				last = last.next; 
			}
			return last;
		}
    }
    
    public void removeFirst(){
    	if(header == null)
    		return;
    	else if(header.next == null)
    		header = null;
    	else
    	{
    		Node temp = header;
    		temp.next.previous = null;
    		header = null;
    		header = temp.next;
    	}
    }
    
    public void removeLast(){
    	
    	if(header == null)
			return;
		else
		{
			Node last = header;
			while(last.next != null){
				last = last.next; 
			}
			last.previous.next = null;
			last = null;
		}
    }
    
    public void printMin(){
    	if(header == null)
			System.out.println("No minimum!");
    	else if(header.next == null)
    	{
    		System.out.println("The minimum is: " + header.value);
    	}
		else
		{
			Node current = header;
			Node next; 
			String minimum = current.value;
			while(current.next != null){				
				next = current.next; 
				if(minimum.charAt(0) > next.value.charAt(0))
					minimum = next.value;
				
				current = next; 
			}
			System.out.println("The minimum is:" + minimum);
		}
    }
    
    public void printMax(){
    	
    	if(header == null)
			System.out.println("No Maximum!");
    	else if(header.next == null)
    	{
    		System.out.println("The Maximum is: " + header.value);
    	}
		else
		{
			Node current = header;
			Node next; 
			String minimum = current.value;
			while(current.next != null){				
				next = current.next; 
				if(minimum.charAt(0) < next.value.charAt(0))
					minimum = next.value;
				
				current = next; 
			}
			System.out.println("The Maximum is:" + minimum);
		}
    }
 
    
    public void print(Node n) {    	
    	if(n == null)
			System.out.println("End of nodes!");
    	
    	else
		{    		
			System.out.print(n.value + " => " );
			print(n.next);
		}
    	
    	
    }
       
	
	public void preAddNode(Node n, String value){
		Node newNode;
		if (n == null){
			//List is empty
			newNode = new Node(null, value, null);
		}
		else if (n.previous == null) {
			//n is the first node
			addFront(value);
		}
		else {
			newNode = new Node(n.previous, value, n);
			n.previous.next = newNode;
			n.previous = newNode;
		}	
					
	}
	
	public Node findLast() {
		if (header == null)
			return null;
		else {
			Node temp = header;
			while (temp.next != null)
				temp = temp.next;
			return temp;
		}
	}

	public Node findItem(String str) {
		if (header == null)
			return null;
		else {
			Node temp = header;
			while (temp != null)
				if (str.equals(temp.value))
					return temp;
				else
					temp = temp.next;
			return null;
		}
	}

	public void deleteNode(Node n) {
		if (header != null && n != null) {
			if (n.next == null && n.previous == null) {
				// only one node
				header = null;
				n = null;
				System.out.println("I am here 1");

			} else if (n.previous == null) {
				// remove first node
				n.next.previous = null;
				header = n.next;
				n = null;
				System.out.println("I am here 2");
			} else if (n.next == null) {
				// remove last node
				n.previous.next = null;
				n = null;
				System.out.println("I am here 3");
			} else {
				// general case
				n.next.previous = n.previous;
				n.previous.next = n.next;
				n = null;
				System.out.println("I am here 4");
			}

		}

	}
	
	public void deleteList(){
		Node tempOne = header;
		Node tempTwo = header;
		while (tempOne != null) {
			tempOne = tempOne.next;
			tempTwo = null;
			tempTwo = tempOne;
		}
		header = null;
	}

	public String toString() {
		String str =""; 
		Node temp = header;
		while (temp != null) {
			str = str + "-->[" + temp.value.toString() + "]";
			temp = temp.next;
		}
		str = str + "-->[" + "NULL" + "]";
		return str;
	}

	public void printReverse() {
		String str =""; 
		Node temp = findLast();
		while (temp != null) {
			str = str + "==>[" + temp.value.toString() + "]";
			temp = temp.previous;
		}
		str = str + "==>[" + "NULL" + "]";
		System.out.println(str);
	}
	
	public class Node {
		String value;
		Node next;
		Node previous;

		Node(Node previous, String value, Node next) {
			this.previous = previous;
			this.value = value;
			this.next = next;
		}

		public String toString() {
			return value;
		}
	}

	public static void main(String[] args) {
	/*	MyStringLinkedList mySL = new MyStringLinkedList();
		System.out.println(mySL);
		
		mySL.printReverse();
		mySL.addFront("Carrot Cake");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.addFront("Blueberry Muffin");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.addFront("Apple Pie");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.addLast("Orange Juice");
		
		System.out.println(mySL);
		mySL.printReverse();
		mySL.addLast("Peach Sauce");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.deleteNode(mySL.findItem("Apple Pie"));
		System.out.println(mySL);
		mySL.printReverse();
		mySL.deleteNode(mySL.findItem("Peach Sauce"));
		System.out.println(mySL);
		mySL.printReverse();
		mySL.deleteNode(mySL.findItem("Carrot Cake"));
		System.out.println(mySL);
		mySL.printReverse();
		mySL.postAddNode(mySL.findItem("Blueberry Muffin"), "Carrot Cake");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.preAddNode(mySL.findItem("Blueberry Muffin"), "Apple Pie" );
		System.out.println(mySL);
		mySL.printReverse();
		mySL.postAddNode(mySL.findItem("Carrot Cake"), "Danish Delight" );
		System.out.println(mySL);
		mySL.printReverse();
		mySL.preAddNode(mySL.findItem("Orange Juice"), "Mango Smoothie" );
		System.out.println(mySL);
		mySL.printReverse();
		mySL.postAddNode(mySL.findItem("Orange Juice"), "Peach Sauce" );
		System.out.println(mySL);
		mySL.printReverse();
		mySL.deleteList();
		System.out.println(mySL);
		mySL.printReverse();*/
		
		//---------------------Testing my added methods
		
		MyStringLinkedList list = new MyStringLinkedList();
		list.print(list.header);
		
		list.addLast("Dell");
		list.addLast("Apple");
		list.addLast("Microst");
		list.addLast("HP");
		list.print(list.header);
		list.postAddNode(list.findItem("Dell"), "Toshiba");
		System.out.println(list.Size());
		list.print(list.header);
		System.out.println(list.isEmpty());
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		list.removeFirst();
		list.print(list.header);
		list.removeLast();
		list.print(list.header);
		list.printMin();
		list.printMax();	
		
	}
}

/*
End of nodes!
Dell => Apple => Microst => HP => End of nodes!
5
Dell => Toshiba => Apple => Microst => HP => End of nodes!
false
Dell
HP
Toshiba => Apple => Microst => HP => End of nodes!
Toshiba => Apple => Microst => End of nodes!
The minimum is:Apple
The Maximum is:Toshiba
*/