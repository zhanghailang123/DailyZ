package zhilian.z231115;

/**
 * @author hailang.zhang
 * @since 2023-11-15
 */
@ApplyPay(bizType = BizTypeEnum.A)
public class BizAApplyPayProcessor extends AbstractApplyPayProcessor<BizADO>{

    @Override
    public BizADO query(ApplyPayRequest request) {
        return new BizADO();
    }

    @Override
    public Boolean check(BizADO o) {
        //..子类业务逻辑省略
        return Boolean.TRUE;
    }

    @Override
    public void process(BizADO o, ApplyPayRequest request) {
        //..子类业务逻辑省略
    }

    @Override
    public void save(BizADO o) {
        //..子类业务逻辑省略
    }
}