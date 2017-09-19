package com.huilian.petitcredit.base.pushmsg.model.xmlvo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class IssueInfoList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message = "上报类型不能为空")  
	@Length(min=1, max=6, message="report_type字段长度1-6")  
	private String report_type;// 上报类型

	@NotNull(message = "组织机构代码不能为空")  
	@Length(min=1, max=50, message="org_code字段长度1-50")  
	private String org_code;// 组织机构代码

	@NotNull(message = "合同编号不能为空")  
	@Length(min=1, max=100, message="contract_no字段长度1-100")  
	private String contract_no;// 合同编号

	@NotNull(message = "发放编号不能为空")  
	@Length(min=1, max=100, message="due_bill_no字段长度1-100")  
	private String due_bill_no;// 发放编号

	@NotNull(message = "借款人类别不能为空")  
	@Length(min=1, max=6, message="customer_type字段长度1-6")  
	private String customer_type;// 借款人类别

	@NotNull(message = "借款人名称不能为空")  
	@Length(min=1, max=50, message="customer_name字段长度1-50")  
	private String customer_name;// 借款人名称

	@NotNull(message = "借款人证件类型不能为空")  
	@Length(min=1, max=6, message="certificate_type字段长度1-6")  
	private String certificate_type;// 借款人证件类型

	@NotNull(message = "借款人证件号码不能为空")  
	@Length(min=1, max=50, message="certificate_no字段长度1-50")  
	private String certificate_no;// 借款人证件号码

	@NotNull(message = "发放金额不能为空")  
	private float dd_amt;// 发放金额

	@NotNull(message = "贷款类别不能为空")  
	@Length(min=1, max=6, message="loan_cate字段长度1-6")  
	private String loan_cate;// 贷款类别

	@NotNull(message = "月利率(‰)不能为空")  
	private float int_rate;// 月利率(‰)

	@NotNull(message = "逾期月利率(‰)不能为空")  
	private float pri_plty_rate;// 逾期月利率(‰)

	@NotNull(message = "利率性质不能为空")  	
	@Length(min=1, max=6, message="rate_type字段长度1-6")  
	private String rate_type;// 利率性质

	@NotNull(message = "签约日期不能为空")  
	@Length(min=1, max=8, message="字段长度1-8")  
	private String sign_date;// 签约日期

	@NotNull(message = "发放日期不能为空")  
	@Length(min=1, max=8, message="dd_date字段长度1-8")  
	private String dd_date;// 发放日期

	@NotNull(message = "到期日期不能为空")  
	@Length(min=1, max=8, message="mature_date字段长度1-8")  
	private String mature_date;// 到期日期

	private String ext_start_date;// 展期开始日期

	private String ext_end_date;// 展期到期日期

	private float ext_outstanding;// 展期余额

	@NotNull(message = "投放区域不能为空")  
	@Length(min=1, max=6, message="字段长度1-6")  
	private String zone;// 投放区域

	@NotNull(message = "担保方式不能为空")  
	@Length(min=1, max=6, message="字段长度1-6")  
	private String guar_type;// 担保方式

	@NotNull(message = "贷款期限不能为空")  
	@Length(min=1, max=6, message="字段长度1-6")  
	private String term;// 贷款期限

	@NotNull(message = "贷款用途不能为空")  
	@Length(min=1, max=6, message="字段长度1-6")  
	private String purpose;// 贷款用途

	@NotNull(message = "贷款对象不能为空")  
	@Length(min=1, max=6, message="字段长度1-6")  
	private String loan_object;// 贷款对象

	@NotNull(message = "贷款对象规模不能为空")  
	@Length(min=1, max=6, message="字段长度1-6")  
	private String loan_object_size;// 贷款对象规模

	@NotNull(message = "计息方式不能为空")  
	@Length(min=1, max=6, message="字段长度1-6")  
	private String rate_calc_mode;// 计息方式

	@NotNull(message = "扣款方式不能为空")  
	@Length(min=1, max=6, message="字段长度1-6")  
	private String repay_mode;// 扣款方式

	@NotNull(message = "投放行业不能为空")  
	@Length(min=1, max=6, message="字段长度1-6")  
	private String industry;// 投放行业

	@NotNull(message = "五级分类不能为空")  
	@Length(min=1, max=6, message="字段长度1-6")  
	private String risk_level;// 五级分类

	@NotNull(message = "发放状态不能为空")  
	@Length(min=1, max=6, message="字段长度1-6")  
	private String issue_status;// 发放状态
	
	List<HypopledgeInfo> Hypopledge_Info;
	
	private String remark ;//备注
	
	private Float fair_amt; //公允价值
	
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

	public float getDd_amt() {
		return dd_amt;
	}

	public void setDd_amt(float dd_amt) {
		this.dd_amt = dd_amt;
	}

	public String getLoan_cate() {
		return loan_cate;
	}

	public void setLoan_cate(String loan_cate) {
		this.loan_cate = loan_cate;
	}

	public float getInt_rate() {
		return int_rate;
	}

	public void setInt_rate(float int_rate) {
		this.int_rate = int_rate;
	}

	public float getPri_plty_rate() {
		return pri_plty_rate;
	}

	public void setPri_plty_rate(float pri_plty_rate) {
		this.pri_plty_rate = pri_plty_rate;
	}

	public String getRate_type() {
		return rate_type;
	}

	public void setRate_type(String rate_type) {
		this.rate_type = rate_type;
	}

	public String getSign_date() {
		return sign_date;
	}

	public void setSign_date(String sign_date) {
		this.sign_date = sign_date;
	}

	public String getDd_date() {
		return dd_date;
	}

	public void setDd_date(String dd_date) {
		this.dd_date = dd_date;
	}

	public String getMature_date() {
		return mature_date;
	}

	public void setMature_date(String mature_date) {
		this.mature_date = mature_date;
	}

	public String getExt_start_date() {
		return ext_start_date;
	}

	public void setExt_start_date(String ext_start_date) {
		this.ext_start_date = ext_start_date;
	}

	public String getExt_end_date() {
		return ext_end_date;
	}

	public void setExt_end_date(String ext_end_date) {
		this.ext_end_date = ext_end_date;
	}

	public float getExt_outstanding() {
		return ext_outstanding;
	}

	public void setExt_outstanding(float ext_outstanding) {
		this.ext_outstanding = ext_outstanding;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getGuar_type() {
		return guar_type;
	}

	public void setGuar_type(String guar_type) {
		this.guar_type = guar_type;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
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

	public String getRate_calc_mode() {
		return rate_calc_mode;
	}

	public void setRate_calc_mode(String rate_calc_mode) {
		this.rate_calc_mode = rate_calc_mode;
	}

	public String getRepay_mode() {
		return repay_mode;
	}

	public void setRepay_mode(String repay_mode) {
		this.repay_mode = repay_mode;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getRisk_level() {
		return risk_level;
	}

	public void setRisk_level(String risk_level) {
		this.risk_level = risk_level;
	}

	public String getIssue_status() {
		return issue_status;
	}

	public void setIssue_status(String issue_status) {
		this.issue_status = issue_status;
	}


	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Float getFair_amt() {
		return fair_amt;
	}

	public void setFair_amt(Float fair_amt) {
		this.fair_amt = fair_amt;
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

	public List<HypopledgeInfo> getHypopledge_Info() {
		return Hypopledge_Info;
	}

	public void setHypopledge_Info(List<HypopledgeInfo> hypopledge_Info) {
		Hypopledge_Info = hypopledge_Info;
	}

	
	
	

}
