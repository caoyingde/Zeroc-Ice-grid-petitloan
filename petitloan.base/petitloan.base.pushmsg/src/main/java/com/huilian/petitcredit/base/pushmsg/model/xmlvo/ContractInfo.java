package com.huilian.petitcredit.base.pushmsg.model.xmlvo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class ContractInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;//id
	  
	private String loan_contract_uuid;//loan_contract_uuid
	  
	@NotNull(message = "批次不能为空")  
	@Length(min=1, max=50, message="batch_no字段长度1-50")  
	private String batch_no;//批次号
	
	@NotNull(message = "数据类型不能为空")  
	@Length(min=1, max=20, message="data_type字段长度1-20")  
	private String data_type;//数据类型
	
	private Integer record_count;//总记录数
	  
	private List<ContractInfoList> contract_info;//合同信息数组

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoan_contract_uuid() {
		return loan_contract_uuid;
	}

	public void setLoan_contract_uuid(String loan_contract_uuid) {
		this.loan_contract_uuid = loan_contract_uuid;
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

	public List<ContractInfoList> getContract_info() {
		return contract_info;
	}

	public void setContract_info(List<ContractInfoList> contract_info) {
		this.contract_info = contract_info;
	}
	  
	
	
}