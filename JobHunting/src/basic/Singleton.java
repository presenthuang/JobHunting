package basic;

public class Singleton {
	private static Singleton instance = null;
	protected Singleton(){
		
	}
	
//	public static Singleton getInstance(){
//		if(instance == null){
//			instance = new Singleton();
//		}
//		return instance;
//	}
	
	public static Singleton getInstance(){
		if(instance == null){
			synchronized (Singleton.class) {
				if(instance == null)
					instance = new Singleton();
			}
		}
		return instance;
	}
}
