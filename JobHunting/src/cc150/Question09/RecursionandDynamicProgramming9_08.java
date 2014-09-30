package cc150.Question09;

public class RecursionandDynamicProgramming9_08 {
//make changes
	int makeChanges(int n){
		int[] denoms = {25,10,5,1};//choices
		int[][] map = new int[n+1][denoms.length];//Store the results in the middle
		int result = makeChange(n,denoms,0,map);
		for(int i = 0; i < map.length; ++i){
			for(int j = 0; j < map[0].length; ++j){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		return result;
	}

	private int makeChange(int amount, int[] denoms, int index, int[][] map) {
		if(map[amount][index] > 0)
			return map[amount][index];
		
		if(index >= denoms.length - 1)
			return 1;
		
		int denomAmount = denoms[index];
		int ways = 0;
		for(int i = 0; i * denomAmount <= amount; i++){
			int amountRemain = amount - i * denomAmount;
			ways += makeChange(amountRemain, denoms, index+1, map);
		}
		map[amount][index] = ways;
		return ways;
	}
	public static void main(String[] args){
		RecursionandDynamicProgramming9_08 changes = new RecursionandDynamicProgramming9_08();
		System.out.println(changes.makeChanges(25));
	}
}
