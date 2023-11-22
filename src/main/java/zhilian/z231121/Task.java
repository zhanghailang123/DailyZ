package zhilian.z231121;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author hailang.zhang
 * @since 2023-11-21
 */

@Data
public class Task {

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务Id
     */
    private String taskId;

    /**
     * 任务金额
     */
    private BigDecimal taskMoney;

    /**
     * 服务费率
     */
    private BigDecimal serviceFeeRate;

    /**
     * 服务费
     */
    private BigDecimal serviceFee;

    public void calculateServiceFee() {
        BigDecimal serviceFee = this.taskMoney.multiply(this.getServiceFeeRate()).setScale(2, RoundingMode.HALF_UP);
        this.setServiceFee(serviceFee);
    }
}