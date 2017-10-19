
/** This class manages the interactions between the different pieces of
 *  the game: the Board, the Daleks, and the Doctor. It determines when
 *  the game is over and whether the Doctor won or lost.
 */
public class CatchGame {

    /**
     * Instance variables go up here
     * Make sure to create a Board, 3 Daleks, and a Doctor
     */
    // create the board
    Board board = new Board(12,12);
    
    // create the first dalek in a random position
    Dalek dalekOne = new Dalek((int)(Math.random()*12),(int)(Math.random()*12));
    // create the second dalek in a random position
    Dalek dalekTwo = new Dalek((int)(Math.random()*12),(int)(Math.random()*12));
    // create the third dalek in a random position
    Dalek dalekThree = new Dalek((int)(Math.random()*12),(int)(Math.random()*12));
    // create the doctor in a random place
    Doctor doc = new Doctor((int)(Math.random()*12),(int)(Math.random()*12));
   

    /**
     * The constructor for the game. 
     * Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame(){
        
    }
    
    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        // allow the doctor to move
        while(true){
            
            
            // keep track of where the user has clicked to move the doctor
            
            Coordinate click = board.getClick();
            // if the user has clicked on a square immediatly surrounfig the doctor
            if((click.getRow()!=doc.getRow()+1||click.getRow()!=doc.getRow()-1)||
                    (click.getCol()!=doc.getCol()+1||click.getCol()!=doc.getCol()-1)){
            // find the row he user clicked on
            int clickRow = click.getRow();
        }   // if the player clicks on the same position that the doctor is on
            else
    }

}
}