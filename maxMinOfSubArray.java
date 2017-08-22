import java.io.*;
import java.util.*;

class maxMinOfSubArray{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array size nd values : \n");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		System.out.println("Enter size of sub array : \n");
		int k = sc.nextInt();
		int max = arr[0];
		for(int i = 0; i <= n-k; i++)
		{
			max = arr[i];
			for(int j = 1; j < k; j++)
			{
				if(arr[i+j]>max)
					max= arr[i+j];
			}
			System.out.print(max+" ");
		}
	}
}