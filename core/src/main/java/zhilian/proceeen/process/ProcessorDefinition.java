package zhilian.proceeen.process;

import lombok.Getter;

/**
 * 定义一个流程
 * @author hailang.zhang
 * @since 2024-03-26
 */
@Getter
public class ProcessorDefinition {

    private String name;

    private ProcessNode first;

    public void setFirst(ProcessNode first) {
        this.first = first;
    }
}