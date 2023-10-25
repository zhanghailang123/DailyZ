package zhilian.z231011;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author hailang.zhang
 * @since 2023-10-25
 */
public class EnumTest implements ObjectSerializer {

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (object instanceof Enum) {
            SerializeWriter out = serializer.out;

            if (object == null) {
                out.writeNull();
                return;
            }
            serializer.write(1);
        }
    }

    public static class ModelValueDeserializer implements ObjectDeserializer {

        @Override
        public ContractTypeEnum deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
            ContractTypeEnum contractTypeEnum = ContractTypeEnum.of(parser.getLexer().intValue());
            if (contractTypeEnum != null) {
                return contractTypeEnum;
            }
            return parser.parseObject(type, fieldName);
        }

        @Override
        public int getFastMatchToken() {
            return 0;
        }
    }
}