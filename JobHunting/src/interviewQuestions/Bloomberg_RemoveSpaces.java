package interviewQuestions;

public class Bloomberg_RemoveSpaces {
//	Given a string which has a lot of spaces beween words . Remove these extra spaces in the string
//	 eg: " I love New York " --> "I love New York"
	
	// use extra space, O(n) time, O(n) space
	public String removeSpace(String sentence){
		StringBuilder sb = new StringBuilder();
		int length = sentence.length();
		int index = 0;
		while(sentence.charAt(index) == ' '){
			index++;
		}
		boolean space = true;
		int i = index;
		while(i < length){
			char cur = sentence.charAt(i);
			if(cur == ' ' && space){//we could insert space because pre is a letter.
				sb.append(cur);
				space = false;
			}else if (cur ==' ' && !space) {//the previous one is already a space so we can not insert in any space.
				
			}else{
				sb.append(cur);
				space = true;
			}
			i++;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Bloomberg_RemoveSpaces().removeSpace(" I love New York    !"));
	}
}
