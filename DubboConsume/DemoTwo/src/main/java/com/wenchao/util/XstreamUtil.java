package com.wenchao.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XstreamUtil {

    private static final Logger logger = LoggerFactory.getLogger(XstreamUtil.class);
    
    
    public static String toXml(Object obj) {
        try {
            XStream xstream = new XStream(new DomDriver("utf8"));
            xstream.processAnnotations(obj.getClass()); // 识别obj类中的注解
            /*
             // 以压缩的方式输出XML
             StringWriter sw = new StringWriter();
             xstream.marshal(obj, new CompactWriter(sw));
             return sw.toString();
             */
            // 以格式化的方式输出XML
            return xstream.toXML(obj);
        } catch (Exception e) {
           logger.error("xstream javaBean to xml is error");
        }
       return null;
    }


    public static <T> T toBean(String xmlStr, Class<T> cls) {
        try {
            XStream xstream = new XStream(new DomDriver("utf8"));
            xstream.processAnnotations(cls);
            @SuppressWarnings("unchecked")
            T t = (T) xstream.fromXML(xmlStr);
            return t;
        } catch (Exception e) {
            logger.error("xstream xml to javaBean is error",e);
            throw new RuntimeException("返回的数据异常");
        }
    }
}
