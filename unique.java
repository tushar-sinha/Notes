import java.io.*;
import java.util.*;
class unique{
	public static void main(String args[]){
		String s = "abcde";
		HashMap<Character,Integer> mapper = new HashMap<>();
		for(char ch : s.toCharArray()){
			if(mapper.get(ch)!=null)
			{
				System.out.println("Not unique");
				System.exit(0);
			}
			else
				mapper.put(ch,1);
		}
		System.out.println("UNIQUE");
	}
}