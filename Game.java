import java.util.*;
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
	public static void  find(){

		Ball b = new Ball();
		System.out.println("Ball Position is "+b.x+" "+b.y);

		//initial position to find path
		int i = 0 ,j = 0;
		for(i = 0 ; i <= b.x;i++){
			System.out.println("Move Right ==> position is x->"+i+" y->"+j);
		}
		for(j = 0 ; j<= b.y;j++){
			System.out.println("Move Up ==> position is x->"+(i-1)	+" y->"+j);
		}

		//return true;
	}
	


}
class Main{
	public static void main(String[] args) {		
		FindPath.find();
	}
}