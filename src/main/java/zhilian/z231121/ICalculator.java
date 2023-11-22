package zhilian.z231121;

import java.math.BigDecimal;

/**
 * @author hailang.zhang
 * @since 2023-11-21
 */
public interface ICalculator<T> {

    BigDecimal calcualate(T t);
}