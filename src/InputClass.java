import java.io.*;
import java.util.*;

class InputClass {
	private ArrayList<Integer> patternLine = new ArrayList<Integer>();
	public int getUserInput(String promt) {
		int inputLine = 0;
		boolean isRightPattern = true;
		System.out.print(promt);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		GameClass game = new GameClass();
		while(true) {
		try {
			inputLine = Integer.parseInt(in.readLine());
		if ((patternLine.indexOf(inputLine) == -1) && (inputLine >= 1 && inputLine <= 9)) {
				patternLine.add(inputLine);
				return inputLine - 1;
			}
			System.out.println("Choose the right cell!");
		} catch (NumberFormatException e) {
			System.out.println("Input the number!");
		} catch (IOException e) { }
		}
	}
}