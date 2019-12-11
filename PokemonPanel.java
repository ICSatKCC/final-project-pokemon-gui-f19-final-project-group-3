import java.util.*; 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; //add this for the listener

/**
* Panel for PokemonFrame GUI.
*
* @author Group 3
* @since 12/10/2019
*/

public class PokemonPanel extends JPanel {

  /********* label. ************/
   private JLabel lTitle = new JLabel("To Catch a Pokemon");
   /********* label. ************/
   private JLabel lMsg = new JLabel("                ");
  /******* button. ****************/
   private JButton bHunt = new JButton(" Hunt ");
   /******* button. ****************/
   private JButton bCatch = new JButton(" Catch ");
   /******* button with pic. ****************/
   private ImageIcon pokedex = new ImageIcon(".png");
   /******* button with pic. ****************/
   private ImageIcon backpack = new ImageIcon(".png");
  /** button with ball on it. */
   private JButton bPokedex = new JButton(pokedex);
  /** button with backpack on it. */
   private JButton bBackpack = new JButton(backpack);
   

  
  /********* sub-panel. *********/
   private JPanel topSubPanel = new JPanel();
   /********* sub-panel. *********/
   private JPanel centerSubPanel = new JPanel();
   /********* sub-panel. *********/
   private JPanel bottomSubPanel = new JPanel();
  /** we can declare and initialize ActionListener obj. */
   private GUIListener listener = new GUIListener();
  
  
  /******** Pokemon.*********/
   private Pokemon pk;
   
  /******** String for holding Student for display. */ 
   private String sOut = new String("");
  /****** text are for displaying Pokemon.toString()s. */
  //parameters are default size in (rows,cols) chars
   private JTextArea textArea1 = new JTextArea(20,25);
   //parameters are default size in (rows,cols) chars
   private JTextArea textArea2 = new JTextArea(20,25);
   /******** text field. *******/
   private JTextField tf = new JTextField(25);

   
  /** Make TextArea scrollable. **********************/
   private JScrollPane scroll1 = new JScrollPane(textArea1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
   JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  
   private JScrollPane scroll2 = new JScrollPane(textArea2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
   JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


/**
  * Constructor holds everything.
  */
   public PokemonPanel() {
    
      this.setLayout(new BorderLayout()); //Border panel layout
      this.setPreferredSize(new Dimension(400, 500));
      topSubPanel.setBackground(Color.gray); //north area color
      centerSubPanel.setBackground(Color.gray); //center area color
      bottomSubPanel.setBackground(Color.gray); //bottomSubPanel area color
     
     //adding title to the topSubPanel
      topSubPanel.add(lTitle);
      this.add("North", topSubPanel); //adding top sub-panel to North
   
     
     
     //add labels, textFields and choice
      centerSubPanel.add(bHunt);
      bHunt.addActionListener(listener); //add listener to button
      centerSubPanel.add(bCatch);
      bCatch.addActionListener(listener); //add listener to button
      centerSubPanel.add(tf);
      
      //set up the textArea for holding list
      //make the textArea look like the background instead of white
      textArea1.setBackground(Color.gray);
      textArea2.setBackground(Color.white);
      

      textArea1.setEditable(false);
      textArea2.setEditable(false);
      scroll1.setBorder(null);
      centerSubPanel.add(scroll1);  //add scrollPane, textArea inside.        
      scroll1.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
      //add the center sub-panel to Center of main panel
      add("Center", centerSubPanel);
     
     //adding textarea2, buttons to the bottomSubPanel sub-panel
      bottomSubPanel.add(bPokedex);
      bottomSubPanel.add(bBackpack);
      bPokedex.addActionListener(listener); //add listener to button
      bBackpack.addActionListener(listener); //add listener to button 
     
      scroll2.setBorder(null);
      bottomSubPanel.add(scroll2);  //add scrollPane, textArea inside.        
      scroll2.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
     //add bottomSubPanel sub-panel to South area of main panel      
      add("South", bottomSubPanel);     
   } //close PokemonPanel constructor
 
 /**
 * Private ActionListener class.
 */
   private class GUIListener implements ActionListener {
   
     Pokemon pTemp = new Bulbasaur();
     PokeTree pTree = new PokeTree();

   /**
   * ActionPerformed method.
   * @param event what button is clicked.
   */ 
      public void actionPerformed(ActionEvent event) {
  
         //Pokemon pTemp = new Bulbasaur();
         //PokeTree pTree = new PokeTree();
      
      //if "hunt" button clicked, a random pokemon appeared  
         if (event.getSource() == bHunt) {
            pTemp = choosePokemon();
            tf.setText("A wild "+ pTemp.getSpecies() + "appeared! ");
            textArea1.setText( "\n" + pTemp.toString() + "\n");
         }
      //if "Catch" button clicked   
         if (event.getSource()  == bCatch) { 
            //pTree.add(pTemp);
            catchPokemon();
         } 
      //if "Pokedex" button clicked, print pokemons from assignment7    
         if (event.getSource()  == bPokedex) { 
         // textArea2.setText(pTree.printPokeTree() + "\n");
         } 
      //if "Backpack" button clicked   
         if (event.getSource()  == bBackpack) { 
         //components
         } 

  } //actionEvent method
   

 
 /**
    * creates & returns an arraylist of Pokemon.
    * @return a pokemon object
    */ 
   private Pokemon choosePokemon() {
     Random ar = new Random();
      //temp declare of pokemon object
      Pokemon p = new Bulbasaur();
      //user choice of species 
      int speChoice = ar.nextInt(9) + 1;;

         switch(speChoice) {
            case 1:
               p = new Bulbasaur();
               break;
            case 2: 
               p = new Ivysaur();
               break;
            case 3: 
               p = new Venusaur();
               break;
            case 4: 
               p = new Charmander();
               break;
            case 5: 
               p = new Charmeleon();
               break;
            case 6: 
               p = new Charizard();
               break;
            case 7: 
               p = new Squirtle();
               break;
            case 8: 
               p = new Wartortle();
               break;
            case 9: 
               p = new Blastoise();
               break;
            default: 
               break;
               
         } // close switch
     
      return p;
   } // close choosePokemon


/**
   * helper method for ActionListener.
   * randomly to decide  whether or not the Pokemon actually gets caught.
   */
      private void catchPokemon() {
         Random ran = new Random();
        //set boolean
        boolean caught = ran.nextBoolean();
      
      if (caught) {
          tf.setText("Caught "+ pTemp.getSpecies() );
          textArea1.setText( "\n" + pTemp.toString() + "\n");
          pTree.add(pTemp);
      } else { //not caught
          tf.setText( pTemp.getSpecies() + "escaped! ");
          textArea1.setText( "\n" + pTemp.toString() + "\n"); 
      }

      } //end catchPokemon method
 
 } // end GUIListener private class


} //end PokemonPanel class
