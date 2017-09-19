package com.huilian.petitcredit.base.pushmsg.model.xmlvo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Transaction<T> {
	@XmlElementWrapper(name = "header")

	@XmlElements(value = { @XmlElement })
	private List<T> msg = new ArrayList<T>();
	@XmlElements(value = { @XmlElement })
	List<XmlHeaderReq> reqList = new ArrayList<XmlHeaderReq>();
	@XmlElements(value = { @XmlElement })
	List<IssueInfo> issueInfoList = new ArrayList<IssueInfo>();
	List<IssueInfoList> infoList = new ArrayList<IssueInfoList>();
	
	@XmlTransient
	public List<XmlHeaderReq> getReqList() {
		return reqList;
	}

	public void setReqList(List<XmlHeaderReq> reqList) {
		this.reqList = reqList;
	}

	@XmlTransient
	public List<T> getMsg() {
		return msg;
	}

	public void setMsg(List<T> msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Transaction [msg=" + msg + ", reqList=" + reqList + ", getReqList()=" + getReqList() + ", getMsg()="
				+ getMsg() + "]";
	}

	@XmlTransient
	public List<IssueInfo> getIssueInfoList() {
		return issueInfoList;
	}

	public void setIssueInfoList(List<IssueInfo> issueInfoList) {
		this.issueInfoList = issueInfoList;
	}

	@XmlTransient
	public List<IssueInfoList> getInfoList() {
		return infoList;
	}

	public void setInfoList(List<IssueInfoList> infoList) {
		this.infoList = infoList;
	}
	

	/*
	 * public List<XmlHeaderRsp> getListRsq() { return listRsq; }
	 * 
	 * public void setListRsq(List<XmlHeaderRsp> listRsq) { this.listRsq =
	 * listRsq; }
	 */

}
