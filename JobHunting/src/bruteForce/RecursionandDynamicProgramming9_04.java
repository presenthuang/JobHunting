package bruteForce;

import java.util.ArrayList;
import java.util.LinkedList;

public class RecursionandDynamicProgramming9_04 {
//Write a method to return all subsets of a set.
	ArrayList<ArrayList<Character>> getSubset(ArrayList<Character> set){
		ArrayList<ArrayList<Character>> results = new ArrayList<>();
		if(set == null || set.size() == 0)
			return results;
		LinkedList<Character> stack = new LinkedList<Character>();
		helper(results, set, stack, 0);
		return results;
	}

	private void helper(ArrayList<ArrayList<Character>> results, ArrayList<Character> set, LinkedList<Character> stack, int index) {
		if(index == set.size()){//find one subset.
			results.add(new ArrayList<Character>(stack));
			return;
		}
		stack.push(set.get(index));
		helper(results, set, stack, index+1);
		stack.pop();
		helper(results, set, stack, index+1);
	}
	
	public static void main(String[] args){
		RecursionandDynamicProgramming9_04 df = new RecursionandDynamicProgramming9_04();
		ArrayList<Character> set = new ArrayList<Character>();
		set.add('a');
		set.add('b');
		set.add('c');
		ArrayList<ArrayList<Character>> result = df.getSubset(set);
		for(ArrayList<Character> list : result){
			for(Character c : list){
				System.out.print(c.toString() + " ");
			}
			System.out.println();
		}
	}
	
}
