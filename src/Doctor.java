
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
        theRow = this.row;
        // set the column to where the doctor is randomly placed
        theCol = this.col;
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
        
            
            
            // keep track of where the user has clicked to move the doctor
             
            
            // if the user has clicked on a square immediatly surrounfig the doctor
            if((newRow!=this.getRow()+1||newRow!=this.getRow()-1)||
                    (newCol!=this.getCol()+1||newCol!=this.getCol()-1)){
                // set the row to the one they clicked in
                this.row = newRow;
                // set the column of the doctor to the one they clicked on
                this.col = newCol;
            
        }   // if the player clicks on the same position that the doctor is on
            else if(newRow == this.row&&newCol==this.col){
                // keep the doctor in the same spot they clicked on
                this.row = newRow;
                this.col = newCol;
            } // they did not click on the same position or an immediate block around them
            else{
            // move the doctor to a random spot
                this.row =(int)(Math.random()*12);
                this.col =(int)(Math.random()*12);
            
    
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
