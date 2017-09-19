import java.io.*;
import java.util.*;

class palinPart{
	static int palinCount = 0;
	static boolean chkPalin(String word){
		String dup ="";
		for(int i = word.length()-1; i>=0; i--){
			dup += word.charAt(i);
		}

		//System.out.println(dup + " " + word);
		if(dup.equals(word))
			return true;
		else
			return false;
	}
	static void createPartition(String word, int palinLength){
		for(int i = 0; i<=word.length()-palinLength;i++)
			{
				if(chkPalin(word.substring(i,i+palinLength)))
				{
					System.out.print(word.substring(i,i+palinLength)+ " ");
					palinCount++;
				}
			}
	}
	public static void main(String args[]){
		String s = "NITIN";
		for(int i = 2; i<=s.length(); i++){
			createPartition(s, i);
		}
		System.out.println("\n"+palinCount);
	}
}