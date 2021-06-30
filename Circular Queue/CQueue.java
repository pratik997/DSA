import java.io.*;
class List
{
	int[] structure;
	int front = 0;
	int rear = 0;
	int curSize = 0;
	public void create(int size)
	{
		structure = new int[size];
		curSize = 0;
	}
	public void insert(int data)
	{
		curSize++;
		if(curSize>structure.length)
		{
			int temp[] = new int[2*curSize];
			int j = structure.length,flag = 0,i = 0;
			for(i = 0;i<j;i++)
			{
				if(i!=front && flag == 0)
				{
					flag = 1;
					i++;
					j++;
					continue;
				}
				else if(i==front)
				{
					j++;
					flag = 1;
				}
				temp[i] = structure[i%structure.length];
			}
			rear = i-1;
			structure = temp;
		}
		if(curSize == 1)
		{
			structure[front] = data;
		}
		else 
		{
			structure[(rear+1)%structure.length] = data;
			rear = (rear+1)%structure.length;
		}
	}
	public int delete()
	{
		if(curSize == 0)return -1;
		int val = structure[front];
		structure[front] = 0;
		front=(front+1)%structure.length;
		curSize--;
		if(curSize == 0)
		{
			front = 0;
			rear = 0;
		}
		return val;
	}
	public int peek()
	{
		if(front==rear && rear==0)return -1;
		return structure[front];
	}
}
class CQueue
{
	public static void main(String pp[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List cqueue = new List();
		while(true)
		{	
			System.out.println("Enter your choice:\n1. Create one\n2. Insert\n3. Delete\n4. Peek");
			switch(Integer.parseInt(br.readLine()))
			{
				case 1:
				cqueue.create(1);
				break;
				case 2:
				System.out.println("Enter an element:");
				cqueue.insert(Integer.parseInt(br.readLine()));
				break;
				case 3:
				System.out.println("Deleted element is :"+cqueue.delete());
				break;
				case 4:
				System.out.println("Currently peek element is:"+cqueue.peek());
				break;
				default:
				System.exit(0);
			}
		}
	}
}

