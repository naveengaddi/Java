
public class SnakeAndLadderMain{
	public static void main(String[] args) {
		Player player1 = new Player("Naveen");
		Player player2 = new Player("Gaddi");
		SnakeAndLadderGame snakeLadderGame = new SnakeAndLadderGame(player1,player2);
		snakeLadderGame.startGame();
	}	
}
