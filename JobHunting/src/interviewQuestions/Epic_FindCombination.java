package interviewQuestions;

import java.util.ArrayList;

public class Epic_FindCombination {
//	 电池有6节包装，9节包装，20节包装三种，input需要多少节电池，如果可以刚好用
//	 3种包装的凑到这个数，就输出这个解， 忘了是不是要输出所有的解。
//	 e.g 输入20， 答{20} 输入17 答没有  输入18，那可能是{6,6,6}也可能是{9,9}。 有
//	 点像找钱的问题，似乎是从集合中找到所有集合值等于一个target这个题的简化版，因
//	 为集合只有6 9 20。 
	public static boolean FindCoin(int input){
		int[] choices = {6,9,20};
		ArrayList<Integer> result = new ArrayList<>();
		return helper(input,choices,result);
	}

	private static boolean helper(int input, int[] choices, ArrayList<Integer> result) {
		if(input == 0){
			for(int i = 0; i < result.size(); ++i)
				System.out.print(result.get(i)+" ");
			System.out.println();
			return true;
		}
		if(input < 0)
			return false;
		boolean flag = false;
		for(int i = 0; i < choices.length; ++i){
			result.add(choices[i]);
			flag |= helper(input-choices[i], choices, result);
			result.remove(result.size()-1);
		}
		return flag;
	}
	
	public static void main(String[] args) {
		System.out.println(FindCoin(20));
	}
}
