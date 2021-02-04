package reference;

import java.io.IOException;

/**
 * @description: 正常引用即强引用
 * @author: zhanghailang
 * @date: 2020/12/10 0010 22:52
 */
public class NormalReference {
    public static void main(String[] args) throws IOException {
        Re re = new Re();
        re = null;
        System.gc();
        System.in.read();
    }
}