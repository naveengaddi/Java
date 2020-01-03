public class GameBoard{
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
