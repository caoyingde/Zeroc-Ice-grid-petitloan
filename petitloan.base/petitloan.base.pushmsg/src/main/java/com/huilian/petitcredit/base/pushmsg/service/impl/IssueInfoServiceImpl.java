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
import com.huilian.petitcredit.base.pushmsg.dao.IssueInfoDao;
import com.huilian.petitcredit.base.pushmsg.model.IssueInfoModel;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.IssueInfo;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.IssueInfoList;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.TransactionBody;
import com.huilian.petitcredit.base.pushmsg.utils.IdGen;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil;
import com.huilian.petitcredit.base.pushmsg.utils.PetitloanConstant;
import com.huilian.petitcredit.base.pushmsg.utils.SystemResource;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil.CollectionWrapper;
import com.huilian.petitcredit.base.pushmsg.utils.fastDFS.FileInfoVo;
import com.huilian.petitcredit.base.pushmsg.utils.vlidationBean.VlidationUtil;
import com.huilian.petitloan.pushmsg.IssueInfoReq;
import com.huilian.petitloan.pushmsg.ResPushStatus;


public class IssueInfoServiceImpl extends BaseServiceImpl<IssueInfoModel>{
	private static Logger logger = LoggerFactory.getLogger(IssueInfoServiceImpl.class);
	private static String METHOD_NAMESPACE = "【pushLoanLaunchReq】";
	private static String DATA_TYPE = PetitloanConstant.ISSUE_INFO;
	private static String ORG_CODE_KEY = SystemResource.getConfigValue(SystemResource.ORG_CODE_KEY);

	private static SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDD");
	
	@Override
	public Class<? extends BaseDao<IssueInfoModel>> getMapperClass() {
		return IssueInfoDao.class;
	}

	@Override
	public BaseDao<IssueInfoModel> getDaoImpl() {
		return (IssueInfoDao) super.getDao();
	}
	
	public ResPushStatus pushLoanLaunchReq(List<IssueInfoReq> req) {
		logger.info(METHOD_NAMESPACE+"pushLoanLaunchReq Is start!!");
		ResPushStatus rs = new ResPushStatus();
		//当前批次号
		String batchNo = UniqId.getInstance().getUniqID();
		rs.setBatchNo(batchNo);
		rs.setDataType(DATA_TYPE);//当前接口数据类型
		try {
			if(null == req ){
				logger.info(METHOD_NAMESPACE+"req is null ");
				rs.setRetCode(RetCode.BUS_ARG_INVALID+"");
				rs.setRetMsg(RetCode.retMsg.get(RetCode.BUS_ARG_INVALID));
				return rs;
			}
			if(req.isEmpty()){
				logger.info(METHOD_NAMESPACE+"req.isEmpty");
				rs.setRetCode(RetCode.BUS_ARG_INVALID+"");
				rs.setRetMsg(RetCode.retMsg.get(RetCode.BUS_ARG_INVALID));
				return rs;
			}
			IssueInfo issueInfo = new IssueInfo();
			IssueInfoList info = new IssueInfoList();
			List<IssueInfo> infoList= new ArrayList<IssueInfo>();
			List<IssueInfoList> issueInfoList= new ArrayList<IssueInfoList>();
			List<IssueInfoModel> modelList= new ArrayList<IssueInfoModel>();
			
			issueInfo.setLoan_launch_uuid(IdGen.uuid());
			issueInfo.setBatch_no(batchNo);
			issueInfo.setData_type(DATA_TYPE);
			issueInfo.setRecord_count(req.size());
			for (IssueInfoReq issueInfoReq : req) {
				
				info.setReport_type(issueInfoReq.getReportType());
				info.setOrg_code(ORG_CODE_KEY);
				info.setContract_no(issueInfoReq.getContractNo());
				info.setDue_bill_no(issueInfoReq.getDueBillNo());
				info.setCustomer_type(issueInfoReq.getCustomerType());
				info.setCustomer_name(issueInfoReq.getCustomerName());
				info.setCertificate_type(issueInfoReq.getCertificateType());
				info.setCertificate_no(issueInfoReq.getCertificateNo());
				info.setDd_amt(issueInfoReq.getDdAmt());
				info.setLoan_cate(issueInfoReq.getLoanCate());
				info.setInt_rate(issueInfoReq.getIntRate());
				info.setRate_type(issueInfoReq.getRateType());
				info.setSign_date(issueInfoReq.getSignDate());
				info.setDd_date(issueInfoReq.getDdDate());
				info.setMature_date(issueInfoReq.getMatureDate());
				//中间的几个可以不写，这里就不写了
				info.setZone(issueInfoReq.getZone());
				info.setGuar_type(issueInfoReq.getGuarType());
				info.setTerm(issueInfoReq.getTerm());
				info.setPurpose(issueInfoReq.getPurpose());
				info.setLoan_object(issueInfoReq.getLoanObject());
				info.setLoan_object_size(issueInfoReq.getLoanObjectSize());
				info.setRate_calc_mode(issueInfoReq.getRateCalcMode());
				info.setRepay_mode(issueInfoReq.getRepayMode());
				info.setIndustry(issueInfoReq.getIndustry());
				info.setRisk_level(issueInfoReq.getRiskLevel());
				info.setIssue_status(issueInfoReq.getIssueStatus());
				VlidationUtil.validate(info);
				//下面的几个不是必须项
				issueInfoList.add(info);
				IssueInfoModel model = new IssueInfoModel();
				model.setLoan_launch_uuid(IdGen.uuid());
				model.setBatch_no(issueInfo.getBatch_no());
				model.setData_type(issueInfo.getData_type());
				model.setRecord_count(req.size());
				model.setReport_type(issueInfoReq.getReportType());
				model.setOrg_code(ORG_CODE_KEY);
				model.setContract_no(issueInfoReq.getContractNo());
				model.setDue_bill_no(issueInfoReq.getDueBillNo());
				model.setCustomer_type(issueInfoReq.getCustomerType());
				model.setCustomer_name(issueInfoReq.getCustomerName());
				model.setCertificate_type(issueInfoReq.getCertificateType());
				model.setCertificate_no(issueInfoReq.getCertificateNo());
				model.setDd_amt(issueInfoReq.getDdAmt());
				model.setLoan_cate(issueInfoReq.getLoanCate());
				model.setInt_rate(issueInfoReq.getIntRate());
				model.setRate_type(issueInfoReq.getRateType());
				model.setSign_date(sdf.parse(issueInfoReq.getSignDate()));
				model.setDd_date(sdf.parse(issueInfoReq.getDdDate()));
				model.setMature_date(sdf.parse(issueInfoReq.getMatureDate()));
				//中间的几个可以不写，这里就不写了
				model.setZone(issueInfoReq.getZone());
				model.setGuar_type(issueInfoReq.getGuarType());
				model.setTerm(issueInfoReq.getTerm());
				model.setPurpose(issueInfoReq.getPurpose());
				model.setLoan_object(issueInfoReq.getLoanObject());
				model.setLoan_object_size(issueInfoReq.getLoanObjectSize());
				model.setRate_calc_mode(issueInfoReq.getRateCalcMode());
				model.setIndustry(issueInfoReq.getIndustry());
				model.setRisk_level(issueInfoReq.getRiskLevel());
				model.setIssue_status(issueInfoReq.getIssueStatus());
				model.setPush_status(PetitloanConstant.PENDING_PUSH_STATUS);
				//下面的几个不是必须项
				modelList.add(model);
			}
			
			//将请求记录批量存储到db
			insertBatch(modelList);
			
			issueInfo.setIssue_info(issueInfoList);
			infoList.add(issueInfo);
			String js = JSON.toJSONString(issueInfo);
			logger.info(METHOD_NAMESPACE+"ISSUE_INFO  transt to xml start and js :"+js);
			TransactionBody<IssueInfo> transaction = (TransactionBody<IssueInfo>) JSON.parseObject(js, new TypeReference<TransactionBody<IssueInfo>>(){});
			transaction.setGettx(infoList);
			//将java对象转换为XML字符串                   
			JaxbUtil requestBinder = new JaxbUtil(TransactionBody.class,CollectionWrapper.class);  
			String retBodyXml = requestBinder.toXml(transaction, "utf-8"); 
			retBodyXml = JaxbUtil.trimStr(retBodyXml);
			logger.info(METHOD_NAMESPACE+" obj parse retBodyXml: "+retBodyXml);
			
			//上传到FastDFS
			FileInfoVo fileInfo = CommonService.uploadFastDFSService(METHOD_NAMESPACE,ORG_CODE_KEY, retBodyXml,issueInfo.getData_type());
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
			boolean rst = CommonService.pushSftpService(METHOD_NAMESPACE,retBodyXml, fileName);
			if(!rst){
				logger.error(METHOD_NAMESPACE+"pushSftpService failed");
				rs.setRetCode(RetCode.SYS_ERROR+"");
				rs.setRetMsg(RetCode.retMsg.get(RetCode.SYS_ERROR)+", pushSftpService failed");
				return rs;
			}
			
			//header对象转换成xml报文
			String retHeaderXml = CommonService.xmlHeaderService(METHOD_NAMESPACE,PetitloanConstant.TRAN_CODE_103,PetitloanConstant.MESSAGE_CODE_0103,ORG_CODE_KEY,issueInfo.getBatch_no(), fileName);
			//上传header xml到socket服务器
			if(null != retHeaderXml){
				String scoketRs = CommonService.getScoketClient(METHOD_NAMESPACE,retHeaderXml);
				//解析返回的xml状态
				rs = CommonService.rsultStatusXmlToBean(rs,METHOD_NAMESPACE,scoketRs);
				//批量更新db中当前批次号状态
				IssueInfoModel updateModel = new IssueInfoModel();
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
