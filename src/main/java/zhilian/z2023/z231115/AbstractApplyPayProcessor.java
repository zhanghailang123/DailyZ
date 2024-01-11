package zhilian.z2023.z231115;

/**
 * @author hailang.zhang
 * @since 2023-11-15
 */
public abstract class AbstractApplyPayProcessor<T> implements IApplyPayProcessor{

    /**
     * 申请支付模板方法
     * @param request
     */
    @Override
    public void applyPay(ApplyPayRequest request) {
        //数据查询
        T t= query(request);
        //校验
        check(t);
        //业务逻辑处理
        process(t, request);
        //数据保存
        save(t);
        //通用业务逻辑处理
        sendMsg(t);
    }

    private void sendMsg(T t) {
        //发送业务逻辑完成通知 event、msg...
//        ...实际代码省略
    }

    /**
     * 根据业务,子类实现
     * @param request
     * @return
     */
    public abstract T query(ApplyPayRequest request);

    /**
     * 根据业务,子类实现
     * @param t
     * @return
     */
    public abstract Boolean check(T t);

    /**
     * 业务逻辑处理
     * @param t
     * @param request
     */
    public abstract void process(T t, ApplyPayRequest request);

    /**
     * 保存
     * @param t
     */
    public abstract void save(T t);
}