package zhilian.z2024.z02.queue;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author hailang.zhang
 * @since 2024-02-25
 */
public class TestNo {


    private static final long OFFSET = 200000000L; // 偏移量，确保ID以2开头且为9位数
    private static final int TARGET_LENGTH = 9;
    private static final String PREFIX = "2";
    private static final AtomicLong counter = new AtomicLong(); // 用于在同一秒内生成多个ID的计数器

    private long lastTimestamp = -1; // 上一个时间戳

    public synchronized String generateUserId() {
        long timestamp = Instant.now().getEpochSecond();

        // 如果当前时间戳小于上一个时间戳，说明系统时钟回退，这是一个严重的问题
        if (timestamp <= lastTimestamp) {
            throw new IllegalStateException("Clock moved backwards");
        }

        long idCore;
        if (timestamp == lastTimestamp) {
            // 在同一秒内，使用计数器生成唯一的ID
            idCore = (lastTimestamp * 1000) + counter.getAndIncrement();
        } else {
            // 在新的一秒开始时，重置计数器
            counter.set(0);
            idCore = timestamp + OFFSET;
        }

        // 确保ID是9位数，不足则补零
        String userId = PREFIX + String.format("%0" + (TARGET_LENGTH - PREFIX.length()) + "d", idCore);

        // 更新最后的时间戳
        lastTimestamp = timestamp;

        return userId;
    }

    public static void main(String[] args) {
        TestNo generator = new TestNo();
        for (int i = 0; i < 10; i++) {
            System.out.println(TestNo.convertToNineDigits(Instant.now().getNano()));
        }
    }
    private static final long FACTOR = 1000L; // 转换因子，根据需要调整

    public static long convertToNineDigits(long timestampMillis) {
        // 转换时间戳为9位数
        long timestampSeconds = timestampMillis / 1000; // 将毫秒转换为秒
        long convertedTimestamp = timestampSeconds / FACTOR; // 应用转换因子
        return convertedTimestamp;
    }

}