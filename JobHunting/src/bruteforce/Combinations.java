package bruteforce;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
//	Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//			For example,
//			If n = 4 and k = 2, a solution is:
//
//			[
//			  [2,4],
//			  [3,4],
//			  [2,3],
//			  [1,2],
//			  [1,3],
//			  [1,4],
//			]
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean [] used = new boolean[n+1];
        
        helper(result,new ArrayList<Integer>(), used, n+1, k);
        return result;
    }

	private void helper(List<List<Integer>> result, ArrayList<Integer> cur, boolean [] used, int n, int k) {
		if(cur.size() == k){
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		
		for(int i = 1; i < n; ++i){
			if(!used[i]){
				cur.add(i);
				used[i] = true;
				helper(result,cur,used,n,k);
				used[i] = false;
				cur.remove(cur.size()-1);
			}
		}
	}
}
