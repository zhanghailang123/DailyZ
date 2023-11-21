package zhilian.z231115;

/**
 * @author hailang.zhang
 * @since 2023-11-20
 */
@ApplyPay(bizType = BizTypeEnum.B)
public class BizBApplyPayProcessor extends AbstractApplyPayProcessor<BiZBDO>{

    @Override
    public BiZBDO query(ApplyPayRequest request) {
        return null;
    }

    @Override
    public Boolean check(BiZBDO biZBDO) {
        return null;
    }

    @Override
    public void process(BiZBDO biZBDO, ApplyPayRequest request) {

    }

    @Override
    public void save(BiZBDO biZBDO) {

    }
}