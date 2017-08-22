import java.io.*;
import java.util.*;

class queueUsingStack{
	static Stack<Integer> s1 = new Stack<>();
	static Stack<Integer> s2 = new Stack<>();
	static void enQueue(int data){
		s1.push(data);
	}
	static int deQueue()
	{
		if(s1.isEmpty() && s2.isEmpty())
		{
			System.out.println("Queue is empty");
			return -1;
		}
		if(s2.isEmpty())
		{
			while(!s1.isEmpty())
				s2.push(s1.pop());
		}
		return s2.pop();
	}
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
				int more = 1;
				while(more != 0){
					System.out.println("\nChoices:\n[1]EnQueue\n[2]DeQueue\n[3]DISPLAY");
					int ch = sc.nextInt();
					switch(ch){
						case 1 :
						System.out.print("Enter data : ");
						int data = sc.nextInt();
						enQueue(data);
						break;
						case 2 :
						System.out.println("Dequeued data : "+deQueue());
						break;
						case 3 :	
						System.out.println(s1);
						break;
						default :
						System.out.println("Enter valid choice!");	
					}
					System.out.print("\npress 0 to exit!\n");
					more = sc.nextInt();	
				}
			}
		}