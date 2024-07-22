package zhilian.z2024.xft;

/**
 * @author hailang.zhang
 * @since 2024-07-08
 */
public class TestXftDecrypt {

    public static void main(String[] args) throws Exception {
        decrpt();
    }

    public static void decrpt() throws Exception {
        String  pubKey ="04c5ee6127033f833bab02cafe3cd8674cbc2465f7d4e3c6d389100a1afe050f00ff9eff6c7f79531eb8653ca452475a73c2415554c498d1aaeb3212bbe14b298e";

        //获取内容
        String eventRcdInf = "6fa93654e2175b5c2d78208d49487de3277ab4c0349a5c3caa57e72b95ec68c547e4bdf187b0598639049e976b7454a211a86c80e1334a75d0a6a71d3309febdc6d9b0433fc33716627357daf9750fd26b9d4a08a6c373beb25922571884f7c7353101f8cfa24ab4833820388a672086e108f5ba46036b0cb61950ea9e3be479169b164219eaa25543746b60d1dc0fc40fd8bb065ff4e9f6eed366eec5d6656541a94527f87f86008ac923dbdadca48b";
        //解密
        String key = pubKey.substring(0, 32);
        eventRcdInf = Sm4Util.decryptEcb(key, eventRcdInf);
        System.out.println(eventRcdInf);
    }
}