package zhilian.proceeen.wrapper.parse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 * @author hailang.zhang
 * @since 2024-03-28
 */
public class ClassPathXmlProcessParser extends XmlProcessParser{

    private final String file;

    public ClassPathXmlProcessParser(String file) {
        this.file = file.startsWith("/") ? file : "/" + file;
    }

    @Override
    public Document getDocument() throws DocumentException {
        InputStream resourceAsStream = getClass().getResourceAsStream(file);
        SAXReader saxReader = new SAXReader();
        return saxReader.read(resourceAsStream);
    }
}