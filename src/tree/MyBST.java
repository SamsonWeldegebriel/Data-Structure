package tree;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;
// Demo code for the user implemenation of Binary search tree
public class MyBST {
	/** The tree root. */
	private BinaryNode root;

	public MyBST() {
		root = null;
	}
	
	public void preOrder(){		
		preOrderPrint(root); 			
}
	
	private void preOrderPrint(BinaryNode t){
		if(t != null)
		{
			System.out.println(t.element);
			preOrderPrint(root.left);
			preOrderPrint(root.right);			
		}				
	}
	
	public void postOrder(){
			postOrder(root);
	}
	private void postOrder(BinaryNode t){  
		if(t != null)
		{
			preOrderPrint(root.left);
			preOrderPrint(root.right);
			System.out.println(t.element);
		}	
	}
	
	public boolean contains(Integer key){ 
		if(key != null)
		{
			if(root.element == key)
			{
				return true;
			}
			printTree( root.left );
		    printTree( root.right );
		}	
		return false;
	}
	
	public Integer getRoot(){//implement 
		
		return root.element;
	}
	
	public Integer[] leafNodes(){
		return leafNodes(root);
		} 
	
	private Integer[] leafNodes(BinaryNode t){
		
		return null;
	}
	
	int size = 0;
	
	public int size(){//implement 
		if()
		printTree( root.left );
	    printTree( root.right );
	}
	
	public boolean isEmpty(){
		 return root == null;
	}
	
	public Integer findMin(){
		 return findMin(root);
		}
		private Integer findMin(){
			}
		}
	
	public Integer findMax(){
		 return findMax(root);
		}
		public Integer findMax(){
			
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
		System.out.println(str);
			
	}
}
