import java.io.*;
import java.util.Scanner;
class Grid{
	//default grid size is 3x3
	final int size = 3;
	char[][] grid = new char[size][size];

	//initialize grid with numbers to indicate  grid is empty
	/*
		1 2 3
		4 5 6
		7 8 9
	*/
	void initializeGrid(){
		int cnt = 0;
		for (int i = 0 ;i<this.size;i++ ) {
			for (int j = 0;j<this.size ;j++ ) {
				this.grid[i][j] = (char)(cnt+49);
				cnt++;
			}
		}
	}
	//utility function returns true if any block is empty in grid
	boolean isEmpty(){
		int cnt = 0;
		for (int i = 0 ;i<this.size;i++ ) {
			for (int j = 0;j<this.size ;j++ ) {
				if(this.grid[i][j] == (char)(cnt+49) )
					return true;
				//grid[i][j] = (char)(cnt+49);
				cnt++;
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
}


class Player{

	String name;
	char symbol;
	// Player(String name){
	// 	this.name = name;
	// 	this.symbol = (x == 0) ? 'O' : 'X';
	// }
	Player(String name,char symbol){
		this.name = name;
		this.symbol = symbol;
	}
}

class TicTacToeGame{

	//boolean var to indicate players turn...
	boolean term = true;

	//creating and initializing empty grid
	Grid createGrid(){
		Grid grid = new Grid();
		grid.initializeGrid();
		return grid;
	}
	private boolean setPointInGrid(Player p,Grid gd,int point){
		int cnt = 0;
		for (int i = 0;i<gd.size ;i++ ) {
			for (int j = 0;j<gd.size;j++ ) {
				cnt++;
				if(cnt == point){
					if(gd.grid[i][j]==(char)(cnt+48)){
						gd.grid[i][j] = p.symbol;
						return true;	
					}else{
						return false;
					}
					
				}
			}
		}
		return false;

	}
	public void startGame(Player p1,Player p2){

		//creating 3x3 grid and initializing to empty with numbers
		Grid grid = this.createGrid();

		//input from player creating object
		Scanner sc = new Scanner(System.in);

		System.out.println("Game Started\n");

		//grid.printGrid();
		//System.out.println(this.isPlayerWon(grid));
		int point = -1;
		char whoWon ='$';
		while( (whoWon=this.isPlayerWon(grid)) == '$' && grid.isEmpty()==true ){
			grid.printGrid();
			System.out.println("\nEnter the number to play");
			if(this.term){
				System.out.println("Player 1 term");
				point = sc.nextInt();
				//System.out.println(point);
				if(this.setPointInGrid(p1,grid,point)){
					this.term = false;
				}
				else{
					System.out.println("Invalid Position");
				}
			}else{
				System.out.println("Player 2 term");
				point = sc.nextInt();
				if(this.setPointInGrid(p2,grid,point)){
					this.term = true;
				}
				else{
					System.out.println("Invalid Position");
				}
			}

		}
		if(p1.symbol == whoWon ){
			System.out.println("Player "+p1.name+" Won");
		}else if(p2.symbol == whoWon){
			System.out.println("Player "+p2.name+" Won");
		}else{
			grid.printGrid();
			System.out.println("\nMatch Tied\n");
		}
		System.out.println("Wanna Play Again (y/n)?");

		//System.out.println(whoWon);


	}
	//checks any player won or not returns players symbol if won..else returns '$'
	private char isPlayerWon(Grid gd){
		//logic goes here for winning
		char whoWon = '$';
		for (int i = 0; i<gd.size ;i++){
			if(gd.grid[i][0]!=' ' && gd.grid[i][1]==gd.grid[i][2] && gd.grid[i][2]==gd.grid[i][0]){
				//return true;
				//flg = true;
				whoWon = gd.grid[i][0];
				return whoWon;
			}
			if(gd.grid[0][i]!=' ' && gd.grid[1][i]==gd.grid[0][i] && gd.grid[2][i]==gd.grid[0][i]){
				//flg = true;
				whoWon = gd.grid[0][i];
				return whoWon;
				//break;
			}
		}
		if(gd.grid[1][1]!=' ' && gd.grid[0][0]==gd.grid[1][1] && gd.grid[1][1]==gd.grid[2][2]){
			//flg = true;
			whoWon = gd.grid[0][0];
			return whoWon;

		}else if(gd.grid[1][1]!=' ' && gd.grid[1][1]==gd.grid[2][0] && gd.grid[2][0]==gd.grid[0][2]){
			//flg = true;
			whoWon = gd.grid[1][1];
			return whoWon;
		}
		return whoWon;

	}
}

public class TicTacToe{
	public static void main(String[] args) {
		Player p1 = new Player("Naveen",'X');
		Player p2 = new Player("Gaddi",'O');

		TicTacToeGame tGame = new TicTacToeGame();
		tGame.startGame(p1,p2);
	}
}