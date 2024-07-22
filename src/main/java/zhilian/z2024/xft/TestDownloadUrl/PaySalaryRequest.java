package zhilian.z2024.xft.TestDownloadUrl;

import java.util.List;

/**
 * @author hailang.zhang
 * @since 2024-06-26
 */
public class PaySalaryRequest {

    /**
     * agentList : [{"agentProtocolNo":"ZA2357","agentRemark":"测试代发说明123","agentUsage":"AGPAY006","appointmentDate":"2022-06-26","appointmentTime":"2022-06-26T21:13","businessReferenceNo":"TEST2023072600000005","currency":"10","currencyFlag":"0","customRemark":"测试备注0234","customRemarkOne":"测试备注1234","customRemarkTwo":"测试备注2234","detailList":[{"accountName":"葛地释","accountNo":"6225886551219437","agentAmount":"0.01","bankAddress":"","bankName":"","businessDetailNo":"1","customRemark":"测试明细备注1","customRemarkOne":"测试明细备注2","customRemarkTwo":"测试明细备注3","transactionText":"测试明细摘要123","mobileShortMessage":"短信备注测试"},{"accountName":"1","accountNo":"2322322323232323","agentAmount":"1000.01","bankAddress":"","bankName":"","businessDetailNo":"2","customRemark":"测试明细备注1","customRemarkOne":"测试明细备注2","customRemarkTwo":"测试明细备注3","transactionText":"测试明细摘要123","mobileShortMessage":"短信备注测试"}],"digitalAgentFlag":"N","payAccountNo":"75592608402200109","mobileShortMessage":"测试短信备注测试短信备注","totalAgentAmount":"1000.02","totalAgentCount":2},{"agentProtocolNo":"ZA2357","agentRemark":"测试代发说明123","agentUsage":"AGPAY006","appointmentDate":"2022-06-27","appointmentTime":"2022-06-27T21:13","businessReferenceNo":"TEST2023072600000006","currency":"10","currencyFlag":"0","customRemark":"测试备注","customRemarkOne":"测试备注1","customRemarkTwo":"测试备注2","detailList":[{"accountName":"清的道芦而觅","accountNo":"536636363536363","agentAmount":"0.01","bankAddress":"中国银行","bankName":"深圳市","businessDetailNo":"1","customRemark":"测试明细备注1","customRemarkOne":"测试明细备注2","customRemarkTwo":"测试明细备注3","transactionText":"测试明细摘要123","mobileShortMessage":"短信备注测试"},{"accountName":"廖欣好","accountNo":"6225758379544272","agentAmount":"0.01","bankAddress":"","bankName":"","businessDetailNo":"2","customRemark":"测试明细备注1","customRemarkOne":"测试明细备注2","customRemarkTwo":"测试明细备注3","transactionText":"测试明细摘要123","mobileShortMessage":"短信备注测试"}],"digitalAgentFlag":"N","payAccountNo":"75592608402200109","mobileShortMessage":"测试短信备注123","totalAgentAmount":"0.02","totalAgentCount":2}]
     * businessReferenceNoList : ["TEST2023072600000005","TEST2023072600000006"]
     * operatorMobilePhone : 13200000000
     * sendMessage : N
     * uploadEnd : Y
     * xftAgentPayFlag : Y
     */

    private String operatorMobilePhone;

    private String sendMessage;

    private String uploadEnd;

    private String xftAgentPayFlag;

    /**
     * agentProtocolNo : ZA2357
     * agentRemark : 测试代发说明123
     * agentUsage : AGPAY006
     * appointmentDate : 2022-06-26
     * appointmentTime : 2022-06-26T21:13
     * businessReferenceNo : TEST2023072600000005
     * currency : 10
     * currencyFlag : 0
     * customRemark : 测试备注0234
     * customRemarkOne : 测试备注1234
     * customRemarkTwo : 测试备注2234
     * detailList : [{"accountName":"葛地释","accountNo":"6225886551219437","agentAmount":"0.01","bankAddress":"","bankName":"","businessDetailNo":"1","customRemark":"测试明细备注1","customRemarkOne":"测试明细备注2","customRemarkTwo":"测试明细备注3","transactionText":"测试明细摘要123","mobileShortMessage":"短信备注测试"},{"accountName":"1","accountNo":"2322322323232323","agentAmount":"1000.01","bankAddress":"","bankName":"","businessDetailNo":"2","customRemark":"测试明细备注1","customRemarkOne":"测试明细备注2","customRemarkTwo":"测试明细备注3","transactionText":"测试明细摘要123","mobileShortMessage":"短信备注测试"}]
     * digitalAgentFlag : N
     * payAccountNo : 75592608402200109
     * mobileShortMessage : 测试短信备注测试短信备注
     * totalAgentAmount : 1000.02
     * totalAgentCount : 2
     */

    private List<AgentListBean> agentList;

    private List<String> businessReferenceNoList;

    public String getOperatorMobilePhone() {return operatorMobilePhone;}

    public void setOperatorMobilePhone(String operatorMobilePhone) {this.operatorMobilePhone = operatorMobilePhone;}

    public String getSendMessage() {return sendMessage;}

    public void setSendMessage(String sendMessage) {this.sendMessage = sendMessage;}

    public String getUploadEnd() {return uploadEnd;}

    public void setUploadEnd(String uploadEnd) {this.uploadEnd = uploadEnd;}

    public String getXftAgentPayFlag() {return xftAgentPayFlag;}

    public void setXftAgentPayFlag(String xftAgentPayFlag) {this.xftAgentPayFlag = xftAgentPayFlag;}

    public List<AgentListBean> getAgentList() {return agentList;}

    public void setAgentList(List<AgentListBean> agentList) {this.agentList = agentList;}

    public List<String> getBusinessReferenceNoList() {return businessReferenceNoList;}

    public void setBusinessReferenceNoList(List<String> businessReferenceNoList) {this.businessReferenceNoList = businessReferenceNoList;}

    public static class AgentListBean {

        private String agentProtocolNo;

        private String agentRemark;

        private String agentUsage;

        private String appointmentDate;

        private String appointmentTime;

        private String businessReferenceNo;

        private String currency;

        private String currencyFlag;

        private String customRemark;

        private String customRemarkOne;

        private String customRemarkTwo;

        private String digitalAgentFlag;

        private String payAccountNo;

        private String mobileShortMessage;

        private String totalAgentAmount;

        private int totalAgentCount;

        /**
         * accountName : 葛地释
         * accountNo : 6225886551219437
         * agentAmount : 0.01
         * bankAddress :
         * bankName :
         * businessDetailNo : 1
         * customRemark : 测试明细备注1
         * customRemarkOne : 测试明细备注2
         * customRemarkTwo : 测试明细备注3
         * transactionText : 测试明细摘要123
         * mobileShortMessage : 短信备注测试
         */

        private List<DetailListBean> detailList;

        public String getAgentProtocolNo() {return agentProtocolNo;}

        public void setAgentProtocolNo(String agentProtocolNo) {this.agentProtocolNo = agentProtocolNo;}

        public String getAgentRemark() {return agentRemark;}

        public void setAgentRemark(String agentRemark) {this.agentRemark = agentRemark;}

        public String getAgentUsage() {return agentUsage;}

        public void setAgentUsage(String agentUsage) {this.agentUsage = agentUsage;}

        public String getAppointmentDate() {return appointmentDate;}

        public void setAppointmentDate(String appointmentDate) {this.appointmentDate = appointmentDate;}

        public String getAppointmentTime() {return appointmentTime;}

        public void setAppointmentTime(String appointmentTime) {this.appointmentTime = appointmentTime;}

        public String getBusinessReferenceNo() {return businessReferenceNo;}

        public void setBusinessReferenceNo(String businessReferenceNo) {this.businessReferenceNo = businessReferenceNo;}

        public String getCurrency() {return currency;}

        public void setCurrency(String currency) {this.currency = currency;}

        public String getCurrencyFlag() {return currencyFlag;}

        public void setCurrencyFlag(String currencyFlag) {this.currencyFlag = currencyFlag;}

        public String getCustomRemark() {return customRemark;}

        public void setCustomRemark(String customRemark) {this.customRemark = customRemark;}

        public String getCustomRemarkOne() {return customRemarkOne;}

        public void setCustomRemarkOne(String customRemarkOne) {this.customRemarkOne = customRemarkOne;}

        public String getCustomRemarkTwo() {return customRemarkTwo;}

        public void setCustomRemarkTwo(String customRemarkTwo) {this.customRemarkTwo = customRemarkTwo;}

        public String getDigitalAgentFlag() {return digitalAgentFlag;}

        public void setDigitalAgentFlag(String digitalAgentFlag) {this.digitalAgentFlag = digitalAgentFlag;}

        public String getPayAccountNo() {return payAccountNo;}

        public void setPayAccountNo(String payAccountNo) {this.payAccountNo = payAccountNo;}

        public String getMobileShortMessage() {return mobileShortMessage;}

        public void setMobileShortMessage(String mobileShortMessage) {this.mobileShortMessage = mobileShortMessage;}

        public String getTotalAgentAmount() {return totalAgentAmount;}

        public void setTotalAgentAmount(String totalAgentAmount) {this.totalAgentAmount = totalAgentAmount;}

        public int getTotalAgentCount() {return totalAgentCount;}

        public void setTotalAgentCount(int totalAgentCount) {this.totalAgentCount = totalAgentCount;}

        public List<DetailListBean> getDetailList() {return detailList;}

        public void setDetailList(List<DetailListBean> detailList) {this.detailList = detailList;}

        public static class DetailListBean {

            private String accountName;

            private String accountNo;

            private String agentAmount;

            private String bankAddress;

            private String bankName;

            private String businessDetailNo;

            private String customRemark;

            private String customRemarkOne;

            private String customRemarkTwo;

            private String transactionText;

            private String mobileShortMessage;

            public String getAccountName() {return accountName;}

            public void setAccountName(String accountName) {this.accountName = accountName;}

            public String getAccountNo() {return accountNo;}

            public void setAccountNo(String accountNo) {this.accountNo = accountNo;}

            public String getAgentAmount() {return agentAmount;}

            public void setAgentAmount(String agentAmount) {this.agentAmount = agentAmount;}

            public String getBankAddress() {return bankAddress;}

            public void setBankAddress(String bankAddress) {this.bankAddress = bankAddress;}

            public String getBankName() {return bankName;}

            public void setBankName(String bankName) {this.bankName = bankName;}

            public String getBusinessDetailNo() {return businessDetailNo;}

            public void setBusinessDetailNo(String businessDetailNo) {this.businessDetailNo = businessDetailNo;}

            public String getCustomRemark() {return customRemark;}

            public void setCustomRemark(String customRemark) {this.customRemark = customRemark;}

            public String getCustomRemarkOne() {return customRemarkOne;}

            public void setCustomRemarkOne(String customRemarkOne) {this.customRemarkOne = customRemarkOne;}

            public String getCustomRemarkTwo() {return customRemarkTwo;}

            public void setCustomRemarkTwo(String customRemarkTwo) {this.customRemarkTwo = customRemarkTwo;}

            public String getTransactionText() {return transactionText;}

            public void setTransactionText(String transactionText) {this.transactionText = transactionText;}

            public String getMobileShortMessage() {return mobileShortMessage;}

            public void setMobileShortMessage(String mobileShortMessage) {this.mobileShortMessage = mobileShortMessage;}
        }
    }
}