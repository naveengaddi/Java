import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
class Die{
	int rollDie(){
		return (int)(Math.random()*6)+1;
	}
}
class Player{
	private final String name;
	private int position;
	Player(String name){
		this.name = name;
		this.position = 0;
	}
	String getName(){
		return this.name;
	}
	int rollDie(Die die){
		return die.rollDie();
	}
	void updatePosition(int position){
		this.position = position;
		System.out.println("Current Position is "+this.position);
	}
	int getPosition(){
		return this.position;
	}
}
abstract class SpecialPositions{
	public abstract Map<Integer,Integer> getPositions();

}
class Snake extends SpecialPositions{
	private Map<Integer,Integer> snakes = new HashMap<>();
	Snake(){
		this.snakes.put(16,8);
		this.snakes.put(52,28);
		this.snakes.put(78,25);
		this.snakes.put(93,89);
		this.snakes.put(95,75);
		this.snakes.put(99,21);
	}

	@Override
	public Map<Integer,Integer> getPositions(){
		return this.snakes;
	}
	boolean checkPlayerLandedOnSnake(Player player){
		if(this.snakes.containsKey(player.getPosition())){
			player.updatePosition(this.snakes.get(player.getPosition()));
			return true;
		}else{
			return false;
		}
	}

}
class Ladder extends SpecialPositions{
	private Map<Integer,Integer> ladders = new HashMap<>();
	Ladder(){
		this.ladders.put(2,45);
		this.ladders.put(4,27);
		this.ladders.put(9,31);
		this.ladders.put(47,84);
		this.ladders.put(70,87);
		this.ladders.put(71,91);

	}
	@Override
	public Map<Integer,Integer> getPositions(){
		return this.ladders;
	}
	boolean checkPlayerLandedOnLadder(Player player){
		if(this.ladders.containsKey(player.getPosition())){
			player.updatePosition(this.ladders.get(player.getPosition()));
			return true;
		}else{
			return false;
		}
	}
}
class GameBoard{
	private Ladder ladder;
	private Snake snake;
	private Die die;

	GameBoard(){
		this.ladder = new Ladder();
		this.snake = new Snake();
		this.die = new Die();
	}
	Ladder getLadders(){
		return this.ladder;
	}
	Snake getSnakes(){
		return this.snake;
	}
	Die getDie(){
		return this.die;
	}
}

class SnakeAndLadderGame{
	private GameBoard gameBoard;
	private Player player1,player2,currentPlayer;
    SnakeAndLadderGame(Player player1,Player player2){
    	this.gameBoard = new GameBoard();
    	this.player1 = player1;
    	this.player2 = player2;
    }
    boolean validateDieNumber(Player currentPlayer,int die_number){
    	if((currentPlayer.getPosition()+die_number)<=100){
    		return true;
    	}
    	System.out.println("This Die number not applicable to you.");
    	return false;
    }
    String checkForSpecialPositions(Player currentPlayer){
    	String ret = "";
    	if(this.gameBoard.getSnakes().checkPlayerLandedOnSnake(currentPlayer)){
    		System.out.println("You landed on snake");
    		ret = "snake";
    	}else if(this.gameBoard.getLadders().checkPlayerLandedOnLadder(currentPlayer)){
    		System.out.println("You landed on ladder");
    		ret = "ladder";
    	}
    	return ret;

    }
    void updatePlayerPosition(int die_number){
    	this.currentPlayer.updatePosition(this.currentPlayer.getPosition()+die_number);
    }
	public void startGame(){
		Scanner input = new Scanner(System.in);
		currentPlayer = player1;
		while(!this.isGameEnded()){
			System.out.println("\n"+currentPlayer.getName()+"\'s Position-> "+currentPlayer.getPosition()+" "+" -- Press Enter to Roll Die");
			input.nextLine();
			int die_number = currentPlayer.rollDie(gameBoard.getDie());
			System.out.println(currentPlayer.getName()+" Rolled Die. Number is --> "+die_number);
			if(this.validateDieNumber(currentPlayer,die_number)==true){
				updatePlayerPosition(die_number);
				//currentPlayer.updatePosition(currentPlayer.getPosition()+die_number);
				String landedObject = this.checkForSpecialPositions(currentPlayer);
				if((die_number == 6 && landedObject!="snake") ){
					continue;
				}
			}
			if(currentPlayer == player1){
				currentPlayer = player2;
			}else{
				currentPlayer = player1;
			}
		}
		this.whoWon();
		
	}
	void whoWon(){
		if(this.player1.getPosition()==100){
			System.out.println("Player --> "+player1.getName()+" Won the Match");
		}else{
			System.out.println("Player --> "+player2.getName()+" Won the Match");
		}
	}
	boolean isGameEnded(){
		if(this.player1.getPosition()==100 || this.player2.getPosition()==100){
			return true;
		}
		return false;
	}
}
class SnakeAndLadderTest{
	public static void main(String[] args) {
		Player player1 = new Player("Naveen");
		Player player2 = new Player("Gaddi");
		
		SnakeAndLadderGame snakeLadderGame = new SnakeAndLadderGame(player1,player2);
		snakeLadderGame.startGame();
	}	
}
