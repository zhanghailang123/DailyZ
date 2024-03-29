package zhilian.proceeen.wrapper.parse;

import org.dom4j.DocumentException;
import zhilian.proceeen.wrapper.ProcessModel;

import java.util.List;

/**
 * @author hailang.zhang
 * @since 2024-03-27
 */
public interface ProcessParser {

    List<ProcessModel> parse() throws Exception;
}
