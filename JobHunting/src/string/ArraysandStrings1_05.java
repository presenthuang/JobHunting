package string;

public class ArraysandStrings1_05 {
//Implement a method to perform basic string compression 
//	using the counts of repeated characters. 
//	For examples, the string aabcccccaaa would become a2b1c5a3. 
//	If the "compressed" string would not become smaller than the orignial string, 
//	your method should return the original string.
	
	public String compress(String str){
		int size = str.length();
		int stack = -1;
		int length = 0;
		StringBuffer buffer = new StringBuffer("");
		for(int i = 0; i < size; ++i){
			char cur = str.charAt(i);
			if(stack == cur){
				length++;
			}else{
				if(stack != -1){
					buffer.append((char)stack);
					buffer.append(length);
					length = 0;
				}
				stack = cur;
				length++;
			}
		}
		if(stack != -1){
			buffer.append((char)stack);
			buffer.append(length);
		}
		return buffer.toString().length() < size ? buffer.toString():str;
	}
	
	public static void main(String[] args) {
		ArraysandStrings1_05 s2 = new ArraysandStrings1_05();
		System.out.println(s2.compress("abc"));
	}
}
