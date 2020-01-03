import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
public class Ladder extends SpecialPositions{
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
