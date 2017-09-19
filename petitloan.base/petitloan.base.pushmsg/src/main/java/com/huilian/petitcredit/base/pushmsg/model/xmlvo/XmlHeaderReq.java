package com.huilian.petitcredit.base.pushmsg.model.xmlvo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso(XmlHeaderReq.class)
public class XmlHeaderReq implements Serializable{
	/**
	 * 报文头请求实体类
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String SERVICE_CODE;//服务代码
	
	
	private String TRAN_CODE;//交易码
	
	
	private String TRAN_TYPE;//交易类型
	
	
	private String TRAN_MODE;//交易模式
	
	
	private String BRANCH_ID;//组织机构代码
	
	
	private String TRAN_DATE;//交易日期
	
	
	private String TRAN_TIMESTAMP;//交易时间
	
	
	private String SERVER_ID;//服务器标识
	
	
	private String WS_ID;//终端标识
	
	
	private String USER_LANG;//用户语言
	
	
	private String SEQ_NO;//渠道流水号
	
	
	private String SOURCE_BRANCH_NO;//源节点编号，保留域，默认为空
	
	
	private String DEST_BRANCH_NO;//目标节点编号，保留域，默认为空
	
	
	private String MODULE_ID;//模块标识
	
	
	private String MESSAGE_TYPE;//报文类型
	
	
	private String MESSAGE_CODE;//报文代码
	
	
	private String FILE_PATH;//文件路径，文件报文使用文件名规则：组织机构代码-YYYYMMDD-数据类型-XX.xml
	
	@XmlElement(name="SERVICE_CODE")
	public String getSERVICE_CODE() {
		return SERVICE_CODE;
	}
	public void setSERVICE_CODE(String sERVICE_CODE) {
		SERVICE_CODE = sERVICE_CODE;
	}
	@XmlElement(name="TRAN_CODE")
	public String getTRAN_CODE() {
		return TRAN_CODE;
	}
	public void setTRAN_CODE(String tRAN_CODE) {
		TRAN_CODE = tRAN_CODE;
	}
	@XmlElement(name="TRAN_TYPE")
	public String getTRAN_TYPE() {
		return TRAN_TYPE;
	}
	public void setTRAN_TYPE(String tRAN_TYPE) {
		TRAN_TYPE = tRAN_TYPE;
	}
	@XmlElement(name="TRAN_MODE")
	public String getTRAN_MODE() {
		return TRAN_MODE;
	}
	public void setTRAN_MODE(String tRAN_MODE) {
		TRAN_MODE = tRAN_MODE;
	}
	@XmlElement(name="BRANCH_ID")
	public String getBRANCH_ID() {
		return BRANCH_ID;
	}
	public void setBRANCH_ID(String bRANCH_ID) {
		BRANCH_ID = bRANCH_ID;
	}
	@XmlElement(name="TRAN_DATE")
	public String getTRAN_DATE() {
		return TRAN_DATE;
	}
	public void setTRAN_DATE(String tRAN_DATE) {
		TRAN_DATE = tRAN_DATE;
	}
	@XmlElement(name="TRAN_TIMESTAMP")
	public String getTRAN_TIMESTAMP() {
		return TRAN_TIMESTAMP;
	}
	public void setTRAN_TIMESTAMP(String tRAN_TIMESTAMP) {
		TRAN_TIMESTAMP = tRAN_TIMESTAMP;
	}
	@XmlElement(name="SERVER_ID")
	public String getSERVER_ID() {
		return SERVER_ID;
	}
	public void setSERVER_ID(String sERVER_ID) {
		SERVER_ID = sERVER_ID;
	}
	@XmlElement(name="WS_ID")
	public String getWS_ID() {
		return WS_ID;
	}
	public void setWS_ID(String wS_ID) {
		WS_ID = wS_ID;
	}
	@XmlElement(name="USER_LANG")
	public String getUSER_LANG() {
		return USER_LANG;
	}
	public void setUSER_LANG(String uSER_LANG) {
		USER_LANG = uSER_LANG;
	}
	@XmlElement(name="SEQ_NO")
	public String getSEQ_NO() {
		return SEQ_NO;
	}
	public void setSEQ_NO(String sEQ_NO) {
		SEQ_NO = sEQ_NO;
	}
	@XmlElement(name="SOURCE_BRANCH_NO")
	public String getSOURCE_BRANCH_NO() {
		return SOURCE_BRANCH_NO;
	}
	public void setSOURCE_BRANCH_NO(String sOURCE_BRANCH_NO) {
		SOURCE_BRANCH_NO = sOURCE_BRANCH_NO;
	}
	@XmlElement(name="DEST_BRANCH_NO")
	public String getDEST_BRANCH_NO() {
		return DEST_BRANCH_NO;
	}
	public void setDEST_BRANCH_NO(String dEST_BRANCH_NO) {
		DEST_BRANCH_NO = dEST_BRANCH_NO;
	}
	@XmlElement(name="MODULE_ID")
	public String getMODULE_ID() {
		return MODULE_ID;
	}
	public void setMODULE_ID(String mODULE_ID) {
		MODULE_ID = mODULE_ID;
	}
	@XmlElement(name="MESSAGE_TYPE")
	public String getMESSAGE_TYPE() {
		return MESSAGE_TYPE;
	}
	public void setMESSAGE_TYPE(String mESSAGE_TYPE) {
		MESSAGE_TYPE = mESSAGE_TYPE;
	}
	@XmlElement(name="MESSAGE_CODE")
	public String getMESSAGE_CODE() {
		return MESSAGE_CODE;
	}
	public void setMESSAGE_CODE(String mESSAGE_CODE) {
		MESSAGE_CODE = mESSAGE_CODE;
	}
	@XmlElement(name="FILE_PATH")
	public String getFILE_PATH() {
		return FILE_PATH;
	}
	public void setFILE_PATH(String fILE_PATH) {
		FILE_PATH = fILE_PATH;
	}
	@Override
	public String toString() {
		return "XmlHeaderReq [SERVICE_CODE=" + SERVICE_CODE + ", TRAN_CODE=" + TRAN_CODE + ", TRAN_TYPE=" + TRAN_TYPE
				+ ", TRAN_MODE=" + TRAN_MODE + ", BRANCH_ID=" + BRANCH_ID + ", TRAN_DATE=" + TRAN_DATE
				+ ", TRAN_TIMESTAMP=" + TRAN_TIMESTAMP + ", SERVER_ID=" + SERVER_ID + ", WS_ID=" + WS_ID
				+ ", USER_LANG=" + USER_LANG + ", SEQ_NO=" + SEQ_NO + ", SOURCE_BRANCH_NO=" + SOURCE_BRANCH_NO
				+ ", DEST_BRANCH_NO=" + DEST_BRANCH_NO + ", MODULE_ID=" + MODULE_ID + ", MESSAGE_TYPE=" + MESSAGE_TYPE
				+ ", MESSAGE_CODE=" + MESSAGE_CODE + ", FILE_PATH=" + FILE_PATH + ", getSERVICE_CODE()="
				+ getSERVICE_CODE() + ", getTRAN_CODE()=" + getTRAN_CODE() + ", getTRAN_TYPE()=" + getTRAN_TYPE()
				+ ", getTRAN_MODE()=" + getTRAN_MODE() + ", getBRANCH_ID()=" + getBRANCH_ID() + ", getTRAN_DATE()="
				+ getTRAN_DATE() + ", getTRAN_TIMESTAMP()=" + getTRAN_TIMESTAMP() + ", getSERVER_ID()=" + getSERVER_ID()
				+ ", getWS_ID()=" + getWS_ID() + ", getUSER_LANG()=" + getUSER_LANG() + ", getSEQ_NO()=" + getSEQ_NO()
				+ ", getSOURCE_BRANCH_NO()=" + getSOURCE_BRANCH_NO() + ", getDEST_BRANCH_NO()=" + getDEST_BRANCH_NO()
				+ ", getMODULE_ID()=" + getMODULE_ID() + ", getMESSAGE_TYPE()=" + getMESSAGE_TYPE()
				+ ", getMESSAGE_CODE()=" + getMESSAGE_CODE() + ", getFILE_PATH()=" + getFILE_PATH() + "]";
	}
	
}
