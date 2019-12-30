class Grid{
	//default size of grid is 10
	static int size;
	Grid(int size){
		this.size  = size;
	}
	
}
class Position{
	private int x,y;
	Position(int x,int y){
		this.x = x;
		this.y = y;
	}
	// Pair<Integer,Integer> getCoordinates(){
	// 	return this.co_ordinate;
	// }
	int getXCoordinate(){
		return this.x;
	}
	int getYCoordinate(){
		return this.y;
	}
}

class Ball{
	final Position ball_position;
	Ball(){

		this.ball_position = new Position(this.getRandomNumberWithinGrid(),this.getRandomNumberWithinGrid());
	}
	void printPosition(){
		System.out.println("Ball Position is ("+this.ball_position.getXCoordinate()+","+this.ball_position.getYCoordinate()+")");
	}
	int getRandomNumberWithinGrid(){
		return (int)(Math.random()*Grid.size+1);
	}

}
class Person{
	Position person_position;
	Person(int x,int y){
		this.person_position = new Position(x,y);
	}
	Person(){
		this.person_position = new Position(0,0);
	}
	void move(String command){
		if(command.equalsIgnoreCase("right")){
			this.person_position = new Position(this.person_position.getXCoordinate()+1,this.person_position.getYCoordinate());
			//this.person_position.setXCoordinate(this.person_position.getXCoordinate()+1);
		}else if(command.equalsIgnoreCase("up")){
			this.person_position = new Position(this.person_position.getXCoordinate(),this.person_position.getYCoordinate()+1);
			//this.person_position.setYCoordinate(this.person_position.getYCoordinate()+1);
		}
	}
	void printPosition(){
		System.out.println("Person Position is ("+this.person_position.getXCoordinate()+","+this.person_position.getYCoordinate()+")");
	}

}
class GridGame{
	/*
                |2,3    (2 right moves , 3 up moves)
                | 
	0,0__ __|
	*/
	Grid grid;	
	void createGrid(int size){
		this.grid = new Grid(size);
	}
	boolean isPersonReachedBall(Ball ball,Person person){
		if(ball.ball_position.getXCoordinate()==person.person_position.getXCoordinate() && ball.ball_position.getYCoordinate()==person.person_position.getYCoordinate() )
			return true;
		return false;
	}
	public void findPath(Ball ball,Person person){
		ball.printPosition();
		person.printPosition();
		while(isPersonReachedBall(ball,person)==false){
			if(person.person_position.getXCoordinate()<ball.ball_position.getXCoordinate()){
				System.out.println("Move Right");
				person.move("right");
				person.printPosition();
			}
			if(person.person_position.getYCoordinate()<ball.ball_position.getYCoordinate()){
				System.out.println("Move Up");
				person.move("up");
				person.printPosition();
			}
		}
		
	}

}
public class GridProblem{
	public static void main(String[] args) {	


		GridGame gridGame = new GridGame();
		gridGame.createGrid(10);

		Ball ball = new Ball();

		Person person = new Person();

		gridGame.findPath(ball,person);
	}
}
