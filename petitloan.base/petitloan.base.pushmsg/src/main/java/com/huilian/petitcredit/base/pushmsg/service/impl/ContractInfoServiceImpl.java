package com.huilian.petitcredit.base.pushmsg.service.impl;

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
import com.huilian.petitcredit.base.pushmsg.dao.ContractInfoDao;
import com.huilian.petitcredit.base.pushmsg.model.ContractInfoModel;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.ContractInfo;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.ContractInfoList;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.TransactionBody;
import com.huilian.petitcredit.base.pushmsg.utils.DateUtils;
import com.huilian.petitcredit.base.pushmsg.utils.IdGen;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil;
import com.huilian.petitcredit.base.pushmsg.utils.PetitloanConstant;
import com.huilian.petitcredit.base.pushmsg.utils.SystemResource;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil.CollectionWrapper;
import com.huilian.petitcredit.base.pushmsg.utils.fastDFS.FileInfoVo;
import com.huilian.petitcredit.base.pushmsg.utils.vlidationBean.VlidationUtil;
import com.huilian.petitloan.pushmsg.ContractInfoReq;
import com.huilian.petitloan.pushmsg.ResPushStatus;


public class ContractInfoServiceImpl extends BaseServiceImpl<ContractInfoModel>{
	private static Logger logger = LoggerFactory.getLogger(ContractInfoServiceImpl.class);
	private static String METHOD_NAMESPACE = "【pushContractInfoReq】";
	private static String ORG_CODE_KEY = SystemResource.getConfigValue(SystemResource.ORG_CODE_KEY);
	private static String DATA_TYPE = PetitloanConstant.CONTRACT_INFO;
	@Override
	public Class<? extends BaseDao<ContractInfoModel>> getMapperClass() {
		// TODO Auto-generated method stub
		return ContractInfoDao.class;
	}

	@Override
	public BaseDao<ContractInfoModel> getDaoImpl() {
		// TODO Auto-generated method stub
		return (ContractInfoDao)super.getDao();
	}
	public ResPushStatus pushContractInfoReq(List<ContractInfoReq> req) {
		logger.info(METHOD_NAMESPACE+"start");
		ResPushStatus rs = new ResPushStatus();
		//当前批次号
		String batchNo = UniqId.getInstance().getUniqID();
		rs.setBatchNo(batchNo);
		rs.setDataType(DATA_TYPE);//当前接口数据类型
		try {
			if(null == req){
				rs.setRetCode(RetCode.BUS_ARG_INVALID+"");
				rs.setRetMsg(RetCode.retMsg.get(RetCode.BUS_ARG_INVALID));
				return rs;
			}
			
			ContractInfo contractInfo = new ContractInfo();
			ContractInfoList info = new ContractInfoList();
			List<ContractInfoModel> modelList = new ArrayList<ContractInfoModel>();
			List<ContractInfo> contractInfoList = new ArrayList<ContractInfo>();
			List<ContractInfoList> infoList = new ArrayList<ContractInfoList>();
			
			contractInfo.setLoan_contract_uuid(IdGen.uuid());
			contractInfo.setBatch_no(batchNo);
			contractInfo.setData_type(DATA_TYPE);
			contractInfo.setRecord_count(req.size());
			for (ContractInfoReq contractInfoReq : req) {
				
				info.setReport_type(contractInfoReq.getReportType());
				info.setOrg_code(ORG_CODE_KEY);
				info.setContract_no(contractInfoReq.getContractNo());
				info.setLoan_cate(contractInfoReq.getLoanCate());
				info.setContract_name(contractInfoReq.getContractName());
				info.setCustomer_type(contractInfoReq.getCustomerType());
				info.setCustomer_name(contractInfoReq.getCustomerName());
				info.setCertificate_type(contractInfoReq.getCertificateType());
				info.setCertificate_no(contractInfoReq.getCertificateNo());
				info.setLoan_object(contractInfoReq.getLoanObject());
				info.setLoan_object_size(contractInfoReq.getLoanObjectSize());
				info.setContract_sign_date(contractInfoReq.getContractSignDate());
				info.setContract_begin_date(contractInfoReq.getContractBeginDate());
				info.setContract_end_date(contractInfoReq.getContractEndDate());
				info.setContract_amount(contractInfoReq.getContractAmount());
				info.setOutstanding(contractInfoReq.getOutstanding());
				info.setGuar_type(contractInfoReq.getGuarType());
				info.setCcy(contractInfoReq.getCcy());
				info.setIs_real_quota_loan(contractInfoReq.getIsRealQuotaLoan());
				info.setInt_rate(contractInfoReq.getIntRate());
				info.setPri_plty_rate(contractInfoReq.getPriPltyRate());
				info.setContract_status(contractInfoReq.getContractStatus());
				info.setRelation_manager(contractInfoReq.getRelationManager());
				info.setDispute_scheme(contractInfoReq.getDisputeScheme());
				//校验obj是否为空
				VlidationUtil.validate(info);
				infoList.add(info);
				
				
				ContractInfoModel model = new ContractInfoModel();
				
				model.setLoan_contract_uuid(IdGen.uuid());
				model.setBatch_no(contractInfo.getBatch_no());
				model.setData_type(contractInfo.getData_type());
				model.setRecord_count(contractInfo.getRecord_count());
				model.setReport_type(contractInfoReq.getReportType());
				model.setOrg_code(ORG_CODE_KEY);
				model.setContract_no(contractInfoReq.getContractNo());
				model.setLoan_cate(contractInfoReq.getLoanCate());
				model.setContract_name(contractInfoReq.getContractName());
				model.setCustomer_type(contractInfoReq.getCustomerType());
				model.setCustomer_name(contractInfoReq.getCustomerName());
				model.setCertificate_type(contractInfoReq.getCertificateType());
				model.setCertificate_no(contractInfoReq.getCertificateNo());
				model.setLoan_object(contractInfoReq.getLoanObject());
				model.setLoan_object_size(contractInfoReq.getLoanObjectSize());
				model.setContract_sign_date(DateUtils.parseDate(contractInfoReq.getContractSignDate()));
				model.setContract_begin_date(DateUtils.parseDate(contractInfoReq.getContractBeginDate()));
				model.setContract_end_date(DateUtils.parseDate(contractInfoReq.getContractEndDate()));
				model.setContract_amount(contractInfoReq.getContractAmount());
				model.setOutstanding(contractInfoReq.getOutstanding());
				model.setGuar_type(contractInfoReq.getGuarType());
				model.setCcy(contractInfoReq.getCcy());
				model.setIs_real_quota_loan(contractInfoReq.getIsRealQuotaLoan());
				model.setInt_rate(contractInfoReq.getIntRate());
				model.setPri_plty_rate(contractInfoReq.getPriPltyRate());
				model.setContract_status(contractInfoReq.getContractStatus());
				model.setRelation_manager(contractInfoReq.getRelationManager());
				model.setDispute_scheme(contractInfoReq.getDisputeScheme());
				model.setPush_status(PetitloanConstant.PENDING_PUSH_STATUS);//推送状态 -1：未推送 0：推送成功 其它：失败
				modelList.add(model);
			}
	
			//将请求记录批量存储到db
			insertBatch(modelList);
			
			contractInfo.setContract_info(infoList);
			contractInfoList.add(contractInfo);
			String bodyJsonStr=JSON.toJSONString(contractInfo);
			logger.info(METHOD_NAMESPACE+" obj parse bodyJsonString: "+bodyJsonStr);
			TransactionBody<ContractInfo> transaction = (TransactionBody<ContractInfo>) JSON.parseObject(bodyJsonStr, new TypeReference<TransactionBody<ContractInfo>>(){});
			transaction.setGettx(contractInfoList);
			//将java对象转换为XML字符串                   
			JaxbUtil requestBinder = new JaxbUtil(TransactionBody.class,CollectionWrapper.class);  
			String retBodyXml = requestBinder.toXml(transaction, "utf-8"); 
			retBodyXml = JaxbUtil.trimStr(retBodyXml);
			logger.info(METHOD_NAMESPACE+" obj parse retBodyXml: "+retBodyXml);
			
			//上传到FastDFS
			FileInfoVo fileInfo = CommonService.uploadFastDFSService(METHOD_NAMESPACE,ORG_CODE_KEY, retBodyXml,contractInfo.getData_type());
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
			String retHeaderXml = CommonService.xmlHeaderService(METHOD_NAMESPACE,PetitloanConstant.TRAN_CODE_102,PetitloanConstant.MESSAGE_CODE_0102,ORG_CODE_KEY,contractInfo.getBatch_no(), fileName);
			//上传header xml到socket服务器
			if(null != retHeaderXml){
				String scoketRs = CommonService.getScoketClient(METHOD_NAMESPACE,retHeaderXml);
				//解析返回的xml状态
				rs = CommonService.rsultStatusXmlToBean(rs,METHOD_NAMESPACE,scoketRs);
				//批量更新db中当前批次号状态
				ContractInfoModel updateModel = new ContractInfoModel();
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
