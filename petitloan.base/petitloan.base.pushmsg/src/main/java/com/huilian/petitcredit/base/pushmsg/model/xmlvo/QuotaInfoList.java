package com.huilian.petitcredit.base.pushmsg.model.xmlvo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class QuotaInfoList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "上报类型不能为空")  
	@Length(min=1, max=6, message="report_type字段长度1-6")  
	private String report_type;//上报类型
	  
	@NotNull(message = "组织机构代码不能为空")  
	@Length(min=1, max=20, message="org_code字段长度1-20")  
	private String org_code;//组织机构代码
	  
	@NotNull(message = "额度协议编号不能为空")  
	@Length(min=1, max=100, message="contract_no字段长度1-100")  
	private String contract_no;//额度协议编号
	  
	@NotNull(message = "额度协议名称不能为空")  
	@Length(min=1, max=50, message="contract_name字段长度1-50")  
	private String contract_name;//额度协议名称
	  
	@NotNull(message = "借款人类别不能为空")  
	@Length(min=1, max=6, message="customer_type字段长度1-6")  
	private String customer_type;//借款人类别
	  
	@NotNull(message = "借款人名称不能为空")  
	@Length(min=1, max=50, message="customer_name字段长度1-50")  
	private String customer_name;//借款人名称
	  
	@NotNull(message = "借款人证件类型不能为空")  
	@Length(min=1, max=6, message="certificate_type字段长度1-6")  
	private String certificate_type;//借款人证件类型
	  
	@NotNull(message = "借款人证件号码不能为空")  
	@Length(min=1, max=50, message="certificate_no字段长度1-50")  
	private String certificate_no;//借款人证件号码
	  
	@NotNull(message = "额度协议签订日期不能为空")  
	@Length(min=1, max=86, message="contract_sign_date字段长度1-8")  
	private String contract_sign_date;//额度协议签订日期
	  
	@NotNull(message = "额度协议起期不能为空")  
	@Length(min=1, max=8, message="contract_begin_date字段长度1-8")  
	private String contract_begin_date;//额度协议起期
	  
	@NotNull(message = "额度协议止期不能为空")  
	@Length(min=1, max=8, message="contract_end_date字段长度1-8")  
	private String contract_end_date;//额度协议止期
	  
	@NotNull(message = "上报类型不能为空")  
	private Float contract_amount;//额度协议金额
	  
	@NotNull(message = "币种不能为空")  
	@Length(min=1, max=6, message="字段长度1-6")  
	private String ccy;//币种
	  
	@NotNull(message = "上报类型不能为空")  
	private Float used_amount;//已用额度
	  
	@NotNull(message = "上报类型不能为空")  
	private Float remain_amount;//剩余额度
	  
	@NotNull(message = "担保方式不能为空")  
	@Length(min=1, max=6, message="guar_type字段长度1-6")  
	private String guar_type;//担保方式
	  
	@NotNull(message = "是否循环额度不能为空")  
	@Length(min=1, max=6, message="is_circle字段长度1-6")  
	private String is_circle;//是否循环额度
	  
	@NotNull(message = "协议状态不能为空")  
	@Length(min=1, max=6, message="contract_status字段长度1-6")  
	private String contract_status;//协议状态
	
	private String relation_manager;//客户经理
	  
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



	public String getCertificate_no() {
		return certificate_no;
	}

	public void setCertificate_no(String certificate_no) {
		this.certificate_no = certificate_no;
	}



	public String getContract_sign_date() {
		return contract_sign_date;
	}

	public void setContract_sign_date(String contract_sign_date) {
		this.contract_sign_date = contract_sign_date;
	}

	public String getContract_begin_date() {
		return contract_begin_date;
	}

	public void setContract_begin_date(String contract_begin_date) {
		this.contract_begin_date = contract_begin_date;
	}

	public String getContract_end_date() {
		return contract_end_date;
	}

	public void setContract_end_date(String contract_end_date) {
		this.contract_end_date = contract_end_date;
	}

	public Float getContract_amount() {
		return contract_amount;
	}

	public void setContract_amount(Float contract_amount) {
		this.contract_amount = contract_amount;
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


	public String getCertificate_type() {
		return certificate_type;
	}

	public void setCertificate_type(String certificate_type) {
		this.certificate_type = certificate_type;
	}

	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
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
