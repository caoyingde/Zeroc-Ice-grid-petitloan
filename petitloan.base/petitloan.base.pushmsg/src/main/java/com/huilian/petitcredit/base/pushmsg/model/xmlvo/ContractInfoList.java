package com.huilian.petitcredit.base.pushmsg.model.xmlvo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class ContractInfoList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "上报类型不能为空")  
	@Length(min=1, max=6, message="report_type字段长度1-6")  
	private String report_type;//上报类型
	  
	@NotNull(message = "组织机构代码不能为空")  
	@Length(min=1, max=20, message="字段长度1-20")  
	private String org_code;//组织机构代码
	  
	@NotNull(message = "合同编号不能为空")  
	@Length(min=1, max=100, message="字段长度1-100")  
	private String contract_no;//合同编号
	  
	@NotNull(message = "贷款类别不能为空")  
	@Length(min=1, max=6, message="loan_cate字段长度1-6")  
	private String loan_cate;//贷款类别
	  
	@NotNull(message = "合同名称不能为空")  
	@Length(min=1, max=100, message="contract_name字段长度1-100")  
	private String contract_name;//合同名称
	  
	@NotNull(message = "借款人类别不能为空")  
	@Length(min=1, max=6, message="customer_type字段长度1-6")  
	private String customer_type;//借款人类别
	  
	@NotNull(message = "借款人名称不能为空")  
	@Length(min=1, max=100, message="字段长度1-100")  
	private String customer_name;//借款人名称
	  
	@NotNull(message = "借款人证件类型不能为空")  
	@Length(min=1, max=6, message="certificate_type字段长度1-6")  
	private String certificate_type;//借款人证件类型
	  
	@NotNull(message = "借款人证件号码不能为空")  
	@Length(min=1, max=50, message="字段长度1-50")  
	private String certificate_no;//借款人证件号码
	  
	private String linkman;//联系人
	  
	private String telephone;//联系电话
	  
	@NotNull(message = "贷款对象不能为空")  
	@Length(min=1, max=6, message="loan_object字段长度1-6")  
	private String loan_object;//贷款对象
	  
	@NotNull(message = "贷款对象规模不能为空")  
	@Length(min=1, max=6, message="loan_object_size字段长度1-6")  
	private String loan_object_size;//贷款对象规模
	  
	@NotNull(message = "合同签订日期不能为空")  
	@Length(min=1, max=8, message="字段长度1-8")  
	private String contract_sign_date;//合同签订日期
	  
	@NotNull(message = "合同有效起始日期不能为空")  
	@Length(min=1, max=8, message="字段长度1-8")  
	private String contract_begin_date;//合同有效起始日期
	  
	@NotNull(message = "合同有效结束日期不能为空")  
	@Length(min=1, max=8, message="字段长度1-8")  
	private String contract_end_date;//合同有效结束日期
	  
	@NotNull(message = "合同金额不能为空")  
	private Float contract_amount;//合同金额
	  
	@NotNull(message = "贷款余额不能为空")  
	private Float outstanding;//贷款余额
	  
	@NotNull(message = "担保方式不能为空")  
	@Length(min=1, max=6, message="guar_type字段长度1-6")  
	private String guar_type;//担保方式
	  
	@NotNull(message = "币种不能为空")  
	@Length(min=1, max=6, message="ccy字段长度1-6")  
	private String ccy;//币种
	  
	@NotNull(message = "是否额度项下贷款不能为空")  
	@Length(min=1, max=6, message="is_real_quota_loan字段长度1-6")  
	private String is_real_quota_loan;//是否额度项下贷款
	  
	private String real_quota_no;//授信额度协议编号
	  
	@NotNull(message = "月利率(‰)不能为空")  
	private Float int_rate;//月利率(‰)
	  
	@NotNull(message = "逾期月利率(‰)不能为空")  
	private Float pri_plty_rate;//逾期月利率(‰)
	  
	@NotNull(message = "合同状态不能为空")  
	@Length(min=1, max=6, message="contract_status字段长度1-6")  
	private String contract_status;//合同状态
	  
	@NotNull(message = "客户经理不能为空")  
	@Length(min=1, max=50, message="字段长度1-50")  
	private String relation_manager;//客户经理
	  
	@NotNull(message = "争议解决方式不能为空")  
	@Length(min=1, max=6, message="dispute_scheme字段长度1-6")  
	private String dispute_scheme;//争议解决方式
	  
	private String remark;//备注
	  
	private String con_customer_type;//委托人类别
	  
	private String con_customer_name;//委托人
	  
	private String con_certificate_type;//委托人证件类型
	  
	private String con_certificate_no;//委托人证件号码
	  
	private String con_jurisitc;//委托方法定代表人/负责人
	  
	private String con_telephone;//委托人联系电话
	  
	private String con_locus;//委托人地址
	  
	private String con_postalcode;//委托人邮编
	  
	private String con_fincal_org;//委托人开户金融机构
	  
	private String con_account_no;//委托人账户
	  
	private String ass_customer_name;//受托人
	  
	private String ass_juristic;//受托人法定代表人/负责人
	  
	private String ass_telephone;//受托人联系电话
	  
	private String ass_locus;//受托人地址
	  
	private String ass_postalcode;//受托人邮编
	  
	private Float con_fee;//代理费
	  
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
