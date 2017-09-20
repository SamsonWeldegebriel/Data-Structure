package stackAndQueue;

import java.util.Arrays;

public class ArrayQueueImpl {
	private int[] arr = new int[10];
	private int front = -1;
	private int rear = 0;
	
	private int size = 0;

	public int peek() {
		if(arr.length == 0)
		{
			System.out.println("Queue is Empty");
			return -1;
		}
		else	
			return arr[front];
	}

	public void enqueue(int obj) {	
		if(rear == arr.length-1)
			resize();
		if(front == -1)
		{
			front++;
			arr[rear] = obj;
			size++;
		}
		else
		{
			arr[++rear] = obj;			
			size++;
		}			
	}

	public int dequeue() {
		if(front == -1)
		{
			System.out.println("Queue is Empty");
			return -1;
		}
		
		else
		{
			size--;
			return arr[front++];
		}	
	}

	public boolean isEmpty() {
		
		return size == 0;
	}

	public int size() {
		return size;
	}

	private void resize() {
		int[] temp = new int[arr.length*2];
		System.arraycopy(arr, front, temp, 0, size);
		arr = temp;
	}
	
	public void print(){
		int[] temp = new int[size];
		System.arraycopy(arr, front, temp, 0, size);
		System.out.println(Arrays.toString(temp));
	}
	
	@Override
	public String toString() {
		return "ArrayQueueImpl [arr=" + Arrays.toString(arr) + ", front="
				+ front + ", rear=" + rear + "]";
	}

	public static void main(String[] args) {
		ArrayQueueImpl arrque = new ArrayQueueImpl();
		System.out.println("is Emptry?:" + arrque.isEmpty());
		arrque.enqueue(10);
		arrque.enqueue(20);
		arrque.enqueue(30);
		arrque.enqueue(40);
		arrque.enqueue(50);
		arrque.enqueue(60);
		arrque.enqueue(70);
		arrque.enqueue(80);
		arrque.enqueue(90);
		arrque.enqueue(100);
		arrque.enqueue(110);
		arrque.enqueue(120);
		arrque.enqueue(130);
		
		
		arrque.print();
		arrque.dequeue();
		arrque.print();
		arrque.dequeue();
		arrque.print();
		System.out.println("Size:" + arrque.size());		
		System.out.println("Pick:" + arrque.peek());
		arrque.dequeue();
		arrque.print();
		System.out.println("Pick:" + arrque.peek());
		System.out.println("is Emptry?:" + arrque.isEmpty());
		
	}
}

/*
Output: 
*
is Emptry?:true
[10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130]
[20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130]
[30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130]
Size:11
Pick:30
[40, 50, 60, 70, 80, 90, 100, 110, 120, 130]
Pick:40
is Emptry?:false
*/