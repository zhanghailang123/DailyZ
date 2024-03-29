package zhilian.z2024.z02;

import cn.hutool.core.util.DesensitizedUtil;

/**
 * @author hailang.zhang
 * @since 2024-03-28
 */
public class EncryptTest {

    public static void main(String[] args) {
//        System.out.println(AesUtils.encrypt("125911537210301", "1CB78829F-663-18"));
        System.out.println(AesUtils.decrypt("XkJh83sJBlWF3YzRjX++5Q==","1CB78829F-663-18"));

//        System.out.println(DesensitizedUtil.email("1231232131231@qq.com"));
    }
}