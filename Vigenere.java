public class Vigenere extends Substitution {

    public String stringKey;
    
    public int index = 0; 

/**
* Constructor holds the value alpha, which can be used to work out the nubmer to shift by.
*/
    public Vigenere() {
        char alpha = 'A';
    }
/**
* constructor takes a user arguemnt key, which is the string that will be used to encrypt the text.
* @param key this is the users inputed key for translation.
*/
    public Vigenere(String key) {
        stringKey = key; 
    }
    
/**
* takes a char and then encrypts.
* @param charactor this takes every char from a string and encrypts it.
* @return encryption this returns the encrypted charactor.
*/
    
    public char encrypt(char charactor) {
        int length = stringKey.length();
        int i = 0 ;
        char[] letterArray = stringKey.toCharArray();
        int[] stringArray = new int[length];
        char encryption = ' ';

        while(i < length){
            
            stringArray[i] = (letterArray[i]);
            stringArray[i] = stringArray[i] - 'A';
            i++;
        }
        
        if(index < length){
            Caesar shift = new Caesar(stringArray[index]);
            encryption = shift.encrypt(charactor);
        }
        else{
            index = 0;
            Caesar shift = new Caesar(stringArray[index]);
            encryption = shift.encrypt(charactor);
        }
        index++;
        return encryption; 
       
        }
/**
* takes a char and then decrypts.
* @param charactor this takes every char from a string and encrypts it. 
* @return decryption this returns the decrypted charactor.
*/
    public char decrypt(char charactor) {
        char decryption = ' ';
        int length = stringKey.length();
        int i = 0 ;
        char[] letterArray = stringKey.toCharArray();
        int[] stringArray = new int[length];

        while(i < length){
            
            stringArray[i] = (letterArray[i]);
            stringArray[i] = stringArray[i] - 'A';
            i++;
        }
        
        if(index < length){
            Caesar shift = new Caesar(stringArray[index]);
            decryption = shift.decrypt(charactor);
        }
        else{
            index = 0;
            Caesar shift = new Caesar(stringArray[index]);
            decryption = shift.decrypt(charactor);
        }
        index++;
        return decryption; 
    }
    
/**
* This takes command line inputs from the user, checks if they are valid then calls encrpt or decrypt, will then print the encrypted or decrypted text.
* @param args the user will input encrypt/ decrypt, the key string, and then the cipher text
*/
 public static void main(String[] args) {
    if (args.length < 3){
        System.out.println("Too few parameters!");
        System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
        System.exit(1);
    }
     else if (args.length > 3){
        System.out.println("Too many parameters!");
        System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
        System.exit(1); 
    }
    Vigenere key = new Vigenere(args[1]);
    if (args[0].equals("encrypt")) {
        System.out.println(key.encrypt(args[2]));
    }
    else if (args[0].equals("decrypt")) {
        System.out.println(key.decrypt(args[2]));
     }
    else {
        System.out.println("First parameter must be \"encrypt\" or \"decrypt\"!");
         System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
        System.exit(1); 
        }
    }    
}