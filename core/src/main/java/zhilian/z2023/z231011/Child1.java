package zhilian.z2023.z231011;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hailang.zhang
 * @since 2023-10-16
 */
public class Child1 extends Parent{

    public void doSomething() {
    }

    public static void main(String[] args) throws JSONException {
        Child1 child1 = new Child1();
        child1.setField1("skdjka1");

        Parent parent = new Parent();
        parent.setField1("1111");
        parent.setField2("2222");

        ParentList list = new ParentList();
        list.setName("zhangsan1");

        ParentList list2 = new ParentList();
        list2.setName("lisi");

        List<ParentList> re = new ArrayList<>();
        re.add(list);
        re.add(list2);
        parent.setLists(re);

//        Child2 child2 = JSONObject.parseObject("{\"field1\":\"1111\",\"field2\":\"2222\",\"lists\":[{\"name\":\"zhangsan1\"},{\"name\":\"lisi\"}]}\n", Child2.class);
        Child2 child2 = JSONObject.parseObject(JSONObject.toJSONString(parent), Child2.class);
//        child2.setField2("qwewqe");
        System.out.println(JSONObject.toJSONString(parent));
        System.out.println(JSONObject.toJSONString(child2, SerializerFeature.WriteMapNullValue));
//        JSONAssert.assertEquals(JSONObject.toJSONString(parent),JSONObject.toJSONString(child2), JSONCompareMode.LENIENT);
//        JSONCompareResult result = JSONCompare.compareJSON(JSONObject.toJSONString(child2), JSONObject.toJSONString(parent), JSONCompareMode.LENIENT);
        JSONCompareResult result = JSONCompare.compareJSON("[{\"singleServiceFee\":{\"caculateType\":39,\"value\":94426178,\"valueUnit\":49}},{\"singleServiceFee\":{\"caculateType\":15,\"value\":91827395,\"valueUnit\":14}},{\"singleServiceFee\":{\"caculateType\":82,\"value\":8331470,\"valueUnit\":44}},{\"singleServiceFee\":{\"caculateType\":41,\"value\":41232912,\"valueUnit\":8}},{\"singleServiceFee\":{\"caculateType\":18,\"value\":69649463,\"valueUnit\":99}}]", "[{\"feeItems\":[{\"code\":25,\"desc\":\"occaecat\"},{\"code\":81,\"desc\":\"mollit id eu\"},{\"code\":79,\"desc\":\"anim Excepteur ut officia\"},{\"code\":53,\"desc\":\"do exercitation culpa\"},{\"code\":89,\"desc\":\"minim laborum pariatur\"}],\"jobs\":[{\"code\":9,\"desc\":\"commodo\"},{\"code\":67,\"desc\":\"in ex reprehenderit\"},{\"code\":10,\"desc\":\"voluptate ea\"},{\"code\":21,\"desc\":\"eu consequat\"},{\"code\":13,\"desc\":\"eu quis dolore ad id\"}],\"laderServiceFee\":{\"caculateType\":2,\"laders\":[{\"max\":176166,\"min\":85010315,\"order\":20554962,\"value\":79987108},{\"max\":54772834,\"min\":12339557,\"order\":44229519,\"value\":76515028}],\"valueUnit\":14},\"serviceFeeItems\":[{\"code\":98,\"desc\":\"consectetur proident commodo\"}],\"singleServiceFee\":{\"caculateType\":39,\"value\":94426178,\"valueUnit\":49}},{\"feeItems\":[{\"code\":36,\"desc\":\"dolor elit ad aute\"},{\"code\":30,\"desc\":\"commodo amet ea sunt deserunt\"},{\"code\":86,\"desc\":\"tempor in ut ex amet\"},{\"code\":23,\"desc\":\"esse aliqua occaecat non ut\"}],\"jobs\":[{\"code\":51,\"desc\":\"proident\"}],\"laderServiceFee\":{\"caculateType\":57,\"laders\":[{\"max\":52210887,\"min\":58644435,\"order\":5949991,\"value\":72492530},{\"max\":18740985,\"min\":50795934,\"order\":17998695,\"value\":39074361}],\"valueUnit\":95},\"serviceFeeItems\":[{\"code\":90,\"desc\":\"in culpa eu voluptate in\"},{\"code\":78,\"desc\":\"Excepteur incididunt nisi commodo ad\"}],\"singleServiceFee\":{\"caculateType\":15,\"value\":91827395,\"valueUnit\":14}},{\"feeItems\":[{\"code\":35,\"desc\":\"et aute mollit aliquip consequat\"}],\"jobs\":[{\"code\":27,\"desc\":\"esse consequat tempor dolore\"},{\"code\":3,\"desc\":\"aliqua dolor in dolore laboris\"},{\"code\":26,\"desc\":\"ut in dolor ex mollit\"}],\"laderServiceFee\":{\"caculateType\":94,\"laders\":[{\"max\":55743583,\"min\":67028827,\"order\":73158241,\"value\":7490686},{\"max\":82118749,\"min\":64200152,\"order\":12609652,\"value\":58565121},{\"max\":28203523,\"min\":72264310,\"order\":22888685,\"value\":48442061},{\"max\":24438264,\"min\":35955956,\"order\":28601380,\"value\":68105160},{\"max\":48108740,\"min\":80276398,\"order\":26763213,\"value\":6990536}],\"valueUnit\":70},\"serviceFeeItems\":[{\"code\":49,\"desc\":\"est irure Lorem laboris ut\"},{\"code\":58,\"desc\":\"amet anim\"}],\"singleServiceFee\":{\"caculateType\":82,\"value\":8331470,\"valueUnit\":44}},{\"feeItems\":[{\"code\":47,\"desc\":\"quis aliqua proident est\"}],\"jobs\":[{\"code\":96,\"desc\":\"sit\"}],\"laderServiceFee\":{\"caculateType\":3,\"laders\":[{\"max\":32232760,\"min\":5024875,\"order\":69008870,\"value\":64388277},{\"max\":76468641,\"min\":67296506,\"order\":39528472,\"value\":77650806},{\"max\":94021467,\"min\":75911484,\"order\":58532520,\"value\":48282919},{\"max\":75834982,\"min\":45664758,\"order\":31759392,\"value\":94868783}],\"valueUnit\":29},\"serviceFeeItems\":[{\"code\":81,\"desc\":\"Lorem dolore Duis\"},{\"code\":29,\"desc\":\"amet\"}],\"singleServiceFee\":{\"caculateType\":41,\"value\":41232912,\"valueUnit\":8}},{\"feeItems\":[{\"code\":49,\"desc\":\"ad irure Duis\"},{\"code\":36,\"desc\":\"in veniam\"},{\"code\":87,\"desc\":\"nostrud\"}],\"jobs\":[{\"code\":88,\"desc\":\"qui fugiat ut\"},{\"code\":22,\"desc\":\"eu sint\"}],\"laderServiceFee\":{\"caculateType\":12,\"laders\":[{\"max\":71452511,\"min\":41000800,\"order\":87738482,\"value\":35488044}],\"valueUnit\":23},\"serviceFeeItems\":[{\"code\":26,\"desc\":\"tempor officia anim deserunt\"},{\"code\":34,\"desc\":\"ut\"},{\"code\":68,\"desc\":\"consectetur deserunt commodo\"},{\"code\":59,\"desc\":\"ex non dolore pariatur deserunt\"},{\"code\":79,\"desc\":\"magna sunt consectetur\"}],\"singleServiceFee\":{\"caculateType\":18,\"value\":69649463,\"valueUnit\":99}}]", JSONCompareMode.NON_EXTENSIBLE);
//        JSONCompareResult result = JSONCompare.compareJSON("{\"singleServiceFee\":{\"valueUnit\":49,\"caculateType\":39,\"value\":94426178}}",
//                "{\"singleServiceFee\":{\"valueUnit\":49,\"caculateType\":39,\"value\":94426178},\"serviceFeeItems\":[{\"code\":98,\"desc\":\"consectetur proident commodo\"}],\"jobs\":[{\"code\":9,\"desc\":\"commodo\"},{\"code\":67,\"desc\":\"in ex reprehenderit\"},{\"code\":10,\"desc\":\"voluptate ea\"},{\"code\":21,\"desc\":\"eu consequat\"},{\"code\":13,\"desc\":\"eu quis dolore ad id\"}],\"laderServiceFee\":{\"laders\":[{\"min\":85010315,\"max\":176166,\"value\":79987108,\"order\":20554962},{\"min\":12339557,\"max\":54772834,\"value\":76515028,\"order\":44229519}],\"valueUnit\":14,\"caculateType\":2},\"feeItems\":[{\"code\":25,\"desc\":\"occaecat\"},{\"code\":81,\"desc\":\"mollit id eu\"},{\"code\":79,\"desc\":\"anim Excepteur ut officia\"},{\"code\":53,\"desc\":\"do exercitation culpa\"},{\"code\":89,\"desc\":\"minim laborum pariatur\"}]}", JSONCompareMode.NON_EXTENSIBLE);
        System.out.println(result.getMessage());

//        JSONComparator innerComparator = new DefaultComparator(JSONCompareMode.NON_EXTENSIBLE);
//        Customization innerCustomization = new Customization("a[1]", new ArrayValueMatcher<Object>(innerComparator, 0));
//        JSONComparator comparator = new CustomComparator(JSONCompareMode.NON_EXTENSIBLE, innerCustomization);
//        Customization customization = new Customization("a", new ArrayValueMatcher<Object>(comparator, 1));
//        JSONCompareResult result = JSONCompare.compareJSON("[{\"singleServiceFee\":{\"caculateType\":39,\"value\":94426178,\"valueUnit\":49}},{\"singleServiceFee\":{\"caculateType\":15,\"value\":91827395,\"valueUnit\":14}},{\"singleServiceFee\":{\"caculateType\":82,\"value\":8331470,\"valueUnit\":44}},{\"singleServiceFee\":{\"caculateType\":41,\"value\":41232912,\"valueUnit\":8}},{\"singleServiceFee\":{\"caculateType\":18,\"value\":69649463,\"valueUnit\":99}}]", "[{\"feeItems\":[{\"code\":25,\"desc\":\"occaecat\"},{\"code\":81,\"desc\":\"mollit id eu\"},{\"code\":79,\"desc\":\"anim Excepteur ut officia\"},{\"code\":53,\"desc\":\"do exercitation culpa\"},{\"code\":89,\"desc\":\"minim laborum pariatur\"}],\"jobs\":[{\"code\":9,\"desc\":\"commodo\"},{\"code\":67,\"desc\":\"in ex reprehenderit\"},{\"code\":10,\"desc\":\"voluptate ea\"},{\"code\":21,\"desc\":\"eu consequat\"},{\"code\":13,\"desc\":\"eu quis dolore ad id\"}],\"laderServiceFee\":{\"caculateType\":2,\"laders\":[{\"max\":176166,\"min\":85010315,\"order\":20554962,\"value\":79987108},{\"max\":54772834,\"min\":12339557,\"order\":44229519,\"value\":76515028}],\"valueUnit\":14},\"serviceFeeItems\":[{\"code\":98,\"desc\":\"consectetur proident commodo\"}],\"singleServiceFee\":{\"caculateType\":39,\"value\":94426178,\"valueUnit\":49}},{\"feeItems\":[{\"code\":36,\"desc\":\"dolor elit ad aute\"},{\"code\":30,\"desc\":\"commodo amet ea sunt deserunt\"},{\"code\":86,\"desc\":\"tempor in ut ex amet\"},{\"code\":23,\"desc\":\"esse aliqua occaecat non ut\"}],\"jobs\":[{\"code\":51,\"desc\":\"proident\"}],\"laderServiceFee\":{\"caculateType\":57,\"laders\":[{\"max\":52210887,\"min\":58644435,\"order\":5949991,\"value\":72492530},{\"max\":18740985,\"min\":50795934,\"order\":17998695,\"value\":39074361}],\"valueUnit\":95},\"serviceFeeItems\":[{\"code\":90,\"desc\":\"in culpa eu voluptate in\"},{\"code\":78,\"desc\":\"Excepteur incididunt nisi commodo ad\"}],\"singleServiceFee\":{\"caculateType\":15,\"value\":91827395,\"valueUnit\":14}},{\"feeItems\":[{\"code\":35,\"desc\":\"et aute mollit aliquip consequat\"}],\"jobs\":[{\"code\":27,\"desc\":\"esse consequat tempor dolore\"},{\"code\":3,\"desc\":\"aliqua dolor in dolore laboris\"},{\"code\":26,\"desc\":\"ut in dolor ex mollit\"}],\"laderServiceFee\":{\"caculateType\":94,\"laders\":[{\"max\":55743583,\"min\":67028827,\"order\":73158241,\"value\":7490686},{\"max\":82118749,\"min\":64200152,\"order\":12609652,\"value\":58565121},{\"max\":28203523,\"min\":72264310,\"order\":22888685,\"value\":48442061},{\"max\":24438264,\"min\":35955956,\"order\":28601380,\"value\":68105160},{\"max\":48108740,\"min\":80276398,\"order\":26763213,\"value\":6990536}],\"valueUnit\":70},\"serviceFeeItems\":[{\"code\":49,\"desc\":\"est irure Lorem laboris ut\"},{\"code\":58,\"desc\":\"amet anim\"}],\"singleServiceFee\":{\"caculateType\":82,\"value\":8331470,\"valueUnit\":44}},{\"feeItems\":[{\"code\":47,\"desc\":\"quis aliqua proident est\"}],\"jobs\":[{\"code\":96,\"desc\":\"sit\"}],\"laderServiceFee\":{\"caculateType\":3,\"laders\":[{\"max\":32232760,\"min\":5024875,\"order\":69008870,\"value\":64388277},{\"max\":76468641,\"min\":67296506,\"order\":39528472,\"value\":77650806},{\"max\":94021467,\"min\":75911484,\"order\":58532520,\"value\":48282919},{\"max\":75834982,\"min\":45664758,\"order\":31759392,\"value\":94868783}],\"valueUnit\":29},\"serviceFeeItems\":[{\"code\":81,\"desc\":\"Lorem dolore Duis\"},{\"code\":29,\"desc\":\"amet\"}],\"singleServiceFee\":{\"caculateType\":41,\"value\":41232912,\"valueUnit\":8}},{\"feeItems\":[{\"code\":49,\"desc\":\"ad irure Duis\"},{\"code\":36,\"desc\":\"in veniam\"},{\"code\":87,\"desc\":\"nostrud\"}],\"jobs\":[{\"code\":88,\"desc\":\"qui fugiat ut\"},{\"code\":22,\"desc\":\"eu sint\"}],\"laderServiceFee\":{\"caculateType\":12,\"laders\":[{\"max\":71452511,\"min\":41000800,\"order\":87738482,\"value\":35488044}],\"valueUnit\":23},\"serviceFeeItems\":[{\"code\":26,\"desc\":\"tempor officia anim deserunt\"},{\"code\":34,\"desc\":\"ut\"},{\"code\":68,\"desc\":\"consectetur deserunt commodo\"},{\"code\":59,\"desc\":\"ex non dolore pariatur deserunt\"},{\"code\":79,\"desc\":\"magna sunt consectetur\"}],\"singleServiceFee\":{\"caculateType\":18,\"value\":69649463,\"valueUnit\":99}}]", new CustomComparator(JSONCompareMode.LENIENT, customization));
//        System.out.println(result.getMessage());

    }
}