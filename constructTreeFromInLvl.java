import java.io.*;
import java.util.*;
class Node{
	int data;
	Node left, right;
	Node(int item){
		data = item;
	}
	public void setLeft(Node left){
		this.left = left;
	}
	public void setRight(Node right){
		this.right = right;
	}
}
class constructTreeFromInLvl{
	Node buildTree(int[] in, int[] lvl){
		Node startNode = null;
		return constructTree(startNode, in, lvl, 0, in.length-1);
	}
	Node constructTree(Node startNode, int[] in, int[] lvl, int inStart, int inEnd){
		if(inStart>inEnd)
			return null;
		if(inStart==inEnd)
			return new Node(in[inStart]);
		Boolean found = false;
		int index = 0;
		for(int i = 0; i<lvl.length; i++){
			int data = lvl[i];
			for(int j = inStart; j<inEnd; j++)
			{
				if(data == in[j])
				{
					index = j;
					startNode = new Node(data);
					found = true;
					break;
				}
			}
			if(found)
				break;
		}
		startNode.setLeft(constructTree(startNode, in, lvl,inStart, index-1));
		startNode.setRight(constructTree(startNode, in, lvl,index+1, inEnd));
		return startNode;
	}
	void printInorder(Node node){
		if(node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data+" ");
		printInorder(node.right);
	}
	public static void main(String args[]){		
        constructTreeFromInLvl tree = new constructTreeFromInLvl();
        int in[] = new int[]{4, 8, 10, 12, 14, 20, 22};
        int level[] = new int[]{20, 8, 22, 4, 12, 10, 14};
        Node node = tree.buildTree(in, level);
  
        /* Let us test the built tree by printing Inorder traversal */
        System.out.print("Inorder traversal of the constructed tree is ");
        tree.printInorder(node);
	}
}