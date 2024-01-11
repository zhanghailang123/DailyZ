package zhilian.z2024.z01.pipeline;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author hailang.zhang
 * @since 2024-01-11
 */
public class StandardPipelineContext implements PipelineContext {

    private Map<String, Object> contentMap = Maps.newConcurrentMap();

    @Override
    public void set(String contextKey, Object contextValue) {
        contentMap.put(contextKey, contextValue);
    }

    @Override
    public Object get(String contextKey) {
        return contentMap.get(contextKey);
    }
}