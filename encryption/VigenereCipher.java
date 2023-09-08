/**
 * Vigenere Cipher
 * Encryption formula Ei = (Pi + Ki) mod 26
 * Decryption formula Di = (Ei – Ki) mod 26
 */
public class VigenereCipher {

    static int ALPHABET_SIZE = 26;
    final static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String plainText, String key){
        // Step 1 String builder for the encrypt message
        StringBuilder stringBuilder = new StringBuilder();

        // Step 2 we check if the key is big enough
        if (key.length() < plainText.length()) {
            StringBuilder expandedKeyword = new StringBuilder();
            while (expandedKeyword.length() < plainText.length()) {
                expandedKeyword.append(key);
            }
            key = expandedKeyword.substring(0, plainText.length());
        }

        // Step 3 we start doing the formula (Pi + Ki) % m
        for (int i = 0; i < plainText.length(); i++) {
            int P = alphabet.indexOf(plainText.charAt(i));
            int K = alphabet.indexOf(key.charAt(i));

            stringBuilder.append(alphabet.charAt((P + K) % ALPHABET_SIZE));
        }

        // Step 4 return the encrypted text
        return stringBuilder.toString();
    }

    public static String decrypt(String encryptedText, String key){
        // Step 1 String builder for the encrypt message
        StringBuilder stringBuilder = new StringBuilder();

        // Step 2 we check if the key is big enough
        if (key.length() < encryptedText.length()) {
            StringBuilder expandedKeyword = new StringBuilder();
            while (expandedKeyword.length() < encryptedText.length()) {
                expandedKeyword.append(key);
            }
            key = expandedKeyword.substring(0, encryptedText.length());
        }

        // Step 3 we start doing the formula (Ei – Ki) mod 26
        for (int i = 0; i < encryptedText.length(); i++) {
            int E = alphabet.indexOf(encryptedText.charAt(i));
            int K = alphabet.indexOf(key.charAt(i));

            int D = (E - K) % ALPHABET_SIZE;

            if(D > 0){
                stringBuilder.append(alphabet.charAt(D));
                continue;
            }

            stringBuilder.append(alphabet.charAt(D + 26));
        }

        // Step 4 return the encrypted text
        return stringBuilder.toString();
    }
}
