import java.io.*;
import java.util.*;
class Node{
	Node left;
	Node right;
	int data;
	public Node(int item)
	{
		data = item;
		left = right = null;
	}
}
class levelOrder{
	Node root;
	static void printLvlOrder(Node node){
		int h = height(node);
		for(int i = 1; i<=h; i++)
		{
			printByLvl(node,i);
		}
	}
	static int height(Node root){
		if(root == null)
			return 0;
		else{
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		if(lHeight > rHeight)
			return lHeight+1;
		else
			return rHeight+1;
		}
	}
	static void printByLvl(Node node, int lvl)
	{
		if(node == null)
			return;
		if(lvl == 1)
			System.out.print(node.data+" ");
		else if(lvl>1)
		{
			printByLvl(node.left, lvl-1);
			printByLvl(node.right, lvl-1);
		}
	}
	public static void main(String args[]){
		levelOrder tree = new levelOrder();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);	
		tree.root.right.right = new Node(7);
		printLvlOrder(tree.root);
	}
}







