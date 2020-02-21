package utils;

public class ClearScreen {
	private static ClearScreen instance = new ClearScreen();
	private final int ENTER_AMOUNT = 30;
	
	public static ClearScreen getInstance() {
		return instance;
	}
	
	public void clear() {
		for(int i = 0; i < ENTER_AMOUNT; i++) {
			System.out.println("");
		}
	}
}
