package zhilian.z2023.z231011;

import lombok.Data;

import java.util.List;

/**
 * @author hailang.zhang
 * @since 2023-10-16
 */
@Data
public class Parent {

    private String field1;
    private String field2;
    private String field3;

    List<ParentList> lists;

    @Override
    public String toString() {
        return "{\"field1\":\"\",\"field2\":\"\",\"field3\":\"\",\"lists\":[{\"name\":\"\"}]}";
    }
}