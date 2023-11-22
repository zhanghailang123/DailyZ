package zhilian.z231121;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author hailang.zhang
 * @since 2023-11-21
 */
public class ServiceFeeCalculator implements ICalculator<Task>{

    @Override
    public BigDecimal calcualate(Task task) {
        return task.getServiceFee().multiply(task.getServiceFeeRate()).setScale(2, RoundingMode.HALF_UP);
    }
}