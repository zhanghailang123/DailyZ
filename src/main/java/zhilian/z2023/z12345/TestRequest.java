package zhilian.z2023.z12345;

import java.util.List;

/**
 * @author hailang.zhang
 * @since 2023-08-10
 */
public class TestRequest {

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    private Integer pageIndex;
    private Integer pageSize;

    private String sender;

    private long signDeadlineEndMili;

    private long overdueTimeEndMili;

    private long sendTimeEndMili;

    private long finishTimeEndMili;

    private long overdueTimeStartMili;

    private long signDeadlineStartMili;

    private String signer;

    private long sendTimeStartMili;

    private long finishTimeStartMili;

    private List<String> contractStatus;

    public String getSender() {return sender;}

    public void setSender(String sender) {this.sender = sender;}

    public long getSignDeadlineEndMili() {return signDeadlineEndMili;}

    public void setSignDeadlineEndMili(long signDeadlineEndMili) {this.signDeadlineEndMili = signDeadlineEndMili;}

    public long getOverdueTimeEndMili() {return overdueTimeEndMili;}

    public void setOverdueTimeEndMili(long overdueTimeEndMili) {this.overdueTimeEndMili = overdueTimeEndMili;}

    public long getSendTimeEndMili() {return sendTimeEndMili;}

    public void setSendTimeEndMili(long sendTimeEndMili) {this.sendTimeEndMili = sendTimeEndMili;}

    public long getFinishTimeEndMili() {return finishTimeEndMili;}

    public void setFinishTimeEndMili(long finishTimeEndMili) {this.finishTimeEndMili = finishTimeEndMili;}

    public long getOverdueTimeStartMili() {return overdueTimeStartMili;}

    public void setOverdueTimeStartMili(long overdueTimeStartMili) {this.overdueTimeStartMili = overdueTimeStartMili;}

    public long getSignDeadlineStartMili() {return signDeadlineStartMili;}

    public void setSignDeadlineStartMili(long signDeadlineStartMili) {this.signDeadlineStartMili = signDeadlineStartMili;}

    public String getSigner() {return signer;}

    public void setSigner(String signer) {this.signer = signer;}

    public long getSendTimeStartMili() {return sendTimeStartMili;}

    public void setSendTimeStartMili(long sendTimeStartMili) {this.sendTimeStartMili = sendTimeStartMili;}

    public long getFinishTimeStartMili() {return finishTimeStartMili;}

    public void setFinishTimeStartMili(long finishTimeStartMili) {this.finishTimeStartMili = finishTimeStartMili;}

    public List<String> getContractStatus() {return contractStatus;}

    public void setContractStatus(List<String> contractStatus) {this.contractStatus = contractStatus;}
}