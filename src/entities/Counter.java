package entities;

public class Counter {

	private static int i = 0;

	public static int getI() {
		return i;
	}
	
	public static void increment() {
		i++;
	}
}
