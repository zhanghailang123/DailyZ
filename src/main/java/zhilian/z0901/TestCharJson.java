package zhilian.z0901;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import lombok.Data;

/**
 * @description: 今天遇到的一个问题 char c = "https".charAt(0) c = 8234
 * @author: zhanghailang
 * @date: 2021/9/1 0001 21:46
 */
@Data
public class TestCharJson {
    /**
     * test url
     */
    private String url;

    public static void main(String[] args) {
//        {
//            "url": "https",
//                "@comment": {
//            "url": "/**\n     * test url\n     */"
//        }
//        }
        String s ="";

                String[] file = s.split(",");
        for (String s2 : file) {
            HttpUtil.downloadFile(StrUtil.trim(s2), "D:\\新建文件夹 (2)");

        }
    }
}