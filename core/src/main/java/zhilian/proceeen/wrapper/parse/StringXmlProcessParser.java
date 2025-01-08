package zhilian.proceeen.wrapper.parse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.StringReader;

/**
 * @author hailang.zhang
 * @since 2024-03-28
 */
public class StringXmlProcessParser extends XmlProcessParser{

    private String xmlConfig;

    public StringXmlProcessParser(String xmlConfig) {
        this.xmlConfig = xmlConfig;
    }

    @Override
    public Document getDocument() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        StringReader reader = new StringReader(xmlConfig);
        return saxReader.read(reader);
    }
}