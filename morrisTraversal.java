import java.io.*;
import java.util.*;
class morrisTraversal{
	Node root;	
	static void morrisInorder(Node node){
		if(node == null)
			return;
		Node cur = node;
		Node pre = null;
		while(cur != null){
			if(cur.left == null)
			{
				System.out.print(cur.data+" ");
				cur = cur.right;
			}
			else{
				pre = cur.left;
				while(pre.right != null && pre.right != cur)
					pre = pre.right;
				if(pre.right == null){
					pre.right = cur;
					cur = cur.left;
				}
				else{
					pre.right = null;
					System.out.print(cur.data+" ");
					cur = cur.right;
				}
			}
		}
	}
	static void morrisPreorder(Node node){
		if(node == null)
			return;
		Node cur, pre;
		cur = node;
		while(cur != null){
			if(cur.left == null){
				System.out.print(cur.data+" ");
				cur = cur.right;
			}
			else{
				pre = cur.left;
				while(pre.right != null && pre.right != cur)
					pre = pre.right;
				if(pre.right == null){
					System.out.print(cur.data + " ");
					pre.right = cur;
					cur = cur.left;
				}
				else{
					pre.right = null;
					cur = cur.right;
				}
			}
		}
	}
	public static void main(String args[]){
		leafTraversal ob = new leafTraversal();
		ob.root 				= new Node(1);
		ob.root.left 			= new Node(2);
		ob.root.right 			= new Node(3);
		ob.root.left.left		= new Node(4);
		ob.root.left.right 		= new Node(5);
		System.out.println("Morris Traversal Inorder : ");
		morrisInorder(ob.root);
		System.out.println("\nMorris Traversal Preorder : ");
		morrisPreorder(ob.root);
	}
}