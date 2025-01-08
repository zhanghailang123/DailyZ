package JUC;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @description: 异步线程的测试使用
 * @author: zhanghailang
 * @date: 2021-5-17 20:33
 */
public class FutureEx {
    public static void completableFutureTest(){
       CompletableFuture<String> aa =  CompletableFuture.supplyAsync(() ->{
            System.out.println("开始异步2");
            return "成功结束";
        });
        System.out.println("主线程做了些别的事情");
        try {
            System.out.println(aa.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        completableFutureTest();
    }
}