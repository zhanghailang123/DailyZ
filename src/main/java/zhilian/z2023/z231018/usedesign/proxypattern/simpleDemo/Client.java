package zhilian.z2023.z231018.usedesign.proxypattern.simpleDemo;


/**
 * @author hailang.zhang
 * @since 2023-10-26
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {
        ProxyImage image1 = new ProxyImage("image1.jpg");
        ProxyImage image2 = new ProxyImage("image2.jpg");

        image1.display();

        image1.display();

        image2.display();
    }
}