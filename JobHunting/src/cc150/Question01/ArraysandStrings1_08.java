package cc150.Question01;

public class ArraysandStrings1_08 {
//Assume you have a method isSubstring which checks 
//	if one word is a substring of another. 
//	Given two strings, s1 and s2, 
//	write code to check if s2 is a rotation of s1 using only one call to isSubstring
	public boolean isRotation(String s1, String s2){
		int len = s1.length();
		if(len == s2.length() && len > 0){
			String s1s1 = s1 + s1;
			return isSubstring(s1s1,s2);
		}
		return false;
	}
	
	private boolean isSubstring(String s1s1, String s2) {
		int s1length = s1s1.length();
		int s2length = s2.length();
		
		if(s1length < s2length)
			return false;
		boolean flag = false;
		for(int i = 0; i < s1length-s2length; ++i){
			for(int j = 0; j < s2length; ++j){
				if(s1s1.charAt(i+j) != s2.charAt(j)){
					break;
				}
				if(s1s1.charAt(i+j) == s2.charAt(j) && j == s2length - 1){
					flag = true;
				}
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "terbottlewa";
		
		ArraysandStrings1_08 s3 = new ArraysandStrings1_08();
		System.out.println(s3.isRotation(s1, s2));
	}
}
