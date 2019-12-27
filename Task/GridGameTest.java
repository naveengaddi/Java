class Grid{
	//grid size is defined by min and max
    final int max,min,range;
	Grid(int max,int min){
		this.max = max;
		this.min = min;
		this.range = max-min+1;
	}
	//default grid will be 0,0 to 10,10
	Grid(){
		this.max = 10;
		this.min = 0;
		this.range = max-min+1;
	}
}
class Ball{
	//x,y are the co-ordinates of ball;
	 int x,y;
	//int max = 10, min = 0 , range = max-min+1;
	Ball(Grid grid){
		x = (int)(Math.random()*grid.range);
		y = (int)(Math.random()*grid.range);
	}
	
}
class Person{
	//default starting co-ordinates of a person is origin
	 int x = 0,y = 0;
	Person(){
		this.x = 0;
		this.y = 0;
	}
	Person(int x,int y){
		this.x = x;
		this.y = y;
	}
}
class GridGame{
	//int max = 10,min = 0, range = max-min+1;
	/*
            |2,3    (2 right moves , 3 up moves)
            | 
	0,0__ __|
	*/
	public static void  findPath(Ball b,Person p){

		System.out.println("Ball Position is "+b.x+" "+b.y);
		System.out.println("Person initial Position is x->"+p.x+" y->"+p.y);
		p.x++;
		while(p.x<=b.x){
			System.out.println("Move Right ==> ( x->"+p.x+" y->"+p.y+" )");
			p.x = move("right",p.x);
			
		}
		p.x--;
		p.y++;
		while(p.y<=b.y){
			System.out.println("Move Up ==> ( x->"+p.x+" y->"+p.y+" )");
			p.y = move("up",p.y);
			
		}

		// for(i=i+1; i <= b.x;i++){
		// 	System.out.println("Move Right ==> position is x->"+i+" y->"+j);
		// }
		// for(j=j+1; j<= b.y;j++){
		// 	System.out.println("Move Up ==> position is x->"+(i-1)	+" y->"+j);
		// }

		//return true;
	}
	
	//Utility function to move up or right
	 static int move(String command,int pos){
		// if(command.equalsIgnoreCase("right")){
		// 	pos++;
		// }else if(command.equalsIgnoreCase("up")){
		// 	pos++;
		// }
		//only right and up moves allowed;
		if( command.equalsIgnoreCase("right") || command.equalsIgnoreCase("up")){
			pos++;
		}
		return pos;

	}

}
public class GridGameTest{
	public static void main(String[] args) {	

		//Ball object contains (x,y) co-ordinates of it.
		Ball ball = new Ball(new Grid());

		//default starting point is 0,0 ( x,y if provided Person(x,y) && x,y>=0)
		Person person = new Person();

		
		//0,0 are the initial co-ordinates to find path from.
		GridGame.findPath(ball,person);
	}
}