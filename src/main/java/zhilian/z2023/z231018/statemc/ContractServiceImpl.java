package zhilian.z2023.z231018.statemc;

/**
 * 有状态和无状态的区别
 * @author hailang.zhang
 * @since 2023-11-01
 */
public class ContractServiceImpl {

    private Contract contract;

    public ContractServiceImpl(Contract contract) {
        this.contract = contract;
    }

    public void add() {
        contract.init();
    }

    public void auditReject() {
        contract.auditReject();
    }
}