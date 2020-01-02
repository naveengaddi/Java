//player class one who plays game..
class Player{
	private String name;
	private char symbol;
	Player(String name,char symbol){
		this.name = name;
		this.symbol = symbol;
	}
	boolean markLocationInGrid(TicTacToeGame game,int markLocation){
		if(game.markLocationInGrid(this,markLocation))
			return true;
		else
			return false;
	}
	String getName(){
		return this.name;
	}
	char getSymbol(){
		return this.symbol;
	}
}
