// prints leaf only if full binary tree
import java.io.*;
import java.util.*;
class Node{
	Node left, right;
	int data;
	Node(int item){
		data = item;
		left = right = null;
	}
}
class leafTraversal{
	Node root;
	leafTraversal(){
		root = null;
	}
	static int height(Node node){
		if(node == null)
			return 0;
		int lheight = height(node.left);
		int rheight = height(node.right);
		if(lheight > rheight)
			return lheight+1;
		else
			return rheight+1;
	}
	static void printLeafByLvl(Node node){
		int h = height(node);
		printLvl(node,h);
	}
	static void printLvl(Node node, int lvl){
		if(node==null)
			return;
		if(lvl==1)
			System.out.print(node.data+" ");
		else{
			printLvl(node.left,lvl-1);
			printLvl(node.right,lvl-1);
		}
	}
	public static void printLeaf(Node node){
		Queue<Node> q = new LinkedList<>();
		if(node == null)
			return;
		q.offer(node);
		while(!q.isEmpty()){
			node = q.poll();
			if(node.left == null && node.right == null){
				System.out.print(node.data+" ");
			}
			if(node.left!=null)
				q.offer(node.left);
			if( node.right!=null)
				q.offer(node.right);
		}
	}
	public static void main(String args[]){
		leafTraversal ob = new leafTraversal();
		ob.root 				= new Node(1);
		ob.root.left 			= new Node(2);
		ob.root.right 			= new Node(3);
		ob.root.left.left		= new Node(4);
		ob.root.left.right 		= new Node(5);
		System.out.println("Print leaf nodes by LVL : ");
		printLeafByLvl(ob.root);
		System.out.println("\nPrint leaf nodes : ");
		printLeaf(ob.root);
	}
}