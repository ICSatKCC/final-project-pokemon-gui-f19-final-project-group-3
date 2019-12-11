import java.util.*; 
/**
 * Pokemon node.
 * @author Yongxin Yang
 * @since 11/25
 */
public class PokeNode {
	// data fields
  /** Data held in Node. */
   private Pokemon data;
  /** variable numCaught. */ 
   private int numCaught;
   
   /** Link to left child Node. */
   private PokeNode left;
   /** Link to right child Node. */
   private PokeNode right;


	/**
	 * Constructor.
	 * 
	 * @param p The address of the object that is stored by the node
    * @param numCaught The address of the caught number
	 * @param lChild The address of the left child
	 * @param rChild The address of the right child
	 */
   public PokeNode(Pokemon p , int numCaught, PokeNode lChild, PokeNode rChild) {
      data = p;
      left = lChild;
      right = rChild;
      this.numCaught = numCaught;
   } 
   

	/**
	 * Automatically called by println() or print() method.
	 * 
	 * @return the Pokemon's string
	 */
   public String toString() {
      String display = data.toString();
      return display;
   }

	/**
	 * Accessor method.
	 * 
	 * @return the Pokemon's address
	 */
   public Pokemon getPokemon() {
      return data;
   }
  
   /**
	 * Accessor method.
	 * 
	 * @return the Pokemon's number
	 */
   public int getKey() {
      int key = data.getNumber();
      return key;
   }
   
   /**
	 * Accessor method.
	 * 
	 * @return the Pokemon's caught number
	 */
   public int getNumCaught() {
      return numCaught;
   }
	
	/**
	 * Accessor method.
	 * 
	 * @return the left child's address
	 */
   public PokeNode getLChild() {
      return left;
   }
   
   /**
	 * Accessor method.
	 * 
	 * @return the right child's address
	 */
   public PokeNode getRChild() {
      return right;
   }


	/**
	 * void method to increase NumCaught
	 */
   public void increaseNumCaught() {
      numCaught++;
   }
   
   /**
	 *void method to decrease NumCaught
	 */
   public void decreaseNumCaught() {
      numCaught--;
   }


   
   /**
	 * Mutator method.
	 * 
	 * @param newLChild
	 *            is the left child's address
	 */
   public void setLChild(PokeNode newLChild) {
      left = newLChild;
   }

	
	/**
	 * Mutator method.
	 * 
	 * @param newRChild
	 *            is the right child's address
	 */
   public void setRChild(PokeNode newRChild) {
      right = newRChild;
   }
   
   
   // Switch Pokemon to help remove node   
   public void switchPokemon(Pokemon newPokemon) {
   	// calls a private setPokemon method
      this.setPokemon(newPokemon);
   }
   
   
   private Pokemon setPokemon(Pokemon newPoke){
      data = newPoke;
      return data;
   }

} // end of class
