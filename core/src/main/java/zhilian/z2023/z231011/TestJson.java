package zhilian.z2023.z231011;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.google.common.collect.Lists;

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
//        TestJson testJson = new TestJson();
//        testJson.parse();

        Child2 child2 = new Child2();
        child2.setLists(Lists.newArrayList());
        child2.setField2("");
        child2.setField4("");
        child2.setContractTypeEnum(ContractTypeEnum.LABOR_DISPATCH);

        System.out.println(JSONObject.parseObject("{\"contractTypeEnum\": \"LABOR_DISPATCH\",\"field2\":\"\",\"field4\":\"\",\"lists\":[]}", Child2.class, Feature.ErrorOnEnumNotMatch));
        System.out.println(111);
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