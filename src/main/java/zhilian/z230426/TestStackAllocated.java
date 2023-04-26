package zhilian.z230426;

import java.time.Instant;

/**
 * 测试栈上分配的场景
 * @author hailang.zhang
 * @since 2023-04-26
 */
public class TestStackAllocated {

    public static void main(String[] args) {

        long start = Instant.now().toEpochMilli();
        for (long i = 0; i < 1000000000; i++) {
            allocate();
        }
        System.out.println(Instant.now().toEpochMilli() - start);
    }

    private static void allocate() {
        TestStackDO a = new TestStackDO("a大飒飒水水水水水水撒啊啊");
    }
}