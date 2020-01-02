//3x3 grid for playing tic tac toe game..
class Grid{
	//default grid size is 3x3
	private final int size = 3;
	char[][] grid = new char[size][size];

	//initialize grid with numbers to indicate  grid is empty
	/*
		1 2 3
		4 5 6
		7 8 9
	*/
	void initializeGrid(){
		int counter = 0;
		for (int i = 0 ;i<this.size;i++ ) {
			for (int j = 0;j<this.size ;j++ ) {
				this.grid[i][j] = (char)(counter+49);
				counter++;
			}
		}
	}
	//utility function returns true if any block is empty in grid
	boolean hasEmptyLocation(){
		int counter = 0;
		for (int i = 0 ;i<this.size;i++ ) {
			for (int j = 0;j<this.size ;j++ ) {
				if(this.grid[i][j] == (char)(counter+49) )
					return true;
				counter++;
			}
		}
		return false;
	}
	boolean markLocationInGrid(Player currentPlayer,int markLocation){
		int counter = 0;
		for (int i = 0 ;i<this.size;i++ ) {
			for (int j = 0;j<this.size ;j++ ) {
				counter++;
				if(counter == markLocation){	
					if(this.grid[i][j] == (char)(counter+48)){
						this.grid[i][j] = currentPlayer.getSymbol();
						return true;
					}else{
						return false;
					}
				}
			}
		}
		return false;
	}

	//utility method to print grid
	public void printGrid(){
		System.out.println("------ Grid ----");
		for (int i = 0 ;i<this.size;i++ ) {
			for (int j = 0;j<this.size ;j++ ) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println("");
		}
	}
	int getSize(){
		return this.size;
	}
}
