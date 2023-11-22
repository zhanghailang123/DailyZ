package zhilian.z231121;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author hailang.zhang
 * @since 2023-11-21
 */
public class Calculator {

    /**
     * 计算服务费
     * @return 计算结果
     */
    public BigDecimal calculateServiceFee(Task task) {
        return task.getServiceFee().multiply(task.getServiceFeeRate()).setScale(2, RoundingMode.HALF_UP);
    }
}