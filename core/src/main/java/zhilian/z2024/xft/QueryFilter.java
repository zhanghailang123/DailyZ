package zhilian.z2024.xft;

/**
 * @author hailang.zhang
 * @since 2024-06-21
 */
public class QueryFilter {
    private String fieldKey;
    private String fieldQueryMethod;
    private String fieldValue;

    // Constructor
    public QueryFilter() {
    }

    // Getters and Setters
    public String getFieldKey() {
        return fieldKey;
    }

    public void setFieldKey(String fieldKey) {
        this.fieldKey = fieldKey;
    }

    public String getFieldQueryMethod() {
        return fieldQueryMethod;
    }

    public void setFieldQueryMethod(String fieldQueryMethod) {
        this.fieldQueryMethod = fieldQueryMethod;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "QueryFilter{" +
                "fieldKey='" + fieldKey + '\'' +
                ", fieldQueryMethod='" + fieldQueryMethod + '\'' +
                ", fieldValue='" + fieldValue + '\'' +
                '}';
    }
}