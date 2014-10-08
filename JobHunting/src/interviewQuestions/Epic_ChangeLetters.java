package interviewQuestions;

import java.util.ArrayList;

public class Epic_ChangeLetters {
//	4. 感觉和上面的题又有点像， 给一个string， 里面不能有数字。 然后所有的大写字
//	母和非字母符号不能动， 其他的小写字母可以随意动。 输出所有的可能。
//	e.g.  input Oh my-god!
//	output  Om hd-goy! Oy hm-dog! 等等。。
	
	public ArrayList<String> changeLetters(String input){
		ArrayList<String> result = new ArrayList<>();
		ArrayList<Character> lowCaseLetters = new ArrayList<>();
		ArrayList<Integer> pos = new ArrayList<>();
		for(int i = 0; i < input.length(); ++i){
			char cur = input.charAt(i);
			if(Character.isLetter(cur) && Character.isLowerCase(cur)){//both is small and lower level
				lowCaseLetters.add(cur);
				pos.add(i);
			}
		}
		helper(result, input, new StringBuilder(input), lowCaseLetters, pos, 0);
		return result;
	}

	private void helper(ArrayList<String> result, String input, StringBuilder curstring,
			ArrayList<Character> lowCaseLetters, ArrayList<Integer> pos, int length) {
			if(length == result.size()){
				String thisString = new String(curstring);
				if(!result.contains(thisString)){
					result.add(thisString);
				}
				return;
			}
			for(int i = 0; i < result.size(); ++i){
				
			}
	}
	
	
}
