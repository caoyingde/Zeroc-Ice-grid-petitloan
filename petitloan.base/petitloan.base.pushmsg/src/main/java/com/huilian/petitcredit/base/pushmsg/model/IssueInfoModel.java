package com.huilian.petitcredit.base.pushmsg.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class IssueInfoModel implements Serializable {
	/**
	 * 贷款发放信息上报（PTLN103）
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String loan_launch_uuid;

	private String batch_no;// 批次号

	private String data_type;// 数据类型

	private Integer record_count;// 总记录数

	private String report_type;// 上报类型

	private String org_code;// 组织机构代码

	private String contract_no;// 合同编号

	private String due_bill_no;// 发放编号

	private String customer_type;// 借款人类别

	private String customer_name;// 借款人名称

	private String certificate_type;// 借款人证件类型

	private String certificate_no;// 借款人证件号码

	private float dd_amt;// 发放金额

	private String loan_cate;// 贷款类别

	private float int_rate;// 月利率(‰)

	private float pri_plty_rate;// 逾期月利率(‰)

	private String rate_type;// 利率性质

	private Date sign_date;// 签约日期

	private Date dd_date;// 发放日期

	private Date mature_date;// 到期日期

	private Date ext_start_date;// 展期开始日期

	private Date ext_end_date;// 展期到期日期

	private float ext_outstanding;// 展期余额

	private String zone;// 投放区域

	private String guar_type;// 担保方式

	private String term;// 贷款期限

	private String purpose;// 贷款用途

	private String loan_object;// 贷款对象

	private String loan_object_size;// 贷款对象规模

	private String rate_calc_mode;// 计息方式

	private String repay_mode;// 扣款方式

	private String industry;// 投放行业

	private String risk_level;// 五级分类

	private String issue_status;// 发放状态

	private String guar_contract_no;// 担保合同号

	private String warrant_no;// 权证号

	private String collateral_type;// 押品类型

	private Float hypopledge_amount;// 抵质押金额

	private String is_write_off;// 是否注销

	private Date write_off_date;// 注销日期

	private String remark;// 备注

	private Float fair_amt; // 公允价值
	
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

	public String getLoan_launch_uuid() {
		return loan_launch_uuid;
	}

	public void setLoan_launch_uuid(String loan_launch_uuid) {
		this.loan_launch_uuid = loan_launch_uuid;
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

	public Date getSign_date() {
		return sign_date;
	}

	public void setSign_date(Date sign_date) {
		this.sign_date = sign_date;
	}

	public Date getDd_date() {
		return dd_date;
	}

	public void setDd_date(Date dd_date) {
		this.dd_date = dd_date;
	}

	public Date getMature_date() {
		return mature_date;
	}

	public void setMature_date(Date mature_date) {
		this.mature_date = mature_date;
	}

	public Date getExt_start_date() {
		return ext_start_date;
	}

	public void setExt_start_date(Date ext_start_date) {
		this.ext_start_date = ext_start_date;
	}

	public Date getExt_end_date() {
		return ext_end_date;
	}

	public void setExt_end_date(Date ext_end_date) {
		this.ext_end_date = ext_end_date;
	}

	public void setWrite_off_date(Date write_off_date) {
		this.write_off_date = write_off_date;
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

	public String getGuar_contract_no() {
		return guar_contract_no;
	}

	public void setGuar_contract_no(String guar_contract_no) {
		this.guar_contract_no = guar_contract_no;
	}

	public String getWarrant_no() {
		return warrant_no;
	}

	public void setWarrant_no(String warrant_no) {
		this.warrant_no = warrant_no;
	}

	public String getCollateral_type() {
		return collateral_type;
	}

	public void setCollateral_type(String collateral_type) {
		this.collateral_type = collateral_type;
	}

	public Float getHypopledge_amount() {
		return hypopledge_amount;
	}

	public void setHypopledge_amount(Float hypopledge_amount) {
		this.hypopledge_amount = hypopledge_amount;
	}

	public String getIs_write_off() {
		return is_write_off;
	}

	public void setIs_write_off(String is_write_off) {
		this.is_write_off = is_write_off;
	}

	public Date getWrite_off_date() {
		return write_off_date;
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
