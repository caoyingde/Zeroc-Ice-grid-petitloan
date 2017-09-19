package com.huilian.petitcredit.base.pushmsg.model.xmlvo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class RepayInfoList implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@NotNull(message = "上报类型不能为空")  
	@Length(min=1, max=6, message="report_type字段长度1-6")  
	private String report_type;//上报类型
	

	@NotNull(message = "机构组织代码不能为空")  
	@Length(min=1, max=20, message="org_code字段长度1-20")  
	private String org_code;//机构组织代码；
	

	@NotNull(message = "合同编号不能为空")  
	@Length(min=1, max=100, message="contract_no字段长度1-100")  
	private String contract_no;//合同编号
	

	@NotNull(message = "发放编号不能为空")  
	@Length(min=1, max=100, message="due_bill_no字段长度1-100")  
	private String due_bill_no;//发放编号
	

	@NotNull(message = "还款日期不能为空")  
	@Length(min=1, max=8, message="repay_date字段长度1-8")  
	private String repay_date;//还款日期
	

	/*@NotNull(message = "还款期数不能为空")  
	@Length(min=1, max=5, message="counter字段长度1-5")  */
	private Integer counter;//还款期数
	

	@NotNull(message = "用户类型不能为空")  
	@Length(min=1, max=6, message="customer_type字段长度1-6")  
	private String customer_type;//用户类型：480001：个人；480002：企业
	

	@NotNull(message = "借款人姓名不能为空")  
	@Length(min=1, max=50, message="customer_name字段长度1-50")  
	private String customer_name;//借款人姓名，主借款人
	

	@NotNull(message = "主借款人证件类型不能为空")  
	@Length(min=1, max=6, message="certificate_type字段长度1-6")  
	private String certificate_type;//主借款人证件类型：150001：身份证；150002；组织机构代码；150003：护照；
	

	@NotNull(message = "主借款人证件号码不能为空")  
	@Length(min=1, max=50, message="certificate_no字段长度1-50")  
	private String certificate_no;//主借款人证件号码
	

	@NotNull(message = "扣款方式不能为空")  
	@Length(min=1, max=6, message="gather_mode字段长度1-6")  
	private String gather_mode;//扣款方式：430001：银行代扣；430002：银联代扣；430003：现金；430004：银行转账；430005：其他
	

	@NotNull(message = "收回本金(元)不能为空")  
	private float repay_pri_amt;//收回本金(元)
	

	@NotNull(message = "收回利息(元)不能为空")  
	private float repay_int_amt;//收回利息(元)
	

	@NotNull(message = "起息日期不能为空")  
	@Length(min=1, max=8, message="start_date字段长度1-8")  
	private String start_date;//起息日期
	

	@NotNull(message = "止息日期不能为空")  
	@Length(min=1, max=8, message="end_date字段长度1-8")  
	private String end_date;//止息日期
	

	@NotNull(message = "回收类型不能为空")  
	@Length(min=1, max=6, message="receipt_type字段长度1-6")  
	private String receipt_type;//回收类型：550001：正常回款；550002：逾期回款；550003：提前结清；550004：不良核销；550005：资产转让
	

	private Integer delay_days;//逾期天数
	

	private float delay_amt;//逾期本金（元）
	

	private float delay_interest;//逾期利息（元）
	
	private float delay_fee;//逾期滞纳金（元）
	

	private float pri_plty_rate;//逾期月利率(‰)
	
	private String remark;//备注
	
	private String reserved_field1;//保留域1
	
	private String reserved_field2;//保留域2
	
	private String reserved_field3;//保留域3


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


	public String getRepay_date() {
		return repay_date;
	}

	public void setRepay_date(String repay_date) {
		this.repay_date = repay_date;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
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
