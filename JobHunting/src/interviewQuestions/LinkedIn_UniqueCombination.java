package interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
//
//14. 题目描述起来很简单，就是给出一个数，找出所有Unique的组合。 
//比如： 
//2:    1＋1
//3:    1＋2，　1＋1＋1　 
//4:    1＋3，　1＋2，　1＋1＋1＋1，　2＋2

public class LinkedIn_UniqueCombination {
	public static void countUnique(int n, ArrayList<ArrayList<Integer>> result) {
		for (int i = 1; i <= n / 2; i++) {
			if (i == 1) {
				countUnique(n - i, result);
				for (ArrayList<Integer> array : result) {
					array.add(1);
				}
			}
			result.add(new ArrayList<Integer>(Arrays.asList(i, n - i)));
		}
		return;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		countUnique(5, result);
		System.out.println(result);

	}
}
