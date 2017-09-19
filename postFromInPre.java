import java.io.*;
import java.util.*;
class postFromInPre
{
	static int preIndex=0;
	public static int search(int start, int end, int arr[], int x)
    {
        for (int i = start; i <= end; i++)
            if (arr[i] == x)
            return i;
        return -1;
    }
	public static void printPostOrder(int inStart, int inEnd, int in[], int pre[])
	{

		if(inStart > inEnd) return;
		if(inStart == inEnd) {
			System.out.print(pre[preIndex++]+" ");
			return;
		}
		int index = search(inStart, inEnd, in, pre[preIndex++]);
		printPostOrder(inStart, index-1, in, pre);
		printPostOrder(index+1, inEnd, in, pre);
		System.out.print(in[index]+" ");
	}
	public static void main(String args[])
	{
		int[] in  = {4,2,5,1,6,3,7};
		int[] pre = {1,2,4,5,3,6,7};
        printPostOrder(0,in.length-1, in, pre);
	}
}