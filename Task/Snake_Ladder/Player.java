public class Player{
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
