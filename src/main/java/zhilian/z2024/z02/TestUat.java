package zhilian.z2024.z02;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

/**
 * @author hailang.zhang
 * @since 2024-04-22
 */
public class TestUat {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orderNo","PO240417020001");
        HttpResponse response = HttpUtil
                .createGet("http://it-api-uat.zhaopin.com/token/java-it-caigou-employee/v1/purchaseOrder/detailByOrderNo?token=c2bff7262e1a4326b73cdeb20ff75d6a&orderNo=PO240417020001")

                .body(jsonObject.toJSONString(),"application/json;charset=UTF-8").contentType("application/json;charset=UTF-8").execute();
        System.out.println(response);
    }
}