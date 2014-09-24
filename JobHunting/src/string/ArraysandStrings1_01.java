package string;

public class ArraysandStrings1_01 {
//Implement an algorithm to determine if a string has all unique characters. 
//	What if you cannot use additional data structures?
	public boolean checkUnique(String s){
		if(s.length() > 256)
			return false;
		boolean [] isFalse = new boolean[256];
		for(int i = 0; i < s.length(); ++i){
			char cur = s.charAt(i);
			if(isFalse[cur])
				return false;
			isFalse[cur] = true;
		}
		return true;
	}
}
