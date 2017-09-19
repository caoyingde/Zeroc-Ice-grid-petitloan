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
import com.huilian.petitcredit.base.pushmsg.dao.AbNormalInfoDao;
import com.huilian.petitcredit.base.pushmsg.dao.BaseDao;
import com.huilian.petitcredit.base.pushmsg.model.AbNormalInfoModel;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.AbNormalInfo;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.AbNormalInfoList;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.TransactionBody;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil;
import com.huilian.petitcredit.base.pushmsg.utils.PetitloanConstant;
import com.huilian.petitcredit.base.pushmsg.utils.SystemResource;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil.CollectionWrapper;
import com.huilian.petitcredit.base.pushmsg.utils.fastDFS.FileInfoVo;
import com.huilian.petitcredit.base.pushmsg.utils.vlidationBean.VlidationUtil;
import com.huilian.petitloan.pushmsg.AbNormalInfoReq;
import com.huilian.petitloan.pushmsg.ResPushStatus;


public class AbNormalInfoServiceImpl extends BaseServiceImpl<AbNormalInfoModel>{


	private static Logger logger = LoggerFactory.getLogger(AbNormalInfoServiceImpl.class);
	private static String METHOD_NAMESPACE = "【pushNonNormalCustmerReq】";
	private static String DATA_TYPE = PetitloanConstant.ABNORMAL_INFO;
	private static String ORG_CODE_KEY = SystemResource.getConfigValue(SystemResource.ORG_CODE_KEY);
	private static SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDD");
	@Override
	public Class<? extends BaseDao<AbNormalInfoModel>> getMapperClass() {
		// TODO Auto-generated method stub
		return AbNormalInfoDao.class;
	}

	@Override
	public BaseDao<AbNormalInfoModel> getDaoImpl() {
		// TODO Auto-generated method stub
		return (AbNormalInfoDao) super.getDao();
	}

	
	public ResPushStatus pushNonNormalCustmerReq(List<AbNormalInfoReq> req) {
		ResPushStatus rs = new ResPushStatus();
		//当前批次号
		String batchNo = UniqId.getInstance().getUniqID();
		rs.setBatchNo(batchNo);
		rs.setDataType(DATA_TYPE);//当前接口数据类型
		try {
			if(req==null ){
				logger.info(METHOD_NAMESPACE+"req is invalid");
				rs.setRetCode(RetCode.BUS_ARG_INVALID+"");
				return rs;
			}
			logger.info(METHOD_NAMESPACE+"NonNormalCustmerReq :"+req);
			List<AbNormalInfoModel> modelList = new ArrayList<AbNormalInfoModel>();
			
			List<AbNormalInfo> infoList = new ArrayList<AbNormalInfo>();
			AbNormalInfo info = new AbNormalInfo();
			List<AbNormalInfoList> nomalInfoList = new ArrayList<AbNormalInfoList>();
			AbNormalInfoList normalInfo = new AbNormalInfoList();
			info.setBatch_no(batchNo);
			info.setData_type(DATA_TYPE);
			info.setRecord_count(req.size());
			
			for (AbNormalInfoReq abNormalInforeq : req) {
				
				//非正常用户信息上报字段 
				normalInfo.setReport_type(abNormalInforeq.getReportType());
				normalInfo.setOrg_code(ORG_CODE_KEY);
				normalInfo.setCustomer_type(abNormalInforeq.getCustomerType());
				normalInfo.setCustomer_name(abNormalInforeq.getCustomerName());
				normalInfo.setCertificate_type(abNormalInforeq.getCertificateType());
				normalInfo.setCertificate_no(abNormalInforeq.getCertificateNo());
				normalInfo.setReason(abNormalInforeq.getReason());
				normalInfo.setIndustry(abNormalInforeq.getIndustry());
				normalInfo.setZone(abNormalInforeq.getZone());
				normalInfo.setStart_date(abNormalInforeq.getStartDate());
				normalInfo.setEnd_date(abNormalInforeq.getEndDate());
				//校验obj是否为空
				VlidationUtil.validate(normalInfo);
				nomalInfoList.add(normalInfo);
				
				AbNormalInfoModel model = new AbNormalInfoModel();
				
				model.setBatch_no(info.getBatch_no());
				model.setNon_normal_uuid(UniqId.getInstance().getUniqID());
				model.setData_type(info.getData_type());
				model.setRecord_count(info.getRecord_count());
				model.setReport_type(abNormalInforeq.getReportType());
				model.setOrg_code(ORG_CODE_KEY);
				model.setCustomer_type(abNormalInforeq.getCustomerType());
				model.setCustomer_name(abNormalInforeq.getCustomerName());
				model.setCertificate_type(abNormalInforeq.getCertificateType());
				model.setCertificate_no(abNormalInforeq.getCertificateNo());
				model.setReason(abNormalInforeq.getReason());
				model.setIndustry(abNormalInforeq.getIndustry());
				model.setZone(abNormalInforeq.getZone());
				model.setStart_date(sdf.parse(abNormalInforeq.getStartDate()));
				model.setEnd_date(sdf.parse(abNormalInforeq.getEndDate()));
				model.setPush_status(PetitloanConstant.PENDING_PUSH_STATUS);
				modelList.add(model);
			}
			

			info.setAbnormal_info(nomalInfoList);
			infoList.add(info);
			//将请求记录批量存储到db
			insertBatch(modelList);
			String js = JSON.toJSONString(info);
			logger.info(METHOD_NAMESPACE+"ABNORMAL_INFO  transt to xml start and js :"+js);
			TransactionBody<AbNormalInfo> transaction = (TransactionBody<AbNormalInfo>) JSON.parseObject(js, new TypeReference<TransactionBody<AbNormalInfo>>(){});
			transaction.setGettx(infoList);
			//将java对象转换为XML字符串                   
			JaxbUtil requestBinder = new JaxbUtil(TransactionBody.class,  
					CollectionWrapper.class);  
			String retXml = requestBinder.toXml(transaction, "utf-8");  
			retXml = JaxbUtil.trimStr(retXml);
			logger.info(METHOD_NAMESPACE+"ABNORMAL_INFO  transt to xml end and xml :"+retXml);
			//上传到FastDFS
			FileInfoVo fileInfo = CommonService.uploadFastDFSService(METHOD_NAMESPACE,ORG_CODE_KEY, retXml,info.getData_type());
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
			String retHeaderXml = CommonService.xmlHeaderService(METHOD_NAMESPACE,PetitloanConstant.TRAN_CODE_106,PetitloanConstant.MESSAGE_CODE_0106,ORG_CODE_KEY,info.getBatch_no(), fileName);
			//上传header xml到socket服务器
			if(null != retHeaderXml){
				String scoketRs = CommonService.getScoketClient(METHOD_NAMESPACE,retHeaderXml);
				//解析返回的xml状态
				rs = CommonService.rsultStatusXmlToBean(rs,METHOD_NAMESPACE,scoketRs);
				AbNormalInfoModel model = new AbNormalInfoModel();
				model.setBatch_no(batchNo);
				model.setBody_xml_path(fileInfo.getFilePath());
				
				model.setPush_status(rs.getRetCode());
				update(model);
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
