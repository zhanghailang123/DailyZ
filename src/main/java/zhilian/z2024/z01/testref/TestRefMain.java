package zhilian.z2024.z01.testref;

import cn.hutool.core.convert.NumberChineseFormatter;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.text.DateFormat;

/**
 * @author hailang.zhang
 * @since 2024-01-09
 */
public class TestRefMain {

    public static void main(String[] args) {
//        TestStu stu = new TestStu(1);
//        TestStu child = new TestStu(2);
//        stu.add(child);
//
//        TestStu first = stu;
//
//        TestStu test2 = first.next;
//
//        System.out.println(first.hashCode());
//        System.out.println(test2.hashCode());
//
//        stu.setId(100);
//        System.out.println(first.getId());
//
//        child.setId(200);
//        System.out.println(test2.getId());
//        DateTime parse = DateUtil.parse("2023/01", "yyyy/MM/dd");
//        DateTime parse = DateTime.of("2023/1/1", "yyyy/MM/dd");
//        String format = DateUtil.format(parse, "yyyy-MM-dd");
//        System.out.println(format);
        System.out.println(NumberChineseFormatter.format(0.13, Boolean.TRUE, Boolean.TRUE));
    }
}