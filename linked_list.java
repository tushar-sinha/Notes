/*
	Author : Tushar Sinha
	Program to do following operations on linked list :
	*Insert
	*Delete
	*
*/
import java.io.*;
import java.lang.*;
import java.util.*;

class Node{
	int data;
	Node next;
}
class linked_list{
	static Node head;
	public Node insert(Node head,int data)
	{
		Node temp = new Node();
		temp.data = data;
		Node cur = head;
		if(head == null){
			return temp;
		}
		while( cur.next != null){
			cur = cur.next;
		}
		cur.next = temp;
		return head;
	}
	public Node delete(Node head, int data){
		Node cur = head;
		Node prev = null;
		if(head == null)
		{
			System.out.println("Nothing to delete!");
			return null;
		}
		while(cur.next != null && cur.data != data)
		{
			prev = cur;
			cur = cur.next;
		}
		if(cur.next == null && cur.data != data)
		{
			System.out.print("Not found!");
			return head;
		}
		else
		{
			prev.next = cur.next;
			return head;
		}
	}
	public void display(Node head){
		if(head == null)
			return;
		System.out.print(head.data + " ");
		display(head.next);
	}
	public Node sort(Node head){
		if(head == null || head.next == null)
		{
			return head;
		}
		Node middle = getMiddle(head);
		Node nextofmiddle = middle.next;
		middle.next = null;

		Node left = sort(head);

		Node right = sort(nextofmiddle);

		Node sortedlist = sortedMerge(left, right);
		return sortedlist;
	}
	public Node getMiddle(Node head){
		if(head == null)
			return head;
		Node slowptr = head;
		Node fastptr = head.next;
		while(fastptr != null)
		{
			fastptr = fastptr.next;
			if(fastptr != null){
			slowptr = slowptr.next;
			fastptr = fastptr.next;	
			}
		}
		return slowptr;
	}
	public Node sortedMerge(Node a, Node b){
		Node result = null;
		if(a == null)
			return b;
		if(b == null)
			return a;
		if(a.data <= b.data)
		{
			result = a;
			result.next = sortedMerge(a.next, b);
		}
		else{
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;
	}
	public Node rotate(Node head, int pos)
	{
		if(head == null)
		{
			return head;
		}
		Node cur = head;
		int count = 1;
		while(cur.next != null && count != pos)
		{
			cur = cur.next;
			count++;
		}
		if(cur.next == null){
			System.out.println("Last element can't rotate!");
			return head;
		}
		Node temp = cur.next;
		cur.next = null;
		cur = temp;
		while(temp.next != null)
		{
			temp = temp.next;
		}
		temp.next = head;
		head = cur;
		return head;
	}
	public Node pairwise(Node head)
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		Node prev = head;
		Node cur = head.next;
		head = cur;
		while(true)
		{
			Node temp = cur.next;
			cur.next = prev;
			if(temp == null || temp.next == null)
			{
				prev.next = temp;
				break;
			} 
			prev.next = temp.next;
			prev = temp;
			cur = prev.next;
		}
		return head;
	}
	public Node deleteMiddle(Node head){
		Node slowptr = head;
		Node fastptr = head;
		Node prev = head;
		if(head == null)
			return head;
		while(fastptr != null && fastptr.next != null){
			prev = slowptr;
			slowptr = slowptr.next;
			fastptr = fastptr.next.next;
		}
		prev.next = slowptr.next;
		return head;
	}
	public Node addUtil(Node head)
	{
		head = reverse(head);
		head = addOne(head);
		return reverse(head);
	}
	public static Node reverse(Node head)
	{
		Node prev = null;
		Node cur = head;
		Node temp = null;
		while(cur != null)
		{
			temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		return prev;
	}
	public Node addOne(Node head)
	{
		int sum   = 0;
		int carry = 1;
		Node temp = head;
		Node prev = null;
		while(temp != null)
		{
			sum = carry + temp.data;
			carry = (sum>=10)?1:0;
			temp.data = sum%10;
			prev = temp;
			temp = temp.next;

		}
		if(carry!=0)
		{
			prev.next = new Node();
			prev.next.data = carry;
		}
		return head;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int more = 1;
		linked_list ob = new linked_list();
		while(more != 0){
			System.out.println("\nChoices:\n[420]Dummy LL\n[1]INSERT\n"+
				"[2]DELETE\n[3]DISPLAY\n[4]SORT\n[5]ROTATE\n[6]PAIRWISE SWAP\n[7]DELETE MIDDLE\n"+
				"[8]ADD 1 TO NO. REPRESENTED AS LL");
			int ch = sc.nextInt();
			switch(ch){
			case 420:
					head = ob.insert(head, 1);
					head = ob.insert(head, 2);
					head = ob.insert(head, 3);
					head = ob.insert(head, 4);
					head = ob.insert(head, 5);
					break;
			case 1 :
					System.out.print("Enter data : ");
					int data = sc.nextInt();
					head = ob.insert(head, data);
					break;
			case 2 :
					System.out.print("Enter data to be delete : ");		
					int data1 = sc.nextInt();
					head = ob.delete(head, data1);
					break;
			case 3 :		
					ob.display(head);
					break;
			case 4 :
					head = ob.sort(head);
					break;
			case 5 :
					System.out.print("Enter position for rotation : ");
					int pos = sc.nextInt();
					head = ob.rotate(head, pos);
					break;
			case 6 :
					head = ob.pairwise(head);
					break;
			case 7 :
					head = ob.deleteMiddle(head);
					break;		
			case 8 :
					head = ob.addUtil(head);
					break;
			default :
					System.out.println("Enter valid choice!");	
		}
			System.out.print("\npress 0 to exit!\n");
			more = sc.nextInt();	
		}
	}
}