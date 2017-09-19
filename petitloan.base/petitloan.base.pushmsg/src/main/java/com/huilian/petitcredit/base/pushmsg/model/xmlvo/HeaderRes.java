package com.huilian.petitcredit.base.pushmsg.model.xmlvo;  
  
import javax.xml.bind.annotation.XmlAccessType;  
import javax.xml.bind.annotation.XmlAccessorType;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;  
import javax.xml.bind.annotation.XmlType;  
  
/** 
 * @author      zhuc 
 * @create      2013-3-29 下午2:51:44 
 */  
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "transaction")  
@XmlType(propOrder = {})  
public class HeaderRes {  
  
    @XmlElement(name = "header")  
    private Header header;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}  
}  