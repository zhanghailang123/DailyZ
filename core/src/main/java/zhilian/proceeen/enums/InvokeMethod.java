package zhilian.proceeen.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hailang.zhang
 * @since 2024-03-27
 */
@Getter
@AllArgsConstructor
public enum InvokeMethod {
    SYNC("同步"),
    ASYNC("异步")
    ;
    private final String desc;
}