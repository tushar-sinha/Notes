import java.io.*;
import java.util.*;
class Node{
	Node left, right;
	int data;
	Node(int item){
		left = null;
		right = null;
		data = item;
	}
}
class treeTraversal{
	Node root;
	void preorder(Node root){
		if(root!=null){
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
		}
	}
	void inorder(Node root){
		if(root!=null){
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	void postorder(Node root)
	{
		if(root!=null){
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data+" ");
		}
	}
	ArrayList<ArrayList<Integer>> lvlOrderTraversal(Node root){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Queue<Node> q = new LinkedList<>();
		if(root == null)
			return res;
		q.offer(root);
		q.offer(null);
		ArrayList<Integer> cur = new ArrayList<>();
		while(!q.isEmpty()){
			Node temp = q.poll();
			if(temp!=null){
			cur.add(temp.data);
			if(temp.left!=null)
				q.offer(temp.left);
			if(temp.right!=null)
				q.offer(temp.right);
		}
		else{
			ArrayList<Integer> cur1 = new ArrayList<Integer>(cur);
			res.add(cur1);
			cur.clear();
			if(!q.isEmpty())
				q.offer(null);
		}
		}
		return res;
	}
	static int max(Node root){
		int max = Integer.MIN_VALUE;
		Queue<Node> q = new LinkedList<>();
		if(root == null)
			return max;
		q.offer(root);
		while(!q.isEmpty())
		{
			Node temp = q.poll();
			if(temp.data > max)
			{
				max = temp.data;
			}
			if(temp!=null){
			if(temp.left!=null)
				q.offer(temp.left);
			if(temp.right!=null)
				q.offer(temp.right);	
			}			
		}
		return max;
	}
	int maxRec(Node root){
		int max = Integer.MIN_VALUE;
		if(root!=null){
			int leftMax = maxRec(root.left);
			int rightMax = maxRec(root.right);
			if(leftMax > rightMax)
				max = leftMax;
			else
				max = rightMax;
			if(root.data > max)
				max = root.data;
		}
	return max;
	}
	static boolean searchRec(Node root, int item){
		if(root == null)
			return false;
		if(root.data == item)
			return true;
		return searchRec(root.left,item)||searchRec(root.right,item);
	}
	boolean search(Node root, int item)
	{
		if(root == null)
			return false;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()){
			Node temp = q.poll();
			if(temp.data == item)
			{
				return true;
			}
			if(temp != null){
				if(temp.left !=null)
					q.offer(temp.left);
				if(temp.right != null)
					q.offer(temp.right);
			}
		}
		return false;
	}
	static void printLeaves(Node node){
		if(node == null)
			return;
		printLeaves(node.left);
		if(node.left == null && node.right == null)
			System.out.print(node.data+" ");
		printLeaves(node.right);
	}
	static void printLeft(Node node)
	{
		if(node == null)
			return;
		if(node.left!=null){
			System.out.print(node.data+" ");
			printLeft(node.left);
		}
		else if(node.right != null){
			System.out.print(node.data+" ");
			printLeft(node.right);
		}
	}
	static void printRight(Node node){
		if(node == null)
			return;
		if(node.right!=null){
			System.out.print(node.data+" ");
			printRight(node.right);
		}
		else if(node.left != null){
			System.out.print(node.data+" ");
			printRight(node.left);
		}

	}
	static void boundary(Node node){
		if(node == null)
			return;
		System.out.print(node.data+" ");
		printLeft(node.left);
		printLeaves(node);
		printRight(node.right);
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> ar = new ArrayList<ArrayList<Integer>>();
		treeTraversal ob = new treeTraversal();
		ob.root = new Node(1);
		ob.root.left = new Node(2);
		ob.root.right = new Node(3);
		ob.root.left.left = new Node(4);
		ob.root.left.right = new Node(5);
		ob.root.right.left = new Node(6);
		ob.root.right.right = new Node(7);
		ob.root.left.left.left = new Node(8);
		ob.root.left.left.right = new Node(9);
		ob.root.left.right.left = new Node(10);
		ob.root.left.right.right = new Node(11);
		System.out.println("TREE TRAVERSAL :\n[1]PREORDER\n[2]INORDER\n[3]POSTORDER\n[4]LEVEL ORDER TRAVERSAL"+
			"\n[5]MAX(iterative)\n[6]MAX(recursive)\n[7]SEARCH(Iterative)\n[8]SEARCH(RECURSIVE)\n[9]BOUNDARY TRAVERSAL");
		int ch = sc.nextInt();
		switch(ch){
			case 1:
			ob.preorder(ob.root);
			break;
			case 2:
			ob.inorder(ob.root);
			break;
			case 3:
			ob.postorder(ob.root);
			break;
			case 4:			
			ar = ob.lvlOrderTraversal(ob.root);
			for(ArrayList<Integer> a : ar)
			{				
				System.out.println(a);
			}		
			case 5:
			System.out.println(max(ob.root));
			break;		
			case 6:
			System.out.println(ob.maxRec(ob.root));
			break;
			case 7:
			System.out.println("Enter element to search");
			int data1 = sc.nextInt();
			System.out.println(ob.search(ob.root,data1));
			break;
			case 8:
			System.out.println("Enter element to search");
			int data2 = sc.nextInt();
			System.out.println(searchRec(ob.root,data2));
			break;
			case 9 :
			System.out.println("Boundary Traversal :");
			boundary(ob.root);
			break;
			default:
			System.out.println("WRONG CHOICE!");
		}
	}
}
