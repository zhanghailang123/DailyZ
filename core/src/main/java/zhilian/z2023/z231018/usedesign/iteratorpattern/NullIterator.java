package zhilian.z2023.z231018.usedesign.iteratorpattern;

import java.util.Iterator;

/**
 * 我们可以让createIterator方法返回null，但是如果这么做，我们的客户代码就需要条件语句来判断返回值是否为null
 * 这里我们定义一个空的迭代器，让处理逻辑统一起来 让null值在内部被处理掉 不需要让客户感知到null值
 * @author hailang.zhang
 * @since 2023-10-26
 */
public class NullIterator implements Iterator {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}