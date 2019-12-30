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



public class TicTacToe{
	public static void main(String[] args) {
		Player p1 = new Player("Naveen",'X');
		Player p2 = new Player("Gaddi",'O');

		TicTacToeGame tGame = new TicTacToeGame();
		tGame.startGame(p1,p2);
	}
}