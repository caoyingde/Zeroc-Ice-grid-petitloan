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
import com.huilian.petitcredit.base.pushmsg.dao.QuotaInfoDao;
import com.huilian.petitcredit.base.pushmsg.model.QuotaInfoModel;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.QuotaInfo;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.QuotaInfoList;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.TransactionBody;
import com.huilian.petitcredit.base.pushmsg.utils.IdGen;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil;
import com.huilian.petitcredit.base.pushmsg.utils.PetitloanConstant;
import com.huilian.petitcredit.base.pushmsg.utils.SystemResource;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil.CollectionWrapper;
import com.huilian.petitcredit.base.pushmsg.utils.fastDFS.FileInfoVo;
import com.huilian.petitloan.pushmsg.QuotaInfoReq;
import com.huilian.petitloan.pushmsg.ResPushStatus;


public class QuotaInfoServiceImpl extends BaseServiceImpl<QuotaInfoModel>{

	private static Logger logger = LoggerFactory.getLogger(QuotaInfoServiceImpl.class);
	private static String METHOD_NAMESPACE = "【pushCreditLineReq】";
	private static String DATA_TYPE = PetitloanConstant.QUOTA_INFO;
	private static String ORG_CODE_KEY = SystemResource.getConfigValue(SystemResource.ORG_CODE_KEY);

	private static SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDD");
	@Override
	public Class<? extends BaseDao<QuotaInfoModel>> getMapperClass() {
		// TODO Auto-generated method stub
		return QuotaInfoDao.class;
	}

	@Override
	public BaseDao<QuotaInfoModel> getDaoImpl() {
		// TODO Auto-generated method stub
		return (QuotaInfoDao)super.getDao();
	}

	public ResPushStatus pushCreditLineReq(List<QuotaInfoReq> req) {
		logger.info(METHOD_NAMESPACE+"pushCreditLineReq is start ");
		ResPushStatus rs = new ResPushStatus();
		//当前批次号
		String batchNo = UniqId.getInstance().getUniqID();
		rs.setBatchNo(batchNo);
		rs.setDataType(DATA_TYPE);//当前接口数据类型
		try {
		
			if(req.isEmpty()){
				logger.info(METHOD_NAMESPACE+"CreditLineReq is null ");
				rs.setRetCode(RetCode.BUS_ARG_INVALID+"");
				rs.setRetMsg(RetCode.retMsg.get(RetCode.BUS_ARG_INVALID));
				return rs;
			}
			if(req.isEmpty()){
				logger.info(METHOD_NAMESPACE+"req.getNetbookInfoReqList is null");
				rs.setRetCode(RetCode.BUS_ARG_INVALID+"");
				rs.setRetMsg(RetCode.retMsg.get(RetCode.BUS_ARG_INVALID));
				return rs;
			}
			QuotaInfo quotaInfo = new QuotaInfo();
			QuotaInfoList info = new QuotaInfoList();
			List<QuotaInfo> quotaInfoList= new ArrayList<QuotaInfo>();
			List<QuotaInfoList> infoList= new ArrayList<QuotaInfoList>();
			List<QuotaInfoModel> modelList= new ArrayList<QuotaInfoModel>();
			
			
			
			quotaInfo.setBatch_no(batchNo);
			quotaInfo.setCredit_line_uuid(IdGen.uuid());
			quotaInfo.setData_type(DATA_TYPE);
			quotaInfo.setRecord_count(req.size());
			logger.info(METHOD_NAMESPACE+"QuotaInfoDao insertBacth in database start");
			for (QuotaInfoReq quotaInfoReq : req) {
				
				info.setReport_type(quotaInfoReq.getReportType());
				info.setOrg_code(ORG_CODE_KEY);
				info.setContract_no(quotaInfoReq.getContractNo());
				info.setContract_name(quotaInfoReq.getContractName());
				info.setCustomer_type(quotaInfoReq.getCustomerType());
				info.setCustomer_name(quotaInfoReq.getCustomerName());
				info.setCertificate_type(quotaInfoReq.getCertificateType());
				info.setCertificate_no(quotaInfoReq.getCertificateNo());
				info.setContract_sign_date(quotaInfoReq.getContractSignDate());
				info.setContract_begin_date(quotaInfoReq.getContractBeginDate());
				info.setContract_end_date(quotaInfoReq.getContractEndDate());
				info.setContract_amount(quotaInfoReq.getContractAmount());
				info.setCcy(quotaInfoReq.getCcy());
				info.setUsed_amount(quotaInfoReq.getUsedAmount());
				info.setRemain_amount(quotaInfoReq.getRemainAmount());
				info.setGuar_type(quotaInfoReq.getGuarType());
				info.setIs_circle(quotaInfoReq.getIsCircle());
				info.setContract_status(quotaInfoReq.getContractStatus());
				//下面的为不是必输项
				infoList.add(info);
				
				
				QuotaInfoModel model = new QuotaInfoModel();
				
				model.setBatch_no(quotaInfo.getBatch_no());
				model.setData_type(quotaInfo.getData_type());
				model.setCredit_line_uuid(IdGen.uuid());
				model.setRecord_count(quotaInfo.getRecord_count());
				model.setReport_type(quotaInfoReq.getReportType());
				model.setOrg_code(ORG_CODE_KEY);
				model.setContract_no(quotaInfoReq.getContractNo());
				model.setContract_name(quotaInfoReq.getContractName());
				model.setCustomer_type(quotaInfoReq.getCustomerType());
				model.setCustomer_name(quotaInfoReq.getCustomerName());
				model.setCertificate_type(quotaInfoReq.getCertificateType());
				model.setCertificate_no(quotaInfoReq.getCertificateNo());
				model.setContract_sign_date(sdf.parse(quotaInfoReq.getContractSignDate()));
				model.setContract_begin_date(sdf.parse(quotaInfoReq.getContractBeginDate()));
				model.setContract_end_date(sdf.parse(quotaInfoReq.getContractEndDate()));
				model.setContract_amount(quotaInfoReq.getContractAmount());
				model.setCcy(quotaInfoReq.getCcy());
				model.setUsed_amount(quotaInfoReq.getUsedAmount());
				model.setRemain_amount(quotaInfoReq.getRemainAmount());
				model.setGuar_type(quotaInfoReq.getGuarType());
				model.setIs_circle(quotaInfoReq.getIsCircle());
				model.setContract_status(quotaInfoReq.getContractStatus());
				model.setPush_status(PetitloanConstant.PENDING_PUSH_STATUS);
				//下面的为不是必输项
				modelList.add(model);
			}
			//将请求记录批量存储到db
			insertBatch(modelList);
			
			quotaInfo.setQuota_info(infoList);
			quotaInfoList.add(quotaInfo);
			logger.info(METHOD_NAMESPACE+"QuotaInfo package quotaiNfoList end");
			
			String js = JSON.toJSONString(quotaInfo);
			logger.info(METHOD_NAMESPACE+"js:"+js);
			TransactionBody<QuotaInfo> transaction = (TransactionBody<QuotaInfo>) JSON.parseObject(js, new TypeReference<TransactionBody<QuotaInfo>>(){});
			transaction.setGettx(quotaInfoList);
			//将java对象转换为XML字符串         
			logger.info(METHOD_NAMESPACE+"QUOTA_INFO  transt to xml start");
			JaxbUtil requestBinder = new JaxbUtil(TransactionBody.class,  
					CollectionWrapper.class);  
			String retXml = requestBinder.toXml(transaction, "utf-8");  
			retXml = JaxbUtil.trimStr(retXml);
			logger.info(METHOD_NAMESPACE+"QUOTA_INFO transt to xml end xml:"+retXml);
			//上传到FastDFS
			FileInfoVo fileInfo = CommonService.uploadFastDFSService(METHOD_NAMESPACE,ORG_CODE_KEY, retXml,quotaInfo.getData_type());
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
			String retHeaderXml = CommonService.xmlHeaderService(METHOD_NAMESPACE,PetitloanConstant.TRAN_CODE_101,PetitloanConstant.MESSAGE_CODE_0101,ORG_CODE_KEY,quotaInfo.getBatch_no(), fileName);
			//上传header xml到socket服务器
			if(null != retHeaderXml){
				String scoketRs = CommonService.getScoketClient(METHOD_NAMESPACE,retHeaderXml);
				//解析返回的xml状态
				rs = CommonService.rsultStatusXmlToBean(rs,METHOD_NAMESPACE,scoketRs);
				//批量更新db中当前批次号状态
				QuotaInfoModel updateModel = new QuotaInfoModel();
				updateModel.setBatch_no(batchNo);
				updateModel.setBody_xml_path(fileInfo.getFilePath());
				updateModel.setPush_status(rs.getRetCode());
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
