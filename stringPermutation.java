import java.io.*;
import java.util.*;
class stringPermutation{
	static String permutationMethod2(String test, String match){
		char a[]= test.toCharArray();
		char b[]= match.toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		if(Arrays.equals(a,b))
			return "they are permutation";
		else
			return "not a permutation";
	}
	static String permutation(String test, String match){
		HashMap<Character,Integer> mapper = new HashMap<Character,Integer>();
		for(char ch : test.toCharArray()){
			if(mapper.get(ch)==null)
				mapper.put(ch,1);
			else
				mapper.put(ch,mapper.get(ch)+1);
		}
		for(char ch : match.toCharArray()){
			if(mapper.get(ch)!=null)
				mapper.put(ch,mapper.get(ch-1));
			else
				return "not a permutation";
		}
		Set s = mapper.entrySet();
		Iterator i = s.iterator();
		while(i.hasNext()){
			Map.Entry me = (Map.Entry)i.next();
			if(me.getValue() != null)
				return "not a permutation";
		}
		return "they are permutation";
	}
	public static void main(String args[]){
		String s1 = "abcde";
		String s2 = "bdcea";
		System.out.println(permutation(s1,s2)+"-----with method1");
		System.out.println(permutationMethod2(s1,s2)+"----with method2");
	}
}