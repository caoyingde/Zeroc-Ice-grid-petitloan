package com.huilian.petitcredit.base.pushmsg.model.xmlvo;

import java.io.Serializable;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.hibernate.validator.constraints.Length;

@XmlSeeAlso(NetBookInfo.class)
public class NetBookInfoList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull(message = "组织机构代码不能为空")  
	@Length(min=1, max=20, message="org_code字段长度1-20")  
	private String org_code;// 机构组织代码；
	@NotNull(message = "合同编号不能为空") 
	@Length(min=1, max=100, message="contract_no字段长度1-100")  
	private String contract_no;// 合同编号
	@NotNull(message = "贷款类别不能为空") 
	@Length(min=1, max=6, message="loan_cate字段长度1-6")  
	private String loan_cate;// 贷款类别
	@NotNull(message = "借款人类别不能为空") 
	@Length(min=1, max=6, message="customer_type字段长度1-6") 
	private String customer_type;// 借款人类别
	@NotNull(message = "借款人名称不能为空") 
	@Length(min=1, max=100, message="customer_name字段长度1-100") 
	private String customer_name;// 借款人姓名，主借款人
	@NotNull(message = "借款人证件类型不能为空") 
	@Length(min=1, max=6, message="certificate_type字段长度1-6") 
	private String certificate_type;// 主借款人证件类型：150001：身份证；150002；组织机构代码；150003：护照；
	@NotNull(message = "借款人证件号码不能为空") 
	private String certificate_no;// 主借款人证件号码
	
	private String con_customer_type;// 委托人类别

	private String con_customer_name;// 借款人姓名，主借款人

	private String con_certificate_type;// 主借款人证件类型：150001：身份证；150002；组织机构代码；150003：护照；

	private String con_certificate_no;// 主借款人证件号码
	private Float con_fee;// 代理费
	@NotNull(message = "合同金额不能为空") 
	private Float contract_amount;// 合同金额
	@NotNull(message = "合同签订日期不能为空") 
	private String contract_sign_date;// 合同签订日期
	@NotNull(message = "月利率不能为空") 
	@DecimalMin(value="0",message="最小值为0")
	private Float int_rate;// 月利率(‰)

	private String reserved_field1;// 保留域1

	private String reserved_field2;// 保留域2

	private String reserved_field3;// 保留域3

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
		return "NetBookInfoList [org_code=" + org_code + ", contract_no=" + contract_no + ", loan_cate=" + loan_cate
				+ ", customer_type=" + customer_type + ", customer_name=" + customer_name + ", certificate_type="
				+ certificate_type + ", certificate_no=" + certificate_no + ", con_customer_type=" + con_customer_type
				+ ", con_customer_name=" + con_customer_name + ", con_certificate_type=" + con_certificate_type
				+ ", con_certificate_no=" + con_certificate_no + ", con_fee=" + con_fee + ", contract_amount="
				+ contract_amount + ", contract_sign_date=" + contract_sign_date + ", int_rate=" + int_rate
				+ ", reserved_field1=" + reserved_field1 + ", reserved_field2=" + reserved_field2 + ", reserved_field3="
				+ reserved_field3 + "]";
	}

}
