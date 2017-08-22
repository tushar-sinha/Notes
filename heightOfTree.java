import java.io.*;
import java.util.*;
class Node{
	int data;
	Node left, right;
	Node(int item){
		data = item;
		left = right;
	}
}
class heightOfTree{
	Node root;
	static int treeHeight(Node node)
	{
		if(node == null)
			return 0;
		Queue<Node> q = new LinkedList();
		q.add(node);
		int height = 0;
		while(true)
		{
			int nodeCount = q.size();
			if(nodeCount == 0)
				return height;
			height++;
			while(nodeCount>0)
			{
				Node newnode = q.peek();
				q.poll();
				if(newnode.left!=null)
					q.add(newnode.left);
				if(newnode.right!=null)
					q.add(newnode.right);
				nodeCount--;
			}
		}
	}
	public static void main(String args[]){
		heightOfTree tree = new heightOfTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);	
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.println("Height of tree is "+tree.treeHeight(tree.root));
	}
}