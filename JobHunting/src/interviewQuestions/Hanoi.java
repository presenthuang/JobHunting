package interviewQuestions;

public class Hanoi {
	public static String HanoiT(int nDisks, int fromPeg, int toPeg){
		int helperPeg;
		String Sol1, Sol2, MyStep, mySol;   // Contains moves
		if(nDisks == 1){
			return fromPeg + " -> " + toPeg + "\n";
		}else{
			helperPeg = 6 - fromPeg - toPeg;// Because fromPeg + helpPeg + toPeg = 6
			Sol1 = HanoiT(nDisks-1, fromPeg, helperPeg);
			MyStep = fromPeg + " -> " + toPeg + "\n";
			Sol2 = HanoiT(nDisks-1, helperPeg, toPeg);
			mySol = Sol1 + MyStep + Sol2;
			return mySol;
		}
	}
	
	public static void main (String[] args)
    {
 	 int n = 10;
  
 	 String StepsToSolution;
  
 	 StepsToSolution = HanoiT(n, 1, 3);
  
 	 System.out.println(StepsToSolution);
    }
}
