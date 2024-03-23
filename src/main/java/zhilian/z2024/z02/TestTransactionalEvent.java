package zhilian.z2024.z02;

import org.springframework.context.ApplicationEvent;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.concurrent.Executors;

/**
 * @author hailang.zhang
 * @since 2024-03-18
 */
public class TestTransactionalEvent {

    @TransactionalEventListener
    public void subscribe(ApplicationEvent event) {
        Executors.newFixedThreadPool(5);
    }

    public static void main(String[] args) {

    }
}