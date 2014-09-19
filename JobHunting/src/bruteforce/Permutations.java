package bruteforce;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
//	Given a collection of numbers, return all possible permutations.
//
//			For example,
//			[1,2,3] have the following permutations:
//			[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean [] flags = new boolean [num.length];
        helper(result,new ArrayList<Integer>(),num,flags,0);
        return result;
    }

	private void helper(List<List<Integer>> result, ArrayList<Integer> current, int[] num, boolean[] flags, int pos) {
		if(num.length == pos){
			result.add(current);
			return;
		}
		for(int i = 0; i < num.length; ++i){
			if(!flags[i]){
				current.add(num[i]);
				flags[i] = true;
				helper(result,current,num,flags,pos+1);
				current.remove(current.size()-1);
				flags[i] = false;
			}
		}
	}
}
