import java.io.*;
import java.util.Scanner;
//Class Tic Tac toe game to play game.
class TicTacToeGame{
	private Grid grid;
	private Player player1,player2,currentPlayer;
	 TicTacToeGame(String player1_name,String player2_name){
	 	this.grid = this.createGrid();
	 	this.player1 = new Player(player1_name,'X');
	 	this.player2 = new Player(player2_name,'O');

	 }
	private Grid createGrid(){
		Grid grid = new Grid();
		return grid;
	}
	private void declareWinner(){
		this.togglePlayerTurn();
		this.grid.printGrid();
		System.out.println("==>>Player "+currentPlayer.getName()+" Won<<==");
		
	}
	private void gameEnded(){

		Scanner input = new Scanner(System.in);
		System.out.println("\nWanna Play Again (y/n)?");
		String play = input.nextLine();
		
		if(play.equalsIgnoreCase("y") || play.equalsIgnoreCase("yes")){
			this.startGame();
		}else{
			System.out.println("Bye!");
		}
	}
	private void togglePlayerTurn(){
		if(this.currentPlayer == this.player1){
			this.currentPlayer = this.player2;
		}else{
			this.currentPlayer = this.player1;
		}
	}
	private boolean gameOver(){
		//update code for future use as winning conditions
		for (int i = 0; i<this.grid.getSize();i++){
			if(this.grid.grid[i][1]==this.grid.grid[i][2] && this.grid.grid[i][2]==this.grid.grid[i][0]){
				return true;
			}
			if(this.grid.grid[1][i]==this.grid.grid[0][i] && this.grid.grid[2][i]==this.grid.grid[0][i]){
				return true;
			}
		}
		if(this.grid.grid[0][0]==this.grid.grid[1][1] && this.grid.grid[1][1]==this.grid.grid[2][2]){
			return true;

		}else if(this.grid.grid[1][1]==this.grid.grid[2][0] && this.grid.grid[2][0]==this.grid.grid[0][2]){
			return true;
		}
		return false;

	}
	boolean markLocationInGrid(Player currentPlayer,int markLocation){
		if(this.currentPlayer.getSymbol() == currentPlayer.getSymbol()){
			if(this.grid.markLocationInGrid(this.currentPlayer,markLocation))
				return true;
			else
				return false;
		}else{
			return false;
		}
	}
	public void startGame(){

		this.grid.initializeGrid();

		Scanner input = new Scanner(System.in);

		System.out.println("Game Started\n");
	
		currentPlayer = player1;
		while(!this.gameOver() && this.grid.hasEmptyLocation()){
			this.grid.printGrid();
			System.out.println("\nEnter the number to play");
			System.out.println("Player "+currentPlayer.getName()+" turn");
			int markLocation = input.nextInt();
			if(!currentPlayer.markLocationInGrid(this,markLocation)){
				continue;
			}else{
				this.togglePlayerTurn();
			}
			

		}
		if(this.gameOver()){
			this.declareWinner();
		}else{
			System.out.println("\n==>>Match Tied<<==\n");
		}
		this.gameEnded();

	}
	
}
