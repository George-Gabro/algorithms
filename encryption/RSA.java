import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSA {

    private final Key PRIVATE_KEY;
    private final Key PUBLIC_KEY;

    /**
     * @param publicKey public key file must contain key bytes only
     * @param privateKey private key file must contain key bytes only
     */
    public RSA(File publicKey, File privateKey) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] publicKeyBytes = Files.readAllBytes(publicKey.toPath());
        byte[] privateKeyBytes = Files.readAllBytes(privateKey.toPath());

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);

        PUBLIC_KEY = keyFactory.generatePublic(publicKeySpec);
        PRIVATE_KEY = keyFactory.generatePrivate(privateKeySpec);
    }

    public String encrypt(String text) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, PUBLIC_KEY);

        byte[] textBytes = text.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedMessageBytes = encryptCipher.doFinal(textBytes);
        return encodeBase64(encryptedMessageBytes);
    }

    public String decrypt(String encryptedMessage) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, PRIVATE_KEY);

        byte[] decryptedMessageBytes = decryptCipher.doFinal(decodeBase64(encryptedMessage));
        return new String(decryptedMessageBytes);
    }

    private String encodeBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decodeBase64(String data) {
        return Base64.getDecoder().decode(data);
    }

}

