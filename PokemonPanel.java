import java.util.*; 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; //add this for the listener
import javax.swing.BorderFactory; 
import javax.swing.border.Border;


/**
* Panel for PokemonFrame GUI.
*
* @author Group 3 - Yongxin 
* @since 12/10/2019
*/

public class PokemonPanel extends JPanel {

  /******* button. ****************/
   private JButton bHunt = new JButton(" Hunt ");
   /******* button. ****************/
   private JButton bCatch = new JButton(" Catch ");
   /******* button with pic. ****************/
   private ImageIcon pokedex = new ImageIcon("pokedex_phone.png");
   /******* button with pic. ****************/
   private ImageIcon backpack = new ImageIcon("backpack_icon.png");
   
   /** button with ball on it. */
   private JButton bPokedex = new JButton(pokedex);
   /** button with backpack on it. */
   private JButton bBackpack = new JButton(backpack);
   /** pop up button. */
   private JButton bRec = new JButton(" Recent ");
   /** pop up button. */
   private JButton bNum = new JButton(" Number ");
   /** border. */ 
   private Border blueline = BorderFactory.createLineBorder(Color.blue);


  
  /********* sub-panel. *********/
   private JPanel topSubPanel = new JPanel();
   /********* sub-panel. *********/
   private JPanel centerSubPanel = new JPanel();
   /********* sub-panel. *********/
   private JPanel bottomSubPanel = new JPanel();
  /** we can declare and initialize ActionListener obj. */
   private GUIListener listener = new GUIListener();
  
  
  /******** Pokemon.*********/
   private Pokemon pTemp = new Bulbasaur();
   /******** Pokemon tree.*********/
   private PokeTree pTree = new PokeTree();
   /******** queue.*********/   
   private PriorityQueue<Pokemon> pq = new PriorityQueue<>();
   /******** helper queue.*********/
   private PriorityQueue<Pokemon> pqTemp = new PriorityQueue<>();
   /******** stack.*********/
   private Deque<Pokemon> stack = new LinkedList<>();
   /******** helper stack .*********/
   private Deque<Pokemon> stackTemp = new LinkedList<>();

   
  /******* pokemon pic. ****************/
   private ImageIcon iTemp = new ImageIcon("Question_mark.png");
   /******* pokemon pic. ****************/
   private ImageIcon blastoise = new ImageIcon("Blastoise.png");
   /******* pokemon pic. ****************/
   private ImageIcon bulbasaur = new ImageIcon("Bulbasaur.png");
   /******* pokemon pic. ****************/
   private ImageIcon charmander = new ImageIcon("Charmander.png");
   /******* pokemon pic. ****************/
   private ImageIcon charmeleon = new ImageIcon("Charmeleon.png");
   /******* pokemon pic. ****************/
   private ImageIcon charizard = new ImageIcon("Charizard.png");
   /******* pokemon pic. ****************/
   private ImageIcon ivysaur = new ImageIcon("Ivysaur.png");
   /******* pokemon pic. ****************/
   private ImageIcon squirtle = new ImageIcon("Squirtle.png");
   /******* pokemon pic. ****************/
   private ImageIcon venusaur = new ImageIcon("Venusaur.png");
   /******* pokemon pic. ****************/
   private ImageIcon wartortle = new ImageIcon("Wartortle.png");
   
  /********* label. ************/
   private JLabel jImage = new JLabel(iTemp);

   
  /******** String for holding pokemon for display. */ 
   private String sOut = new String("");
  /****** text are for displaying Pokemon.toString()s. */
  //parameters are default size in (rows,cols) chars
   private JTextArea textArea1 = new JTextArea(9, 25);
   /****** text are for displaying Pokemon.toString()s. */
   //parameters are default size in (rows,cols) chars
   private JTextArea textArea2 = new JTextArea(10, 25);
   /******** text field. *******/
   private JTextField tf = new JTextField(25);
   
  /** Make TextArea1 scrollable. **********************/
   private JScrollPane scroll1 = new JScrollPane(
                     textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                     JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  /** Make TextArea2 scrollable. **********************/
   private JScrollPane scroll2 = new JScrollPane(
                    textArea2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                     JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


/**
  * Constructor holds everything.
  */
   public PokemonPanel() {
    
      GridLayout gl = new GridLayout(1, 2);
      this.setLayout(new BorderLayout()); //Border panel layout
      this.setPreferredSize(new Dimension(400, 600));
      topSubPanel.setPreferredSize(new Dimension(400, 350));
      topSubPanel.setBackground(Color.lightGray); //north area color
      
      centerSubPanel.setBackground(Color.lightGray); //center area color
      centerSubPanel.setPreferredSize(new Dimension(400, 50));
      centerSubPanel.setLayout(gl);
   
      bottomSubPanel.setBackground(Color.lightGray); //bottomSubPanel area color
      bottomSubPanel.setPreferredSize(new Dimension(400, 200));
     
     //adding title to the topSubPanel
      topSubPanel.setBorder((BorderFactory.createTitledBorder(
                       blueline, "To catch a Pokemon")));
     
      this.add("North", topSubPanel); //adding top sub-panel to North
   
     
     
     //add textFields and label
      topSubPanel.add(tf);
      topSubPanel.add(jImage);
            
      //set up the textArea for holding list
      //make the textArea  white
      textArea1.setBackground(Color.white);
      textArea2.setBackground(Color.white);
      
   
      textArea1.setEditable(false);
      textArea1.setBorder(BorderFactory.createLineBorder(Color.black));
      textArea2.setEditable(false);
      textArea2.setBorder(BorderFactory.createLineBorder(Color.black));
      scroll1.setBorder(null);
      topSubPanel.add(scroll1);  //add scrollPane, textArea inside.        
      scroll1.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
      
      //add buttons
      //add listener to button
      topSubPanel.add(bHunt);
      bHunt.addActionListener(listener); 
      topSubPanel.add(bCatch);
      bCatch.addActionListener(listener); 
   
      bRec.addActionListener(listener);
      bNum.addActionListener(listener);
   
      
      //add the center sub-panel to Center of main panel
      add("Center", centerSubPanel);
     
     //adding textarea2, buttons to the bottomSubPanel sub-panel
      centerSubPanel.add(bPokedex);
      centerSubPanel.add(bBackpack);
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
   
        
   /**
   * ActionPerformed method.
   * @param event what button is clicked.
   */ 
      public void actionPerformed(ActionEvent event) {
      
      
      //if "hunt" button clicked, a random pokemon appeared  
         if (event.getSource() == bHunt) {
            pTemp = choosePokemon();
            tf.setText("A wild " + pTemp.getSpecies() + " appeared! ");
            textArea1.setText("\n" + pTemp.toString() + "\n");
            bCatch.setEnabled(true);
         }
      //if "Catch" button clicked, randomly decide whether to catch    
         if (event.getSource()  == bCatch) { 
            catchPokemon();
            bCatch.setEnabled(false);
         } 
      //if "Pokedex" button clicked, print pokemons from PokeTree    
         if (event.getSource()  == bPokedex) { 
            textArea2.setText(pTree.printPokeTree2() + "\n");
         } 
      
      //if "Backpack" button clicked, giving two options  
         if (event.getSource()  == bBackpack) { 
            sortingChoice();   
                                      
         }
      //if "Recent" button clicked, sort Pokemon by recent 
         if (event.getSource()  == bRec) {
            sOut = recentSort();
            textArea2.setText(sOut + "\n");
                   
         }
      //if "Number" button clicked, sort Pokemon by number
         if (event.getSource()  == bNum) {
            sOut = numberSort();
            textArea2.setText(sOut + "\n");
                   
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
         int speChoice = ar.nextInt(9) + 1;
      
         switch(speChoice) {
            case 1:
               p = new Bulbasaur();
               jImage.setIcon(bulbasaur);
               break;
            case 2: 
               p = new Ivysaur();
               jImage.setIcon(ivysaur);
               break;
            case 3: 
               p = new Venusaur();
               jImage.setIcon(venusaur);
               break;
            case 4: 
               p = new Charmander();
               jImage.setIcon(charmander);
               break;
            case 5: 
               p = new Charmeleon();
               jImage.setIcon(charmeleon);
               break;
            case 6: 
               p = new Charizard();
               jImage.setIcon(charizard);
               break;
            case 7: 
               p = new Squirtle();
               jImage.setIcon(squirtle);
               break;
            case 8: 
               p = new Wartortle();
               jImage.setIcon(wartortle);
               break;
            case 9: 
               p = new Blastoise();
               jImage.setIcon(blastoise);
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
            tf.setText("Caught " + pTemp.getSpecies());
            textArea1.setText("\n" + pTemp.toString() + "\n");
            pTree.add(pTemp);
            pq.add(pTemp);
            stack.push(pTemp);
         
         } else { //not caught
            tf.setText(pTemp.getSpecies() + " escaped! ");
            textArea1.setText("                 ");
         }
      
      } //end catchPokemon method
 
     
     /**
   * helper method for to sort Pokemon.
   * display Pokemon by stack
   * @return string holding list of Pokemon sorted by stack
   */
 
      private String recentSort() {
         
         String sRecent = "";
      
         while (stack.size() > 0) {
            Pokemon curr = stack.poll();
            sRecent = sRecent + curr.toString() + "\n\n";
            stackTemp.push(curr);
            
         }
         while (stackTemp.size() > 0) {
            stack.push(stackTemp.poll());
         }
         return sRecent;
      
      } // end recentSort
  
   
   /**
   * helper method for to sort Pokemon.
   * display Pokemon by queue
   * @return string holding list of Pokemon sorted by stack
   */

      private String numberSort() {
      
         String sNumber = "";
      
         while (pq.size() > 0) {
            Pokemon curr = pq.poll();
            sNumber = sNumber + curr.toString() + "\n\n";
            pqTemp.add(curr);
         } 
         while (pqTemp.size() > 0) {
            pq.add(pqTemp.poll());
         } 
             
         return sNumber;     
      
      } // end numberSort
   
   /**
   * helper method for to sort Pokemon.
   * giving two options for users to sort Pokemon
   */

      private void sortingChoice() {
         JButton[] options = {bRec, bNum};
      
         
         JFrame frm = new JFrame("Pokemon");
         
         int n = JOptionPane.showOptionDialog(frm,
               "Would you like to sort your Pokemons by Recent or by Number?",
               "Backpack",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE,
               null,     //do not use a custom Icon
               options,  //the titles of buttons
               options[0]); //default button title
      
      
      } //end sortingChoice
   
   
   } // end GUIListener private class


} //end PokemonPanel class
