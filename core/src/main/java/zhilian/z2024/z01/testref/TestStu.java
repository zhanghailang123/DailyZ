package zhilian.z2024.z01.testref;

import lombok.Data;

/**
 * @author hailang.zhang
 * @since 2024-01-09
 */
@Data
public class TestStu {

    private int id;

    public TestStu next;

    public TestStu(int id) {
        this.id = id;
    }

    public void add(TestStu stu) {
        this.next = stu;
    }
}