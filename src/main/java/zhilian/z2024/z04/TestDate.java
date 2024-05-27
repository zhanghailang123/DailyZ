package zhilian.z2024.z04;

import cn.hutool.core.date.DateUtil;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author hailang.zhang
 * @since 2024-04-30
 */
@Valid
public class TestDate {

    public static void main(String[] args) {
        String assetDateYm = DateUtil.format(new Date(), String.valueOf(DateFormat.MONTH_FIELD));
        System.out.println(assetDateYm);

        TestDate testDate = new TestDate();
        testDate.testNull(null);

        ConcurrentSkipListMap map = new ConcurrentSkipListMap();
    }

    @Valid
    public void testNull(@NotNull(message = "a cant be null") String s) {
        System.out.println("测试 s " + s);
    }
}