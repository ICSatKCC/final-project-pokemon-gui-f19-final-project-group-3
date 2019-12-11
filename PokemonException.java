/**
* An Exception for use with the Pokemon class.
* @author Yongxin Yang
* @since 11/10/2019
*/

public class PokemonException extends RuntimeException {
   /**
    * Constructor.
    * 
    * @param message Describes the cause of the error
    */
   public PokemonException(String message) {
      super(message);
   }
} // end of class

