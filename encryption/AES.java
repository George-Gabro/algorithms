import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AES
{

    private final byte[] INITIALIZATION_VECTOR;

    private final SecretKey SECRET_KEY;

    private final int TAG_LENGTH = 128; // 96, 104, 112, 120, 128

    public AES(SecretKeySpec spec, String initializationVector) {
        INITIALIZATION_VECTOR = decodeBase64(initializationVector);
        assert spec.getAlgorithm().equals("AES");
        SECRET_KEY = spec;
    }

    public String encrypt(String message) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = getCipher();
        cipher.init(
                Cipher.ENCRYPT_MODE,
                SECRET_KEY,
                new GCMParameterSpec(TAG_LENGTH,INITIALIZATION_VECTOR)
        );
        byte[] encrypt = cipher.doFinal(message.getBytes());
        return encodeBase64(encrypt);
    }

    public String decrypt(String message) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = getCipher();
        cipher.init(
                Cipher.DECRYPT_MODE,
                SECRET_KEY,
                new GCMParameterSpec(TAG_LENGTH,INITIALIZATION_VECTOR)
        );
        byte[] decrypt = cipher.doFinal(decodeBase64(message));
        return new String(decrypt);
    }

    private Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("AES/GCM/NoPadding");
    }

    private String encodeBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decodeBase64(String data) {
        return Base64.getDecoder().decode(data);
    }
}
