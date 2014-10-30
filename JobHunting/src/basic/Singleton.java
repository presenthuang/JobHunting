package basic;


//lazy initialization
public class Singleton {
	private volatile static Singleton instance = null;

	private Singleton() {}
	// public static Singleton getInstance(){
	// if(instance == null){
	// instance = new Singleton();
	// }
	// return instance;
	// }

//	double checked locking pattern
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null)
					instance = new Singleton();
			}
		}
		return instance;
	}
}


//Eager initialization
//public class Singleton{
//    //类加载时就初始化
//    private static final Singleton instance = new Singleton();
//    
//    private Singleton(){}
//    public static Singleton getInstance(){
//        return instance;
//    }
//}

//static nested class
//public class Singleton {  
//    private static class SingletonHolder {  
//        private static final Singleton INSTANCE = new Singleton();  
//    }  
//    private Singleton (){}  
//    public static final Singleton getInstance() {  
//        return SingletonHolder.INSTANCE; 
//    }  
//}