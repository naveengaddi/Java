class Grid{
	//default size of grid is 10
	private static int size;
	Grid(int size){
		this.size  = size;
	}
	Grid(){
		this.size = 10;
	}
	int getSize(){
		return this.size+1;
	}
	
}
class Position{
	private int x,y;
	Position(int x,int y){
		this.x = x;
		this.y = y;
	}
	String getPosition(){
		return this.x+","+this.y;
	}
	void incrementXCoordinate(){
		this.x++;
	}
	void incrementYCoordinate(){
		this.y++;
	}
	void decrementXCoodinate(){
		this.x--;
	}
	void decrementYCoodinate(){
		this.y--;
	}
	boolean equals(Position position){
		if(this.x == position.x && this.y == position.y)
			return true;
		return false;
	}
	double calculateDistance(Position position){
		return Math.pow((this.x-position.x),2)+Math.pow((this.y-position.y),2);
	}
}

class Ball{
	private final Position ball_position;
	Ball(Position ball_position){
		this.ball_position = ball_position;
	}
	void printPosition(){
		System.out.println("Ball Position is ("+this.ball_position.getPosition()+")");
	}
	Position getPosition(){
		return this.ball_position;
	}
}
class Person{
	private Position person_position;
	Person(Position person_position){
		this.person_position = person_position;
	}
	void move(String command){
		if(command.equalsIgnoreCase("right")){
			this.person_position.incrementXCoordinate();
		}else if(command.equalsIgnoreCase("up")){
			this.person_position.incrementYCoordinate();
		}else if(command.equalsIgnoreCase("left")){
			this.person_position.decrementXCoodinate();
		}else if(command.equalsIgnoreCase("down")){
			this.person_position.decrementYCoodinate();
		}else{
			System.out.println("Unknown Command");
		}
	}
	void nextMove(GridGame game){
		double dist_before_move = game.calculateDistance();
		System.out.println("Moving Right");
		this.move("right");
		double dist_after_right_move = game.calculateDistance();
		if(dist_before_move < dist_after_right_move){
			//revert move bcz gng in wrng direction..
			System.out.println("Reverting previous move RIGHT move is not correct");
			this.move("left");
		}
		dist_before_move = game.calculateDistance();
		System.out.println("Moving Up");
		this.move("up");
		double dist_after_up_move = game.calculateDistance();
		if(dist_before_move < dist_after_up_move){
			System.out.println("Reverting move. UP move is not correct");
			this.move("down");
		}


	}
	void printPosition(){
		System.out.println("Person Position is ("+this.person_position.getPosition()+")");
	}
	
	Position getPosition(){
		return this.person_position;
	}

}
class GridGame{
	/*
            |2,3    (2 right moves , 3 up moves)
            | 
	0,0__ __|
	*/
	private final Grid grid;
	private Person person;
	private Ball ball;
	GridGame(){
		this.grid = new Grid(10);
		this.ball = new Ball(new Position(this.getRandomNumberWithinGrid(),this.getRandomNumberWithinGrid()));
		this.person = new Person(new Position(0,0));

	}
	int getRandomNumberWithinGrid(){
		return (int)(Math.random()*this.grid.getSize());
	}
	
	double calculateDistance(){
		return this.person.getPosition().calculateDistance(this.ball.getPosition());
	}
	boolean isPersonReachedBall(){
		if(this.person.getPosition().equals(this.ball.getPosition()))
			return true;
		return false;
	}
	public void findPath(){
		this.ball.printPosition();
		this.person.printPosition();

		while(!isPersonReachedBall()){
			this.person.nextMove(this);
			this.person.printPosition();
		}
		
	}
	Ball getBall(){
		return this.ball;
	}

}
public class GridProblem{
	public static void main(String[] args) {	


		GridGame gridGame = new GridGame();

		gridGame.findPath();
	}
}
