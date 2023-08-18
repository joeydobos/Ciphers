public class Caesar extends MonoAlphaSubstitution {
    
    public String alphabet =  "abcdefghijklmnopqrstuvwxyz";
    public int shift;
/**
* Constructor holds the shift value.
*/
    public Caesar() {
        shift = 0;
    }
/**
* constructor takes a user arguemnt key, which is the value that the cipher text should be shifted.
* @param key this is the users inputed key for translation. 
*/
    public Caesar(int key){
        shift = key;
    }
    
            
/**
* takes a char and then encrypts.
* @param charactor this takes every char from a string and encrypts it.
* @return encryption this returns the encrypted charactor.
*/
    
    public char encrypt (char charactor){
        boolean found = false;
        boolean isUpper = false;
        char letter = Character.toLowerCase(charactor);
        char[] alphabetArray = alphabet.toCharArray();
        char encryption = ' ';
        int j = 0; 
        
        if (Character.isUpperCase(charactor)){
            isUpper = true; 
        }
        
       for(int a = 0; a < alphabet.length(); a++){
           if (letter != alphabetArray[a]){
               encryption = letter;
               break; 
           }
       }

        while((shift > 26) || (shift < -26)){
            shift = shift % 26; 
        }
        
        for(int i = 0;  i < alphabet.length(); i++){
            if (letter == alphabetArray[i]){
                if(shift + i < 0){
                    j = (shift + i) + 26;
                    encryption = alphabetArray[j];
                    break; 
                }
                if(shift + i < 26){
                    j = i + shift; 
                    encryption = alphabetArray[j];
                }
                if(shift + i > 26){
                    j = (i - 26) + shift; 
                    encryption = alphabetArray[j];
                }
        }
    }
    
    if(isUpper == true){
        encryption = Character.toUpperCase(encryption);
    }
    return encryption;
    }
    
/**
* takes a char and then decrypts.
* @param charactor this takes every char from a string and decrypts it.
* @return encryption this returns the decrypted charactor.
*/
    
    public char decrypt (char charactor){
        boolean found = false;
        boolean isUpper = false;
        char letter = Character.toLowerCase(charactor);
        char[] alphabetArray = alphabet.toCharArray();
        char encryption = ' ';
        int j = 0; 
        int temp = shift; 
        temp = shift * -1;
        
        
        
        if (Character.isUpperCase(charactor)){
            isUpper = true; 
        }
        
        
        
       for(int a = 0; a < alphabet.length(); a++){
           if (letter != alphabetArray[a]){
               encryption = letter;
               break; 
           }
       }
       
       

        while((temp > 26) || (temp < -26)){
            temp = temp % 26; 
        }
        
        for(int i = 0;  i < alphabet.length(); i++){
            if (letter == alphabetArray[i]){
                if(temp + i < 0){
                    j = (temp + i) + 26;
                    encryption = alphabetArray[j];
                    break; 
                }
                if(temp + i < 26){
                    j = i + temp; 
                    encryption = alphabetArray[j];
                }
                if(temp + i > 26){
                    j = (i - 26) + temp; 
                    encryption = alphabetArray[j];
                }
                
        }
    }
    
    if(isUpper == true){
        encryption = Character.toUpperCase(encryption);
    }
    
    
    return encryption;
    
    }
/**
* This takes command line inputs from the user, checks if they are valid then calls encrpt or decrypt, will then print the encrypted or decrypted text.
* @param args the user will input encrypt/ decrypt, the shift, and then the cipher text.
*/

    public static void main(String[] args) {
        
        String one = "encrypt";
        String two = "decode";
        
        
        if (args.length < 3){
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
            System.exit(1);
          }
         
           else if (args.length > 3){
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
            System.exit(1);
          }
          
         
        
         Caesar shift = new Caesar(Integer.parseInt(args[1]));
        if (args[0].equals("encrypt")) {
            System.out.println(shift.encrypt(args[2]));
        }
        else if (args[0].equals("decrypt")) {
            System.out.println(shift.decrypt(args[2]));
            }
        else {
            System.out.println("First parameter must be \"encrypt\" or \"decrypt\"!");
            System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
            System.exit(1); 
        }
        
    }
}
        
        
    
      
        
        
    
    

