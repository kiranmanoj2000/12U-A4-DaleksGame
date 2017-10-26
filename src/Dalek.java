
/**
 * This class models a Dalek in the game. A Delek has a position and can advance
 * towards the Doctor.
 */
public class Dalek {

    private int row, col;
    private boolean hasCrashed;

    /**
     * Initializes the variables for a Dalek.
     *
     * @param theRow The row this Dalek starts at.
     * @param theCol The column this Dalek starts at.
     */
    public Dalek(int theRow, int theCol) {
        // set the row of each dalek to where it is randomly placed
        this.row = theRow;
        // set the column of each dalek to where it is randomly placed
        this.col = theCol;
    }

    /**
     * Attempts to move the Dalek towards the Doctor by the most direct route,
     * moving up, down, right, left or diagonally. For example, if the Doctor is
     * above and to the right of a Dalek, it will move diagonally. If the Doctor
     * is directly below a Dalek, it will move down.
     *
     * @param doc The Doctor to move towards.
     */
    public void advanceTowards(Doctor doc) {
        // move the dalek towards the doctor
        // if the dalek is directly underneath the doctor
        if (doc.getCol() == this.col && doc.getRow() < this.row) {
            // move the dalek up one a row
            this.row = this.row - 1;
        }// if the doctor is directly underneath the dalek
        else if (doc.getCol() == this.col && doc.getRow() > this.row) {
            // move the dalek down a row
            this.row = this.row + 1;
        }// if the doctor is exactly to the right
        else if (doc.getRow() == this.row && doc.getCol() > this.col) {
            // move the dalek to the right a column
            this.col = this.col + 1;
        }// if the doctor is exactly to the left
        else if (doc.getRow() == this.row && doc.getCol() < this.col) {
            // move the dalek to the left a column
            this.col = this.col - 1;
        } // if the doctor is to the diagonal right
        else if (doc.getRow() < this.row && doc.getCol() > this.col) {
            // move the dalek to the right one column
            this.col = this.col + 1;
            // move it up a row
            this.row = this.row - 1;
        } // if the doctor is to the diagonal left
        else if (doc.getRow() < this.row && doc.getCol() < this.col) {
            // move the dalek to the left one column
            this.col = this.col - 1;
            // move it to the up a row
            this.row = this.row - 1;
        }// if the doctor is to the diagonally bottom right
        else if (doc.getRow() > this.row && doc.getCol() > this.col) {
            // move the dalek a column to the right
            this.col = this.col + 1;
            // move the dalek down a row
            this.row = this.row + 1;
        }// if the doctor is to the diagonallly bottom left
        else if (doc.getRow() > this.row && doc.getCol() < this.col) {
            // move the dalek to the left one column
            this.col = this.col - 1;
            // move the dalek down a row
            this.row = this.row + 1;
        }
    }

    /**
     * Returns the row of this Dalek.
     *
     * @return This Dalek's row.
     */
    public int getRow() {
        // return the row of the dalek
        return this.row;
    }

    /**
     * Returns the column of this Dalek.
     *
     * @return This Dalek's column.
     */
    public int getCol() {
        // return the column of the dalek
        return this.col;

    }

    /**
     * Sets the Dalek to be in a crashed state.
     */
    public void crash() {
        // when the dalek has crashed set that the dalek has crashed
        this.hasCrashed = true;
    }

    /**
     * Returns whether or not this Dalek has crashed.
     *
     * @return true if this Dalek has crashed, false otherwise
     */
    public boolean hasCrashed() {
        // if two daleks have crashed
        if (this.hasCrashed) {
            // return true
            return true;
        } else {
            // return false
            return false;
        }

    }
}
