import java.io.*;
import java.util.Scanner;
//Class Tic Tac toe game to play game.
class TicTacToeGame{

	//boolean var to indicate players turn...
	boolean term = true;

	//creating and initializing empty grid
	Grid createGrid(){
		this.term = true;
		//Grid grid = Grid.getGrid();
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
			System.out.println("==>>Player "+p1.name+" Won<<==");
		}else if(p2.symbol == whoWon){
			System.out.println("==>>Player "+p2.name+" Won<<==");
		}else{
			
			System.out.println("\n==>>Match Tied<<==\n");
		}
		grid.printGrid();
		System.out.println("\nWanna Play Again (y/n)?");
		String play = sc.nextLine();
		play = sc.nextLine();
		if(play.equalsIgnoreCase("y") || play.equalsIgnoreCase("yes")){
			this.startGame(p1,p2);
		}else{
			System.out.println("Bye!");
		}

	}
	//checks any player won or not returns players symbol if won..else returns '$'
	private char isPlayerWon(Grid gd){
		//logic goes here for winning
		char whoWon = '$';
		for (int i = 0; i<gd.size ;i++){
			if(gd.grid[i][1]==gd.grid[i][2] && gd.grid[i][2]==gd.grid[i][0]){
				//return true;
				//flg = true;
				whoWon = gd.grid[i][0];
				return whoWon;
			}
			if(gd.grid[1][i]==gd.grid[0][i] && gd.grid[2][i]==gd.grid[0][i]){
				//flg = true;
				whoWon = gd.grid[0][i];
				return whoWon;
				//break;
			}
		}
		if(gd.grid[0][0]==gd.grid[1][1] && gd.grid[1][1]==gd.grid[2][2]){
			//flg = true;
			whoWon = gd.grid[0][0];
			return whoWon;

		}else if(gd.grid[1][1]==gd.grid[2][0] && gd.grid[2][0]==gd.grid[0][2]){
			//flg = true;
			whoWon = gd.grid[1][1];
			return whoWon;
		}
		return whoWon;

	}
}