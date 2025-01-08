package zhilian.z2024.xft;

import java.util.List;

/**
 * @author hailang.zhang
 * @since 2024-06-21
 */
public class RequestStaff {

    /**
     * queryType : FIELD
     * queryFieldList : ["sex","seniorityBeginDate","firstWorkDate"]
     */

    private QueryResultTypeBean queryResultType;

    /**
     * queryFilterList : [{"fieldKey":"stfSeq","fieldQueryMethod":"EQUAL","fieldValue":"0000000024"}]
     * queryResultType : {"queryType":"FIELD","queryFieldList":["sex","seniorityBeginDate","firstWorkDate"]}
     * currentPage : 1
     * pageSize : 10
     */

    private String currentPage;

    private String pageSize;

    /**
     * fieldKey : stfSeq
     * fieldQueryMethod : EQUAL
     * fieldValue : 0000000024
     */

    private List<QueryFilterListBean> queryFilterList;

    public QueryResultTypeBean getQueryResultType() {return queryResultType;}

    public void setQueryResultType(QueryResultTypeBean queryResultType) {this.queryResultType = queryResultType;}

    public String getCurrentPage() {return currentPage;}

    public void setCurrentPage(String currentPage) {this.currentPage = currentPage;}

    public String getPageSize() {return pageSize;}

    public void setPageSize(String pageSize) {this.pageSize = pageSize;}

    public List<QueryFilterListBean> getQueryFilterList() {return queryFilterList;}

    public void setQueryFilterList(List<QueryFilterListBean> queryFilterList) {this.queryFilterList = queryFilterList;}

    public static class QueryResultTypeBean {

        private String queryType;

        private List<String> queryFieldList;

        public String getQueryType() {return queryType;}

        public void setQueryType(String queryType) {this.queryType = queryType;}

        public List<String> getQueryFieldList() {return queryFieldList;}

        public void setQueryFieldList(List<String> queryFieldList) {this.queryFieldList = queryFieldList;}
    }

    public static class QueryFilterListBean {

        private String fieldKey;

        private String fieldQueryMethod;

        private String fieldValue;

        public String getFieldKey() {return fieldKey;}

        public void setFieldKey(String fieldKey) {this.fieldKey = fieldKey;}

        public String getFieldQueryMethod() {return fieldQueryMethod;}

        public void setFieldQueryMethod(String fieldQueryMethod) {this.fieldQueryMethod = fieldQueryMethod;}

        public String getFieldValue() {return fieldValue;}

        public void setFieldValue(String fieldValue) {this.fieldValue = fieldValue;}
    }
}