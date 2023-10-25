package zhilian.z231011;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

/**
 * @author hailang.zhang
 * @since 2023-10-16
 */

@JSONType
@Data
public class Child2 {

//    @JSONField(parseFeatures = Feature.SupportArrayToBean)

    private List<ParentList> lists;

    private String field2;

    @JSONField(parseFeatures = Feature.InitStringFieldAsEmpty )
    private String field4;

    @JSONField(serializeUsing = EnumTest.class, deserializeUsing = EnumTest.ModelValueDeserializer.class)
    private ContractTypeEnum contractTypeEnum;
}