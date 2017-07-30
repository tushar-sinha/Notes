import java.io.*;
import java.util.*;

class circularQueue{
	static int[] cirArr = new int[10];
	static int front = -1, rear = -1;
	final static int SIZE = 10;
	static int getCount(){return rear-front;}
	static boolean isEmpty(){return getCount() == 0;}
	static boolean isFull(){return getCount() == SIZE;};
	public static void main(String[] args){
	
	Scanner sc = new Scanner(System.in);
				int more = 1;
				while(more != 0){
					System.out.println("\nChoices:\n[1]EnQueue\n"+
						"[2]DeQueue\n[3]DISPLAY");
					int ch = sc.nextInt();
					switch(ch){
						case 1 :
						System.out.print("Enter data : ");
						int data = sc.nextInt();
						if(!isFull())
							cirArr[++rear%SIZE] = data;
						else
							System.out.println("Overflow");
						break;
						case 2 :
						if(!isEmpty())
						{
							System.out.println(cirArr[++front%SIZE]);
						}
						else
						{
							System.out.println("Underflow");
						}
						break;
						case 3 :	
						int dup = front;
						if(isEmpty())
						{
							System.out.println("Underflow");
							break;
						}
						while(dup++%SIZE!=rear)
						{
							System.out.print(cirArr[dup]+" ");
						}
						break;
						default :
						System.out.println("Enter valid choice!");	
					}
					System.out.print("\npress 0 to exit!\n");
					more = sc.nextInt();	
				}
			}
		}