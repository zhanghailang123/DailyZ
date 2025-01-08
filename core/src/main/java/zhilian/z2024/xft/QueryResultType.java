package zhilian.z2024.xft;

/**
 * @author hailang.zhang
 * @since 2024-06-21
 */
import java.util.List;

public class QueryResultType {
    private String queryType;
    private List<String> queryFieldList;

    // Constructor
    public QueryResultType() {
    }

    // Getters and Setters
    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public List<String> getQueryFieldList() {
        return queryFieldList;
    }

    public void setQueryFieldList(List<String> queryFieldList) {
        this.queryFieldList = queryFieldList;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "QueryResultType{" +
                "queryType='" + queryType + '\'' +
                ", queryFieldList=" + queryFieldList +
                '}';
    }
}