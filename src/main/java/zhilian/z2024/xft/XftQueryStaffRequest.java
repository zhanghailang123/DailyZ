package zhilian.z2024.xft;

/**
 * @author hailang.zhang
 * @since 2024-06-21
 */
import java.util.List;

public class XftQueryStaffRequest {
    private List<QueryFilter> queryFilterList;
    private QueryResultType queryResultType;
    private String currentPage;
    private String pageSize;

    // Constructor
    public XftQueryStaffRequest() {
    }

    // Getters and Setters
    public List<QueryFilter> getQueryFilterList() {
        return queryFilterList;
    }

    public void setQueryFilterList(List<QueryFilter> queryFilterList) {
        this.queryFilterList = queryFilterList;
    }

    public QueryResultType getQueryResultType() {
        return queryResultType;
    }

    public void setQueryResultType(QueryResultType queryResultType) {
        this.queryResultType = queryResultType;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "XftQueryStaffRequest{" +
                "queryFilterList=" + queryFilterList +
                ", queryResultType=" + queryResultType +
                ", currentPage='" + currentPage + '\'' +
                ", pageSize='" + pageSize + '\'' +
                '}';
    }
}