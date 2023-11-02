package zhilian.z231018.statemc;

/**
 * @author hailang.zhang
 * @since 2023-11-01
 */
public class Contract {

    private String contractNum;

    private ContractStateEnum stateEnum;

    public void init() {
        stateEnum = ContractStateEnum.INIT;
    }

    public void auditReject() {
        if (stateEnum != ContractStateEnum.INIT) {
            throw new IllegalStateException("");
        }
        stateEnum = ContractStateEnum.REJECT;
    }

    public void auditPass() {
        if (stateEnum != ContractStateEnum.INIT) {
            throw new IllegalStateException();
        }
        stateEnum = ContractStateEnum.VALID;
    }

    public void expired() {
        if (true) {
            stateEnum = ContractStateEnum.EXPIRED;
        }
    }
}