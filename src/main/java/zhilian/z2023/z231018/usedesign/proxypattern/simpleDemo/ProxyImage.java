package zhilian.z2023.z231018.usedesign.proxypattern.simpleDemo;

/**
 * @author hailang.zhang
 * @since 2023-10-26
 */
public class ProxyImage implements Image{

    private String filename;

    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        System.out.println("显示占位图：" + filename);

        if (realImage == null) {
            realImage = new RealImage(filename);
        }

        realImage.display();
    }
}