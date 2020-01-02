import java.io.*;
import java.util.Scanner;

public class TicTacToeTest{
	public static void main(String[] args) {
		// Player p1 = new Player("Naveen",'X');
		// Player p2 = new Player("Gaddi",'O');

		TicTacToeGame tGame = new TicTacToeGame("Naveen","Mani");
		tGame.startGame();
	}
}
