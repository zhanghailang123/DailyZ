package zhilian.z2024.z02;

import cn.hutool.core.util.DesensitizedUtil;

/**
 * @author hailang.zhang
 * @since 2024-03-28
 */
public class EncryptTest {

    public static void main(String[] args) {
        System.out.println(AesUtils.encrypt("1b8e9faf-fe4c-41eb-befc-9aef2d714081", "1CB78829F-663-18"));
//        System.out.println(AesUtils.encrypt("008d325eb16a25b5bebeca13847da71ff89d5af91be537861e30156905e53d3b11", "1CB78829F-663-18"));
//        System.out.println(AesUtils.decrypt("r3UkYJU7aU4ZxHIc7j/ByA==","1CB78829F-663-18"));

//        System.out.println(DesensitizedUtil.email("1231232131231@qq.com"));
    }
}