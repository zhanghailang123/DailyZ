package zhilian.z230720;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hailang.zhang
 * @since 2023-10-08
 */
@Data
public class JobDO {
    private String desc;
    private String code;

    private String parentCode;
    private Set<JobDO> childs;

    public JobDO() {
        this.childs = new HashSet<>();
    }
}