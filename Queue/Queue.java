import java.io.*;

class Node
{
	private int data;
	Node next;
	Node(int data)
	{
		this.data = data;
	}
	public int getData()
	{
		return data;
	}
}
class List
{
	public Node head;
	public Node tail;
	public void create(int arr[])
	{
		head = new Node(arr[0]);
		tail = head;
		head.next = null;
		for(int i = 1 ; i < arr.length ; i ++)
		{
			Node newNode = new Node(arr[i]);
			head.next = newNode;
			head = head.next;
		}
		head.next = null;
	}
	public void enqueue(int data)
	{
		if(head == null)
		{
			head = new Node(data);
			tail = head;
		}
		else
		{
			Node newNode = new Node(data);
			head.next = newNode;
			head = head.next;
		}
		head.next = null;
	}
	public int dequeue()
	{
		if(tail == null)return -1;
		Node newNode = tail.next;
		tail.next = null;
		int res = tail.getData();
		tail = newNode;
		return res;
	}
	public int peek()
	{
		return tail!=null?tail.getData():-1;
	}
}
class Queue
{
	public static void main(String pp[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of element: ");
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		for(int i = 0 ; i < n ; i ++)
		{
			System.out.println("Enter the element: ");
			arr[i] = Integer.parseInt(br.readLine());
		}
		List queue = new List();
		queue.create(arr);
		while(true)
		{
			System.out.println("Enter your choice\n1. Insert\n2. Delete\n3. Peek:");
			switch(Integer.parseInt(br.readLine()))
			{
				case 1:
				queue.enqueue(Integer.parseInt(br.readLine()));
				break;
				case 2:
				System.out.println("The deleted element is "+queue.dequeue());
				break;
				case 3:
				System.out.println("The top element is "+queue.peek());
				break;
				default:
				System.exit(0);
			}
		}
	}
}