import java.io.*;
import java.util.*;

class divByThree{
	public static void main(String args[]){
		Queue<Integer> q0 = new LinkedList<>();
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of digits");
		int n = sc.nextInt();
		int[] arr = new int[n];
		int j = 0, sum = 0;
		Integer[] auxArr = new Integer[n];
		System.out.println("Enter the digits : \n");
		for(int i = 0; i < n; i++)
		{
			arr[i] = sc.nextInt();
			sum += arr[i];
			if(arr[i]%3==0)
				q0.add(arr[i]);
			else if(arr[i]%3==1)
				q1.add(arr[i]);
			else if(arr[i]%3==2)
				q2.add(arr[i]);
		}
		if(sum % 3 == 1)	
		{
			if(q1.peek() != null)
			{
				q1.poll();
			}
			else 
			{
				if(q2.peek() != null)
				q2.poll();
				else{
					System.out.println("Any combination of given digits cannot be divided by 3");
					System.exit(0);
				}
				if(q2.peek() != null)
				q2.poll();
				else{
					System.out.println("Any combination of given digits cannot be divided by 3");
					System.exit(0);
				}	
			}
		}
		else if(sum%3 == 2)
		{
			if(q2.peek() != null)
			{
				q2.poll();
			}
			else 
			{
				if(q1.peek() != null)
				q1.poll();
				else{
					System.out.println("Any combination of given digits cannot be divided by 3");
					System.exit(0);
				}
				if(q1.peek() != null)
				q1.poll();
				else{
					System.out.println("Any combination of given digits cannot be divided by 3");
					System.exit(0);
				}	
			}
		}
		while(q0.peek()!=null)
			auxArr[j++] = q0.poll();
		while(q1.peek()!=null)
			auxArr[j++] = q1.poll();
		while(q2.peek()!=null)
			auxArr[j++] = q2.poll();
		if(auxArr != null){
		Arrays.sort(auxArr, Collections.reverseOrder());
		for(int i = 0;i < n; i++)
		{
			System.out.print(auxArr[i]);
		}	
		}
		else
			System.out.println("Any combination of given digits cannot be divided by 3");
	}
}