package zhilian.z2023.z220326;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @description:根据某列去重处理
 * @author: zhanghailang
 * @date: 2022/4/24 15:25
 */
public class Test {
    public static void main(String[] args) {
        List<Student> stus = new ArrayList<>();
        Student student = new Student();
        student.setName("zhangsan");
        student.setSex("男");

        Student student1 = new Student();
        student1.setName("lisi");
        student1.setSex("女");


        Student student2 = new Student();
        student2.setName("zhangsan");
        student2.setSex("男");


        Student student3 = new Student();
        student3.setName("lisi");
        student3.setSex("女1");
        stus.add(student);
        stus.add(student1);
        stus.add(student2);
        stus.add(student3);
        stus = stus.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(Comparator.comparing(Student :: getNameAndSex))), ArrayList::new)
        );

        stus.stream().forEach(item -> {
            System.out.println(item.getName() + item.getSex());
        });
    }
}