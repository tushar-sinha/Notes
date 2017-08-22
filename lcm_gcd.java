import java.util.*;
import java.io.*;

class lcm_gcd{
	static int gcd(int a, int b){
		while(b>0)
		{
			int temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
	static int lcm(int a , int b)
	{
		return a*(b/gcd(a,b));
	}
	public static void main(String args[]){
		int resultL, resultG;
		System.out.println("Enter no. of inputs and their data :\n");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		for(int i = 0; i < n; i++)
			input[i] = sc.nextInt();
		resultL = input[0];
		resultG = input[0];
		for(int i = 1; i<n;i++)
			resultG = gcd(resultL, input[i]);
		for(int i = 1; i<n;i++)
			resultL = lcm(resultL, input[i]);
		System.out.println("LCM : " + resultL + "\n" + "GCD : " + resultG);
	}
}