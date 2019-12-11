import javax.swing.JFrame;

/**
* GUI with Pokemon class.
* @author Group 3
* @since 12/10/2019
*/

public class PokemonFrame {
   /** main method.
   * @param args not used
   */
   public static void main(String[ ] args) {
      //setup basic JFrame
        
      JFrame frm = new JFrame("Pokemon Go");
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Add StudentPanel object to Frame
      frm.getContentPane().add(new PokemonPanel());
      //Display to screen
      frm.pack();
      frm.setVisible(true);
      
   }
}