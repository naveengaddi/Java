import java.util.Scanner;
enum LandedObject{
    SNAKE,LADDER,EMPTY;
}
public class Game{
    private GameBoard gameBoard;
    private Player player1,player2,currentPlayer;
    Game(Player player1,Player player2){
        this.gameBoard = new GameBoard();
        this.player1 = player1;
        this.player2 = player2;
    }
    private boolean validateDieNumber(Player currentPlayer,int die_number){
        if((currentPlayer.getPosition()+die_number)<=100){
            return true;
        }
        System.out.println("This Die number not applicable to you.");
        return false;
    }
    private LandedObject checkForSpecialPositions(Player currentPlayer){
        if(this.gameBoard.getSnakes().checkPlayerLandedOnSnake(currentPlayer)){
            System.out.println("You landed on snake");
            return LandedObject.SNAKE;
        }else if(this.gameBoard.getLadders().checkPlayerLandedOnLadder(currentPlayer)){
            System.out.println("You landed on ladder");
            return LandedObject.LADDER;
        }
        return LandedObject.EMPTY;

    }
    private void togglePlayerTurn(){
        if(this.currentPlayer == this.player1){
            this.currentPlayer = this.player1;
        }else{
            this.currentPlayer = this.player2;
        }
    }
    private void updatePlayerPosition(int die_number){
        this.currentPlayer.updatePosition(this.currentPlayer.getPosition()+die_number);
    }
    private void declareWinner(){
        this.togglePlayerTurn();
        System.out.println("Player --> "+this.currentPlayer.getName()+" Won the Match");
    }
    private boolean isGameEnded(){
        if(this.player1.getPosition()==100 || this.player2.getPosition()==100){
            return true;
        }
        return false;
    }
     public void startGame(){
        Scanner input = new Scanner(System.in);
        currentPlayer = player1;
        while(!this.isGameEnded()){
            System.out.println("\n"+currentPlayer.getName()+"\'s Position-> "+currentPlayer.getPosition()+" "+" -- Press Enter to Roll Die");
            input.nextLine();
            int die_number = currentPlayer.rollDie(gameBoard.getDie());
            System.out.println(currentPlayer.getName()+" Rolled Die. Number is --> "+die_number);
            if(this.validateDieNumber(currentPlayer,die_number)){
                this.updatePlayerPosition(die_number);
                LandedObject landedObject = this.checkForSpecialPositions(currentPlayer);
                if((die_number == 6 && landedObject!=LandedObject.SNAKE)){
                    continue;
                }
            }
            this.togglePlayerTurn();
        }
        this.declareWinner();
        
    }
}
