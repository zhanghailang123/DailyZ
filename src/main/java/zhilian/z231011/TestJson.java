package zhilian.z231011;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hailang.zhang
 * @since 2023-10-16
 */
public class TestJson {
    private static List<DictTreeDTO> jobTree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        TestJson testJson = new TestJson();
        testJson.parse();
    }

    public void parse () throws IOException {
        InputStream inputStream = null;
        try {
            String filePath = "/cts-job.json";
            inputStream = getClass().getResourceAsStream(filePath);
            jobTree = JSONArray.parseObject(inputStream, List.class);
            System.out.println(jobTree);
        } finally {
            inputStream.close();
        }
    }
}