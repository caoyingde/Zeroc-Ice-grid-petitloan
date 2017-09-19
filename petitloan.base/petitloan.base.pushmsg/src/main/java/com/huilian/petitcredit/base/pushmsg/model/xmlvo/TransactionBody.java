package com.huilian.petitcredit.base.pushmsg.model.xmlvo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name ="transaction")
public class TransactionBody<T> {
	@XmlElementWrapper(name ="body")

	@XmlElements(value = { @XmlElement })
	private List<T> gettx = new ArrayList<T>();
	@XmlElements(value = { @XmlElement })
	List<NetBookInfo> netBookInfo = new ArrayList<NetBookInfo>();
	List<NetBookInfoList> netBookInfoList = new ArrayList<NetBookInfoList>();
	
	@XmlElements(value = { @XmlElement })
	List<RepayInfo> recoveryLoanList = new ArrayList<RepayInfo>();
	List<RepayInfoList> list = new ArrayList<RepayInfoList>();
	
	@XmlElements(value = { @XmlElement })
	List<PayPlanInfo> payPlanList = new ArrayList<PayPlanInfo>();
	List<PayPlanInfoList> payPlanInfoList = new ArrayList<PayPlanInfoList>();
	
	@XmlElements(value = { @XmlElement })
	List<AbNormalInfo> abNormalList = new ArrayList<AbNormalInfo>();
	List<AbNormalInfoList> abNormalInfoList = new ArrayList<AbNormalInfoList>();
	
	@XmlElements(value = { @XmlElement })//这个注解是需要加的，否则的话就会报超类@XmlSeeAlso(TransactionBody.class)这个注解可以不用加
	List<IssueInfo> issueInfolist = new ArrayList<IssueInfo>();
	List<IssueInfoList> infolist = new ArrayList<IssueInfoList>();
	
	@XmlElements(value = { @XmlElement })
	List<QuotaInfo> quotaList = new ArrayList<QuotaInfo>();
	List<QuotaInfoList> quotaInfolist = new ArrayList<QuotaInfoList>();
	
	@XmlElements(value = { @XmlElement })
	List<ContractInfo> contractList = new ArrayList<ContractInfo>();
	List<ContractInfoList> contractInfoList = new ArrayList<ContractInfoList>();

	@XmlTransient
	public List<T> getGettx() {
		return gettx;
	}


	public void setGettx(List<T> gettx) {
		this.gettx = gettx;
	}


	@XmlTransient
	public List<RepayInfo> getRecoveryLoanList() {
		return recoveryLoanList;
	}


	public void setRecoveryLoanList(List<RepayInfo> recoveryLoanList) {
		this.recoveryLoanList = recoveryLoanList;
	}


	@XmlTransient
	public List<RepayInfoList> getList() {
		return list;
	}
	
	public void setList(List<RepayInfoList> list) {
		this.list = list;
	}
	
	@XmlTransient
	public List<NetBookInfo> getNetBookInfo() {
		return netBookInfo;
	}


	public void setNetBookInfo(List<NetBookInfo> netBookInfo) {
		this.netBookInfo = netBookInfo;
	}

	@XmlTransient
	public List<NetBookInfoList> getNetBookInfoList() {
		return netBookInfoList;
	}


	public void setNetBookInfoList(List<NetBookInfoList> netBookInfoList) {
		this.netBookInfoList = netBookInfoList;
	}

	@XmlTransient//如果不加的话会报具有相同属性的名称
	public List<IssueInfo> getIssueInfolist() {
		return issueInfolist;
	}


	public void setIssueInfolist(List<IssueInfo> issueInfolist) {
		this.issueInfolist = issueInfolist;
	}


	@XmlTransient
	public List<IssueInfoList> getInfolist() {
		return infolist;
	}


	public void setInfolist(List<IssueInfoList> infolist) {
		this.infolist = infolist;
	}

	@XmlTransient
	public List<PayPlanInfo> getPayPlanList() {
		return payPlanList;
	}


	public void setPayPlanList(List<PayPlanInfo> payPlanList) {
		this.payPlanList = payPlanList;
	}


	@XmlTransient
	public List<PayPlanInfoList> getPayPlanInfoList() {
		return payPlanInfoList;
	}


	public void setPayPlanInfoList(List<PayPlanInfoList> payPlanInfoList) {
		this.payPlanInfoList = payPlanInfoList;
	}


	@XmlTransient
	public List<QuotaInfo> getQuotaList() {
		return quotaList;
	}


	public void setQuotaList(List<QuotaInfo> quotaList) {
		this.quotaList = quotaList;
	}


	@XmlTransient
	public List<QuotaInfoList> getQuotaInfolist() {
		return quotaInfolist;
	}


	public void setQuotaInfolist(List<QuotaInfoList> quotaInfolist) {
		this.quotaInfolist = quotaInfolist;
	}

	@XmlTransient
	public List<AbNormalInfo> getAbNormalList() {
		return abNormalList;
	}


	public void setAbNormalList(List<AbNormalInfo> abNormalList) {
		this.abNormalList = abNormalList;
	}

	@XmlTransient
	public List<AbNormalInfoList> getAbNormalInfoList() {
		return abNormalInfoList;
	}


	public void setAbNormalInfoList(List<AbNormalInfoList> abNormalInfoList) {
		this.abNormalInfoList = abNormalInfoList;
	}

	@XmlTransient
	public List<ContractInfo> getContractList() {
		return contractList;
	}


	public void setContractList(List<ContractInfo> contractList) {
		this.contractList = contractList;
	}

	@XmlTransient
	public List<ContractInfoList> getContractInfoList() {
		return contractInfoList;
	}


	public void setContractInfoList(List<ContractInfoList> contractInfoList) {
		this.contractInfoList = contractInfoList;
	}
	

	

	
	
}
