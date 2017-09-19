import java.io.*;
import java.util.*;
class Node{
	int data;
	Node left, right;
	Node(int item){
		data = item;
		left = right = null;
	}
}
class Value{
	int min, max;
}
class treeVerticalPrint{
	Node root;
	Value val = new Value();
	void findMinMax(Node node, Value v, int d)
	{
		if(node == null)
			return;
		if(d<v.min)
			v.min = d;
		if(d>v.max)
			v.max = d;
		findMinMax(node.left, v, d-1);
		findMinMax(node.right, v, d+1);
	}
	void printVertical(Node node, int line_no, int depth)
	{
		if(node == null)
			return;
		if(line_no == depth)
			System.out.print(node.data+" ");
		printVertical(node.left, line_no, depth-1);
		printVertical(node.right, line_no, depth+1);
	}
	void verticalPrint(Node node){
		findMinMax(node,val,0);
		for(int i = val.min; i<=val.max; i++)
		{
			printVertical(node, i, 0);
			System.out.println("");
		}
	}
	public static void main(String args[])
	{
		treeVerticalPrint ob = new treeVerticalPrint();
		ob.root 				= new Node(1);
		ob.root.left 			= new Node(2);
		ob.root.right 			= new Node(3);
		ob.root.left.left		= new Node(4);
		ob.root.left.right 		= new Node(5);
		ob.root.right.left 		= new Node(6);
		ob.root.right.right 	= new Node(7);
		System.out.println("Vertical Traversal : ");
		ob.verticalPrint(ob.root);
	}
}
