
/**
 * This class models the Doctor in the game. A Doctor has a position and can
 * move to a new position.
 */
public class Doctor {

    private int row, col;

    /**
     * Initializes the variables for a Doctor.
     *
     * @param theRow The row this Doctor starts at.
     * @param theCol The column this Doctor starts at.
     */
    public Doctor(int theRow, int theCol) {
        // set the row to where the doctor is randomly placed
        this.row = theRow;
        // set the column to where the doctor is randomly placed
        this.col = theCol;
    }

    /**
     * Move the Doctor. If the player clicks on one of the squares immediately
     * surrounding the Doctor, the peg is moved to that location. Clicking on
     * the Doctor does not move the peg, but instead allows the Doctor to wait
     * in place for a turn. Clicking on any other square causes the Doctor to
     * teleport to a random square (perhaps by using a �sonic screwdriver�).
     * Teleportation is completely random.
     *
     * @param newRow The row the player clicked on.
     * @param newCol The column the player clicked on.
     */
    public void move(int newRow, int newCol) {
        // allow the doctor to move
        // if the user has clicked on a square immediatly on top the doctor
        if (((newRow - this.row == -1 || newRow - this.row == 0) && (newCol - this.col == 0 || newCol - this.col == -1 || newCol - this.col == 1))
                // or if a space to the immediate left is clicked
                || ((newRow - this.row == -1 || newRow - this.row == 0) && (newCol - this.col == -1))
                // or if a space directly under is clicked
                || ((newRow - this.row == 1 || newRow - this.row == 0) && (newCol - this.col == -1 || newCol - this.col == 0 || newCol - this.col == 1))
                // or if a space directly to the right is clicked
                || ((newRow - this.row == 0) && (newCol - this.col == 1))) {
            // set the row to the one they clicked on
            this.row = newRow;
            // set the column of the doctor to the one they clicked on
            this.col = newCol;

        } // if the player clicks on the same position that the doctor is on
        else if (newRow == this.row && newCol == this.col) {
            // keep the doctor in the same row they clicked on
            this.row = newRow;
            // keep the doctor in the same column they clicked on
            this.col = newCol;
        } // they did not click on the same position or an immediate block around the doctor
        else {
            // move the doctor to a random row
            this.row = (int) (Math.random() * 12);
            // move the doctor to a random column
            this.col = (int) (Math.random() * 12);

        }
    }

    /**
     * Returns the row of this Doctor.
     *
     * @return This Doctor's row.
     */
    public int getRow() {
        // return the row the doctor is on
        return this.row;
    }

    /**
     * Returns the column of this Doctor.
     *
     * @return This Doctor's column.
     */
    public int getCol() {
        // return the column the doctor is on
        return this.col;
    }

}
