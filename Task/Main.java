class Ball{
	//x,y are the co-ordinates of ball;
	int x,y;
	int max = 10, min = 0 , range = max-min+1;
	Ball(){
		x = (int)(Math.random()*range);
		y = (int)(Math.random()*range);
	}
	
}
class FindPath{
	//int max = 10,min = 0, range = max-min+1;
	/*
            |2,3    (2 right moves , 3 up moves)
            | 
	0,0__ __|
	*/
	public static void  find(Ball b, int i,int j){

		System.out.println("Ball Position is "+b.x+" "+b.y);
		System.out.println("Initial Position is x->"+i+" y->"+j);
		i++;
		while(i<=b.x){
			System.out.println("Move Right ==> position is x->"+i+" y->"+j);
			i = move("right",i);
			
		}
		i--;
		j++;
		while(j<=b.y){
			System.out.println("Move Up ==> position is x->"+i+" y->"+j);
			j = move("up",j);
			
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
		if( command.equalsIgnoreCase("right") || command.equalsIgnoreCase("up")){
			pos++;
		}
		return pos;

	}

}
public class Main{
	public static void main(String[] args) {	

		//Ball object contains (x,y) co-ordinates of it.
		Ball b = new Ball();
		
		//0,0 are the initial co-ordinates to find path from.
		FindPath.find(b,0,0);
	}
}