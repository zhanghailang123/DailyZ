package zhilian.z231115;

/**
 * @author hailang.zhang
 * @since 2023-11-17
 */
public class ClientService {

    public void doApplyPay(ApplyPayRequest request) {
        if (A) {
            BizAApplyPayProcessor processor = new BizAApplyPayProcessor();
            processor.applyPay(request);
        } else if (B) {
            BizBApplyPayProcessor processor = new BizBApplyPayProcessor();
            processor.applyPay(request);
        } else if (C) {
            BizCApplyPayProcessor processor = new BizCApplyPayProcessor();
            processor.applyPay(request);
        }
    }
}