package zhilian.z0808;

import java.util.concurrent.TimeUnit;

public interface ICacheHandler {
    String get(String key);
    void set (String key, String value);
    void set(String key, String value, long timeout, TimeUnit timeUnit);
    void del(String key);
}
