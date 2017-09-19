package com.huilian.petitcredit.base.pushmsg.model.xmlvo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
public class NetBookInfo implements Serializable {

	/**
	 * 网签文件上报
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;// ID

	private String signed_doc_uuid;//
	
	@NotNull(message = "批次不能为空")  
	@Length(min=1, max=50, message="batch_no字段长度1-50")  
	private String batch_no;//批次号
	
	@NotNull(message = "数据类型不能为空")  
	@Length(min=1, max=20, message="data_type字段长度1-20")  
	private String data_type;//数据类型
	
	private Integer record_count;//总记录数
	private List<NetBookInfoList> netbook_info;// 合同信息数组

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigned_doc_uuid() {
		return signed_doc_uuid;
	}

	public void setSigned_doc_uuid(String signed_doc_uuid) {
		this.signed_doc_uuid = signed_doc_uuid;
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

	public List<NetBookInfoList> getNetbook_info() {
		return netbook_info;
	}

	public void setNetbook_info(List<NetBookInfoList> netbook_info) {
		this.netbook_info = netbook_info;
	}

	@Override
	public String toString() {
		return "NetBookInfo [id=" + id + ", signed_doc_uuid=" + signed_doc_uuid + ", batch_no=" + batch_no
				+ ", data_type=" + data_type + ", record_count=" + record_count + ", netbook_info=" + netbook_info
				+ "]";
	}

}
