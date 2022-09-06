package com.zhanghl.first.z220207;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 測試驗證java是值傳遞還是引用傳遞
 * @author: zhanghailang
 * @date: 2022/8/12 9:13
 */
public class ReferenceTest {

    /**
     * 解析地址
     * @author lin
     * @param address
     * @return
     */
    public static List<Map<String,String>> addressResolution(String address) {
//        String regex = "(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县|.*?区)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        String regex = "(?<province>[^省]+省|.+自治区|[^澳门]+澳门|[^香港]+香港|[^市]+市)?(?<city>[^自治州]+自治州|[^特别行政区]+特别行政区|[^市]+市|.*?地区|.*?行政单位|.+盟|市辖区|[^县]+县)(?<county>[^县]+县|[^市]+市|[^镇]+镇|[^区]+区|[^乡]+乡|.+场|.+旗|.+海域|.+岛)?(?<address>.*)";
        Matcher m = Pattern.compile(regex).matcher(address);
        String province = null, city = null, county = null, town = null, village = null;
        List<Map<String, String>> table = new ArrayList<Map<String, String>>();
        Map<String, String> row = null;
        while (m.find()) {
            row = new LinkedHashMap<String, String>();
            province = m.group("province");
            row.put("province", province == null ? "" : province.trim());
            city = m.group("city");
            row.put("city", city == null ? "" : city.trim());
//            county = m.group("county");
//            row.put("county", county == null ? "" : county.trim());
//            town = m.group("town");
//            row.put("town", town == null ? "" : town.trim());
//            village = m.group("village");
//            row.put("village", village == null ? "" : village.trim());
            table.add(row);
        }
        return table;
    }

    public static void main(String[] args) {
        System.out.println(addressResolution("贵州省黔东南苗族侗族自治州天柱县"));
    }
}