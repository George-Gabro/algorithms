/**
 * Simple explained code about how to encrypt and decrypt a text using AffineCipher
 * encrypt formula: E(x) = (ax + b) mod m,
 * decrypt formula: D(x) = a(x-b) mod m, (a is the multiplicative inverse of a in the encryption formula)
 */
public class AffineCipher {
    static int ALPHABET_SIZE = 26;
    final static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String decrypt(String encryptedMessage, int a, int b) {
        // Step 1 String builder for the decrypted message
        StringBuilder stringBuilder = new StringBuilder();

        // Step 2 we get the array of chars in the encrypted message
        char[] messageChars = encryptedMessage.toCharArray();

        // Step 3 we turn the chars to numbers based on the char position in the alphabet
        int[] result = new int[messageChars.length];

        // Step 4 we turn the chars to numbers based on the alphabet
        for (int i = 0; i < messageChars.length; i++) {
            result[i] = (alphabet.indexOf(messageChars[i]));
        }

        // Step 5 we do minus b from the numbers
        for (int i = 0; i < messageChars.length; i++) {
            if(result[i] - b < 0){
                result[i] = (result[i] - b + ALPHABET_SIZE);
            } else{
                result[i] = result[i] - b;
            }
        }

        // Step 6 we multiply the result with the multiplicative inverse of a
        for (int i = 0; i < messageChars.length; i++) {
            result[i] = result[i] * modInverse(a, ALPHABET_SIZE);
        }

        // Step 7 we finish the last part which is module the result on the alphabet size
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] % ALPHABET_SIZE;
        }

        // Step 7 we make letters from the result
        for (int n :
                result) {
            stringBuilder.append(alphabet.toCharArray()[n]);
        }

        return stringBuilder.toString();
    }

    public static String encrypt(String message, int a, int b) {
        // Step 1 String builder for the encrypted message
        StringBuilder stringBuilder = new StringBuilder();

        // Step 2 we get the array of the chars in the message
        char[] messageChars = message.toCharArray();

        // Step 3 we turn the chars to numbers based on the char position in the alphabet
        int[] result = new int[messageChars.length];

        // Step 4 We calculate the first part a*x
        for (int i = 0; i < messageChars.length; i++) {
            result[i] = alphabet.indexOf(messageChars[i]) * a;
        }

        // Step 5 we continue the formula with + b
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] + b;
        }

        // Step 6 we finish the last part which is module the result on the alphabet size
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] % ALPHABET_SIZE;
        }

        // Step 7 we make letters from the result
        for (int n :
                result) {
            stringBuilder.append(alphabet.toCharArray()[n]);
        }

        return stringBuilder.toString();
    }

    // get the multiplicative inverse of 'a' with respect to 'm'
    private static int modInverse(int a, int m) {
        for (int i = 1; i < m; i++) {
            if ((a * i) % m == 1) { // if the result of module is 1 then this is our multiplicative inverse
                return i;
            }
        }
        return -1; // Inverse doesn't exist
    }
}
