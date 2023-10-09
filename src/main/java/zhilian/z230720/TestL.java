package zhilian.z230720;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author hailang.zhang
 * @since 2023-07-28
 */
public class TestL {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\shi.pengfei\\Desktop\\123.json.txt");
        JSONArray objects = JSONUtil.readJSONArray(file, StandardCharsets.UTF_8);
        List<JobDO> list = new ArrayList<>();
        Iterator<Object> iterator = objects.iterator();

        Map<String, JobDO> map = new ConcurrentHashMap<>();
        while (iterator.hasNext()) {
            cn.hutool.json.JSONObject next = (cn.hutool.json.JSONObject) iterator.next();
            String 一级编码1 = next.getStr("一级编码");
            String 一级 = next.getStr("一级");

            JobDO job = new JobDO();
            job.setCode(一级编码1);
            job.setDesc(一级);
            map.put(一级, job);

        }

        Map<String, JobDO> cache2 = new ConcurrentHashMap<>();
        Iterator<Object> iterator2 = objects.iterator();
        while (iterator2.hasNext()) {
            cn.hutool.json.JSONObject next = (cn.hutool.json.JSONObject) iterator2.next();
            String 二级编码 = next.getStr("二级编码");
            String 二级 = next.getStr("二级");
            String 一级 = next.getStr("一级");
            String 一级编码1 = next.getStr("一级编码");

            String 三级编码 = next.getStr("三级编码");
            String 三级 = next.getStr("三级名称");


            JobDO job3 = new JobDO();
            job3.setDesc(三级);
            job3.setCode(三级编码);
            job3.setParentCode(二级编码);

            JobDO job = new JobDO();
            job.setCode(二级编码);
            job.setDesc(二级);
            job.setParentCode(一级编码1);

            if (cache2.containsKey(二级编码)) {
                job = cache2.get(二级编码);
                job.getChilds().add(job3);
            } else {
                job.getChilds().add(job3);
                cache2.put(二级编码, job);
            }

            JobDO aDo = map.get(一级);
            aDo.getChilds().add(job);
            aDo.setChilds(aDo.getChilds().stream().distinct().collect(Collectors.toSet()));
            map.put(一级, aDo);
        }

//        List<JobDO> list3 = new ArrayList<>();
//        Iterator<Object> iterator3 = objects.iterator();
//        while (iterator3.hasNext()) {
//            cn.hutool.json.JSONObject next = (cn.hutool.json.JSONObject) iterator3.next();
//            String 三级编码 = next.getStr("三级编码");
//            String 三级 = next.getStr("三级");
//
//            String 一级 = next.getStr("一级");
//            JobDO aDo = map.get(一级);
//            aDo.getChilds().add(aDo);
//            map.put(一级, aDo);
//
//        }
        map.forEach((k, v) -> list.add(v));
//        System.out.println(list);
//        JobDO aDo = list.get(16);
//        System.out.println(JSONObject.toJSON(aDo));
        String jsonString = com.alibaba.fastjson.JSONArray.toJSONString(list.stream().distinct().collect(Collectors.toList()));
        System.out.println(jsonString);
    }
}