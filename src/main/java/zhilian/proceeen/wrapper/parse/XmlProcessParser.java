package zhilian.proceeen.wrapper.parse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import zhilian.proceeen.wrapper.ProcessModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hailang.zhang
 * @since 2024-03-27
 */
public abstract class XmlProcessParser implements ProcessParser{

    @Override
    public List<ProcessModel> parse() throws Exception {
        Document document = getDocument();
        Element rootElement = document.getRootElement();
        List<Element> processElements = rootElement.elements();
        List<ProcessModel> processModels = new ArrayList<>();
        for (Element process : processElements) {

        }
        return processModels;
    }

    public abstract Document getDocument() throws DocumentException;
}