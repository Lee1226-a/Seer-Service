package seer.seerservice.utils;


import java.util.Base64;

public class SM4Test {
    public static void main(String[] args) throws Exception {
        // 16字节密钥 (128位)
        byte[] key = "1234567890abcdef".getBytes();
        // 16字节IV (CBC模式需要)
        byte[] iv = "abcdef1234567890".getBytes();
        String plaintext = "这是要加密的原始数据";

        System.out.println("=== ECB模式测试 ===");
        byte[] encryptedECB = SM4Utils.encrypt_ECB(key, plaintext.getBytes());
        System.out.println("加密结果(Base64): " + Base64.getEncoder().encodeToString(encryptedECB));
        byte[] decryptedECB = SM4Utils.decrypt_ECB(key, encryptedECB);
        System.out.println("解密结果: " + new String(decryptedECB));

        System.out.println("\n=== CBC模式测试 ===");
        byte[] encryptedCBC = SM4Utils.encrypt_CBC(key, iv, plaintext.getBytes());
        System.out.println("加密结果(Base64): " + Base64.getEncoder().encodeToString(encryptedCBC));
        byte[] decryptedCBC = SM4Utils.decrypt_CBC(key, iv, encryptedCBC);
        System.out.println("解密结果: " + new String(decryptedCBC));
    }
}
