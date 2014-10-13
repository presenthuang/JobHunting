package interviewQuestions;

import java.util.HashMap;

public class Epic_PrintKeypadString {
	public static void keypad(String numbers){
		HashMap<Integer, String> keys = new HashMap<Integer, String>();
		storeKeypad(keys);
		char[] array = numbers.toCharArray();
		bfs(keys, array, new StringBuilder(""),0);
	}

	private static void bfs(HashMap<Integer, String> keys, char[] array, StringBuilder cur, int depth){
		if(depth == array.length){
			System.out.println(cur.toString());
			return;
		}
		String candidates = keys.get(array[depth] - '0');
		if(candidates == null){
			bfs(keys, array, cur, depth+1);
		}else{
			for(int i = 0; i < candidates.length(); ++i){
				cur.append(candidates.charAt(i));
				bfs(keys, array, cur, depth+1);
				cur.deleteCharAt(cur.length() - 1);
			}
		}
	}
	private static void storeKeypad(HashMap<Integer, String> keys){
		keys.put(2,"ABC");
		keys.put(3,"DEF");
		keys.put(4,"GHI");
		keys.put(5,"JKL");
		keys.put(6,"MNO");
		keys.put(7,"PRS");
		keys.put(8,"TUV");
		keys.put(9,"WXY");
	}
	public static void main(String[] args) {
		Epic_PrintKeypadString.keypad("23");
	}
}
