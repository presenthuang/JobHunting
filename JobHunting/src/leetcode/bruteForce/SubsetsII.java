package leetcode.bruteForce;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {
//	Given a collection of integers that might contain duplicates, S, return all possible subsets.
//
//			Note:
//			Elements in a subset must be in non-descending order.
//			The solution set must not contain duplicate subsets.
//			For example,
//			If S = [1,2,2], a solution is:
//
//			[
//			  [2],
//			  [1],
//			  [1,2,2],
//			  [2,2],
//			  [1,2],
//			  []
//			]
//	just use this dfs method
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {  
	       ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
	       ArrayList<Integer> tmp = new ArrayList<Integer>();  
	       Arrays.sort(num);  
	       res.add(tmp);  
	       dfs(res,tmp,num,0);  
	       return res;  
	    }  
	      
	    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] num, int pos){  
	        for(int i=pos;i<=num.length-1;i++){  
	            tmp.add(num[i]);  
	            res.add(new ArrayList<Integer>(tmp));
	            System.out.println("before delete: " + i);
	            for(Integer k : tmp){
	            	System.out.print(k + " ");
	            }
	            System.out.println();
	            dfs(res,tmp,num,i+1);  
	            tmp.remove(tmp.size()-1);
	            System.out.println("after delete: " + i);
	            for(Integer k : tmp){
	            	System.out.print(k + " ");
	            }
	            System.out.println();
	            while(i<num.length-1 && num[i]==num[i+1]) i++; 
	        }  
	    } 
	    
	    public static void main(String[] args) {
			int[]list = {1,2,3,4,5};
			ArrayList<ArrayList<Integer>> result = new SubsetsII().subsetsWithDup(list);
		}
}
