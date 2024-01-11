package zhilian.z2023.z231115;

/**
 * @author hailang.zhang
 * @since 2023-11-17
 */
public class ClientService {

    public void doApplyPay(ApplyPayRequest request) {
//        if (request.getType().equals(A)) {
//            BizAApplyPayProcessor processor = new BizAApplyPayProcessor();
//            processor.applyPay(request);
//        } else if (request.getType().equals(B)) {
//            BizBApplyPayProcessor processor = new BizBApplyPayProcessor();
//            processor.applyPay(request);
//        } else if (request.getType().equals(C)) {
//            BizCApplyPayProcessor processor = new BizCApplyPayProcessor();
//            processor.applyPay(request);
//        }

        BizFactory.getApplyPayProcessor(BizTypeEnum.B);
    }

    public static void main(String[] args) {

    }
}