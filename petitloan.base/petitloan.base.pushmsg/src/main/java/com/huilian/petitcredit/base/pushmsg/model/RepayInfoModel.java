package com.huilian.petitcredit.base.pushmsg.model;

import java.io.Serializable;
import java.util.Date;

public class RepayInfoModel implements Serializable {

	/**
	 * 4.5贷款回收信息上报（PTLN104）
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;// ID

	private String loan_recovery_uuid;//

	private String batch_no;

	private String data_type;

	private Integer record_count;

	private String report_type;// 上报类型

	private String org_code;// 机构组织代码；

	private String contract_no;// 合同编号

	private String due_bill_no;// 发放编号

	private Date repay_date;// 还款日期

	private Integer counter;// 还款期数

	private String customer_type;// 用户类型：480001：个人；480002：企业

	private String customer_name;// 借款人姓名，主借款人

	private String certificate_type;// 主借款人证件类型：150001：身份证；150002；组织机构代码；150003：护照；

	private String certificate_no;// 主借款人证件号码

	private String gather_mode;// 扣款方式：430001：银行代扣；430002：银联代扣；430003：现金；430004：银行转账；430005：其他

	private float repay_pri_amt;// 收回本金(元)

	private float repay_int_amt;// 收回利息(元)

	private Date start_date;// 起息日期

	private Date end_date;// 止息日期

	private String receipt_type;// 回收类型：550001：正常回款；550002：逾期回款；550003：提前结清；550004：不良核销；550005：资产转让

	private Integer delay_days;// 逾期天数

	private float delay_amt;// 逾期本金（元）

	private float delay_interest;// 逾期利息（元）

	private float delay_fee;// 逾期滞纳金（元）

	private float pri_plty_rate;// 逾期月利率(‰)

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

	public String getLoan_recovery_uuid() {
		return loan_recovery_uuid;
	}

	public void setLoan_recovery_uuid(String loan_recovery_uuid) {
		this.loan_recovery_uuid = loan_recovery_uuid;
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

	public String getDue_bill_no() {
		return due_bill_no;
	}

	public void setDue_bill_no(String due_bill_no) {
		this.due_bill_no = due_bill_no;
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
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

	public String getGather_mode() {
		return gather_mode;
	}

	public void setGather_mode(String gather_mode) {
		this.gather_mode = gather_mode;
	}

	public float getRepay_pri_amt() {
		return repay_pri_amt;
	}

	public void setRepay_pri_amt(float repay_pri_amt) {
		this.repay_pri_amt = repay_pri_amt;
	}

	public float getRepay_int_amt() {
		return repay_int_amt;
	}

	public void setRepay_int_amt(float repay_int_amt) {
		this.repay_int_amt = repay_int_amt;
	}

	public Date getRepay_date() {
		return repay_date;
	}

	public void setRepay_date(Date repay_date) {
		this.repay_date = repay_date;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getReceipt_type() {
		return receipt_type;
	}

	public void setReceipt_type(String receipt_type) {
		this.receipt_type = receipt_type;
	}

	public Integer getDelay_days() {
		return delay_days;
	}

	public void setDelay_days(Integer delay_days) {
		this.delay_days = delay_days;
	}

	public float getDelay_amt() {
		return delay_amt;
	}

	public void setDelay_amt(float delay_amt) {
		this.delay_amt = delay_amt;
	}

	public float getDelay_interest() {
		return delay_interest;
	}

	public void setDelay_interest(float delay_interest) {
		this.delay_interest = delay_interest;
	}

	public float getDelay_fee() {
		return delay_fee;
	}

	public void setDelay_fee(float delay_fee) {
		this.delay_fee = delay_fee;
	}

	public float getPri_plty_rate() {
		return pri_plty_rate;
	}

	public void setPri_plty_rate(float pri_plty_rate) {
		this.pri_plty_rate = pri_plty_rate;
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
