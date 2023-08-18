
public abstract class Substitution implements Cipher {
/**
* takes char to be encrypyed.
* @param c takes a char that will be encrypted.
* @return c
*/
    public abstract char encrypt(char c);
/**
* takes char to be encrypted.
* @param c takes a char that will be decrypted.
* @return c 
*/
    public abstract char decrypt(char c);
    
/**
* adds all chars to a string.
* @param plaintext takes a char that will be decrypted. 
* @return output this is the outputed encrypted string. 
*/
     public String encrypt(String plaintext) {
        
        String output = "";
        for (int i = 0; i < plaintext.length(); i++) {
            output = output + encrypt(plaintext.charAt(i));
        }
        return output;
    }
/**
* adds all chars to a string.
* @param cryptotext takes a char that will be decrypted. 
* @return output this is the outputed encrypted string. 
*/

     public String decrypt(String cryptotext) {
        String output = "";
        for (int i = 0; i < cryptotext.length(); i++) {
            output = output + decrypt(cryptotext.charAt(i));
        }
        return output;
    }

}