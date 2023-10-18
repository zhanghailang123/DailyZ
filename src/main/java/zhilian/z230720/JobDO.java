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
    private String strKey;
    private String value;
    private String desc;

    private String parentStrKey;
    private Set<JobDO> children;

    public JobDO() {
        this.children = new HashSet<>();
    }
}