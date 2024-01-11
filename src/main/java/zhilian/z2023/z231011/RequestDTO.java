package zhilian.z2023.z231011;

import com.alibaba.fastjson.JSONObject;

/**
 * @author hailang.zhang
 * @since 2023-10-16
 */
public class RequestDTO {

    public static void main(String[] args) {
        String s = "{\"singleServiceFee\":{\"valueUnit\":64,\"caculateType\":79,\"value\":51},\"serviceFeeItems\":[{\"desc\":\"ea ex esse Duis irure\",\"code\":78},{\"code\":38,\"desc\":\"aliqua qui minim elit magna\"},{\"desc\":\"ipsum officia\",\"code\":71},{\"desc\":\"nisi in irure labore ea\",\"code\":98}],\"laderServiceFee\":{\"valueUnit\":90,\"laders\":[{\"order\":80,\"min\":8,\"max\":65,\"value\":17},{\"max\":40,\"min\":57,\"order\":49,\"value\":43},{\"min\":6,\"value\":91,\"max\":36,\"order\":59},{\"max\":31,\"value\":27,\"order\":8,\"min\":64},{\"order\":56,\"value\":84,\"max\":40,\"min\":28}],\"caculateType\":79},\"jobs\":[{\"desc\":\"id nulla tempor\",\"code\":34},{\"desc\":\"ea reprehenderit ut velit pariatur\",\"code\":70},{\"desc\":\"Lorem Excepteur veniam velit\",\"code\":79}],\"feeItems\":[{\"code\":64,\"desc\":\"nostrud\"},{\"desc\":\"pariatur qui officia\",\"code\":20}]}";
        Quotation_1 quotation1 = JSONObject.parseObject(s, Quotation_1.class);
        System.out.println(quotation1.getJobs());
    }
}