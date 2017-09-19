package com.huilian.petitcredit.base.pushmsg.model;

import java.io.Serializable;
import java.util.Date;

public class QuotaInfoModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;// ID

	private String credit_line_uuid;//

	private String batch_no;

	private String data_type;

	private Integer record_count;

	private String report_type;// 上报类型

	private String org_code;// 组织机构代码

	private String contract_no;// 额度协议编号

	private String contract_name;// 额度协议名称

	private String customer_type;// 借款人类别

	private String customer_name;// 借款人名称

	private String certificate_type;// 借款人证件类型

	private String certificate_no;// 借款人证件号码

	private Date contract_sign_date;// 额度协议签订日期

	private Date contract_begin_date;// 额度协议起期

	private Date contract_end_date;// 额度协议止期

	private Float contract_amount;// 额度协议金额

	private String ccy;// 币种

	private Float used_amount;// 已用额度

	private Float remain_amount;// 剩余额度

	private String guar_type;// 担保方式

	private String is_circle;// 是否循环额度

	private String contract_status;// 协议状态

	private String relation_manager;// 客户经理

	private String remark;// 备注
	
	private String body_xml_path;//body xml报文地址

	private String push_status;// 推送状态：-1：未推送 0：推送成功；其他均为推送失败

	private String reserved_field1;// 保留域1

	private String reserved_field2;// 保留域2

	private String reserved_field3;// 保留域3

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCredit_line_uuid() {
		return credit_line_uuid;
	}

	public void setCredit_line_uuid(String credit_line_uuid) {
		this.credit_line_uuid = credit_line_uuid;
	}

	public String getBatch_no() {
		return batch_no;
	}

	public void setBatch_no(String batch_no) {
		this.batch_no = batch_no;
	}

	public String getData_type() {
		return data_type;
	}

	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

	public Integer getRecord_count() {
		return record_count;
	}

	public void setRecord_count(Integer record_count) {
		this.record_count = record_count;
	}

	public String getReport_type() {
		return report_type;
	}

	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}

	public String getOrg_code() {
		return org_code;
	}

	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}

	public String getContract_no() {
		return contract_no;
	}

	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}

	public String getContract_name() {
		return contract_name;
	}

	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
	}

	public String getCustomer_type() {
		return customer_type;
	}

	public void setCustomer_type(String customer_type) {
		this.customer_type = customer_type;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCertificate_type() {
		return certificate_type;
	}

	public void setCertificate_type(String certificate_type) {
		this.certificate_type = certificate_type;
	}

	public String getCertificate_no() {
		return certificate_no;
	}

	public void setCertificate_no(String certificate_no) {
		this.certificate_no = certificate_no;
	}

	public Date getContract_sign_date() {
		return contract_sign_date;
	}

	public void setContract_sign_date(Date contract_sign_date) {
		this.contract_sign_date = contract_sign_date;
	}

	public Date getContract_begin_date() {
		return contract_begin_date;
	}

	public void setContract_begin_date(Date contract_begin_date) {
		this.contract_begin_date = contract_begin_date;
	}

	public Date getContract_end_date() {
		return contract_end_date;
	}

	public void setContract_end_date(Date contract_end_date) {
		this.contract_end_date = contract_end_date;
	}

	public Float getContract_amount() {
		return contract_amount;
	}

	public void setContract_amount(Float contract_amount) {
		this.contract_amount = contract_amount;
	}

	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	public Float getUsed_amount() {
		return used_amount;
	}

	public void setUsed_amount(Float used_amount) {
		this.used_amount = used_amount;
	}

	public Float getRemain_amount() {
		return remain_amount;
	}

	public void setRemain_amount(Float remain_amount) {
		this.remain_amount = remain_amount;
	}

	public String getGuar_type() {
		return guar_type;
	}

	public void setGuar_type(String guar_type) {
		this.guar_type = guar_type;
	}

	public String getIs_circle() {
		return is_circle;
	}

	public void setIs_circle(String is_circle) {
		this.is_circle = is_circle;
	}

	public String getContract_status() {
		return contract_status;
	}

	public void setContract_status(String contract_status) {
		this.contract_status = contract_status;
	}

	public String getRelation_manager() {
		return relation_manager;
	}

	public void setRelation_manager(String relation_manager) {
		this.relation_manager = relation_manager;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	
	public String getBody_xml_path() {
		return body_xml_path;
	}

	public void setBody_xml_path(String body_xml_path) {
		this.body_xml_path = body_xml_path;
	}

	public String getPush_status() {
		return push_status;
	}

	public void setPush_status(String push_status) {
		this.push_status = push_status;
	}

	public String getReserved_field1() {
		return reserved_field1;
	}

	public void setReserved_field1(String reserved_field1) {
		this.reserved_field1 = reserved_field1;
	}

	public String getReserved_field2() {
		return reserved_field2;
	}

	public void setReserved_field2(String reserved_field2) {
		this.reserved_field2 = reserved_field2;
	}

	public String getReserved_field3() {
		return reserved_field3;
	}

	public void setReserved_field3(String reserved_field3) {
		this.reserved_field3 = reserved_field3;
	}

}
