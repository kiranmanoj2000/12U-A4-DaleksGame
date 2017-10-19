
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manok5757
 */
public class BoardExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board(8,8);
        
        b.putPeg(Color.pink, 3,4);
        
        // remove peg
        b.removePeg(3,7);
        
        // message
        b.displayMessage("What are you sayying");
        while(true){
        // recieve click from user
        Coordinate click = b.getClick();
        int clickRow = click.getRow();
                int clickColumn = click.getCol();
        b.putPeg(Color.yellow, clickRow, clickColumn);
        }
    }
}
