package zhilian.z2023.z231115;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hailang.zhang
 * @since 2023-11-17
 */
public class BizFactory implements ApplicationListener<ContextRefreshedEvent> {

    private static Map<BizTypeEnum, IApplyPayProcessor> APPLY_PAY_MAP = new ConcurrentHashMap<>(8);

    public static IApplyPayProcessor getApplyPayProcessor(BizTypeEnum bizType) {
        return APPLY_PAY_MAP.get(bizType);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();

        //申请支付工厂初始化
        Map<String, Object> beansWithAnno = applicationContext.getBeansWithAnnotation(ApplyPay.class);
        if (beansWithAnno != null) {
            beansWithAnno.forEach((key, value) -> {
                BizTypeEnum bizType = value.getClass().getAnnotation(ApplyPay.class).bizType();
                APPLY_PAY_MAP.put(bizType, (IApplyPayProcessor) value);
            });
        }
    }
}