public class MonoAlphaSubstitution extends Substitution{
    
private String alphabet;
    
    
/**
* Construcotor returns alphabet.
*/
   public MonoAlphaSubstitution() {
        alphabet = "aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz";
    }
/**
* constructor takes a user arguemnt key. 
* @param key this is the users inputed key for translation.
*/
    public MonoAlphaSubstitution(String key) {
        if(key.length() == 0){
            alphabet = "aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz";
        }
        else{
        alphabet = key;
        }
        

        }
        
        
/**
* takes a char and then encrypts.
* @param charactor this takes every char from a string and encrypts it.
* @return newChar this returns the encrypted charactor.
*/
     public char encrypt(char charactor){
         char[] alphabetArray = alphabet.toCharArray();
         char newChar = ' ';
         
         int i = 0; 
         while (i < alphabetArray.length){
             if(alphabetArray[i] == charactor){
                  newChar = alphabetArray[i + 1];
                  break;
             }
             else{
                 newChar = charactor;
             }
             i = i + 2;
             
         }
         return newChar;
         
     }
     
/**
* takes a char and decrypts.
* @param charactor this takes every char from a string and decrypts it.
* @return newChar this returns the decrypted charactor.
*/
     
     public char decrypt(char charactor){
         
         char[] alphabetArray = alphabet.toCharArray();
         char newChar = ' ';
         
         int j = 1; 
         while (j < alphabetArray.length){
             if(alphabetArray[j] == charactor){
                  newChar = alphabetArray[j - 1];
                  break;
             }
             else{
                 newChar = charactor;
             }
             j = j + 2;
             
         }
         return newChar;
         
     }
     
/**
* This takes command line inputs from the user, checks if they are valid then calls encrpt or decrypt, will then print the encrypted or decrypted text.
* @param args the user will input encrypt/ decrypt, the key, and then the cipher text.
*/
      public static void main(String[] args) {
        if (args.length < 3){
            System.out.println("Too few parameters!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
            System.exit(1);
          }
         
        else if (args.length > 3){
            System.out.println("Too many parameters!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
            System.exit(1);
          }  
          
        MonoAlphaSubstitution key = new MonoAlphaSubstitution(args[1]);
        if (args[0].equals("encrypt")) {
            String encode = (key.encrypt(args[2]));
            System.out.println(encode); 
        }
            
            
        else if (args[0].equals("decrypt")) {
            String decode = (key.decrypt(args[2]));
            System.out.println(decode);
        }
        else{
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
            System.exit(1); 
        }
        
          
      
          
      }
}
