import java.io.*;
import java.util.*;

class one{
	public static void main(String args[]){
		int[] arr = {3, 5, 1, 6, 0};
		int max = Integer.MIN_VALUE;
		for(int i = 4; i>=0; i--){
			for(int j = 0; j<5; j++){
				if(arr[i]>arr[j] && i-j>max)
						max = i-j;
			}
		}
		System.out.println(max);
	}
}