package zhilian.z2023.z231011;

import lombok.Getter;

/**
 * 合同类型
 * @author liang.lei
 * 2022-12-07
 */
@Getter
public enum ContractTypeEnum {
    /**
     * 合同类型
     */
    LABOR_DISPATCH(2, "劳务派遣",",2020002426,421000003,"),
    SERVICE_OUTSOURCING(3, "服务外包",",2020002430,421002001," ),
    FULL_RISK_OUTSOURCING(4, "全风险外包",",2020002427,421002004,"),
    CROWD_SOURCING(5, "平台众包服务",",2020002414,421002006,421002003,"),
    INTERN(6, "实习生",",2020002413,2020002429,421002005,421002002,"),
    AGENCY_RECRUITMENT(7, "代理招聘",",2020106841,2020002412,421002007"),
    DISABILITY_BENEFITS(8, "残保服务",",2020106842,"),
    AGENCY_SMALL_LIBRARY(9, "小库代理",",2020103786"),
    ;

    /**
     * 值
     */
    private final int value;

    /**
     * 描述
     */
    private final String description;

    /**
     * cmp 中产品id
     */
    private final String cmpProdIds;

    ContractTypeEnum(int value, String description,String cmpProdIds) {
        this.value = value;
        this.description = description;
        this.cmpProdIds = cmpProdIds;
    }

    /**
     *
     * @param value 值
     * @return 枚举类
     */
    public static ContractTypeEnum of(int value) {
        for (ContractTypeEnum e : values()) {
            if (value == e.getValue()) {
                return e;
            }
        }
        return null;
    }

    public static ContractTypeEnum ofCmpProdIds(String value) {
        for (ContractTypeEnum e : values()) {
            if (e.getCmpProdIds().contains("," + value + ",")) {
                return e;
            }
        }
        return null;
    }

}
