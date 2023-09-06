/**
 * A Caesar cipher is a simple method of encoding messages.
 * Caesar ciphers use a substitution method where letters in the alphabet are shifted by some fixed number of spaces
 * to yield an encoding alphabet.
 * Encrypt formula En(x) = (x + n) mod 26
 * Decrypt formula Dn(x) = (x – n) mod 26
 */
public class CaesarCipher {
    static int ALPHABET_SIZE = 26;
    public static String encrypt(String plaintext, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (char character : plaintext.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                encryptedText.append((char) (((character - base + shift) % ALPHABET_SIZE) + base));
            } else {
                encryptedText.append(character);
            }
        }
        return encryptedText.toString();
    }

    public static String decrypt(String encryptedText, int shift) {
        return encrypt(encryptedText, ALPHABET_SIZE - shift); // Decrypting is the same as encrypting with a negative shift.
    }
}
