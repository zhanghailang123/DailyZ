package zhilian.z1206;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import org.springframework.util.Base64Utils;

import java.util.Date;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/12/6 14:14
 */
public class TestBase64 {

    public static void main(String[] args) {
        System.out.println(Base64Utils.encodeToString("11111111".getBytes()));
        System.out.println(Base64Utils.decodeFromUrlSafeString("MTExMTExMTE=").toString());
        System.out.println(Base64.decodeStrGbk("MTExMTExMTE="));
        //

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        //How To Controll Hao Hao 的去经营
        System.out.println(DateUtil.endOfWeek(new Date()));

        System.out.println(String.format("众包%s结算信息",DateUtil.format(DateUtil.yesterday(),"yyyy-MM-dd")));

    }
}