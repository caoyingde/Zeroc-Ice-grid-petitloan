package com.huilian.petitcredit.base.pushmsg.model;

import java.io.Serializable;

public class NetBookInfoModel implements Serializable {

	/**
	 * 网签文件上报
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;// ID

	private String net_book_uuid;//

	private String batch_no;// 批次号

	private String data_type;// 数据类型

	private Integer record_count;// 总记录数

	private String org_code;// 机构组织代码；

	private String contract_no;// 合同编号

	private String loan_cate;// 贷款类别

	private String customer_type;// 借款人类别

	private String customer_name;// 借款人姓名，主借款人

	private String certificate_type;// 主借款人证件类型：150001：身份证；150002；组织机构代码；150003：护照；

	private String certificate_no;// 主借款人证件号码

	private String con_customer_type;// 委托人类别

	private String con_customer_name;// 借款人姓名，主借款人

	private String con_certificate_type;// 主借款人证件类型：150001：身份证；150002；组织机构代码；150003：护照；

	private String con_certificate_no;// 主借款人证件号码
	private Float con_fee;// 代理费

	private Float contract_amount;// 合同金额

	private String contract_sign_date;// 合同签订日期

	private Float int_rate;// 月利率(‰)

	private String body_xml_path; // body xml报文地址

	private String push_status; // 推送状态 -1：未推送 0：推送成功 其它：失败

	private String reserved_field1;// 保留域1

	private String reserved_field2;// 保留域2

	private String reserved_field3;// 保留域3

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNet_book_uuid() {
		return net_book_uuid;
	}

	public void setNet_book_uuid(String net_book_uuid) {
		this.net_book_uuid = net_book_uuid;
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

	public String getLoan_cate() {
		return loan_cate;
	}

	public void setLoan_cate(String loan_cate) {
		this.loan_cate = loan_cate;
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

	public String getCon_customer_type() {
		return con_customer_type;
	}

	public void setCon_customer_type(String con_customer_type) {
		this.con_customer_type = con_customer_type;
	}

	public String getCon_customer_name() {
		return con_customer_name;
	}

	public void setCon_customer_name(String con_customer_name) {
		this.con_customer_name = con_customer_name;
	}

	public String getCon_certificate_type() {
		return con_certificate_type;
	}

	public void setCon_certificate_type(String con_certificate_type) {
		this.con_certificate_type = con_certificate_type;
	}

	public String getCon_certificate_no() {
		return con_certificate_no;
	}

	public void setCon_certificate_no(String con_certificate_no) {
		this.con_certificate_no = con_certificate_no;
	}

	public Float getCon_fee() {
		return con_fee;
	}

	public void setCon_fee(Float con_fee) {
		this.con_fee = con_fee;
	}

	public Float getContract_amount() {
		return contract_amount;
	}

	public void setContract_amount(Float contract_amount) {
		this.contract_amount = contract_amount;
	}

	public String getContract_sign_date() {
		return contract_sign_date;
	}

	public void setContract_sign_date(String contract_sign_date) {
		this.contract_sign_date = contract_sign_date;
	}

	public Float getInt_rate() {
		return int_rate;
	}

	public void setInt_rate(Float int_rate) {
		this.int_rate = int_rate;
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

	@Override
	public String toString() {
		return "NetBookInfoModel [id=" + id + ", net_book_uuid=" + net_book_uuid + ", batch_no=" + batch_no
				+ ", data_type=" + data_type + ", record_count=" + record_count + ", org_code=" + org_code
				+ ", contract_no=" + contract_no + ", loan_cate=" + loan_cate + ", customer_type=" + customer_type
				+ ", customer_name=" + customer_name + ", certificate_type=" + certificate_type + ", certificate_no="
				+ certificate_no + ", con_customer_type=" + con_customer_type + ", con_customer_name="
				+ con_customer_name + ", con_certificate_type=" + con_certificate_type + ", con_certificate_no="
				+ con_certificate_no + ", con_fee=" + con_fee + ", contract_amount=" + contract_amount
				+ ", contract_sign_date=" + contract_sign_date + ", int_rate=" + int_rate + ", body_xml_path="
				+ body_xml_path + ", push_status=" + push_status + ", reserved_field1=" + reserved_field1
				+ ", reserved_field2=" + reserved_field2 + ", reserved_field3=" + reserved_field3 + "]";
	}

}
