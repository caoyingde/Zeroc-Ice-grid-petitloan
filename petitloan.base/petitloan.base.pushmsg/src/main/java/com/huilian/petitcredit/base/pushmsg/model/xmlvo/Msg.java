package com.huilian.petitcredit.base.pushmsg.model.xmlvo;

import java.util.List;

public class Msg {
	private List<RetList> RET;
	private String TRAN_TIMESTAMP;//交易时间
	private String MESSAGE_TYPE;//报文类型
	private String SOURCE_BRANCH_NO;//源节点编号 保留域，默认为空
	private String BRANCH_ID;//组织机构代码
	private String MESSAGE_CODE;//报文代码
	private String RET_STATUS;//交易状态 成功：S  失败：F
	private String SERVICE_CODE;//服务代码
	private String FILE_PATH;////文件路径，文件报文使用文件名规则：组织机构代码-YYYYMMDD-数据类型-XX.xml
	private String DEST_BRANCH_NO;//目标节点编号 保留域，默认为空
	private String TRAN_DATE;//交易日期
	private String SEQ_NO;//渠道流水号
	
	public List<RetList> getRET() {
		return RET;
	}
	public void setRET(List<RetList> rET) {
		RET = rET;
	}
	public String getTRAN_TIMESTAMP() {
		return TRAN_TIMESTAMP;
	}
	public void setTRAN_TIMESTAMP(String tRAN_TIMESTAMP) {
		TRAN_TIMESTAMP = tRAN_TIMESTAMP;
	}
	public String getMESSAGE_TYPE() {
		return MESSAGE_TYPE;
	}
	public void setMESSAGE_TYPE(String mESSAGE_TYPE) {
		MESSAGE_TYPE = mESSAGE_TYPE;
	}
	public String getSOURCE_BRANCH_NO() {
		return SOURCE_BRANCH_NO;
	}
	public void setSOURCE_BRANCH_NO(String sOURCE_BRANCH_NO) {
		SOURCE_BRANCH_NO = sOURCE_BRANCH_NO;
	}
	public String getBRANCH_ID() {
		return BRANCH_ID;
	}
	public void setBRANCH_ID(String bRANCH_ID) {
		BRANCH_ID = bRANCH_ID;
	}
	public String getMESSAGE_CODE() {
		return MESSAGE_CODE;
	}
	public void setMESSAGE_CODE(String mESSAGE_CODE) {
		MESSAGE_CODE = mESSAGE_CODE;
	}
	public String getRET_STATUS() {
		return RET_STATUS;
	}
	public void setRET_STATUS(String rET_STATUS) {
		RET_STATUS = rET_STATUS;
	}
	public String getSERVICE_CODE() {
		return SERVICE_CODE;
	}
	public void setSERVICE_CODE(String sERVICE_CODE) {
		SERVICE_CODE = sERVICE_CODE;
	}
	public String getFILE_PATH() {
		return FILE_PATH;
	}
	public void setFILE_PATH(String fILE_PATH) {
		FILE_PATH = fILE_PATH;
	}
	public String getDEST_BRANCH_NO() {
		return DEST_BRANCH_NO;
	}
	public void setDEST_BRANCH_NO(String dEST_BRANCH_NO) {
		DEST_BRANCH_NO = dEST_BRANCH_NO;
	}
	public String getTRAN_DATE() {
		return TRAN_DATE;
	}
	public void setTRAN_DATE(String tRAN_DATE) {
		TRAN_DATE = tRAN_DATE;
	}
	public String getSEQ_NO() {
		return SEQ_NO;
	}
	public void setSEQ_NO(String sEQ_NO) {
		SEQ_NO = sEQ_NO;
	}
	
}
