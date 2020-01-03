import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
public class Snake extends SpecialPositions{
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
