import java.io.*;
import java.util.*;
class inputTest{
	public static void main(String args[]){
		int[][] ar = new int[2][3];
		Scanner sc = new Scanner(System.in);
		for(int i =0; i<2;i++)
			for(int j =0; j<3;j++)
				ar[i][j] = sc.nextInt();
		for(int[] i : ar)
			for(int j : i)
			System.out.println(j);
	}
}