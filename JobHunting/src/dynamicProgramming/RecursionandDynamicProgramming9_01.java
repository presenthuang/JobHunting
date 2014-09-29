package dynamicProgramming;

public class RecursionandDynamicProgramming9_01 {
//A child is running a staircase with n steps, and can hop either 1 step, 2 steps,
//or 3 steps at a time. Implement a method to count how many possible ways the
//child can run up the stairs.
	
	//by using dp it can be stored.
	public static int countWays(int n, int[] map){
		if(n < 0)
			return 0;
		if(n == 0)
			return 1;
		if(map[n] > -1)
			return map[n];
		map[n] = countWays(n-1, map) + countWays(n-2, map) + countWays(n-3, map);
		return map[n];
	}
}
