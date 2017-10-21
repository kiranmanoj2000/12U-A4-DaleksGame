
import java.awt.Color;

/**
 * This class manages the interactions between the different pieces of the game:
 * the Board, the Daleks, and the Doctor. It determines when the game is over
 * and whether the Doctor won or lost.
 */
public class CatchGame {

    /**
     * Instance variables go up here Make sure to create a Board, 3 Daleks, and
     * a Doctor
     */
    // create the board
    Board board = new Board(12, 12);
    
    // create the first dalek in a random position
    Dalek dalekOne = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
    // create the second dalek in a random position
    Dalek dalekTwo = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
    // create the third dalek in a random position
    Dalek dalekThree = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
    // create the doctor in a random place
    Doctor doc = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));

    
    /**
     * The constructor for the game. Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame() {
            // put a peg in the position of the doctor
            board.putPeg(Color.green, doc.getRow(), doc.getCol());
            // put a peg in the position of the first dalek
            board.putPeg(Color.gray, dalekOne.getRow(),dalekOne.getRow());
            // put a peg in the position of the second dalek
            board.putPeg(Color.orange, dalekTwo.getRow(),dalekTwo.getRow());
            // put a peg in the position of the first dalek
            board.putPeg(Color.cyan, dalekThree.getRow(),dalekThree.getRow());


     
    }
    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        // while the user is clicking on the screen
        while (true) {
            
            // find where they  clicked 
            Coordinate click = board.getClick();
            // remove the peg where the doctor was before the click
            board.removePeg(doc.getRow(), doc.getCol());
            // make the doctor move to where the user clicked
            doc.move(click.getRow(), click.getCol());
            
            // move the peg that represents the doctor
            board.putPeg(Color.green, doc.getRow(), doc.getCol());
            
            
            // remove the peg where the first dalek was
            board.removePeg(dalekOne.getRow(),dalekOne.getCol());
            // make the first dalek move closer to the doctor
            dalekOne.advanceTowards(doc);
            // move the peg that represents the first dalek
            board.putPeg(Color.red, dalekOne.getRow(), dalekOne.getCol());
            
            // remove the peg where the second dalek was
            board.removePeg(dalekTwo.getRow(),dalekTwo.getCol());
            // make the second dalek move closer to the doctor
            dalekTwo.advanceTowards(doc);
            // move the peg that represents the second dalek
            board.putPeg(Color.blue, dalekTwo.getRow(), dalekTwo.getCol());
            
            // remove the peg where the third dalek was
            board.removePeg(dalekThree.getRow(),dalekThree.getCol());
            // make the third dalek move closer to the doctor
            dalekThree.advanceTowards(doc);
            // move the peg that represents the third dalek
            board.putPeg(Color.pink, dalekThree.getRow(), dalekThree.getCol());

            // if two daleks have crashed
            
        }

    }
}
