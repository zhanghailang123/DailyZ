package zhilian.z231011;

import lombok.Data;

import java.util.List;

/**
 * @description  字典树返回实体
 * @author zhanghailang
 * @date 2022/7/1 14:15
 */
@Data
public class DictTreeDTO {

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典项
     */
    private List<DictItemDTO> items;

}