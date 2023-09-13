import java.math.BigInteger;

/**
 * Simple way to generate a public and private key mathematically for RSA
 * We learned this in Cryptography lesson
 */
public class Kid_RSA_Key_Generator {
    class Keys {
        private final BigInteger publicKeyN;
        private final BigInteger publicKeyE;
        private final BigInteger privateKeyD;

        public Keys(BigInteger publicKeyN, BigInteger publicKeyE, BigInteger privateKeyD) {
            this.publicKeyN = publicKeyN;
            this.publicKeyE = publicKeyE;
            this.privateKeyD = privateKeyD;
        }

        public BigInteger getPublicKeyN() {
            return publicKeyN;
        }

        public BigInteger getPublicKeyE() {
            return publicKeyE;
        }

        public BigInteger getPrivateKeyD() {
            return privateKeyD;
        }

        @Override
        public String toString() {
            return "Keys{" +
                    "publicKeyN=" + publicKeyN +
                    ", publicKeyE=" + publicKeyE +
                    ", privateKeyD=" + privateKeyD +
                    '}';
        }
    }

    /**
     * the numbers should be prime numbers
     *
     * @return list with public and private key
     */
    public Keys generateKeys(BigInteger a, BigInteger b, BigInteger a1, BigInteger b1) {
        // compute M = a * b - 1
        BigInteger m = a.multiply(b).subtract(BigInteger.ONE);

        // compute e = a1 * m + a
        BigInteger e = a1.multiply(m).add(a);

        // compute d = b1 * m + b
        BigInteger d = b1.multiply(m).add(b);

        // compute n = ((e * d) - 1)/m
        BigInteger n = e.multiply(d).subtract(BigInteger.ONE).divide(m);

        return new Keys(n, e, d);
    }

    public static void main(String[] args) {
        Kid_RSA_Key_Generator kidRsaKeyGenerator = new Kid_RSA_Key_Generator();
        Keys myKeys = kidRsaKeyGenerator.generateKeys(
                new BigInteger("10007"),
                new BigInteger("12203"),
                new BigInteger("11113"),
                new BigInteger("62273")
        );

        BigInteger p = new BigInteger("74105637123421123"); // is what we want to encrypt

        // c is the encrypted number
        BigInteger c = p.multiply(myKeys.getPublicKeyE()).mod(myKeys.getPublicKeyN());

        System.out.printf("Encrypt is: %s%n", c);

        // this is the decrypted number
        System.out.printf("Decrypt is: %s%n", c.multiply(myKeys.getPrivateKeyD()).mod(myKeys.publicKeyN));
    }
}
