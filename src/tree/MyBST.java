package tree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;
// Demo code for the user implemenation of Binary search tree
public class MyBST {
	/** The tree root. */
	private BinaryNode root;
	int min;
	int max;
	int size = 0;
	int NumLeafs = 0;

	public MyBST() {
		root = null;
	}
	
	public void preOrder(){	
		
		if(root == null)
			System.out.println("The root is empty!");
		else
			preOrder(root); 			
}
	
	private void preOrder(BinaryNode t){
		if(t != null)
		{
			System.out.print(t.element+",");
			preOrder(t.left);
			preOrder(t.right);			
		}				
	}
	
	public void postOrder(){
		if(root == null)
			System.out.println("The root is empty!");
		else
			postOrder(root);
	}
	private void postOrder(BinaryNode t){  
		if(t != null)
		{
			postOrder(t.left);
			postOrder(t.right);
			System.out.print(t.element+",");
		}	
	}
	
	public boolean contains(Integer key){ 
		if(key == null)
		{
			return false;
		}
		else
			return contains(key, root);
	}
	
	public boolean contains(Integer key, BinaryNode t)
	{
		if(t != null)
		{
			if(t.element.intValue() == key.intValue())
			{
				return true;
			}
				
			
			if(contains(key, t.left)) return true;
			if(contains(key, t.right)) return true;
		}
		return false;
	}
	
	public Integer getRoot(){//implement 
		
		return root.element;
	}
	
	public Integer leafNodes(){
		if(root == null)
		{
			System.out.println("It is empty!");
			return 0;
		}
		else
			return leafNodes(root);
		} 
	
	private Integer leafNodes(BinaryNode t){		
		
		if(t != null)
		{
			if(t.left == null && t.right == null)
				NumLeafs++;
			leafNodes(t.left);
			leafNodes(t.right);
		}
		
		return NumLeafs;
	}
	
	
	
	public int size(){	        
	    if( root == null )
	    	return 0;
		else
			return size(root);
	}
	
	
	
	public int size(BinaryNode t){
		if(t != null)
		{
			size++;
			size(t.left);
			size(t.right);
		}
		return size;
	}
	
	public boolean isEmpty(){		
		return(size() == 0);
	}
	

	public Integer findMin(){
		if(root != null)
		{
			min = root.element;
			return findMin(root);
		}
		else
			return null;
		}
		private Integer findMin(BinaryNode t){
			if(t != null)
			{
				if(t.element < min)
					min = t.element;
				
				findMin(t.left);
				findMin(t.right);
			}
			return min;
		}
		
	
	public Integer findMax(){
		if(root != null)
		{
			max = root.element;
			return findMax(root);
		}
		else
			return null;
	}
		
	private Integer findMax(BinaryNode t){			
		if(t != null)
		{
			if(t.element > max)
				max = t.element;
			
			findMax(t.left);
			findMax(t.right);
		}
		return max;
	}

	
	/**
	* Prints the values in the nodes of the tree
	* in sorted order. Inorder Traversal
	*/
	public void printTree() {
		if( root == null )
			System.out.println( "Empty tree" );
		else
			printTree(root);
	}
	// Inorder Traversal to print the nodes in Ascending order
	private void printTree( BinaryNode t ){
		if( t != null ){
			printTree( t.left );
		    System.out.print(t.element+",");
		    printTree( t.right );
		} 
	}
		 
	//Assume the data in the Node is an Integer.	

	public void insert(Integer x) {
		if (root == null) {
			root = new BinaryNode(x);
			
			return;
		}
		else { 
			BinaryNode n = root;
			boolean inserted = false;

			while(!inserted)//true
				{
				
				if(x.compareTo(n.element)<0) {
					
					//space found on the left
					if(n.left == null){
						n.left = new BinaryNode(x,null,null);
						inserted = true;
						
						
					}
					//keep looking for a place to insert (a null)
					else {
						n = n.left;
					}
				}				
				else if(x.compareTo(n.element)>0){ 
					
					//space found on the right					
					if(n.right==null){
					n.right = new BinaryNode(x,null,null);
					inserted = true;
					
					}
						//keep looking for a place to insert (a null)
					else {
							n = n.right;
					}
										
				}
				// if a node already exists
				else {
					inserted = true;
					
				}

			}

		}
	}
	private class BinaryNode {

		private Integer element;// The data in the node
		private BinaryNode left;      // Left child
		private BinaryNode right;     // Right child	  
		// Constructors 
		
		BinaryNode( Integer theElement ){
			this( theElement, null, null );
		}	

		BinaryNode( Integer element, BinaryNode left, BinaryNode right ){
			this.element = element;
			this.left = left;
			this.right = right;
		}
		
	}
		

	public static void main(String[] args) {
		
		MyBST mybst = new MyBST();
		
		int [] a = {15, 12, 9, 56, 1, 16, 19, 22, 3, 100, 2, 25};
			
		for (int j = 0; j < a.length; j++ ) {
			mybst.insert(a[j]);
					
		}
		mybst.insert(12);
		mybst.printTree();
		
		System.out.println("Inorder");
		mybst.preOrder(); //The preorder is 15 12 9 1  3 2 56 16  19  22  25   100  
		System.out.println("Preorder");
		mybst.postOrder();//The postorder is 2  3 1  9  12 25 22 19 16   100 56 15
		System.out.println("Postorder");
		
		System.out.println("The tree contains 3? "+ mybst.contains(3));
		System.out.println("The Root is: " + mybst.getRoot());
		System.out.println("Leaf nodes are: " + mybst.leafNodes());
		
		System.out.println("Size is:" + mybst.size());
		System.out.println("The tree is empty: " + mybst.isEmpty());
		System.out.println("The Minimum is: " + mybst.findMin());
		System.out.println("The Maximum is: " + mybst.findMax());
		/*
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		for (int j = 0; j < a.length; j++ ) {
			ts.add(a[j]);
			System.out.println("\nAfter inserting " + j + "th item " + a[j]);
			Iterator<Integer> it = ts.iterator();		
			Integer nextItem = null;
			while(it.hasNext()) {
				nextItem = it.next();
				System.out.print(nextItem + " ");
			} 
			System.out.println();
		}
		
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		map.put(8, "Hello");
		map.put(10, "World!");
		map.put(11, "Welcome");
		map.remove(8);
		String str = map.get(11)+", "+ map.get(10);
		System.out.println(str); */
			
	}
}
