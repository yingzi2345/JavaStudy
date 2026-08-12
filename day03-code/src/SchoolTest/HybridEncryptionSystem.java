package SchoolTest;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import java.security.*;
import java.security.spec.MGF1ParameterSpec;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

/**
 * 基于DES与RSA混合加密的端到端安全通信系统
 * 信息安全技术 - 实验一（修复版）
 */
public class HybridEncryptionSystem {

    // ==================== DES CBC 工具（对称加密，用于加密消息） ====================
    public static SecretKey generateDesKey() throws NoSuchAlgorithmException {
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        kg.init(56, new SecureRandom());
        return kg.generateKey();
    }

    public static IvParameterSpec generateIv() {
        byte[] iv = new byte[8];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public static byte[] desEncrypt(byte[] data, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        return cipher.doFinal(data);
    }

    public static byte[] desDecrypt(byte[] data, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        return cipher.doFinal(data);
    }

    // ==================== RSA OAEP 加密（非对称加密，用于加密DES会话密钥） ====================
    // 🔴 修复点1：KeyPairGenerator 是 RSA 密钥对生成器，不是 KeyGenerator！
    public static KeyPair generateRsaKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
        kg.initialize(2048, new SecureRandom());
        return kg.generateKeyPair();
    }

    public static byte[] rsaEncrypt(byte[] data, PublicKey pub) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        OAEPParameterSpec spec = new OAEPParameterSpec(
                "SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT
        );
        cipher.init(Cipher.ENCRYPT_MODE, pub, spec);
        return cipher.doFinal(data);
    }

    public static byte[] rsaDecrypt(byte[] data, PrivateKey pri) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        OAEPParameterSpec spec = new OAEPParameterSpec(
                "SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT
        );
        cipher.init(Cipher.DECRYPT_MODE, pri, spec);
        return cipher.doFinal(data);
    }

    // ==================== 数字签名 SHA256withRSA（防篡改、身份认证） ====================
    public static byte[] sign(byte[] data, PrivateKey pri) throws Exception {
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initSign(pri);
        sig.update(data);
        return sig.sign();
    }

    public static boolean verify(byte[] data, byte[] sign, PublicKey pub) throws Exception {
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initVerify(pub);
        sig.update(data);
        return sig.verify(sign);
    }

    // ==================== 安全发送消息（Alice 端） ====================
    public static SecureMessage sendSecureMessage(String msg, PublicKey bobPub, PrivateKey alicePri) throws Exception {
        byte[] msgBytes = msg.getBytes(StandardCharsets.UTF_8);

        // 1. 生成DES会话密钥和IV
        SecretKey desKey = generateDesKey();
        IvParameterSpec iv = generateIv();

        // 2. 用Bob的公钥RSA加密DES密钥
        byte[] encDesKey = rsaEncrypt(desKey.getEncoded(), bobPub);

        // 3. 用DES-CBC加密消息
        byte[] ciphertext = desEncrypt(msgBytes, desKey, iv);

        // 4. 用Alice的私钥对原文签名
        byte[] signature = sign(msgBytes, alicePri);

        return new SecureMessage(encDesKey, iv.getIV(), ciphertext, signature);
    }

    // ==================== 安全接收消息（Bob 端） ====================
    public static String receiveSecureMessage(SecureMessage msg, PrivateKey bobPri, PublicKey alicePub) throws Exception {
        // 1. 用Bob的私钥RSA解密DES密钥
        byte[] desKeyBytes = rsaDecrypt(msg.encryptedDesKey, bobPri);
        SecretKey desKey = new javax.crypto.spec.SecretKeySpec(desKeyBytes, "DES");
        IvParameterSpec iv = new IvParameterSpec(msg.iv);

        // 2. 用DES-CBC解密密文
        byte[] plainBytes = desDecrypt(msg.ciphertext, desKey, iv);
        String plainText = new String(plainBytes, StandardCharsets.UTF_8);

        // 3. 用Alice的公钥验证签名（防篡改）
        boolean ok = verify(plainBytes, msg.signature, alicePub);
        if (!ok) throw new SignatureException("签名无效，消息被篡改！");

        return plainText;
    }

    // ==================== 消息封装类（用于传输加密数据） ====================
    public static class SecureMessage {
        public byte[] encryptedDesKey;
        public byte[] iv;
        public byte[] ciphertext;
        public byte[] signature;

        public SecureMessage(byte[] encryptedDesKey, byte[] iv, byte[] ciphertext, byte[] signature) {
            this.encryptedDesKey = encryptedDesKey;
            this.iv = iv;
            this.ciphertext = ciphertext;
            this.signature = signature;
        }
    }

    // ==================== 主函数测试 ====================
    public static void main(String[] args) {
        try {
            System.out.println("===== 基于DES+RSA混合加密的端到端安全通信 =====");

            // 1. 生成Alice和Bob的RSA密钥对
            KeyPair aliceKeys = generateRsaKeyPair();
            KeyPair bobKeys = generateRsaKeyPair();
            System.out.println("✅ Alice与Bob的RSA密钥对生成完成");

            // 2. 原始明文消息
            String original = "Top Secret: Attack at dawn!";
            System.out.println("原始消息：" + original);

            // 3. Alice发送加密消息
            SecureMessage secureMsg = sendSecureMessage(original, bobKeys.getPublic(), aliceKeys.getPrivate());
            System.out.println("\n===== 发送方Alice已加密 =====");
            System.out.println("加密DES密钥(Base64): " + Base64.getEncoder().encodeToString(secureMsg.encryptedDesKey));
            System.out.println("IV(Base64): " + Base64.getEncoder().encodeToString(secureMsg.iv));
            System.out.println("密文(Base64): " + Base64.getEncoder().encodeToString(secureMsg.ciphertext));
            System.out.println("签名(Base64): " + Base64.getEncoder().encodeToString(secureMsg.signature));

            // 4. Bob接收并解密
            String result = receiveSecureMessage(secureMsg, bobKeys.getPrivate(), aliceKeys.getPublic());
            System.out.println("\n===== 接收方Bob解密结果 =====");
            System.out.println("解密后：" + result);
            System.out.println("✅ 签名验证通过，通信安全");

            // 5. 篡改测试（验证防篡改能力）
            System.out.println("\n===== 篡改测试 =====");
            secureMsg.ciphertext[0] ^= 1; // 篡改密文的1个比特
            try {
                receiveSecureMessage(secureMsg, bobKeys.getPrivate(), aliceKeys.getPublic());
            } catch (SignatureException e) {
                System.out.println("❌ 篡改后：" + e.getMessage());
                System.out.println("✅ 系统正确拒绝篡改消息");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}