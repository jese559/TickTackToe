import java.util.*;

class GameClass {
	private int[] grid = new int[9];
	
	public void setGridCell(int cell, boolean isCurrentX) {
		if (isCurrentX) grid[cell] = 1; else grid[cell] = 2;
	}
	
	public int getGridCell(int cell) {
		return grid[cell];
	}
			
	public void generateGrid() {
		for (int i = 0; i < 9; i++) {
			grid[i] = 0;
		}
	}

    public void showGrid(){
        System.out.println("     |     |     ");
        for (int i = 0; i < grid.length; i++) {
            if (i!=0){
                if (i%3==0) {
                    System.out.println();
                    System.out.println("_____|_____|_____");
                    System.out.println("     |     |     ");
                }
                else
                    System.out.print("|");
            }
			int y = i + 1;
            if (grid[i]==0) System.out.print("  " + y + "  ");
            if (grid[i]==1) System.out.print("  X  ");
            if (grid[i]==2) System.out.print("  O  ");
        }
        System.out.println();
        System.out.println("     |     |     ");
    }
	
	public boolean isGameOver(int n) {
		int row = n-n%3;
		int column = n%3;

		if ((grid[row] == grid[row+1]) && (grid[row] == grid[row+2])) 
			return true; // чекаем нужную строку
		if ((grid[column] == grid[column+3]) && (grid[column] == grid[column+6])) 
			return true; // чекаем нужный столбец
		if(n%2!=0) return false;
		if(n%4==0) {
			if ((grid[0] == grid[4]) && (grid[0] == grid[8])) 
				return true; // чекаем первую диагональ
			if(n!=4) return false;
		}
		return (grid[2] == grid[4]) && (grid[2] == grid[6]);
	}
	
	public boolean isDraw() {
		for (int n : grid)
			if (n==0) return false;
		return true;
	}
}