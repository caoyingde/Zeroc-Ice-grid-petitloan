package com.huilian.petitcredit.base.pushmsg.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.huilian.hlej.base.utils.UniqId;
import com.huilian.hlej.market.constant.RetCode;
import com.huilian.petitcredit.base.pushmsg.dao.BaseDao;
import com.huilian.petitcredit.base.pushmsg.dao.RepayInfoDao;
import com.huilian.petitcredit.base.pushmsg.model.QuotaInfoModel;
import com.huilian.petitcredit.base.pushmsg.model.RepayInfoModel;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.RepayInfo;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.RepayInfoList;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.TransactionBody;
import com.huilian.petitcredit.base.pushmsg.utils.IdGen;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil.CollectionWrapper;
import com.huilian.petitcredit.base.pushmsg.utils.PetitloanConstant;
import com.huilian.petitcredit.base.pushmsg.utils.SystemResource;
import com.huilian.petitcredit.base.pushmsg.utils.fastDFS.FileInfoVo;
import com.huilian.petitcredit.base.pushmsg.utils.vlidationBean.VlidationUtil;
import com.huilian.petitloan.pushmsg.RepayInfoReq;
import com.huilian.petitloan.pushmsg.ResPushStatus;

public class RepayInfoServiceImpl extends BaseServiceImpl<RepayInfoModel> {

	private static Logger logger = LoggerFactory.getLogger(RepayInfoServiceImpl.class);
	private static String METHOD_NAMESPACE = "【pushLoanRecoveryReq】";
	private static String DATA_TYPE = PetitloanConstant.REPAY_INFO;
	private static String ORG_CODE_KEY = SystemResource.getConfigValue(SystemResource.ORG_CODE_KEY);
	private static SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDD");

	@Override
	public Class<? extends BaseDao<RepayInfoModel>> getMapperClass() {
		// TODO Auto-generated method stub
		return RepayInfoDao.class;
	}

	@Override
	public BaseDao<RepayInfoModel> getDaoImpl() {
		// TODO Auto-generated method stub
		return (RepayInfoDao)super.getDao();
	}

	public ResPushStatus pushLoanRecoveryReq(List<RepayInfoReq> loanRecoveryreq) {
		ResPushStatus rs = new ResPushStatus();
		//当前批次号
		String batchNo = UniqId.getInstance().getUniqID();
		rs.setBatchNo(batchNo);
		rs.setDataType(DATA_TYPE);//当前接口数据类型
		try {
			if (loanRecoveryreq == null) {
				logger.info(METHOD_NAMESPACE+"LoanRecoveryReq is null");
				rs.setRetCode(RetCode.BUS_ARG_INVALID+"");
				rs.setRetMsg(RetCode.retMsg.get(RetCode.BUS_ARG_INVALID));
				return rs;
			}
			logger.info(METHOD_NAMESPACE+"LoanRecoveryReq req :" + loanRecoveryreq);
			List<RepayInfoModel> modelList = new ArrayList<RepayInfoModel>();
			RepayInfoModel model = new RepayInfoModel();

			List<RepayInfo> repayList = new ArrayList<RepayInfo>();
			List<RepayInfoList> repayInfoList = new ArrayList<RepayInfoList>();
			RepayInfoList repayInfos = new RepayInfoList();
			RepayInfo payInfo = new RepayInfo();
			payInfo.setBatch_no(batchNo);
			payInfo.setData_type(DATA_TYPE);
			payInfo.setRecord_count(repayInfoList.size());
			payInfo.setLoan_recovery_uuid(UniqId.getInstance().getUniqID());
			for (RepayInfoReq repayInfoReq : loanRecoveryreq) {
				
				repayInfos.setReport_type(repayInfoReq.getReportType());
				repayInfos.setOrg_code(ORG_CODE_KEY);
				repayInfos.setContract_no(repayInfoReq.getContractNo());
				repayInfos.setDue_bill_no(repayInfoReq.getDueBillNo());
				repayInfos.setRepay_date(repayInfoReq.getRepayDate());
				repayInfos.setCounter(repayInfoReq.getCounter());
				repayInfos.setCustomer_type(repayInfoReq.getCustomerType());
				repayInfos.setCustomer_name(repayInfoReq.getCustomerName());
				repayInfos.setCertificate_type(repayInfoReq.getCertificateType());
				repayInfos.setCertificate_no(repayInfoReq.getCertificateNo());
				repayInfos.setGather_mode(repayInfoReq.getGatherMode());
				repayInfos.setRepay_pri_amt(repayInfoReq.getRepayPriAmt());
				repayInfos.setRepay_int_amt(repayInfoReq.getRepayIntAmt());
				repayInfos.setStart_date(repayInfoReq.getStartDate());
				repayInfos.setEnd_date(repayInfoReq.getEndDate());
				repayInfos.setDelay_amt(repayInfoReq.getDelayAmt());
				repayInfos.setReceipt_type(repayInfoReq.getReceiptType());
				VlidationUtil.validate(repayInfos);
				repayInfoList.add(repayInfos);
				
				model.setBatch_no(payInfo.getBatch_no());
				model.setLoan_recovery_uuid(IdGen.uuid());
				model.setData_type(payInfo.getData_type());
				
				model.setReport_type(repayInfoReq.getReportType());
				model.setOrg_code(ORG_CODE_KEY);
				model.setCertificate_no(repayInfoReq.getCertificateNo());
				model.setCertificate_type(repayInfoReq.getCertificateType());
				model.setContract_no(repayInfoReq.getContractNo());
				model.setCounter(repayInfoReq.getCounter());
				model.setCustomer_name(repayInfoReq.getCustomerName());
				model.setCustomer_type(repayInfoReq.getCustomerType());
				model.setDelay_amt(repayInfoReq.getDelayAmt());
				model.setDelay_days(repayInfoReq.getDelayDays());
				model.setDelay_fee(repayInfoReq.getDelayFee());
				model.setDelay_interest(repayInfoReq.getDelayInterest());
				model.setDue_bill_no(repayInfoReq.getDueBillNo());
				model.setEnd_date(sdf.parse(repayInfoReq.getEndDate()));
				model.setGather_mode(repayInfoReq.getGatherMode());
				model.setPri_plty_rate(repayInfoReq.getPriPltyRate());
				model.setReceipt_type(repayInfoReq.getReceiptType());
				model.setRemark(repayInfoReq.getRemark());
				model.setRepay_date(sdf.parse(repayInfoReq.getRepayDate()));
				model.setRepay_int_amt(repayInfoReq.getRepayIntAmt());
				model.setStart_date(sdf.parse(repayInfoReq.getStartDate()));
				model.setReserved_field1(repayInfoReq.getReservedField1());
				model.setReserved_field2(repayInfoReq.getReservedField2());
				model.setReserved_field3(repayInfoReq.getReservedField3());
				modelList.add(model);
			}
			insertBatch(modelList);

			payInfo.setBatch_no(model.getBatch_no());
			payInfo.setData_type(PetitloanConstant.REPAY_INFO);
			payInfo.setRecord_count(repayInfoList.size());
			payInfo.setRepay_info(repayInfoList);
			VlidationUtil.validate(payInfo);
			logger.info(METHOD_NAMESPACE+"PayInfo is :"+payInfo);
			String js = JSON.toJSONString(payInfo);
			
			repayList.add(payInfo);
			logger.info(METHOD_NAMESPACE+"REPAY_INFO transt to xml start and js :"+js);
			TransactionBody<RepayInfo> transaction = (TransactionBody<RepayInfo>) JSON.parseObject(js,
					new TypeReference<TransactionBody<RepayInfo>>() {
					});
			transaction.setGettx(repayList);
			// 将java对象转换为XML字符串
			JaxbUtil requestBinder = new JaxbUtil(TransactionBody.class, CollectionWrapper.class);
			String retXml = requestBinder.toXml(transaction, "utf-8");
			retXml = JaxbUtil.trimStr(retXml);
			logger.info(METHOD_NAMESPACE+"REPAY_INFO transt to xml end and xml :"+retXml);
			//上传到FastDFS
			FileInfoVo fileInfo = CommonService.uploadFastDFSService(METHOD_NAMESPACE,ORG_CODE_KEY, retXml,payInfo.getData_type());
			String fileName = "";
			if(null != fileInfo){
				fileName = fileInfo.getFileName()+".xml";
			}else{
				logger.error(METHOD_NAMESPACE+"error, filePath is null");
				rs.setRetCode(RetCode.SYS_ERROR+"");
				rs.setRetMsg(RetCode.retMsg.get(RetCode.SYS_ERROR)+", filePath is null");
				return rs;
			}
			
			//上传业务body数据到重庆SFTP服务器
			boolean rst = CommonService.pushSftpService(METHOD_NAMESPACE,retXml, fileName);
			if(!rst){
				logger.error(METHOD_NAMESPACE+"pushSftpService failed");
				rs.setRetCode(RetCode.SYS_ERROR+"");
				rs.setRetMsg(RetCode.retMsg.get(RetCode.SYS_ERROR)+", pushSftpService failed");
				return rs;
			}
			
			//header对象转换成xml报文
			String retHeaderXml = CommonService.xmlHeaderService(METHOD_NAMESPACE,PetitloanConstant.TRAN_CODE_104,PetitloanConstant.MESSAGE_CODE_0104,ORG_CODE_KEY,payInfo.getBatch_no(), fileName);
			//上传header xml到socket服务器
			if(null != retHeaderXml){
				String scoketRs = CommonService.getScoketClient(METHOD_NAMESPACE,retHeaderXml);
				//解析返回的xml状态
				rs = CommonService.rsultStatusXmlToBean(rs,METHOD_NAMESPACE,scoketRs);
				//批量更新db中当前批次号状态
				RepayInfoModel updateModel = new RepayInfoModel();
				updateModel.setBatch_no(batchNo);
				updateModel.setPush_status(rs.getRetCode());
				updateModel.setBody_xml_path(fileInfo.getFilePath());
				update(updateModel);
				logger.info(METHOD_NAMESPACE+"update db,batchNo: "+batchNo+",pushStatus:"+rs.getRetCode());
			}else{
				logger.error(METHOD_NAMESPACE+" retHeaderXml is null");
				rs.setRetCode(RetCode.SYS_ERROR+"");
				rs.setRetMsg(RetCode.retMsg.get(RetCode.SYS_ERROR)+": retHeaderXml is null");
				return rs;
			}
			//更新数据库存报文状态
			
		} catch (ValidationException e) {
			logger.error(METHOD_NAMESPACE+"param error or null,"+e.getMessage());
			rs.setRetCode(RetCode.BUS_ARG_INVALID+"");
			rs.setRetMsg(RetCode.retMsg.get(RetCode.BUS_ARG_INVALID)+":"+e.getMessage());
			return rs;
		} catch (Exception e) {
			logger.error(METHOD_NAMESPACE+"error, msg:"+e.getMessage());
			rs.setRetCode(RetCode.SYS_ERROR+"");
			rs.setRetMsg(RetCode.retMsg.get(RetCode.SYS_ERROR)+":"+e.getMessage());
			return rs;
		}
		logger.info(METHOD_NAMESPACE+"end,rs:batchNo="+rs.getBatchNo()+",dataType="+rs.getDataType()+",retCode="+rs.getRetCode()+",retMsg="+rs.getRetMsg());
		return rs;
	}
}
