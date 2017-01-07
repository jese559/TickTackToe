import java.util.*;

class MainClass {
	public static void main(String[] args) {
		Random random = new Random();
		GameClass game = new GameClass();
		InputClass input = new InputClass();
		boolean isCurrentX = true;
		boolean isOver = true;
		
		game.generateGrid();
		game.showGrid();
		
		do {
			int getGuess = input.getUserInput("Your's move " + (isCurrentX ? "X" : "O") + ": ");
			game.setGridCell(getGuess, isCurrentX);
			game.showGrid();
			isCurrentX = !isCurrentX;
			isOver = game.isGameOver(getGuess);
			boolean isDraw = game.isDraw();
			if (isDraw) {
				System.out.println("Draw!");
				return;
			}
		} while(!isOver);
		System.out.println("We have a winner " + (!isCurrentX ? "X" : "O"));
	}
}