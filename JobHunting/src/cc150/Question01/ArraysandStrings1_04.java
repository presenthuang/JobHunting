package cc150.Question01;

public class ArraysandStrings1_04 {
//Write a method to replace all spaces in a string with '%20'. 
//You may assume that the string has sufficient space at the end of the string 
//	to hold the additional characters, and that you are given the "true" length of the string.
	public void replaceSpace(char[] array, int length){
		if(array == null){
			return;
		}
		int spaceCount = 0;
		for(int i = 0; i < length; ++i){
			if(array[i] == ' ')
				spaceCount++;
		}
		int newlength = length + spaceCount * 2;
		for(int i = length-1; i >= 0; --i){
			if(array[i] == ' '){
				array[--newlength] = '0';
				array[--newlength] = '2';
				array[--newlength] = '%';
 			}else {
				array[--newlength] = array[i];
			}
		}
	}
	public static void main(String[] args) {
		ArraysandStrings1_04 s3 = new ArraysandStrings1_04();
		char [] array = new char[9];
		array[0] = '1';
		array[1] = '2';
		array[2] = '3';
		array[3] = '4';
		array[4] = '5';
		array[5] = ' ';
		array[6] = '6';
		s3.replaceSpace(array, 7);
		System.out.println(array);
	}
}
