package com.huilian.petitcredit.base.pushmsg.model.xmlvo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class AbNormalInfoList implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message = "上报类型不能为空")  
	@Length(min=1, max=6, message="report_type字段长度1-6")  
	private String report_type;//上报类型
	
	@NotNull(message = "机构组织代码；不能为空")  
	@Length(min=1, max=20, message="org_code字段长度1-20")  
	private String org_code;//机构组织代码；
	
	@NotNull(message = "用户类型不能为空")  
	@Length(min=1, max=6, message="customer_type字段长度1-6")  
	private String customer_type;//用户类型：480001：个人；480002：企业
	
	@NotNull(message = "借款人姓名不能为空")  
	@Length(min=1, max=100, message="customer_name字段长度1-100")  
	private String customer_name;//借款人姓名，主借款人
	
	@NotNull(message = "证件类型不能为空")  
	@Length(min=1, max=6, message="certificate_type字段长度1-6")  
	private String certificate_type;//主借款人证件类型：150001：身份证；150002；组织机构代码；150003：护照；
	
	@NotNull(message = "证件号码不能为空")  
	@Length(min=1, max=50, message="certificate_no字段长度1-50")  
	private String certificate_no;//主借款人证件号码
	
	@NotNull(message = "非正常原因不能为空")  
	@Length(min=1, max=500, message="reason字段长度1-500")  
	private String reason;//非正常原因
	
	@NotNull(message = "客户所属行业不能为空")  
	@Length(min=1, max=6, message="industry字段长度1-6")  
	private String industry;//客户所属行业
	
	@NotNull(message = "客户所属区域不能为空")  
	@Length(min=1, max=6, message="zone字段长度1-6")  
	private String zone;//客户所属区域
	
	@NotNull(message = "起息日期不能为空")  
	@Length(min=1, max=10, message="start_date字段长度1-10")  
	private String start_date;//起息日期
	
	@NotNull(message = "止息日期不能为空")  
	@Length(min=1, max=10, message="end_date字段长度1-10")  
	private String end_date;//止息日期
	
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
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
