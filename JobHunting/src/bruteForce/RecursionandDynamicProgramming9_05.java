package bruteForce;

import java.util.ArrayList;

public class RecursionandDynamicProgramming9_05 {
//Write a method to compute all permutations of a string of unique characters.
	public static ArrayList<String> getPerms(String str){
		ArrayList<String> results = new ArrayList<String>();
		if(str == null || str.length() == 0)
			return results;
		boolean[] visited = new boolean[str.length()];
		helper(results, str, new StringBuilder(""), visited);
		return results;
	}

	private static void helper(ArrayList<String> results, String str, StringBuilder current, boolean[] visited) {
		if(current.length() == str.length()){
			results.add(current.toString());
			return;
		}
		for(int i = 0; i < str.length(); ++i){
			if(!visited[i]){
				current.append(str.charAt(i));
				visited[i] = true;
				helper(results,str,current,visited);
				current.deleteCharAt(current.length()-1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args){
		ArrayList<String> result = RecursionandDynamicProgramming9_05.getPerms("abc");
		for(String re : result){
			System.out.println(re);
		}
	}
}
