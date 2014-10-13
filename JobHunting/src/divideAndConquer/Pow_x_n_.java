package divideAndConquer;

public class Pow_x_n_ {
	
//	Implement pow(x, n).
    
//	Be careful about the current position of the word, using recursion would be a really good idea.
	public double pow(double x, int n) {
    	if(n == 0)
    		return 1;
        double result = helper(x,Math.abs(n));
        if(n < 0)
        	return 1/result;
        return result;
    }

	private double helper(double x, int n) {
		if(n == 1)
			return x;
		if(n == 0)
			return 1;
		
		double v = helper(x, n/2);
		
		if(n % 2 == 0){
			return v * v;
		}else{
			return v * v * x;
		}
	}
    
}
