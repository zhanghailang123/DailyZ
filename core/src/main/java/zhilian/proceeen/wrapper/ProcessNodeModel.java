package zhilian.proceeen.wrapper;

import lombok.Data;
import zhilian.proceeen.enums.InvokeMethod;

/**
 * @author hailang.zhang
 * @since 2024-03-27
 */
@Data
public class ProcessNodeModel {

    private String name;

    private String className;

    private String nextNodeName;

    private boolean begin = false;

    private InvokeMethod invokeMethod;

}