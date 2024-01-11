package zhilian.z2023.z231011;

import lombok.Data;

import java.util.List;

/**
 * @description  字典项返回实体
 * @author zhanghailang
 * @date 2022/7/1 14:20
 */
@Data
public class DictItemDTO {


    /**
     * 字典项long类型的code
     */
    private Long intKey;

    /**
     * 字典项String类型的code 如有需要可传此字段
     */
    private String strKey;

    /**
     * 字典项值
     */
    private String value;

    /**
     * 描述
     */
    private String desc;

    /**
     * 排序字段
     */
    private Integer order;

    /**
     * 字典项子项 如无子项 为null
     */
    private List<DictItemDTO> children;

    /**
     * 拓展字段
     */
    private String attributeValue;
}