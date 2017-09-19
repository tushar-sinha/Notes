import java.io.*;
import java.util.*;
class Node{
	int data;
	Node left, right;
	Node(int item){
		left = null;
		right = null;
		data = item;
	}
}
class sameTree{
	Node root;
	static boolean findSameTree(Node root1, Node root2)
	{
		if(root1 == null && root2 == null)
		{
			return true;
		}
		if(root1 == null || root2 == null)
			return false;
		return findSameTree(root1.left, root2.left)&&findSameTree(root1.right, root2.right);
	}
	public static void main(String args[]){
		sameTree root1 = new sameTree();
		sameTree root2 = new sameTree();
		root1.root = new Node(1);
		root1.root.left = new Node(2);
		root1.root.right = new Node(3);
		root2.root = new Node(1);
		root2.root.left = new Node(2);
		root2.root.right = new Node(3);
		if(findSameTree(root1.root, root2.root))
			System.out.println("Same Tree Structure");
		else
			System.out.println("Not Same Tree Structure");
	}
}