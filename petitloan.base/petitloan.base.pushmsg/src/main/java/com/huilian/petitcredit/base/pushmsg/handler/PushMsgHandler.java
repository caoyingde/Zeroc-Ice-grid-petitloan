package com.huilian.petitcredit.base.pushmsg.handler;

import java.util.List;

import com.huilian.petitcredit.base.pushmsg.service.impl.IssueInfoServiceImpl;
import com.huilian.petitcredit.base.pushmsg.service.impl.NetSignedServiceImpl;
import com.huilian.petitcredit.base.pushmsg.service.impl.NetbookInfoServiceImpl;
import com.huilian.petitcredit.base.pushmsg.service.impl.AbNormalInfoServiceImpl;
import com.huilian.petitcredit.base.pushmsg.service.impl.ContractInfoServiceImpl;
import com.huilian.petitcredit.base.pushmsg.service.impl.FindPushResultServiceImpl;
import com.huilian.petitcredit.base.pushmsg.service.impl.PayPlanInfoServiceImpl;
import com.huilian.petitcredit.base.pushmsg.service.impl.QuotaInfoServiceImpl;
import com.huilian.petitcredit.base.pushmsg.service.impl.RepayInfoServiceImpl;
import com.huilian.petitloan.pushmsg.AbNormalInfoReq;
import com.huilian.petitloan.pushmsg.ContractInfoReq;
import com.huilian.petitloan.pushmsg.IssueInfoReq;
import com.huilian.petitloan.pushmsg.NetBookInfoReq;
import com.huilian.petitloan.pushmsg.NetSignedReq;
import com.huilian.petitloan.pushmsg.PayplanInfoReq;
import com.huilian.petitloan.pushmsg.QuotaInfoReq;
import com.huilian.petitloan.pushmsg.RepayInfoReq;
import com.huilian.petitloan.pushmsg.ResPushStatus;
import com.huilian.petitloan.pushmsg._BasePushmsgHandlerDisp;

import Ice.Current;

public class PushMsgHandler extends _BasePushmsgHandlerDisp {

	/**
	 * 报文推送统一入口
	 */
	private static final long serialVersionUID = 1L;
	private NetSignedServiceImpl netSignedService = new NetSignedServiceImpl();
	private NetbookInfoServiceImpl netbookInfoService = new NetbookInfoServiceImpl();
	private RepayInfoServiceImpl repayInfoService = new RepayInfoServiceImpl();
	private PayPlanInfoServiceImpl payPlanInfoService = new PayPlanInfoServiceImpl();
	private AbNormalInfoServiceImpl noNormalInfoService = new AbNormalInfoServiceImpl();
	private IssueInfoServiceImpl issueInfoService = new IssueInfoServiceImpl();
	private QuotaInfoServiceImpl quotaInfoService = new QuotaInfoServiceImpl();
	private ContractInfoServiceImpl contractInfoService = new ContractInfoServiceImpl();
	private FindPushResultServiceImpl findPushResultService = new FindPushResultServiceImpl();

	@Override
	public ResPushStatus pushNetSigned(NetSignedReq req, Current __current) {
		// TODO Auto-generated method stub
		return netSignedService.pushNetSigned(req);
	}

	/**
	 * 网签文件上报（PTLN107）
	 */
	public ResPushStatus pushNetbookInfo(List<NetBookInfoReq> req, Current __current) {
		// TODO Auto-generated method stub
		return netbookInfoService.pushNetbookInfo(req);
	}

	/**
	 * 贷款回收信息上报（PTLN104）
	 */
	@Override
	public ResPushStatus pushLoanRecoveryReq(List<RepayInfoReq> req, Current __current) {
		// TODO Auto-generated method stub
		return repayInfoService.pushLoanRecoveryReq(req);
	}

	/**
	 * 还款计划信息上报（PTLN105）
	 */

	@Override
	public ResPushStatus pushRepayPlanInfoReq(List<PayplanInfoReq> req, Current __current) {
		// TODO Auto-generated method stub
		return payPlanInfoService.pushRepayPlanInfoReq(req);
	}

	/**
	 * 非正常客户信息上报（PTLN106）
	 */

	@Override
	public ResPushStatus pushNonNormalCustmerReq(List<AbNormalInfoReq> req, Current __current) {
		// TODO Auto-generated method stub
		return noNormalInfoService.pushNonNormalCustmerReq(req);
	}

	/**
	 * 款发放信息上报（PTLN103）
	 */
	@Override
	public ResPushStatus pushLoanLaunchReq(List<IssueInfoReq> req, Current __current) {
		// TODO Auto-generated method stub
		return issueInfoService.pushLoanLaunchReq(req);
	}

	/**
	 * 授信额度信息上报
	 */
	@Override
	public ResPushStatus pushCreditLineReq(List<QuotaInfoReq> req, Current __current) {
		// TODO Auto-generated method stub
		return quotaInfoService.pushCreditLineReq(req);
	}

	/**
	 * 合同信息上报
	 */

	@Override
	public ResPushStatus pushContractInfoReq(List<ContractInfoReq> req, Current __current) {
		// TODO Auto-generated method stub
		return contractInfoService.pushContractInfoReq(req);
	}
	/**
	 * 上报结果查询（PTLN199）
	 */
	@Override
	public ResPushStatus findPushResult(String batchNo, String dataType, Current __current) {
		// TODO Auto-generated method stub
		return findPushResultService.findPushResult(batchNo,dataType);
	}

}
