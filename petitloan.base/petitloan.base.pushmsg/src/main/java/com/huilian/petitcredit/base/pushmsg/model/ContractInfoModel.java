package com.huilian.petitcredit.base.pushmsg.model;

import java.io.Serializable;
import java.util.Date;

public class ContractInfoModel implements Serializable {
	/**
	 * 贷款合同信息上报
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;// id

	private String loan_contract_uuid;// loan_contract_uuid

	private String batch_no;// 批次号

	private String data_type;// 数据类型

	private Integer record_count;// 总记录数

	private String report_type;// 上报类型

	private String org_code;// 组织机构代码

	private String contract_no;// 合同编号

	private String loan_cate;// 贷款类别

	private String contract_name;// 合同名称

	private String customer_type;// 借款人类别

	private String customer_name;// 借款人名称

	private String certificate_type;// 借款人证件类型

	private String certificate_no;// 借款人证件号码

	private String linkman;// 联系人

	private String telephone;// 联系电话

	private String loan_object;// 贷款对象

	private String loan_object_size;// 贷款对象规模

	private Date contract_sign_date;// 合同签订日期

	private Date contract_begin_date;// 合同有效起始日期

	private Date contract_end_date;// 合同有效结束日期

	private Float contract_amount;// 合同金额

	private Float outstanding;// 贷款余额

	private String guar_type;// 担保方式

	private String ccy;// 币种

	private String is_real_quota_loan;// 是否额度项下贷款

	private String real_quota_no;// 授信额度协议编号

	private Float int_rate;// 月利率(‰)

	private Float pri_plty_rate;// 逾期月利率(‰)

	private String contract_status;// 合同状态

	private String relation_manager;// 客户经理

	private String dispute_scheme;// 争议解决方式

	private String remark;// 备注

	private String con_customer_type;// 委托人类别

	private String con_customer_name;// 委托人

	private String con_certificate_type;// 委托人证件类型

	private String con_certificate_no;// 委托人证件号码

	private String con_jurisitc;// 委托方法定代表人/负责人

	private String con_telephone;// 委托人联系电话

	private String con_locus;// 委托人地址

	private String con_postalcode;// 委托人邮编

	private String con_fincal_org;// 委托人开户金融机构

	private String con_account_no;// 委托人账户

	private String ass_customer_name;// 受托人

	private String ass_juristic;// 受托人法定代表人/负责人

	private String ass_telephone;// 受托人联系电话

	private String ass_locus;// 受托人地址

	private String ass_postalcode;// 受托人邮编

	private Float con_fee;// 代理费
	
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

	public String getLoan_contract_uuid() {
		return loan_contract_uuid;
	}

	public void setLoan_contract_uuid(String loan_contract_uuid) {
		this.loan_contract_uuid = loan_contract_uuid;
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

	public String getLoan_cate() {
		return loan_cate;
	}

	public void setLoan_cate(String loan_cate) {
		this.loan_cate = loan_cate;
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

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLoan_object() {
		return loan_object;
	}

	public void setLoan_object(String loan_object) {
		this.loan_object = loan_object;
	}

	public String getLoan_object_size() {
		return loan_object_size;
	}

	public void setLoan_object_size(String loan_object_size) {
		this.loan_object_size = loan_object_size;
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

	public Float getOutstanding() {
		return outstanding;
	}

	public void setOutstanding(Float outstanding) {
		this.outstanding = outstanding;
	}

	public String getGuar_type() {
		return guar_type;
	}

	public void setGuar_type(String guar_type) {
		this.guar_type = guar_type;
	}

	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	public String getIs_real_quota_loan() {
		return is_real_quota_loan;
	}

	public void setIs_real_quota_loan(String is_real_quota_loan) {
		this.is_real_quota_loan = is_real_quota_loan;
	}

	public String getReal_quota_no() {
		return real_quota_no;
	}

	public void setReal_quota_no(String real_quota_no) {
		this.real_quota_no = real_quota_no;
	}

	public Float getInt_rate() {
		return int_rate;
	}

	public void setInt_rate(Float int_rate) {
		this.int_rate = int_rate;
	}

	public Float getPri_plty_rate() {
		return pri_plty_rate;
	}

	public void setPri_plty_rate(Float pri_plty_rate) {
		this.pri_plty_rate = pri_plty_rate;
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

	public String getDispute_scheme() {
		return dispute_scheme;
	}

	public void setDispute_scheme(String dispute_scheme) {
		this.dispute_scheme = dispute_scheme;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getCon_jurisitc() {
		return con_jurisitc;
	}

	public void setCon_jurisitc(String con_jurisitc) {
		this.con_jurisitc = con_jurisitc;
	}

	public String getCon_telephone() {
		return con_telephone;
	}

	public void setCon_telephone(String con_telephone) {
		this.con_telephone = con_telephone;
	}

	public String getCon_locus() {
		return con_locus;
	}

	public void setCon_locus(String con_locus) {
		this.con_locus = con_locus;
	}

	public String getCon_postalcode() {
		return con_postalcode;
	}

	public void setCon_postalcode(String con_postalcode) {
		this.con_postalcode = con_postalcode;
	}

	public String getCon_fincal_org() {
		return con_fincal_org;
	}

	public void setCon_fincal_org(String con_fincal_org) {
		this.con_fincal_org = con_fincal_org;
	}

	public String getCon_account_no() {
		return con_account_no;
	}

	public void setCon_account_no(String con_account_no) {
		this.con_account_no = con_account_no;
	}

	public String getAss_customer_name() {
		return ass_customer_name;
	}

	public void setAss_customer_name(String ass_customer_name) {
		this.ass_customer_name = ass_customer_name;
	}

	public String getAss_juristic() {
		return ass_juristic;
	}

	public void setAss_juristic(String ass_juristic) {
		this.ass_juristic = ass_juristic;
	}

	public String getAss_telephone() {
		return ass_telephone;
	}

	public void setAss_telephone(String ass_telephone) {
		this.ass_telephone = ass_telephone;
	}

	public String getAss_locus() {
		return ass_locus;
	}

	public void setAss_locus(String ass_locus) {
		this.ass_locus = ass_locus;
	}

	public String getAss_postalcode() {
		return ass_postalcode;
	}

	public void setAss_postalcode(String ass_postalcode) {
		this.ass_postalcode = ass_postalcode;
	}

	public Float getCon_fee() {
		return con_fee;
	}

	public void setCon_fee(Float con_fee) {
		this.con_fee = con_fee;
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
