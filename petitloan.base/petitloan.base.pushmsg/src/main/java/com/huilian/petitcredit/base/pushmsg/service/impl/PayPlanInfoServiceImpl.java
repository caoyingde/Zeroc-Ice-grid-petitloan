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
import com.huilian.petitcredit.base.pushmsg.dao.PayPlanInfoDao;
import com.huilian.petitcredit.base.pushmsg.model.PayPlanInfoModel;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.PayPlanInfo;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.PayPlanInfoList;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.TransactionBody;
import com.huilian.petitcredit.base.pushmsg.utils.IdGen;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil;
import com.huilian.petitcredit.base.pushmsg.utils.PetitloanConstant;
import com.huilian.petitcredit.base.pushmsg.utils.SystemResource;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil.CollectionWrapper;
import com.huilian.petitcredit.base.pushmsg.utils.fastDFS.FileInfoVo;
import com.huilian.petitcredit.base.pushmsg.utils.vlidationBean.VlidationUtil;
import com.huilian.petitloan.pushmsg.PayplanInfoReq;
import com.huilian.petitloan.pushmsg.ResPushStatus;


public class PayPlanInfoServiceImpl extends BaseServiceImpl<PayPlanInfoModel>{

	private static Logger logger = LoggerFactory.getLogger(PayPlanInfoServiceImpl.class);
	private static String METHOD_NAMESPACE = "【pushRepayPlanInfoReq】";
	private static String DATA_TYPE = PetitloanConstant.PAYPLAN_INFO;
	private static String ORG_CODE_KEY = SystemResource.getConfigValue(SystemResource.ORG_CODE_KEY);

	private static SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDD");
	@Override
	public Class<? extends BaseDao<PayPlanInfoModel>> getMapperClass() {
		// TODO Auto-generated method stub
		return PayPlanInfoDao.class;
	}

	@Override
	public BaseDao<PayPlanInfoModel> getDaoImpl() {
		// TODO Auto-generated method stub
		return (PayPlanInfoDao)super.getDao();
	}
	
	public ResPushStatus pushRepayPlanInfoReq(List<PayplanInfoReq> req) {
		logger.info(METHOD_NAMESPACE+"pushRepayPlanInfoReq start");
		ResPushStatus rs = new ResPushStatus();
		//当前批次号
		String batchNo = UniqId.getInstance().getUniqID();
		rs.setBatchNo(batchNo);
		rs.setDataType(DATA_TYPE);//当前接口数据类型
		try {
			if(req ==null){
				logger.info(METHOD_NAMESPACE+"RepayPlanInfoReq req is null!!!");
				rs.setRetCode(RetCode.BUS_ARG_INVALID+"");
				rs.setRetMsg(RetCode.retMsg.get(RetCode.BUS_ARG_INVALID));
			}
			if(req.isEmpty()){
				logger.info(METHOD_NAMESPACE+"req.isEmpty");
				rs.setRetCode(RetCode.BUS_ARG_INVALID+"");
				rs.setRetMsg(RetCode.retMsg.get(RetCode.BUS_ARG_INVALID));
				return rs;
			}
			PayPlanInfo info = new PayPlanInfo();
			PayPlanInfoList payInfo = new PayPlanInfoList();
			List<PayPlanInfo> infoList = new ArrayList<PayPlanInfo>();
			List<PayPlanInfoList> list = new ArrayList<PayPlanInfoList>();
			List<PayPlanInfoModel> modelList = new ArrayList<PayPlanInfoModel>();
			
			info.setBatch_no(batchNo);
			info.setData_type(DATA_TYPE);
			info.setRecord_count(req.size());
			info.setRepayment_plan_uuid(UniqId.getInstance().getUniqID());
			for (PayplanInfoReq payplanInfoReq : req) {
				
				payInfo.setReport_type(payplanInfoReq.getReportType());
				payInfo.setOrg_code(ORG_CODE_KEY);
				payInfo.setContract_no(payplanInfoReq.getContractNo());
				payInfo.setDue_bill_no(payplanInfoReq.getDueBillNo());
				payInfo.setCounter(payplanInfoReq.getCounter());
				payInfo.setRepay_date(payplanInfoReq.getRepayDate());
				payInfo.setRepay_pri_amt(payplanInfoReq.getRepayPriAmt());
				payInfo.setRepay_int_amt(payplanInfoReq.getRepayIntAmt());
				payInfo.setStart_date(payplanInfoReq.getStartDate());
				payInfo.setEnd_date(payplanInfoReq.getEndDate());
				//校验obj否为空
				VlidationUtil.validate(payInfo);
				list.add(payInfo);
				
				PayPlanInfoModel model = new PayPlanInfoModel();
				model.setRepayment_plan_uuid(IdGen.uuid());
				model.setData_type(info.getData_type());
				model.setBatch_no(batchNo);
				model.setRecord_count(info.getRecord_count());
				model.setReport_type(payplanInfoReq.getReportType());
				model.setOrg_code(ORG_CODE_KEY);
				model.setContract_no(payplanInfoReq.getContractNo());
				model.setDue_bill_no(payplanInfoReq.getDueBillNo());
				model.setCounter(payplanInfoReq.getCounter());
				model.setRepay_date(sdf.parse(payplanInfoReq.getRepayDate()));
				model.setRepay_pri_amt(payplanInfoReq.getRepayPriAmt());
				model.setRepay_int_amt(payplanInfoReq.getRepayIntAmt());
				model.setStart_date(sdf.parse(payplanInfoReq.getStartDate()));
				model.setEnd_date(sdf.parse(payplanInfoReq.getEndDate()));
				model.setReserved_field1(payplanInfoReq.getReservedField1());
				model.setReserved_field2(payplanInfoReq.getReservedField2());
				model.setReserved_field3(payplanInfoReq.getReservedField3());
				model.setPush_status(PetitloanConstant.PENDING_PUSH_STATUS);
				modelList.add(model);
			}
			logger.info(METHOD_NAMESPACE+"payPlanInfoDao insert start");
			
			//将请求记录批量存储到db
			insertBatch(modelList);
			
			//将还款的具体信息加入到还款计划信息数组；
			info.setPayplan_info(list);
			infoList.add(info);
			String js = JSON.toJSONString(info);
			logger.info(METHOD_NAMESPACE+"PAYPLAN_INFO transt to xml start and js:"+js);
			
			TransactionBody<PayPlanInfo> transaction = (TransactionBody<PayPlanInfo>) JSON.parseObject(js, new TypeReference<TransactionBody<PayPlanInfo>>(){});
			transaction.setGettx(infoList);
			//将java对象转换为XML字符串                   
			JaxbUtil requestBinder = new JaxbUtil(TransactionBody.class,  
					CollectionWrapper.class);  
			String retXml = requestBinder.toXml(transaction, "utf-8");  
			retXml = JaxbUtil.trimStr(retXml);
			logger.info(METHOD_NAMESPACE+"PAYPLAN_INFO transt to xml end and xml :"+retXml);
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
			String retHeaderXml = CommonService.xmlHeaderService(METHOD_NAMESPACE,PetitloanConstant.TRAN_CODE_105,PetitloanConstant.MESSAGE_CODE_0105,ORG_CODE_KEY,info.getBatch_no(), fileName);
			//上传header xml到socket服务器
			if(null != retHeaderXml){
				String scoketRs = CommonService.getScoketClient(METHOD_NAMESPACE,retHeaderXml);
				//解析返回的xml状态
				rs = CommonService.rsultStatusXmlToBean(rs,METHOD_NAMESPACE,scoketRs);
				//批量更新db中当前批次号状态
				PayPlanInfoModel updateModel = new PayPlanInfoModel();
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
