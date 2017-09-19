package com.huilian.petitcredit.base.pushmsg.utils;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.namespace.QName;

import org.apache.commons.lang3.StringUtils;

public class JaxbUtil {
	 // 多线程安全的Context.  
    private JAXBContext jaxbContext;  
    /** 
     * @param types 
     *            所有需要序列化的Root对象的类型. 
     */  
    public JaxbUtil(Class<?>... types) {  
        try {  
            jaxbContext = JAXBContext.newInstance(types);  
        } catch (JAXBException e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    /** 
     * Java Object->Xml. 
     */  
    public String toXml(Object root, String encoding) {  
        try {  
            StringWriter writer = new StringWriter();  
            createMarshaller(encoding).marshal(root, writer);  
            return writer.toString();  
        } catch (JAXBException e) {  
            throw new RuntimeException(e);  
        }  
    }  
    
    /** 
     * Java Object->Xml, 特别支持对Root Element是Collection的情形. 
     */  
    @SuppressWarnings({ "rawtypes" })  
    public String toXml(Collection root, String rootName, String encoding) {  
        try {  
            CollectionWrapper wrapper = new CollectionWrapper();  
            wrapper.collection = root;  
  
            JAXBElement<CollectionWrapper> wrapperElement = new JAXBElement<CollectionWrapper>(  
                    new QName(rootName), CollectionWrapper.class, wrapper);  
  
            StringWriter writer = new StringWriter();  
            createMarshaller(encoding).marshal(wrapperElement, writer);  
  
            return writer.toString();  
        } catch (JAXBException e) {  
            throw new RuntimeException(e);  
        }  
    }  
    /** 
     * Xml->Java Object. 
     */  
    @SuppressWarnings("unchecked")  
    public <T> T fromXml(String xml) {  
        try {  
            StringReader reader = new StringReader(xml);  
            return (T) createUnmarshaller().unmarshal(reader);  
        } catch (JAXBException e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    /** 
     * Xml->Java Object, 支持大小写敏感或不敏感. 
     */  
    @SuppressWarnings("unchecked")  
    public <T> T fromXml(String xml, boolean caseSensitive) {  
        try {  
            String fromXml = xml;  
            if (!caseSensitive)  
                fromXml = xml.toLowerCase();  
            StringReader reader = new StringReader(fromXml);  
            return (T) createUnmarshaller().unmarshal(reader);  
        } catch (JAXBException e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    /** 
     * 创建Marshaller, 设定encoding(可为Null). 
     */  
    public Marshaller createMarshaller(String encoding) {  
        try {  
            Marshaller marshaller = jaxbContext.createMarshaller();  
  
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);  
  
            if (StringUtils.isNotBlank(encoding)) {  
                marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);  
            }  
            return marshaller;  
        } catch (JAXBException e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    /** 
     * 创建UnMarshaller. 
     */  
    public Unmarshaller createUnmarshaller() {  
        try {  
            return jaxbContext.createUnmarshaller();  
        } catch (JAXBException e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    /** 
     * 封装Root Element 是 Collection的情况. 
     */  
    public static class CollectionWrapper {  
        @SuppressWarnings({ "rawtypes" })  
        @XmlAnyElement  
        protected Collection collection;  
    }  
    /** 
     * xml转换成JavaBean 
     * @param xml 
     * @param c 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public static <T> T converyToJavaBean(String xml, Class<T> c) {  
        T t = null;  
        try {  
            JAXBContext context = JAXBContext.newInstance(c);  
            Unmarshaller unmarshaller = context.createUnmarshaller();  
            t = (T) unmarshaller.unmarshal(new StringReader(xml));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return t;  
    }  
    /** 
     * JavaBean转换成xml 
     * 默认编码UTF-8 
     * @param obj 
     * @param writer 
     * @return  
     */  
    public static String convertToXml(Object obj) {  
        return convertToXml(obj, "UTF-8");  
    }  
  
    /** 
     * JavaBean转换成xml 
     * @param obj 
     * @param encoding  
     * @return  
     */  
    public static String convertToXml(Object obj, String encoding) {  
        String result = null;  
        try {  
            JAXBContext context = JAXBContext.newInstance(obj.getClass());  
            Marshaller marshaller = context.createMarshaller();  
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);  
  
            StringWriter writer = new StringWriter();  
            marshaller.marshal(obj, writer);  
            result = writer.toString();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return result;  
    } 
    /**
     * 
     * @param xml去换行空隔
     * @return
     */
	public static String trimStr(String xml){  
	    StringBuffer sb= new StringBuffer();  
	    for(String s:xml.split("\n")){  
	        sb.append(s.trim());  
	    }  
	    return  sb.toString();  
	}  

}
