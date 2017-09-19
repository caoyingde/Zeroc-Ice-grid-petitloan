package com.huilian.petitcredit.base.pushmsg.model.xmlvo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
public class RepayInfo implements Serializable{

	/**
	 * 贷款信息回收实体类
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;//ID
	 
	private String loan_recovery_uuid;//
	  
	@NotNull(message = "批次不能为空")  
	@Length(min=1, max=50, message="batch_no字段长度1-50")  
	private String batch_no;//批次号
	
	@NotNull(message = "数据类型不能为空")  
	@Length(min=1, max=20, message="data_type字段长度1-20")  
	private String data_type;//数据类型
	
	/*@NotNull(message = "总记录数不能为空")  
	@Length(min=1, max=16, message="record_count字段长度1-16")  */
	private Integer record_count;//总记录数
	
	
	private List<RepayInfoList> repay_info;//回收信息数组

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

	public List<RepayInfoList> getRepay_info() {
		return repay_info;
	}

	public void setRepay_info(List<RepayInfoList> repay_info) {
		this.repay_info = repay_info;
	}
	


	

}
