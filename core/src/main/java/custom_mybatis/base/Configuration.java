package custom_mybatis.base;

import custom_mybatis.transaction.Environment;

/**
 * this is a parsed object
 * maybe from xml or yaml
 * @author hailang.zhang
 * @since 2024-03-31
 */
public class Configuration {

    public Environment getEnvironment() {
        return environment;
    }

    protected Environment environment;
}