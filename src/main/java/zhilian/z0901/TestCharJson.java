package zhilian.z0901;

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
        String s = "https://storage-public.zhaopin.cn/innovation/gig/1630393511322588931/8.31%25E6%2599%25BA%25E8%2581%2594%25E7%2581%25B5%25E7%258A%2580%25E5%25B9%25B3%25E5%258F%25B0.xlsx";
        char c = s.charAt(0);
        System.out.println(c);
    }
}