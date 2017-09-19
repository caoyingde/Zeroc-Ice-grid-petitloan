package com.huilian.petitcredit.base.pushmsg.model.xmlvo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class PayPlanInfoList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message = "上报类型不能为空")  
	@Length(min=1, max=6, message="report_type字段长度1-6")  
	private String report_type;//上报类型
	
	@NotNull(message = "组织机构代码不能为空")  
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
	private int counter;//还款期数
	
	@NotNull(message = "上报类型不能为空")  
	private float repay_pri_amt;//应还本金
	
	@NotNull(message = "上报类型不能为空")  
	private float repay_int_amt;//应还利息
	
	@NotNull(message = "起息日期不能为空")  
	@Length(min=1, max=10, message="start_date字段长度1-10")  
	private String start_date;//起息日期
	
	@NotNull(message = "止息日期不能为空")  
	@Length(min=1, max=10, message="end_date字段长度1-10")  
	private String end_date;//止息日期
	
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


	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
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
