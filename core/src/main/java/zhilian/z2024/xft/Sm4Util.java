package zhilian.z2024.xft;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.Security;

/**
 * @author hailang.zhang
 * @since 2024-07-08
 */

public class Sm4Util {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }
    public static final String ALGORITHM_NAME = "SM4";
    // 加密算法/分组加密模式/分组填充方式
    // PKCS5Padding-以8个字节为一组进行分组加密
    // 定义分组加密模式使用：PKCS5Padding
    public static final String ALGORITHM_NAME_ECB_PADDING = "SM4/ECB/PKCS5Padding";

    /**
     * 生成ECB暗号
     *
     * @param algorithmName 算法名称
     * @param mode          模式
     * @param key           秘钥
     */
    private static Cipher generateEcbCipher(String algorithmName, int mode, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithmName, BouncyCastleProvider.PROVIDER_NAME);
        Key sm4Key = new SecretKeySpec(key, ALGORITHM_NAME);
        cipher.init(mode, sm4Key);
        return cipher;
    }

    /**
     * sm4加密 密文长度不固定，会随着被加密字符串长度的变化而变化
     *
     * @param hexKey   16进制密钥（忽略大小写）
     * @param paramStr 待加密字符串
     * @return 返回16进制的加密字符串
     */
    public static String encryptEcb(String hexKey, String paramStr) throws Exception {
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        byte[] srcData = paramStr.getBytes(StandardCharsets.UTF_8);
        byte[] cipherArray = encryptEcbPadding(keyData, srcData);
        return ByteUtils.toHexString(cipherArray);

    }

    public static byte[] encryptEcbPadding(byte[] key, byte[] data) throws Exception {
        Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    /**
     * sm4解密 采用ECB
     *W
     * @param hexKey     16进制密钥
     * @param cipherText 16进制的加密字符串（忽略大小写）
     * @return 解密后的字符串
     */
    public static String decryptEcb(String hexKey, String cipherText) throws Exception {
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        byte[] cipherData = ByteUtils.fromHexString(cipherText);
        // 解密
        byte[] srcData = decryptEcbPadding(keyData, cipherData);
        return new String(srcData, StandardCharsets.UTF_8);

    }

    public static byte[] decryptEcbPadding(byte[] key, byte[] cipherText) throws Exception {
        Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(cipherText);
    }
}
