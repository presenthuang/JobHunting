package string;

import java.util.Arrays;

public class ArraysandStrings1_03 {
//Given two strings, write a method to decide if one is a permutation of the other.
	
	
	//simple but not efficient
	public boolean isPermutation(String s1, String s2){
		if(s1 == null || s2 == null){
			return s1 == null && s2 == null;
		}
		if(s1.length() != s2.length())
			return false;
		char[] set1 = s1.toCharArray();
		char[] set2 = s2.toCharArray();
		Arrays.sort(set1);
		Arrays.sort(set2);
		String s1_sort = new String(set1);
		String s2_sort = new String(set2);
		return s1_sort.equals(s2_sort);
	}
	
	//use the property of char and store the values for this char array.
	public boolean isPermutation2(String s1, String s2){
		if(s1 == null || s2 == null){
			return s1 == null && s2 == null;
		}
		if(s1.length() != s2.length())
			return false;
		int[] letters = new int[256];
		char [] set1 = s1.toCharArray();
		for(int i = 0; i < set1.length; ++i){
			letters[set1[i]]++;
		}
		for(int k = 0; k < s2.length(); ++k){
			if(--letters[(int)s2.charAt(k)] < 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s1 = "2321ewda";
		String s2 = "2321Ewda";
		ArraysandStrings1_03 strings1_3 = new ArraysandStrings1_03();
		System.out.println(strings1_3.isPermutation2(s1, s2));
	}
}
