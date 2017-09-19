import java.io.*;
import java.util.*;
class Node{
	Node left,right;
	int data;
	Node(int item){
		data = item;
		left = right = null;
	}
}
class traversalWithoutRec{
	Node root;
	public static void inorderDisplay(Node node){
		Stack<Node> st = new Stack<>();
		if(node == null)
			{
				System.out.println("Tree is empty");
				return;
			}
		while(node != null)
		{
			st.push(node);
			node = node.left;
		}
		while(!st.isEmpty()){
			node = st.pop();
			System.out.print(node.data + " ");
			if(node.right != null)
			{
				node = node.right;
				while(node != null)
				{
					st.push(node);
					node = node.left;
				}
			}
		}
	}
	public static void preorderDisplay(Node node){
		Stack<Node> st1 = new Stack<>();
		if(node == null)
		{
			System.out.println("Nothing to display");
			return;
		}
		st1.push(node);
		while(!st1.isEmpty()){
		node = st1.pop();
		System.out.print(node.data+" ");
		if(node.right != null)
			st1.push(node.right);
		if(node.left != null)
			st1.push(node.left);
		}
	}
	static void postorderDisplay(Node node){
		Stack<Node> st2 = new Stack<>();
		if(node == null)
			return;
		st2.push(node);
		Node prev = null;
		while(!st2.isEmpty())
		{
			Node cur = st2.peek();
			if(prev == null || prev.left == cur || prev.right==cur){
				if(cur.left != null)
					st2.push(cur.left);
				else if(cur.right != null)
					st2.push(cur.right);
				else{
					st2.pop();
					System.out.print(cur.data+" ");
				}
			}
			else if(cur.left == prev){
				if(cur.right != null)
					st2.push(cur.right);
				else{
					st2.pop();
					System.out.print(cur.data+" ");
				}
			}
			else if(cur.right==prev){
				st2.pop();
				System.out.print(cur.data+" ");
			}
			prev = cur;
		}
	}
	public static void main(String args[]){
		traversalWithoutRec ob = new traversalWithoutRec();
		ob.root 				= new Node(1);
		ob.root.left 			= new Node(2);
		ob.root.right 			= new Node(3);
		ob.root.left.left		= new Node(4);
		ob.root.left.right 		= new Node(5);
		ob.root.right.left		= new Node(6);
		ob.root.right.right		= new Node(7);
		System.out.println("INORDER : ");
		inorderDisplay(ob.root);
		System.out.println("\nPREORDER : ");
		preorderDisplay(ob.root);
		System.out.println("\nPOSTORDER : ");
		postorderDisplay(ob.root);
	}
}