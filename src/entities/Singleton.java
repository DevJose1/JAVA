package entities;
public class Singleton {

	private static Singleton singleton = null;
	
	private Singleton() {
		// Code tr�s couteux
	}
	
	public static Singleton getInstance()  {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
	
}
