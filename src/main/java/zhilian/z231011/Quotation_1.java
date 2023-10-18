package zhilian.z231011;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hailang.zhang
 * @since 2023-10-12
 */

@Component
@Data
public class Quotation_1 {

    /**
     * 职位
     * code : 1
     * desc :
     */

    private List<OtsContractQuotation.Job> jobs;

    /**
     * 服务费费用项
     * code : 1
     * desc :
     */

    private List<OtsContractQuotation.ServiceFeeItem> serviceFeeItems;


    public void getQuotation() {

    }
}