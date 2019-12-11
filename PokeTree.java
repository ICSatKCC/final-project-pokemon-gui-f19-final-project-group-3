/**
 * Pokemon tree. 
 * @author YongxinYang
 * @since 11/25
 */
public class PokeTree {

  /** Root node instance variable. */
   private PokeNode root = null;

  /** No parameter constructor. */
   public PokeTree() {
      // root already initialized
   }

  /**
   * Adds a Pokemon to the tree.
   * Non-recursive wrapper method
   * @param p The object to be added
   */
   public void add(Pokemon p) {
   // calls a recursive, private method
   // cannot get direct access to the root outside the class
      root = add(root, p);
   }
  
  /**
   * Recusively adds a Pokemon to the tree.
   * 
   * @param node The root of the tree/subtree
   * @param p The object to be added
   * @return The current node
   */
   private PokeNode add(PokeNode node, Pokemon p) {
   // base case: empty tree or end of a leaf
      if (node == null) {
         return new PokeNode(p, 1, null, null);
      }
      // base case: duplicate node, so increase num caught
      else if (p.getNumber() - node.getKey() == 0) {
         node.increaseNumCaught();
         return node;
      }
      // recursive case: if p is less than current node
      // then move to left child node
      else if (p.getNumber() - node.getKey() < 0) {
      // set the node's left child to the
      // left subtree with p added
         node.setLChild(this.add(node.getLChild(), p));
         return node;
      }
      // recursive case: if item is greater than current node
      // then traverse to right child node
      else {
      // set the node's right child to the
      // right subtree with p added
         node.setRChild(this.add(node.getRChild(), p));
         return node;
      }
   } //end add

  
  /**
   * gets a Pokemon from the tree with the same search key.
   * 
   * @param searchKey An object containing the search key
   * @return the data Pokemon in the tree with matching key.
   */
   public Pokemon get(Pokemon searchKey) {
   // cannot get direct access to the root outside the class
      return this.get(root, searchKey);
   }

  /**
   * Recursive methog to get a Pokemon from the tree.
   * 
   * @param node The root of the tree/subtree
   * @param searchKey An object storing the key to get.
   * @return the data Pokemon in tree with matching key.
   * @throws PokeTreeException if Pokemon not found
   */
   private Pokemon get(PokeNode node, Pokemon searchKey) {
   // if not found, throw exception
      if (node == null) {
         throw new PokeTreeException("Pokemon not found!");
      } 
      else {
      // if the search key matches, return the item's address
         if (searchKey.getNumber() - node.getKey() == 0) {
            return node.getPokemon();
         }
         // if the search key of the searchKey is less than the node,
         // then search the left subtree
         else if (searchKey.getNumber() - node.getKey() < 0) {
            return this.get(node.getLChild(), searchKey);
         }
         // if the search key of the searchKey is greater than the node,
         // then search the right subtree
         else {
            return this.get(node.getRChild(), searchKey);
         }
      }
   }

  /**
   * Removes a Pokemon from the tree.
   * 
   * @param p An object storing the key to remove.
   */
   public void remove(Pokemon p) {
      root = this.remove(root, p);
   }

  /**
   * Recursively removes a Pokemon from the tree.   
   * 
   * @param node The root of the tree/subtree
   * @param p An object storing only the key to remove.
   * @return root of current subtree.
   * @throws PokeTreeException if Pokemon not found in tree.
   */
   private PokeNode remove(PokeNode node, Pokemon p) {
   
   // if item not found, throw exception
      if (node == null) {
         throw new PokeTreeException("Pokemon not found!");
      }
      // if search key is less than node's search key,
      // continue to left subtree
      else if (p.getNumber() - node.getKey() < 0) {
         node.setLChild(this.remove(node.getLChild(), p));
         return node;
      }
      // if search key is greater than node's search key,
      // continue to right subtree
      else if (p.getNumber() - node.getKey() > 0) {
         node.setRChild(this.remove(node.getRChild(), p));
         return node;
      }
      // found node containing target Pokemon with same search key,
      // so decrease num caught
      else {
         node.decreaseNumCaught();
      //delete the pokemon if numcaught is 0    
         if (node.getNumCaught() == 0){
         // call private method remove
         node = this.remove(node);
         }
         return node;
      }
   
   }
   
  

  /**
   * Helper method that takes a node out of tree.
   * 
   * @param node The node to remove
   * @return The node that replaces removed node or null.
   */
   
   private PokeNode remove(PokeNode node) {
   // if node is a leaf,return null
      if (node.getLChild() == null && node.getRChild() == null) {
         return null;
      }
      // if node has a single right child node,
      // then return a reference to the right child node
      else if (node.getLChild() == null) {
         return node.getRChild();
      }
      // if node has a single left child node,
      // then return a reference to the left child node
      else if (node.getRChild() == null) {
         return node.getLChild();
      }
      // if the node has two child nodes
      else {
      // get next Smaller Item, which is Largest Item in Left Subtree
      // The next Smaller Item is stored at the rightmost node in the left
      // subtree.
         Pokemon largestPokemonInLeftSubtree = this.getPokemonWithLargestSearchKey(node
             .getLChild());
      // replace the node's Pokemon with this Pokemon
         node.switchPokemon(largestPokemonInLeftSubtree);
      // delete the rightmost node in the left subtree
         node.setLChild(this.removeNodeWithLargestSearchKey(node
             .getLChild()));
         return node;
      }
   }
   /**
   * Returns the Pokemon with the largest search key in the (sub)tree.
   * Helper method for removing interior nodes.
   * @param node The root of the tree/subtree
   * @return The data Pokemon with largest key
   */
   private Pokemon getPokemonWithLargestSearchKey(PokeNode node) {
   // if no right child, then this node contains the largest item
      if (node.getRChild() == null) {
         return node.getPokemon();
      }
      // if not, keep looking on the right
      else {
         return this.getPokemonWithLargestSearchKey(node.getRChild());
      }
   }

  /**
   * Removes the node with the largest search key.
   * Helper method for removing interior nodes.
   * Remove the node formerly occupied by item with largest search key.
   * To be called after Pokemon is moved to new node location.
   * 
   * @param node The root of the tree/subtree
   * @return root of (sub)tree with node removed.
   */
   private PokeNode removeNodeWithLargestSearchKey(PokeNode node) {
   // if no right child, then this node contains the largest item
   // so replace it with its left child
      if (node.getRChild() == null) {
         return node.getLChild();
      }
      // if not, keep looking on the right
      else {
         node.setRChild(this.removeNodeWithLargestSearchKey(node
             .getRChild()));
         return node;
      }
   }


//print method

   public void printPokeTree(){
      this.printPokeTree(root);
   }
   
//switch position to print the tree by inorder
   
   public void printPokeTree(PokeNode root){
      if(root != null){
         printPokeTree(root.getLChild());
         System.out.println( "  " + root.getPokemon( ).toString() + "\nCaught: "+root.getNumCaught( ) );
         printPokeTree(root.getRChild());
      
      }
   }
    

} // end of class

