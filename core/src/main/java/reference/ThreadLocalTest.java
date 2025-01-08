package reference;

/**
 * @description: ThreadLocal的使用详解
 * @author: zhanghailang
 * @date: 2020/12/12 0012 21:54
 */
public class ThreadLocalTest {
    static  ThreadLocal<Person> tl = new ThreadLocal<>();
    public static void main(String[] args) {

        new Thread(() ->{


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tl.set(new Person("zy"));
            System.out.println(tl.get());

        }).start();




        new Thread(() ->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(tl.get());


        }).start();

    }






    static class Person{
        String name = "zhl";

        public Person(String name) {
            this.name = name;
        }
    }
}