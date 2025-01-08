package Web;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;
import java.util.concurrent.atomic.LongAdder;

public class Test {
    public static void main(String[] args) {
//        BigDecimal a = new BigDecimal(471685.58);
//        BigDecimal b = new BigDecimal(0.0);
//        BigDecimal c = new BigDecimal(0.0);
//        BigDecimal d = new BigDecimal(22047.39);
//        BigDecimal g = new BigDecimal(0.0);
//        BigDecimal h = new BigDecimal(0.0);
//        System.out.println(a.add(b).add(c).add(d).add(g).add(h).doubleValue());
        TestBig testBig = new TestBig();
        testBig.setTest(BigDecimal.valueOf(471685.58));
        testBig.setTest(new BigDecimal(471685.58));
        testBig.setTest(new BigDecimal("471685.58"));

        BigDecimal a = BigDecimal.valueOf(0);
//        BigDecimal b = BigDecimal.valueOf(471685.58);
//        BigDecimal b = new BigDecimal(471685.58)
        BigDecimal b = testBig.getTest();
        System.out.println(a.add(b));
    }

}
