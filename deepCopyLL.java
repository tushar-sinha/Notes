import java.io.*;
import java.util.*;
class Node{
	int data;
	Node next, random;
	Node(int item){
		data = item;
		random = next = null;
	}
}
class deepCopyLL{
	Node head, copyLL;	
	static void printNext(Node node){
		Node temp = node;
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	static void printRandom(Node node){
		Node temp = node;
		while(temp != null)
		{
			System.out.print(temp.random.data+" ");
			temp = temp.next;
		}
	}
	static Node createCopy(Node root){
		Node res;
		Node cur = root;
		Node next, tmp;
			while(cur != null)
			{
				tmp = new Node(cur.data);
				tmp.random = null;
				tmp.next = cur.next;
				next = cur.next;
				cur.next = tmp;
				cur = next;        
			}
			res = root.next;
			cur = root;    
			while(cur != null)
			{
				cur.next.random = cur.random.next;
	        	cur = cur.next.next; 
	    	}
	    	cur = root;    
	    	tmp = root.next;
	    	while(cur != null && tmp != null)
	    	{
	    	cur.next = cur.next.next;
	    	cur = cur.next;
	    	if (tmp.next != null){
	    		tmp.next = tmp.next.next;
	    		tmp = tmp.next;
	    	}        
	    }
	    return res;
	}
	public static void main(String args[]){
		deepCopyLL ob = new deepCopyLL();
		ob.head = new Node(1);
		ob.head.next = new Node(2);
		ob.head.next.next = new Node(3);
		ob.head.next.next.next = new Node(4);
		ob.head.next.next.next.next = new Node(5);
		ob.head.random = ob.head.next.next;
		ob.head.next.random = ob.head;
		ob.head.next.next.random = ob.head.next.next.next.next;
		ob.head.next.next.next.random = ob.head.next.next;
		ob.head.next.next.next.next.random = ob.head.next;
		ob.copyLL = null;
		System.out.println("Printing original LL with next pointer : ");
		printNext(ob.head);
		System.out.println("\nPrinting original LL with random pointer : ");
		printRandom(ob.head);
		ob.copyLL = createCopy(ob.head);
		System.out.println("\nPrinting copy LL with next pointer : ");
		printNext(ob.copyLL);
		System.out.println("\nPrinting copy LL with random pointer : ");
		printRandom(ob.copyLL);
	}
}