package com.huilian.petitcredit.base.pushmsg.model;

import java.io.Serializable;
import java.util.Date;

public class PayPlanInfoModel implements Serializable {
	/**
	 * 还款计划信息上报（PTLN105）
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String repayment_plan_uuid;

	private String batch_no;

	private String data_type;

	private Integer record_count;

	private String report_type;// 上报类型

	private String org_code;// 机构组织代码；

	private String contract_no;// 合同编号

	private String due_bill_no;// 发放编号

	private Date repay_date;// 还款日期

	private Integer counter;// 还款期数

	private float repay_pri_amt;// 应还本金

	private float repay_int_amt;// 应还利息

	private Date start_date;// 起息日期

	private Date end_date;// 止息日期
	
	private String body_xml_path;//body xml报文地址

	private String push_status;// 推送状态：-1：未推送 0：推送成功；其他均为推送失败

	private String reserved_field1;// 保留域1

	private String reserved_field2;// 保留域2

	private String reserved_field3;// 保留域3

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRepayment_plan_uuid() {
		return repayment_plan_uuid;
	}

	public void setRepayment_plan_uuid(String repayment_plan_uuid) {
		this.repayment_plan_uuid = repayment_plan_uuid;
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

	public Date getRepay_date() {
		return repay_date;
	}

	public void setRepay_date(Date repay_date) {
		this.repay_date = repay_date;
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
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
