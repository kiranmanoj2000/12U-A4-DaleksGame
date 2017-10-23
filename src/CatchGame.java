
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
        board.putPeg(Color.black, dalekOne.getRow(), dalekOne.getCol());
        // put a peg in the position of the second dalek
        board.putPeg(Color.black, dalekTwo.getRow(), dalekTwo.getCol());
        // put a peg in the position of the third dalek
        board.putPeg(Color.black, dalekThree.getRow(), dalekThree.getCol());

    }

    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        //while a doctor spawns on a dalek at the beginning of the game
        while ((dalekOne.getCol() == doc.getCol() && dalekOne.getRow() == doc.getRow())
                || (dalekTwo.getCol() == doc.getCol() && dalekTwo.getRow() == doc.getRow())
                || (dalekThree.getCol() == doc.getCol() && dalekThree.getRow() == doc.getRow())) {
            // put a yellow peg in the doctors place
            board.putPeg(Color.yellow, doc.getRow(), doc.getCol());
            // output that the game is over (added spaces to centre text while displaying)
            board.displayMessage("          The doctor has been captured! Try again!");
            // end the game
            break;
        }
        // if dalek one spawns on dalek two
        if ((dalekOne.getCol() == dalekTwo.getCol()) && dalekOne.getRow() == dalekTwo.getRow()) {
            // put a red peg at the crash site
            board.putPeg(Color.red, dalekOne.getRow(), dalekOne.getCol());
            // set the first dalek to be in a crashed state
            dalekOne.crash();
            // set the second dalek in a crashed state
            dalekTwo.crash();
        }
        // if dalek one spawns on dalek three
        if ((dalekOne.getCol() == dalekThree.getCol()) && dalekOne.getRow() == dalekThree.getRow()) {
            // put a red peg at the crash site
            board.putPeg(Color.red, dalekOne.getRow(), dalekOne.getCol());
            // set the first dalek to be in a crashed state
            dalekOne.crash();
            // set the third dalek in a crashed state
            dalekThree.crash();
        }
        // if dalek two spawns on dalek three
        if ((dalekTwo.getCol() == dalekThree.getCol()) && dalekTwo.getRow() == dalekThree.getRow()) {
            // put a red peg at the crash site
            board.putPeg(Color.red, dalekTwo.getRow(), dalekTwo.getCol());
            // set the second dalek to be in a crashed state
            dalekTwo.crash();
            // set the third dalek in a crashed state
            dalekThree.crash();
        }
        // while all three daleks spawn at the same spot
        while ((dalekOne.getRow() == dalekTwo.getRow() && dalekOne.getCol() == dalekTwo.getCol()) && (dalekTwo.getRow() == dalekThree.getRow() && dalekTwo.getCol() == dalekThree.getCol())) {
            // put a red peg at the crash site
            board.putPeg(Color.red, dalekOne.getRow(), dalekOne.getCol());
            // set the first dalek to be in a crashed state
            dalekOne.crash();
            // set the second dalek in a crashed state
            dalekTwo.crash();
            // set the third dalek in a crashed state
            dalekThree.crash();
            // output the doctor has won (extra spaces to centre text)
            board.displayMessage("            Congratulations, the doctor has won!");
            // end the game
            break;
        }

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
            // only make dalek one move if it has not crashed
            if (!dalekOne.hasCrashed()) {
                // remove the peg where the first dalek was
                board.removePeg(dalekOne.getRow(), dalekOne.getCol());
                // make the first dalek move closer to the doctor
                dalekOne.advanceTowards(doc);
                // move the peg that represents the first dalek
                board.putPeg(Color.black, dalekOne.getRow(), dalekOne.getCol());
            }
            // only make dalek two move if it has not crashed
            if (!dalekTwo.hasCrashed()) {
                // remove the peg where the second dalek was
                board.removePeg(dalekTwo.getRow(), dalekTwo.getCol());
                // make the second dalek move closer to the doctor
                dalekTwo.advanceTowards(doc);
                // move the peg that represents the second dalek
                board.putPeg(Color.black, dalekTwo.getRow(), dalekTwo.getCol());
            }
            // only make dalek 3 move if it has not crashed
            if (!dalekThree.hasCrashed()) {
                // remove the peg where the third dalek was
                board.removePeg(dalekThree.getRow(), dalekThree.getCol());
                // make the third dalek move closer to the doctor
                dalekThree.advanceTowards(doc);
                // move the peg that represents the third dalek
                board.putPeg(Color.black, dalekThree.getRow(), dalekThree.getCol());
            }
            // COLLISIONS
            // if dalek one and two have crashed
            if ((dalekOne.getCol() == dalekTwo.getCol()) && (dalekOne.getRow() == dalekTwo.getRow())) {
                // set the first dalek in a crashed state
                dalekOne.crash();
                // set the second dalek in a crashed state
                dalekTwo.crash();
                // put a red peg at the crash site
                board.putPeg(Color.red, dalekOne.getRow(), dalekOne.getCol());
            }
            // if dalek two and three have crashed
            if ((dalekTwo.getRow() == dalekThree.getRow()) && (dalekTwo.getCol() == dalekThree.getCol())) {
                // set the second dalek in a crashed state
                dalekTwo.crash();
                // set the third dalek in a crashed state
                dalekThree.crash();
                // put a red peg at the crash site
                board.putPeg(Color.red, dalekTwo.getRow(), dalekTwo.getCol());
            }
            // if dalek one and three have crashed
            if ((dalekOne.getCol() == dalekThree.getCol()) && (dalekOne.getRow() == dalekThree.getRow())) {
                // set the first dalek in a crashed state
                dalekOne.crash();
                // set the third dalek in a crashed state 
                dalekThree.crash();
                // put a red peg at the crash site
                board.putPeg(Color.red, dalekThree.getRow(), dalekThree.getCol());
            }
            // if a dalek has captured the doctor or the doctor moves onto a crash site
            if ((dalekOne.getCol() == doc.getCol() && dalekOne.getRow() == doc.getRow())
                    || (dalekTwo.getCol() == doc.getCol() && dalekTwo.getRow() == doc.getRow())
                    || (dalekThree.getCol() == doc.getCol() && dalekThree.getRow() == doc.getRow())) {
                // put a yellow peg down to let users know the doctor has been captured
                board.putPeg(Color.yellow, doc.getRow(), doc.getCol());
                // output that the game is over (added spaces to centre text while displaying)
                board.displayMessage("          The doctor has been captured! Try again!");
                // end the game
                break;
            }
            // if all the daleks have crashed
            if (dalekOne.hasCrashed() && dalekTwo.hasCrashed() && dalekThree.hasCrashed()) {
                // output the doctor has won (extra spaces to centre text)
                board.displayMessage("            Congratulations, the doctor has won!");
                // end the game
                break;
            }

        }

    }
}
