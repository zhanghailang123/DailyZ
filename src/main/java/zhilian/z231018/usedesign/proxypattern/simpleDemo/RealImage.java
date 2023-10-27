package zhilian.z231018.usedesign.proxypattern.simpleDemo;

/**
 * @author hailang.zhang
 * @since 2023-10-26
 */
public class RealImage implements Image{
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("开始从桌面加载耗时的图片：" + filename);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("图片加载成功：" + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}