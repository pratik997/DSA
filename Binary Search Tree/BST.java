import java.io.*;
import java.lang.Math;
class Node
{
	public Node left;
	public int data;
	public Node right;
	public Node parent;
	Node(){}
	Node(int data)
	{
		this.data = data;
	}
	public int getData()
	{
		return data;
	}
}

class Tree
{
	public Node root;

	public void insertIntoTree(Node root,int val)
	{
		if(root.getData()<val){
			if(root.right!=null)insertIntoTree(root.right,val);
			else
			{
				Node newNode = new Node(val);
				newNode.parent = root;
				root.right = newNode;
			}
		}
		else 
		{
			if(root.left!=null)insertIntoTree(root.left,val);
			else
			{
				Node newNode = new Node(val);
				newNode.parent = root;
				root.left = newNode;
			}
		}
	}
	public void insert(int val)
	{
		if (root == null)
			root = new Node(val);
		else
			insertIntoTree(root, val);
	}

	public int getHeight(Node root)
	{
		if(root==null)return 0;
		return Math.max(getHeight(root.left),getHeight(root.right))+1;
	}
	public int countFull(Node root)
	{
		if(root==null)return 0;
		if(root.left!=null && root.right!=null)return countFull(root.left)+countFull(root.right)+1;
		return countFull(root.left)+countFull(root.right);
	}
	public int count(Node root)
	{
		if(root==null)return 0;
		if(root.left==null && root.right==null)return 0;
		return count(root.left)+count(root.right)+1;
	}
	public int countLeaves(Node root)
	{
		if(root==null)return 0;
		if(root.left == null && root.right == null)
		{
			return 1;
		}
		return countLeaves(root.left)+countLeaves(root.right);
	}
	public Node findPredecessor(Node head)
	{
		Node cur = head;
		if(head.left!=null)
		{
			cur = head.left;
			while(cur.right!=null)cur = cur.right;
		}
		else
		{
			while(cur.parent!=null && cur.parent.right != cur)
			{
				cur = cur.parent;
			}
		}
		return cur;
	}
	public Node search(int val)
	{
		if(root.data == val)return root;
		Node cur = root;
		while(cur!=null && cur.data!=val)
		{
			if(cur.data<val)cur = cur.right;
			else cur = cur.left;
		}
		return cur;
	}
	public void inOrder(Node head)
	{
		if(head==null)return;
		inOrder(head.left);
		System.out.print(head.getData()+" ");
		inOrder(head.right);
	}
	public void preOrder(Node head)
	{
		if(head == null)return;
		System.out.print(head.getData()+" ");
		preOrder(head.left);
		preOrder(head.right);
	}
	public void postOrder(Node head)
	{
		if(head == null)return;
		postOrder(head.left);
		postOrder(head.right);
		System.out.print(head.getData()+" ");	
	}
}
class BST
{
	public static void main(String pp[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Tree bst = new Tree();
		int val = 0;
		while(true)
		{
			System.out.println("Enter your choice\n1- Insert\n2- Delete\n3- Get Height\n4- Get Count of Full Nodes\n5- Get Count of Leaf Nodes\n6- Get count of Non-leaf Nodes\n7- Preorder Traversal\n8- Inorder Traversal\n9- Postorder Traversal");
			switch(Integer.parseInt(br.readLine()))
			{
				case 1:
				val = Integer.parseInt(br.readLine());
				bst.insert(val);
				break;
				// case 2:
				// val = Integer.parseInt(br.readLine());
				// System.out.println("Replacing node is "+bst.delete(val));
				// break;
				case 3:
				System.out.println("Current height of the tree is: "+bst.getHeight(bst.root));
				break;
				case 4:
				System.out.println("Number of nodes in the tree is: "+bst.countFull(bst.root));
				break;
				case 5:
				System.out.println("Number of leaf nodes in the tree is :"+bst.countLeaves(bst.root));
				break;
				case 6:
				System.out.println("Number of non-leaf nodes in the tree is :"+bst.count(bst.root));
				break;
				case 7:
				bst.preOrder(bst.root);
				System.out.println();
				break;
				case 8:
				bst.inOrder(bst.root);
				System.out.println();
				break;
				case 9:
				bst.postOrder(bst.root);
				System.out.println();
				break;
				default:
				System.exit(0);
			}
		}
	}
}