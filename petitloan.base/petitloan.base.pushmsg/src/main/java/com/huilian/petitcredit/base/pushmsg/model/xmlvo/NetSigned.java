package com.huilian.petitcredit.base.pushmsg.model.xmlvo;

import java.io.Serializable;
import java.util.Date;

public class NetSigned implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer ID;//ID
	  
	private String NET_SIGNED_UUID;//NET_SIGNED_UUID
	  
	private String CONTRACT_NO;//合同编号
	  
	private String LOAN_CATE;//贷款类别
	  
	private String CUSTOMER_TYPE;//借款人类别
	  
	private String CUSTOMER_NAME;//借款人名称
	  
	private String CERTIFICATE_TYPE;//借款人证件类型
	  
	private String CERTIFICATE_NO;//借款人证件号码
	  
	private String CON_CUSTOMER_TYPE;//委托人类别
	  
	private String CON_CUSTOMER_NAME;//委托人
	  
	private String CON_CERTIFICATE_TYPE;//委托人证件类型
	  
	private String CON_CERTIFICATE_NO;//委托人证件号码
	  
	private Float CON_FEE;//委托代理费
	  
	private Float CONTRACT_AMOUNT;//合同金额
	  
	private Float INT_RATE;//月利率(‰)
	  
	private Date CONTRACT_SIGN_DATE;//合同签订日期
	  
	private String RESERVED_FIELD1;//保留域1
	  
	private String RESERVED_FIELD2;//保留域2
	  
	private String RESERVED_FIELD3;//保留域3
	  
	public Integer getID() {
		 return ID;
	}
	
	public void setID(Integer ID) {
		 this.ID = ID;
	}
	
	public String getNET_SIGNED_UUID() {
		 return NET_SIGNED_UUID;
	}
	
	public void setNET_SIGNED_UUID(String NET_SIGNED_UUID) {
		 this.NET_SIGNED_UUID = NET_SIGNED_UUID;
	}
	
	public String getCONTRACT_NO() {
		 return CONTRACT_NO;
	}
	
	public void setCONTRACT_NO(String CONTRACT_NO) {
		 this.CONTRACT_NO = CONTRACT_NO;
	}
	
	public String getLOAN_CATE() {
		 return LOAN_CATE;
	}
	
	public void setLOAN_CATE(String LOAN_CATE) {
		 this.LOAN_CATE = LOAN_CATE;
	}
	
	public String getCUSTOMER_TYPE() {
		 return CUSTOMER_TYPE;
	}
	
	public void setCUSTOMER_TYPE(String CUSTOMER_TYPE) {
		 this.CUSTOMER_TYPE = CUSTOMER_TYPE;
	}
	
	public String getCUSTOMER_NAME() {
		 return CUSTOMER_NAME;
	}
	
	public void setCUSTOMER_NAME(String CUSTOMER_NAME) {
		 this.CUSTOMER_NAME = CUSTOMER_NAME;
	}
	
	public String getCERTIFICATE_TYPE() {
		 return CERTIFICATE_TYPE;
	}
	
	public void setCERTIFICATE_TYPE(String CERTIFICATE_TYPE) {
		 this.CERTIFICATE_TYPE = CERTIFICATE_TYPE;
	}
	
	public String getCERTIFICATE_NO() {
		 return CERTIFICATE_NO;
	}
	
	public void setCERTIFICATE_NO(String CERTIFICATE_NO) {
		 this.CERTIFICATE_NO = CERTIFICATE_NO;
	}
	
	public String getCON_CUSTOMER_TYPE() {
		 return CON_CUSTOMER_TYPE;
	}
	
	public void setCON_CUSTOMER_TYPE(String CON_CUSTOMER_TYPE) {
		 this.CON_CUSTOMER_TYPE = CON_CUSTOMER_TYPE;
	}
	
	public String getCON_CUSTOMER_NAME() {
		 return CON_CUSTOMER_NAME;
	}
	
	public void setCON_CUSTOMER_NAME(String CON_CUSTOMER_NAME) {
		 this.CON_CUSTOMER_NAME = CON_CUSTOMER_NAME;
	}
	
	public String getCON_CERTIFICATE_TYPE() {
		 return CON_CERTIFICATE_TYPE;
	}
	
	public void setCON_CERTIFICATE_TYPE(String CON_CERTIFICATE_TYPE) {
		 this.CON_CERTIFICATE_TYPE = CON_CERTIFICATE_TYPE;
	}
	
	public String getCON_CERTIFICATE_NO() {
		 return CON_CERTIFICATE_NO;
	}
	
	public void setCON_CERTIFICATE_NO(String CON_CERTIFICATE_NO) {
		 this.CON_CERTIFICATE_NO = CON_CERTIFICATE_NO;
	}
	
	public Float getCON_FEE() {
		 return CON_FEE;
	}
	
	public void setCON_FEE(Float CON_FEE) {
		 this.CON_FEE = CON_FEE;
	}
	
	public Float getCONTRACT_AMOUNT() {
		 return CONTRACT_AMOUNT;
	}
	
	public void setCONTRACT_AMOUNT(Float CONTRACT_AMOUNT) {
		 this.CONTRACT_AMOUNT = CONTRACT_AMOUNT;
	}
	
	public Float getINT_RATE() {
		 return INT_RATE;
	}
	
	public void setINT_RATE(Float INT_RATE) {
		 this.INT_RATE = INT_RATE;
	}
	
	public Date getCONTRACT_SIGN_DATE() {
		 return CONTRACT_SIGN_DATE;
	}
	
	public void setCONTRACT_SIGN_DATE(Date CONTRACT_SIGN_DATE) {
		 this.CONTRACT_SIGN_DATE = CONTRACT_SIGN_DATE;
	}
	
	public String getRESERVED_FIELD1() {
		 return RESERVED_FIELD1;
	}
	
	public void setRESERVED_FIELD1(String RESERVED_FIELD1) {
		 this.RESERVED_FIELD1 = RESERVED_FIELD1;
	}
	
	public String getRESERVED_FIELD2() {
		 return RESERVED_FIELD2;
	}
	
	public void setRESERVED_FIELD2(String RESERVED_FIELD2) {
		 this.RESERVED_FIELD2 = RESERVED_FIELD2;
	}
	
	public String getRESERVED_FIELD3() {
		 return RESERVED_FIELD3;
	}
	
	public void setRESERVED_FIELD3(String RESERVED_FIELD3) {
		 this.RESERVED_FIELD3 = RESERVED_FIELD3;
	}
	
}