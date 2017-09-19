package com.huilian.petitcredit.base.pushmsg.model.xmlvo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class HypopledgeInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull(message = "担保合同号不能为空")  
	@Length(min=1, max=40, message="字段长度1-40")  
	private String guar_contract_no;//担保合同号
	
	private String warrant_no;//权证号
	
	private String collateral_type;//押品类型
	
	private Float hypopledge_amount;//抵质押金额
	
	@NotNull(message = "是否注销不能为空")  
	@Length(min=1, max=6, message="字段长度1-6")  
	private String is_write_off;//是否注销
	
	private String write_off_date;//注销日期
	
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
	public String getWrite_off_date() {
		return write_off_date;
	}
	public void setWrite_off_date(String write_off_date) {
		this.write_off_date = write_off_date;
	}
	
	
}
