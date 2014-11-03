package basic;

public class CachedFib {
	int max = 100000;
	int [] fib = new int[max];
	
	int fibonacci(int i){
		if(i == 0)
			return 0;
		if(i == 1)
			return 1;
		if(fib[i] != 0)
			return fib[i];
		fib[i] = fibonacci(i-1)+fibonacci(i-2);
		return fib[i];
	}
	
	
	public static void main(String[] args) {
		CachedFib cf = new CachedFib();
		System.out.println(cf.fibonacci(8));
	}
}
