import java.util.*;
import java.io.*;
import java.lang.*;
/*
*
*	queue interface in-built functions()
*	add()	- 	add data or enqueue to tail of LL
*	peek()	-	returns head of queue without removing head from ll of queue
*	remove()-	remove and return data from head but throws NoSuchElementException if queue is empty
*	poll()	-	remove and return data from head but returns null if queue is empty
*
*/
public class queue
{
	public static Queue<Integer> q = new LinkedList<Integer>();//implement queue interface with LL
	//new item will be added at tail and removed from head of LL
	public static void reverse(Queue<Integer> q)
	{
		Stack<Integer> st = new Stack<Integer>();
		while(q.peek()!=null)
		{
			st.push(q.poll());
		}
		while(!st.isEmpty())
		{
			q.add(st.pop());
		}
	}
	public static void main(String ars[]){
		Scanner sc = new Scanner(System.in);
				int more = 1;
				while(more != 0){
					System.out.println("\nChoices:\n[420]Dummy queue\n[1]EnQueue\n"+
						"[2]DeQueue\n[3]DISPLAY\n[4]REVERSE");
					int ch = sc.nextInt();
					switch(ch){
						case 420:
						q.add(1);
						q.add(2);
						q.add(3);
						q.add(4);
						q.add(5);
						break;
						case 1 :
						System.out.print("Enter data : ");
						int data = sc.nextInt();
						q.add(data);
						break;
						case 2 :
						System.out.println("Dequeued data : "+q.remove());
						break;
						case 3 :	
						System.out.println(q);
						break;
						case 4 :
						reverse(q);
						break;
						default :
						System.out.println("Enter valid choice!");	
					}
					System.out.print("\npress 0 to exit!\n");
					more = sc.nextInt();	
				}
			}
		}