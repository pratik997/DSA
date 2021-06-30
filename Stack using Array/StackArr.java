import java.io.*;

class List
{
	private int[] arr;
	private int length;
	List(){

	}
	List(int arr[])
	{
		this.arr = arr;
		length = arr.length;
	}
	public void push(int n)
	{
		length += 1;
		if(length>=arr.length)
		{
			int[] newArr = new int[length*2];
			for(int i=0;i<length-1;i++)
			{
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
		arr[length-1] = n;
	}
	public int pop()
	{
		int res = arr[length-1];
		length -= 1;
		arr[length] = 0;
		return res;
	}
	public int peek()
	{
		return arr[length-1];
	}
}
class StackArr
{
	public static void main(String pp[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of element : ");
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the element : ");
			arr[i] = Integer.parseInt(br.readLine());
		}
		List stack = new List();
		int ch = 0;
		while(true)
		{
			System.out.println("Enter your choice :\n1. Create a stack with the given array.\n2. Insert an element\n3. Delete an element\n4. Get the top element\5. Exit");
			ch = Integer.parseInt(br.readLine());
			switch(ch)
			{
				case 1:
				stack = new List(arr);
				break;
				case 2:
				stack.push(Integer.parseInt(br.readLine()));
				break;
				case 3:
				System.out.println(stack.pop()+" is deleted and now the top element is "+stack.peek());
				break;
				case 4:
				System.out.println(stack.peek()+" is the top element since last operation.");
				break;
				case 5:
				System.exit(0);
				default:break;
			}
		}
	}
}