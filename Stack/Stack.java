import java.io.*;

class Node
{
	private int data;
	Node next;

	Node(){}
	Node(int data)
	{
		this.data = data;
		next = null;
	}
	public int getData(){
		return data;
	}
}
class List
{
	private Node head;

	List(){}
	List(int data)
	{
		head = new Node(data);
	}
	public void create(int[] arr)
	{
		head = null;
		for(int i=0;i<arr.length;i++)
		{
			Node newNode = new Node(arr[i]);
			newNode.next = head;
			head = newNode;
		}
	}
	public void push(int data)
	{
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	public int pop()
	{
		int pop = head.getData();
		Node newNode = new Node();
		newNode = head;
		head = head.next;
		newNode.next = null;
		return pop;
	}
	public int peek()
	{
		return head==null?-1:head.getData();
	}
}
class Stack
{
	public static void main(String pp[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of element : ");
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the number : ");
			arr[i] = Integer.parseInt(br.readLine());
		}
		List stack = new List();
		stack.create(arr);
		int ch = 0;
		while(true)
		{
			System.out.println("Enter your choice :\n1. Insert an element\n2. Delete an element\n3. Get the top element\4. Exit");
			ch = Integer.parseInt(br.readLine());
			switch(ch)
			{				
				case 1:
				stack.push(Integer.parseInt(br.readLine()));
				break;
				case 2:
				System.out.println(stack.pop()+" is deleted and now the top element is "+stack.peek());
				break;
				case 3:
				System.out.println(stack.peek()+" is the top element since last operation.");
				break;
				default:
				System.exit(0);
			}
		}
	}
}