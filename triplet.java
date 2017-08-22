//finding triplet sum to zero using hashing in O(n^2)
import java.io.*;
import java.util.*;
class triplet{
	public static void main(String args[]){
		int[] arr = { -10, 2, 5 , 3, -15, 20, -5, 10};
		boolean found = false;
		int n = arr.length;
		for(int i = 0; i< n-1; i++){
		HashSet<Integer> set = new HashSet<>();
		for(int j = 0;j<n;j++){
			int x = -(arr[i]+arr[j]);
			if(set.contains(x))
			{
				System.out.println(x +" "+arr[i]+" "+arr[j]);
				found = true;
			}
			else
				set.add(arr[j]);
		}	
		}
		if(found == false)
		System.out.println("No triplet found");
	}
}