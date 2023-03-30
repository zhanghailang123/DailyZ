package com.zhanghl.first.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.googlecode.aviator.AviatorEvaluator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hailang.zhang
 * @since 2023-03-23
 */
public class TestAviator {

    public static void main(String[] args) {
//        User0323 user0323 = new User0323();
//        user0323.setAge(11);
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("userName", "aa");
//        map.put("entity", user0323);
//        Boolean result = (Boolean) AviatorEvaluator.execute("userName == nil || userName == ''", map, true);
//        Boolean result2 = (Boolean) AviatorEvaluator.execute("entity.userName == nil || userName == ''", map, true);
//        Boolean result3 = (Boolean) AviatorEvaluator.execute("entity.age > 18", map, true);
//        System.out.println(result2);
//        System.out.println(result3);
//        String Json = "{\"importCommon\":[{\"ruleName\":\"errorName\",\"ruleExpression\":\"entity.name == nil || entity.name == ''\",\"hitDesc\":\"姓名不符合填写要求，请核实\"},{\"ruleName\":\"errorMoney\",\"ruleExpression\":\"let money = entity.taskMoney; return (money == nil || money < 0 || money > 98000 || getDecimalPlaces(money) > 2);\",\"hitDesc\":\"金额不符合填写要求，请核实\"},{\"ruleName\":\"orgManager\",\"ruleExpression\":\"entity.name != nill && orgManager(entity.name, entity.customerName)\",\"hitDesc\":\"该人员受身份限制，无法参与众包结算，请更换人员\"},{\"ruleName\":\"recentTwoMonthSameMoney\",\"ruleExpression\":\"recentTwoMonthSameMoney(entity)\",\"hitDesc\":\"系统识别到发款风险，建议修改发款金额\"}],\"importTask\":[{\"ruleName\":\"repeatTaskData\",\"ruleExpression\":\"repeatTaskData(entity)\",\"hitDesc\":\"重复数据，请核实\"},{\"ruleName\":\"errorInvitationCode\",\"ruleExpression\":\"let code = entity.invitationCode; return (code == nil || code == '' || invitationCodeCheck(entity.gigUserId,code,entity.contractId));\",\"hitDesc\":\"邀请码错误，请核实\"},{\"ruleName\":\"errorTaskName\",\"ruleExpression\":\"entity.taskName == nil || entity.taskName == ''\",\"hitDesc\":\"任务名称不符合填写要求，请核实\"},{\"ruleName\":\"errorCheckMode\",\"ruleExpression\":\"entity.checkMode == nil\",\"hitDesc\":\"验收方式不符合填写要求，请核实\"},{\"ruleName\":\"errorNeedPicture\",\"ruleExpression\":\"entity.needPicture == nil\",\"hitDesc\":\"需要上传图片不符合填写要求，请核实\"}],\"importPaySalary\":[{\"ruleName\":\"errorInvitationCode\",\"ruleExpression\":\"let code = entity.invitationCode; return (code == nil || code == '' || invitationCodeCheck(entity.gigUserId,code,entity.contractId));\",\"hitDesc\":\"邀请码错误，请核实\"}]}";
//        Map<String, List<Rule>> object = JSONObject.parseObject(Json, Map.class);
//        List<Rule> importCommon = JSONArray.parseArray(object.get("importCommon").toString(), Rule.class);
//        importCommon.stream().forEach(rule -> {
//            System.out.println(rule.getRuleExpression());
//        });
//        System.out.println(object);


        //settlementDates 格式2022-06-10 18:31:01
//        List<String> settlementDates = Arrays.asList("2022-01-10 18:31:01", "2022-06-10 18:31:01", "2022-06-10 18:31:01", "2022-03-10 18:31:01","2022-06-10 18:31:01");
        List<String> settlementDates = Arrays.asList( "2022-06-10 18:31:01", "2022-06-10 18:31:01", "2022-03-10 18:31:01","2022-06-10 18:31:01");
        //截取前10位到月份 然后去重计数
        long count = settlementDates.stream().map(a -> a.substring(0, 7)).distinct().count();
        settlementDates.stream().map(a -> a.substring(0, 7)).forEach(a -> {
            System.out.println(a);
        });

        System.out.println(count);
    }
}