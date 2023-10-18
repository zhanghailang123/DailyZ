package zhilian.z231011;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author hailang.zhang
 * @since 2023-10-12
 */
public abstract class OtsContractQuotation {

    /**
     * 单一报价
     * valueUnit : 1
     * caculateType : 1
     * value : 1000
     */

    @JSONField
    private SingleServiceFee singleServiceFee;

    /**
     * 阶梯报价
     * valueUnit : 1
     * caculateType : 1
     * laders : [{"min":0,"max":10,"value":1000},{"min":10,"max":20,"value":800},{"min":20,"max":30,"value":600}]
     */

    private LaderServiceFee laderServiceFee;

    /**
     * 职位
     * code : 1
     * desc :
     */

    private List<Job> jobs;

    /**
     * 服务费费用项
     * code : 1
     * desc :
     */

    private List<ServiceFeeItem> serviceFeeItems;

    /**
     * 费用项
     * code : 1
     * desc :
     */

    private List<FeeItem> feeItems;

    public SingleServiceFee getSingleServiceFee() {return singleServiceFee;}

    public void setSingleServiceFee(SingleServiceFee singleServiceFee) {this.singleServiceFee = singleServiceFee;}

    public LaderServiceFee getLaderServiceFee() {return laderServiceFee;}

    public void setLaderServiceFee(LaderServiceFee laderServiceFee) {this.laderServiceFee = laderServiceFee;}

    public List<Job> getJobs() {return jobs;}

    public void setJobs(List<Job> jobs) {this.jobs = jobs;}

    public List<ServiceFeeItem> getServiceFeeItems() {return serviceFeeItems;}

    public void setServiceFeeItems(List<ServiceFeeItem> serviceFeeItems) {this.serviceFeeItems = serviceFeeItems;}

    public List<FeeItem> getFeeItems() {return feeItems;}

    public void setFeeItems(List<FeeItem> feeItems) {this.feeItems = feeItems;}

    public static class SingleServiceFee {

        /**
         * 费用单位：月 日 小时等
         */
        private int valueUnit;

        /**
         * 计算类型 %
         */
        private int caculateType;

        private int value;

        public int getValueUnit() {return valueUnit;}

        public void setValueUnit(int valueUnit) {this.valueUnit = valueUnit;}

        public int getCaculateType() {return caculateType;}

        public void setCaculateType(int caculateType) {this.caculateType = caculateType;}

        public int getValue() {return value;}

        public void setValue(int value) {this.value = value;}
    }

    public static class LaderServiceFee {

        private int valueUnit;

        private int caculateType;

        /**
         * min : 0
         * max : 10
         * value : 1000
         */

        private List<Lader> laders;

        public int getValueUnit() {return valueUnit;}

        public void setValueUnit(int valueUnit) {this.valueUnit = valueUnit;}

        public int getCaculateType() {return caculateType;}

        public void setCaculateType(int caculateType) {this.caculateType = caculateType;}

        public List<Lader> getLaders() {return laders;}

        public void setLaders(List<Lader> laders) {this.laders = laders;}

        public static class Lader {
            private int order;

            private int min;

            private int max;

            private int value;

            public int getMin() {return min;}

            public void setMin(int min) {this.min = min;}

            public int getMax() {return max;}

            public void setMax(int max) {this.max = max;}

            public int getValue() {return value;}

            public void setValue(int value) {this.value = value;}

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }
        }
    }

    public static class Job {

        private int code;

        private String desc;

        public int getCode() {return code;}

        public void setCode(int code) {this.code = code;}

        public String getDesc() {return desc;}

        public void setDesc(String desc) {this.desc = desc;}
    }

    public static class ServiceFeeItem {

        private int code;

        private String desc;

        public int getCode() {return code;}

        public void setCode(int code) {this.code = code;}

        public String getDesc() {return desc;}

        public void setDesc(String desc) {this.desc = desc;}
    }

    public static class FeeItem {

        private int code;

        private String desc;

        public int getCode() {return code;}

        public void setCode(int code) {this.code = code;}

        public String getDesc() {return desc;}

        public void setDesc(String desc) {this.desc = desc;}
    }
}