package zhilian.z2024.xft;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cmb.xft.open.api.BaseReqInf;
import com.cmb.xft.open.api.HttpResponseData;
import com.cmb.xft.open.api.XftOpenApiReqClient;
import zhilian.z2024.xft.TestDownloadUrl.PaySalaryRequest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hailang.zhang
 * @since 2024-06-20
 */
public class TestXft {

    public static void main(String[] args) throws Exception {
        //        qryOrg();
//        createStaff();
//        queryStaff();
//        queryNewStaff();
//        createTax();
//        qryReg();
//        paySalary();
        qrySalary();
//        getpro();
//        qryTax();
    }

    private static void qrySalary() {
        execute("{\"multipleAgentBatchSequence\":\"MUL2024070000000021\"}", new HashMap<>(), "/apm/apmuat/xft-service-agentpay/agent-apply/result/query");
    }

    private static void paySalary() {
        execute(JSONUtil.toJsonStr(initPayReuqest()), new HashMap<>(), "/apm/apmuat/xft-service-agentpay/agent-apply/multi-batch");
    }
    private static void getpro() {
        String request = "{\"businessType\":\"0\"}";
        //        String request = "{\"OPORGQRYX\":[]}";
        execute(request, new HashMap<>(), "/apm/apmuat/xft-agentprotocol/agent-protocol/query");
    }

    private static void qryOrg() {
        String request = "{\"OPORGQRYX\":[{\"ORGNAM\": \"智联智享（北京）信息技术有限公司\"}]}";
        //        String request = "{\"OPORGQRYX\":[]}";
        execute(request, new HashMap<>(), "/ORG/orgqry/common/OPORGQRY");
    }

    private static void qryReg() {
        String request = "{}";
        //        String request = "{\"OPORGQRYX\":[]}";
        execute(request, new HashMap<>(), "/itax/itaxuat/tax/v2/TXQRYREG");
    }


    private static void qryTax() {
//        execute("{\"TXQRYBLSX\":[],\"TXREGSEQX\":[{\"REGSEQ\":\"10117110119382538762\"}]}", new HashMap<>(), "/itax/itaxuat/tax/v2/TXQRYBLS");
        execute("{}", new HashMap<>(), "/itax/itaxuat/tax/v2/TXQRYRST");
    }

    private static void createTax() {
        CreateSalaryRequest request = new CreateSalaryRequest();
        initcreateRequest(request);
        execute(JSONUtil.toJsonStr(request), new HashMap<>(), "/itax/itaxuat/tax/v2/TXCUDBAT");
    }

    private static void calTax() {

    }

    private static void createStaff() {

        String request = "[{\"staffBasicInfo\":{\"stfType\":\"0\",\"stfStatus\":\"1\",\"stfName\":\"测试海浪\",\"mobileNumber\":\"\",\"certificateType\":\"O\",\"certificateNumber\":\"828888342201199506167751\", \"sex\":\"0\",\"nationality\":\"CN\",\"jobRankSeq\":\"RNK0000001\",\"stfNumber\":\"\",\"telephoneNumber\":\"\",\"workEmail\":\"sjdkdkdkd@qq.com\",\"remark\":\"从组织架构添加的员工\",\"birthday\":\"1993-08-12\",\"hasMarried\":\"1\",\"hasNurtured\":\"1\",\"nation\":\"01\",\"politicalAppearance\":\"0\",\"presentAddressProvince\":\"北京市\",\"presentAddressCity\":\"北京市\",\"presentAddressDistrict\":\"东城区\",\"presentAddressDetail\":\"CES\",\"householdAddressProvince\":null,\"householdAddressCity\":null,\"householdAddressDistrict\":null,\"householdAddressDetail\":null,\"householdType\":\"0\",\"certificateAddress\":null,\"isCertificateLongTermEffective\":null,\"certificateValidBeginDate\":null,\"certificateValidEndDate\":null,\"individualEmail\":\"11122228@qq.com\",\"firstWorkDate\":\"2017-08-10\",\"workplaceLocationSeq\":\"0000000003\",\"contactAddressProvince\":\"内蒙古自治区\",\"contactAddressCity\":\"鄂尔多斯市\",\"contactAddressDistrict\":\"鄂托克旗\",\"contactAddressDetail\":\"CES\",\"businessGroupSeq\":null,\"formerName\":\"测试\",\"reportSuperiorStfSeq\":\"0000000002\",\"customerFieldInfoList\":[{\"classKey\":\"S01BASIC\",\"fieldKey\":\"FLD000000000017\",\"fieldValue\":\"你好1123\"}]}}]";
        execute(request, new HashMap<>(), "/xfthrm/hrm2uat/xft-employeeprofile/employee/staffGeneralApi/addStaff");
    }

    private static void queryStaff() {
        // 创建 XftQueryStaffRequest 对象
        XftQueryStaffRequest xftQueryStaffRequest = new XftQueryStaffRequest();
        initStaffQuery(xftQueryStaffRequest);
        Map<String, Object> queryParam = new HashMap<>();
        execute(JSONObject.toJSONString(xftQueryStaffRequest), queryParam, "/xfthrm/hrm2uat/xft-employeeprofile/employee/external/api/query/staffInfo");
    }

    private static void queryNewStaff() {
        // 创建 XftQueryStaffRequest 对象
//        XftQueryStaffRequest xftQueryStaffRequest = new XftQueryStaffRequest();
//        initStaffQuery(xftQueryStaffRequest);
        Map<String, Object> queryParam = new HashMap<>();
        execute("{\"TXREGSEQX\":[{\"REGSEQ\":\"10117110119382538762\"}],\"TXSTFQRYX\":[{\"CERTYP\":\"A\",\"CERNBR\":\"828888199506167519\"}]}",
                queryParam, "/itax/itaxuat/tax/v2/TXQRYSTF");
    }

    private static void execute(String requestBody, Map<String, Object> queryParam, String url) {
        /* 1.基本信息内容 */
        /* 薪福通租户号 */
        String companyId = "XFB16630";
        /* 开放平台 appId */
        /* 开放平台 authoritySecret */
        /* 请求路径（以测试环境为例） */
        /* 2.公共信息构建 */
        //        /* 3. 请求报文、queryParam构建：字符串形式(推荐使用方式)*/
        //        String requestBody =  "{\"applyTimStart\":\"2022-4-11\",\"applyTimEnd\":\"2022-4-12 15:00:00\",\"limit\":20}";

        /* 4.调用接口 */
        /* url里面除了公共参数（CSCAPPUID，CSCPRJCOD，CSCUSRUID，CSCREQTIM，CSCUSRNBR）的其他参数 */

    }

    private static void initStaffQuery(XftQueryStaffRequest xftQueryStaffRequest) {
        // 初始化 queryFilterList
        QueryFilter stfName = new QueryFilter();
        stfName.setFieldKey("stfName");
        stfName.setFieldQueryMethod("EQUAL");
        stfName.setFieldValue("测试海");

        QueryFilter certificateNumber = new QueryFilter();
        certificateNumber.setFieldKey("certificateNumber");
        certificateNumber.setFieldQueryMethod("EQUAL");
        certificateNumber.setFieldValue("828888199506167519");
        xftQueryStaffRequest.setQueryFilterList(Arrays.asList(stfName, certificateNumber));
//        xftQueryStaffRequest.setQueryFilterList(Arrays.asList(stfName));

        // 初始化 queryResultType
        QueryResultType queryResultType = new QueryResultType();
        queryResultType.setQueryType("FIELD");
        queryResultType.setQueryFieldList(Arrays.asList("orgSeq", "sex"));
        xftQueryStaffRequest.setQueryResultType(queryResultType);

        // 初始化其他字段
        xftQueryStaffRequest.setCurrentPage("1");
        xftQueryStaffRequest.setPageSize("10");
    }

    private static void initcreateRequest(CreateSalaryRequest request) {
        // 初始化 TXCRTBATX 列表
        List<CreateSalaryRequest.TXCRTBATXBean> txcrtbatxList = new ArrayList<>();
        CreateSalaryRequest.TXCRTBATXBean txcrtbatx = new CreateSalaryRequest.TXCRTBATXBean();
        //业务编号
        txcrtbatx.setBUSNBR("66666666");
        //批次名称 否
        txcrtbatx.setBATNAM("Default Batch Name");
        //税款所属时期
        txcrtbatx.setDURTAX("202406");
        //所得类型
        txcrtbatx.setINCTYP("1");
        //所得项目
        txcrtbatx.setINCITE("01");
        //是否使用本地专项附加扣除值 从[专项附加扣除管理] 列表中获取
        txcrtbatx.setUSLSPE("L");
        //同步薪资后是否立刻算税
        txcrtbatx.setCALIMD("Y");
        txcrtbatxList.add(txcrtbatx);
        request.setTXCRTBATX(txcrtbatxList);

        // 初始化 TXSTFSALX 列表
        List<CreateSalaryRequest.TXSTFSALXBean> dataList = new ArrayList<>();
        CreateSalaryRequest.TXSTFSALXBean data = new CreateSalaryRequest.TXSTFSALXBean();
        //登记序号
        data.setREGSEQ("10117110119382538762");
        data.setSTFNAM("Default Test Person");
        data.setSTFSEQ("0000000013");
//        data.setAPISEQ("0000000013");
        data.setCERTYP("A");
        data.setCERNBR("828888199506167519");
        data.setREVCOU("10000");
//        data.setCRMSSD("100");
//        data.setJBYLBX("100");
//        data.setJBYIBX("100");
//        data.setSYVXYE("100");
//        data.setZFGJJY("100");
//        data.setLJYYEF("100");
//        data.setLJZNJY("100");
//        data.setLJJXJY("100");
//        data.setLJFWDK("100");
//        data.setLJZFZJ("100");
//        data.setZYKCJK("0.00");
//        data.setJMSEZD("100");
//        data.setREMARK("Default Remark");
//        data.setISSAVE(true);
//        data.setACDNAM("0.00");
//        data.setSEQNBR(0);
//        data.setROWNBR(2);
        dataList.add(data);
        request.setTXSTFSALX(dataList);

        // 初始化 TXREGPWDX 列表
        List<CreateSalaryRequest.TXREGPWDXBean> txregpwdxList = new ArrayList<>();
        CreateSalaryRequest.TXREGPWDXBean txregpwdx = new CreateSalaryRequest.TXREGPWDXBean();
        txregpwdx.setREGSEQ("10117110119382538762");
        txregpwdx.setPWDTYP("0");
        txregpwdx.setDCLPWD("Aa123456");
        txregpwdxList.add(txregpwdx);
        request.setTXREGPWDX(txregpwdxList);

        // 输出实例化并初始化后的对象内容
        System.out.println(request.toString());
    }

    private static PaySalaryRequest initPayReuqest() {
        // 初始化 PaySalaryRequest 对象
        PaySalaryRequest request = new PaySalaryRequest();

        // 设置 operatorMobilePhone, sendMessage, uploadEnd, xftAgentPayFlag
        request.setOperatorMobilePhone("15227115265");
        request.setSendMessage("N");
        request.setUploadEnd("Y");
        request.setXftAgentPayFlag("Y");

        // 初始化 AgentListBean 列表
        List<PaySalaryRequest.AgentListBean> agentList = new ArrayList<>();

        // 初始化第一个 AgentListBean 对象
        PaySalaryRequest.AgentListBean agent1 = new PaySalaryRequest.AgentListBean();
        agent1.setBusinessReferenceNo("112266");
        agent1.setAgentProtocolNo("ZA7559");
        agent1.setAgentRemark("测试代发说明123");
        //        agent1.setAgentUsage("AGPAY006");
        agent1.setAppointmentDate("2022-06-26");
        agent1.setAppointmentTime("2022-06-26T21:13");
        agent1.setCurrency("10");
        agent1.setCurrencyFlag("0");
        agent1.setCustomRemark("测试备注0234");
        agent1.setCustomRemarkOne("测试备注1234");
        agent1.setCustomRemarkTwo("测试备注2234");
        agent1.setDigitalAgentFlag("N");
        agent1.setPayAccountNo("75592628632210000");
        agent1.setMobileShortMessage("飞琴核心企业有限公司");
        agent1.setTotalAgentAmount("1100");
        agent1.setTotalAgentCount(1);

        // 初始化第一个 AgentListBean 对象
//        PaySalaryRequest.AgentListBean agent2 = new PaySalaryRequest.AgentListBean();
//        agent2.setBusinessReferenceNo("112234");
//        agent2.setAgentProtocolNo("ZA7559");
//        agent2.setAgentRemark("测试代发说明123");
//        //        agent1.setAgentUsage("AGPAY006");
//        agent2.setAppointmentDate("2022-06-26");
//        agent2.setAppointmentTime("2022-06-26T21:13");
//        agent2.setCurrency("10");
//        agent2.setCurrencyFlag("0");
//        agent2.setCustomRemark("测试备注0234");
//        agent2.setCustomRemarkOne("测试备注1234");
//        agent2.setCustomRemarkTwo("测试备注2234");
//        agent2.setDigitalAgentFlag("N");
//        agent2.setPayAccountNo("75592628632210000");
//        agent2.setMobileShortMessage("飞琴核心企业有限公司");
//        agent2.setTotalAgentAmount("900");
//        agent2.setTotalAgentCount(2);

        // 初始化第一个 AgentListBean 的 DetailListBean 列表
        List<PaySalaryRequest.AgentListBean.DetailListBean> detailList1 = new ArrayList<>();
        PaySalaryRequest.AgentListBean.DetailListBean detail1_1 = new PaySalaryRequest.AgentListBean.DetailListBean();
        detail1_1.setAccountName("华忠润111");
        detail1_1.setAccountNo("62148359819134282");
        detail1_1.setAgentAmount("100");
        detail1_1.setBankAddress("");
        detail1_1.setBankName("");
        detail1_1.setBusinessDetailNo("1");
        detail1_1.setCustomRemark("测试明细备注1");
        detail1_1.setCustomRemarkOne("测试明细备注2");
        detail1_1.setCustomRemarkTwo("测试明细备注3");
        detail1_1.setTransactionText("测试明细摘要123");
        detail1_1.setMobileShortMessage("短信备注测试");
        detailList1.add(detail1_1);

        PaySalaryRequest.AgentListBean.DetailListBean detail1_2 = new PaySalaryRequest.AgentListBean.DetailListBean();
        detail1_2.setAccountName("1");
        detail1_2.setAccountNo("2322322323232323");
        detail1_2.setAgentAmount("1000");
        detail1_2.setBankAddress("");
        detail1_2.setBankName("");
        detail1_2.setBusinessDetailNo("2");
        detail1_2.setCustomRemark("测试明细备注1");
        detail1_2.setCustomRemarkOne("测试明细备注2");
        detail1_2.setCustomRemarkTwo("测试明细备注3");
        detail1_2.setTransactionText("测试明细摘要123");
        detail1_2.setMobileShortMessage("短信备注测试");
        detailList1.add(detail1_2);

        agent1.setDetailList(detailList1);
//        agent2.setDetailList(detailList1);

        // 添加第一个 AgentListBean 到 agentList
        agentList.add(agent1);
//        agentList.add(agent2);

//        // 初始化第二个 AgentListBean 对象
//        PaySalaryRequest.AgentListBean agent2 = new PaySalaryRequest.AgentListBean();
//        agent2.setAgentProtocolNo("ZA2357");
//        agent2.setAgentRemark("测试代发说明123");
//        agent2.setAgentUsage("AGPAY006");
//        agent2.setAppointmentDate("2022-06-27");
//        agent2.setAppointmentTime("2022-06-27T21:13");
//        agent2.setBusinessReferenceNo("TEST2023072600000006");
//        agent2.setCurrency("10");
//        agent2.setCurrencyFlag("0");
//        agent2.setCustomRemark("测试备注");
//        agent2.setCustomRemarkOne("测试备注1");
//        agent2.setCustomRemarkTwo("测试备注2");
//        agent2.setDigitalAgentFlag("N");
//        agent2.setPayAccountNo("75592608402200109");
//        agent2.setMobileShortMessage("测试短信备注123");
//        agent2.setTotalAgentAmount("0.02");
//        agent2.setTotalAgentCount(2);
//
//        // 初始化第二个 AgentListBean 的 DetailListBean 列表
//        List<PaySalaryRequest.AgentListBean.DetailListBean> detailList2 = new ArrayList<>();
//        PaySalaryRequest.AgentListBean.DetailListBean detail2_1 = new PaySalaryRequest.AgentListBean.DetailListBean();
//        detail2_1.setAccountName("清的道芦而觅");
//        detail2_1.setAccountNo("536636363536363");
//        detail2_1.setAgentAmount("0.01");
//        detail2_1.setBankAddress("中国银行");
//        detail2_1.setBankName("深圳市");
//        detail2_1.setBusinessDetailNo("1");
//        detail2_1.setCustomRemark("测试明细备注1");
//        detail2_1.setCustomRemarkOne("测试明细备注2");
//        detail2_1.setCustomRemarkTwo("测试明细备注3");
//        detail2_1.setTransactionText("测试明细摘要123");
//        detail2_1.setMobileShortMessage("短信备注测试");
//        detailList2.add(detail2_1);
//
//        PaySalaryRequest.AgentListBean.DetailListBean detail2_2 = new PaySalaryRequest.AgentListBean.DetailListBean();
//        detail2_2.setAccountName("廖欣好");
//        detail2_2.setAccountNo("6225758379544272");
//        detail2_2.setAgentAmount("0.01");
//        detail2_2.setBankAddress("");
//        detail2_2.setBankName("");
//        detail2_2.setBusinessDetailNo("2");
//        detail2_2.setCustomRemark("测试明细备注1");
//        detail2_2.setCustomRemarkOne("测试明细备注2");
//        detail2_2.setCustomRemarkTwo("测试明细备注3");
//        detail2_2.setTransactionText("测试明细摘要123");
//        detail2_2.setMobileShortMessage("短信备注测试");
//        detailList2.add(detail2_2);
//
//        agent2.setDetailList(detailList2);
//
//        // 添加第二个 AgentListBean 到 agentList
//        agentList.add(agent2);

        // 设置 PaySalaryRequest 的 agentList 和 businessReferenceNoList
        request.setAgentList(agentList);

        List<String> businessReferenceNoList = new ArrayList<>();
        businessReferenceNoList.add("112266");
//        businessReferenceNoList.add("112234");
        request.setBusinessReferenceNoList(businessReferenceNoList);

        // 打印结果
        System.out.println(request);
        return request;
    }
}