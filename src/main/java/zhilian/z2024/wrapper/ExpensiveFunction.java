package zhilian.z2024.wrapper;

import java.math.BigInteger;

/**
 * @author hailang.zhang
 * @since 2024-06-24
 */
public class ExpensiveFunction implements Computable<String, BigInteger>{

    @Override
    public BigInteger compute(String arg) {
        return new BigInteger(arg);
    }
}