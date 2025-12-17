package seer.seerservice.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

public class SM4Utils {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static byte[] encrypt_ECB(byte[] key, byte[] plaintext) throws Exception {
        return process(key, null, plaintext, Cipher.ENCRYPT_MODE, "SM4/ECB/PKCS5Padding");
    }

    public static byte[] decrypt_ECB(byte[] key, byte[] ciphertext) throws Exception {
        return process(key, null, ciphertext, Cipher.DECRYPT_MODE, "SM4/ECB/PKCS5Padding");
    }

    public static byte[] encrypt_CBC(byte[] key, byte[] iv, byte[] plaintext) throws Exception {
        return process(key, iv, plaintext, Cipher.ENCRYPT_MODE, "SM4/CBC/PKCS5Padding");
    }

    public static byte[] decrypt_CBC(byte[] key, byte[] iv, byte[] ciphertext) throws Exception {
        return process(key, iv, ciphertext, Cipher.DECRYPT_MODE, "SM4/CBC/PKCS5Padding");
    }

    private static byte[] process(byte[] key, byte[] iv, byte[] data,
                                  int mode, String algorithm) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(key, "SM4");
        Cipher cipher = Cipher.getInstance(algorithm, "BC");

        if (iv != null) {
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(mode, keySpec, ivSpec);
        } else {
            cipher.init(mode, keySpec);
        }

        return cipher.doFinal(data);
    }
}
