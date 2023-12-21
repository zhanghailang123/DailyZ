//package zhilian.z230720;
//
//import cn.hutool.json.JSONArray;
//import cn.hutool.json.JSONUtil;
//import com.alibaba.fastjson.JSONObject;
//
//import java.io.File;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.Iterator;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.stream.Collectors;
//
///**
// * @author hailang.zhang
// * @since 2023-07-28
// */
//public class TestL {
//
//    public static void main(String[] args) {
//        File file = new File("C:\\Users\\shi.pengfei\\Desktop\\123.json.txt");
//        JSONArray objects = JSONUtil.readJSONArray(file, StandardCharsets.UTF_8);
//        List<zhilian.z230720.JobDO> list = new ArrayList<>();
//        Iterator<Object> iterator = objects.iterator();
//
//        Map<String, JobDO> map = new ConcurrentHashMap<>();
//        while (iterator.hasNext()) {
//            cn.hutool.json.JSONObject next = (cn.hutool.json.JSONObject) iterator.next();
//            String 一级编码1 = next.getStr("一级编码");
//            String 一级 = next.getStr("一级");
//
//            zhilian.z230720.JobDO job = new JobDO();
//            job.setStrKey(一级编码1);
//            job.setValue(一级);
//            map.put(一级, job);
//
//        }
//
//        Map<String, zhilian.z230720.JobDO> cache2 = new ConcurrentHashMap<>();
//        Iterator<Object> iterator2 = objects.iterator();
//        while (iterator2.hasNext()) {
//            cn.hutool.json.JSONObject next = (cn.hutool.json.JSONObject) iterator2.next();
//            String 二级编码 = next.getStr("二级编码");
//            String 二级 = next.getStr("二级");
//            String 一级 = next.getStr("一级");
//            String 一级编码1 = next.getStr("一级编码");
//
//            String 三级编码 = next.getStr("三级编码");
//            String 三级 = next.getStr("三级名称");
//
//
//            JobDO job3 = new JobDO();
//            job3.setValue(三级);
//            job3.setStrKey(三级编码);
//            job3.setParentStrKey(二级编码);
//
//            JobDO job = new JobDO();
//            job.setStrKey(二级编码);
//            job.setValue(二级);
//            job.setParentStrKey(一级编码1);
//
//            if (cache2.containsKey(二级编码)) {
//                job = cache2.get(二级编码);
//                job.getChildren().add(job3);
//                job.setChildren(job.getChildren().stream().distinct().sorted(Comparator.comparing(JobDO :: getStrKey)).collect(Collectors.toCollection(LinkedHashSet::new)));
//            } else {
//                job.getChildren().add(job3);
//                job.setChildren(job.getChildren().stream().distinct().sorted(Comparator.comparing(JobDO :: getStrKey)).collect(Collectors.toCollection(LinkedHashSet::new)));
//                cache2.put(二级编码, job);
//            }
//
//            JobDO aDo = map.get(一级);
//            aDo.getChildren().add(job);
//            aDo.setChildren(aDo.getChildren().stream().distinct().sorted(Comparator.comparing(JobDO :: getStrKey)).collect(Collectors.toCollection(LinkedHashSet::new)));
//            map.put(一级, aDo);
//        }
//
////        List<JobDO> list3 = new ArrayList<>();
////        Iterator<Object> iterator3 = objects.iterator();
////        while (iterator3.hasNext()) {
////            cn.hutool.json.JSONObject next = (cn.hutool.json.JSONObject) iterator3.next();
////            String 三级编码 = next.getStr("三级编码");
////            String 三级 = next.getStr("三级");
////
////            String 一级 = next.getStr("一级");
////            JobDO aDo = map.get(一级);
////            aDo.getChilds().add(aDo);
////            map.put(一级, aDo);
////
////        }
//        map.forEach((k, v) -> list.add(v));
////        System.out.println(list);
////        JobDO aDo = list.get(16);
////        System.out.println(JSONObject.toJSON(aDo));
//        String jsonString = com.alibaba.fastjson.JSONArray.toJSONString(list.stream().distinct().sorted(Comparator.comparing(JobDO :: getStrKey)).collect(Collectors.toList()));
//        System.out.println(jsonString);
//    }
//}