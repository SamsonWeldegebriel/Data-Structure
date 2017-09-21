package stackAndQueue;

import java.util.LinkedList;

interface Stack2 {
	
	public void push(Object ob);
	public Object pop();
	public Object peek();
	public boolean isEmpty();
	public int size();
}

public class LinkedListStack implements Stack2 {
	
	private LinkedList<Object> list;
	private Node top;
	private int size;
	
	void Stack2()
	{
		list = new LinkedList<Object>();
		top = null;
		size = 0;
	}
	
	@Override
	public void push(Object ob) {		
		if(top == null)
		{
			top = new Node(null, ob, null);
		}		
		else
		{
			Node temp = new Node(top, ob, null);
			top.next = temp;
			top = temp;
		}
		size++;
			
	}

	@Override
	public Object pop() {
		 if(top==null)
		 {
			 System.out.println("Empty Stack");
			 return null;
		 }
		 else if(top.prev == null)
		 {				
			 size--;
			 Node ret = top;
			 top = null;
			 return ret.value;
		 }
		 else
		 {
			 Node ret = top;
			 size--;
			 Node temp = top.prev;
			 top = null;
			 top = temp;
					 //new Node(top, ob, null);
			 return ret.value;
		 }
		
	}

	@Override
	public Object peek() {
		return top.value;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {		
		return size;
	}
	
	
	public static void main(String[] args) {
		LinkedListStack lls = new LinkedListStack();
		Object item;
		lls.push('A'); // push 4 items onto stack
		lls.push('B');
		lls.push('C');
		lls.push(4);

		System.out.println("size(): " + lls.size());
		item = lls.pop(); // delete item
		System.out.println(item + " is deleted");
		lls.push('D'); // add three more items to the stack
		lls.push('E');
		System.out.println(lls.pop() + " is deleted");
		lls.push('G'); // push one item
		item = lls.peek(); // get top item from the stack
		System.out.println(item + " is on top of stack");
		System.out.println("Size of the Stack : " + lls.size());
	}
	
	
	class Node{
		Object value;
		Node next;
		Node prev;
		
		public Node( Node prev, Object value, Node next) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
	}

}

/*
 * Output:
 * 
size(): 4
4 is deleted
E is deleted
G is on top of stack
Size of the Stack : 5

 * 
 */
