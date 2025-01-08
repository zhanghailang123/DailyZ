package zhilian.z2024.z04;

import cn.hutool.core.date.DateUtil;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;

public class TestDate {

    public static void main(String[] args) {
        String assetDateYm = DateUtil.format(new Date(), "MM");
        System.out.println(assetDateYm);

        // 手动创建验证器
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        TestDate testDate = new TestDate();
        testDate.testNull(null);
    }

    public void testNull(String s) {
        if (s == null) {
            throw new IllegalArgumentException("a cant be null");
        }
        System.out.println("测试 s " + s);
    }
}