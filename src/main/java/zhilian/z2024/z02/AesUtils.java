package zhilian.z2024.z02;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author liang.lei
 */
public class AesUtils {

    /**
     * 加密
     * @param sSrc 参数
     * @param sKey 参数
     * @return
     * @throws Exception
     */
    public static String encrypt(String sSrc, String sKey) {
        if(StringUtils.isBlank(sSrc)){
            return null;
        }
        if (sKey == null) {
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            return null;
        }
        byte[] raw = new byte[0];
        try {
            raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
            return new String(Base64.encodeBase64(encrypted));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 解密
     * @param sSrc 参数
     * @param sKey 参数
     * @return
     */
    public static String decrypt(String sSrc, String sKey) {
        try {
            if(StringUtils.isBlank(sSrc)){
                return null;
            }
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            //byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);
            byte[] encrypted1 = Base64.decodeBase64(sSrc);
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }
}
