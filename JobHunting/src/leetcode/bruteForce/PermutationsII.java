package leetcode.bruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
//	Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//			For example,
//			[1,1,2] have the following unique permutations:
//			[1,1,2], [1,2,1], and [2,1,1].
	
//	carefully remove the situation that the duplicate elements are together
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean [] visited = new boolean[num.length];
        Arrays.sort(num);
        helper(num,result,visited,new ArrayList<Integer>());
        return result;
    }

	private void helper(int[] num, List<List<Integer>> result, boolean[] visited, ArrayList<Integer> current) {		
		if(current.size() == num.length){
			result.add(new ArrayList<>(current));
			return;
		}
		
		for(int i = 0; i < num.length; ++i){
			if(!visited[i]){
				visited[i] = true;
				current.add(num[i]);
				helper(num, result, visited, current);
				current.remove(current.size()-1);
				visited[i] = false;
				
				while(i + 1 < num.length && num[i+1] == num[i]){
					i++;
				}
			}
		}
	}
    
}
