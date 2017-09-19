package com.huilian.petitcredit.base.pushmsg.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.ValidationException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.huilian.hlej.base.utils.UniqId;
import com.huilian.hlej.market.constant.RetCode;
import com.huilian.petitcredit.base.pushmsg.dao.BaseDao;
import com.huilian.petitcredit.base.pushmsg.dao.NetBookInfoDao;
import com.huilian.petitcredit.base.pushmsg.model.NetBookInfoModel;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.NetBookInfo;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.NetBookInfoList;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.TransactionBody;
import com.huilian.petitcredit.base.pushmsg.utils.DateUtils;
import com.huilian.petitcredit.base.pushmsg.utils.IdGen;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil.CollectionWrapper;
import com.huilian.petitcredit.base.pushmsg.utils.vlidationBean.VlidationUtil;
import com.huilian.petitcredit.base.pushmsg.utils.PetitloanConstant;
import com.huilian.petitcredit.base.pushmsg.utils.SystemResource;
import com.huilian.petitcredit.base.pushmsg.utils.fastDFS.FileInfoVo;
import com.huilian.petitloan.pushmsg.NetBookInfoReq;
import com.huilian.petitloan.pushmsg.ResPushStatus;

public class NetbookInfoServiceImpl extends BaseServiceImpl<NetBookInfoModel> {
	private static Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
	private static String DATA_TYPE = PetitloanConstant.DATA_TYPE_NETBOOK_INFO;
	private static String ORG_CODE_KEY = SystemResource.getConfigValue(SystemResource.ORG_CODE_KEY);
	private static String METHOD_NAMESPACE = "【pushNetbookInfo】";


	@Override
	public Class<? extends BaseDao<NetBookInfoModel>> getMapperClass() {
		return NetBookInfoDao.class;
	}

	public NetBookInfoDao getDaoImpl() {
		return (NetBookInfoDao) super.getDao();
	}
	@Test
    public void netbookinfo () {
        try {
        	NetbookInfoServiceImpl service = new NetbookInfoServiceImpl();
        	List<NetBookInfoReq> reqList = new ArrayList<NetBookInfoReq>();
        	for (int i = 1; i < 10; i++) {
        		NetBookInfoReq req = new NetBookInfoReq();
        		req.setContractNo((int)((Math.random()*9+1)*1000000000)+"");//合同编号 10位随机数
        		req.setLoanCate(PetitloanConstant.PL_53_530001);//贷款类别	6	M	参见“PL_53”
        		req.setCustomerType(PetitloanConstant.PL_48_480001);//借款人类别	6	M	参见“PL_48”
        		req.setCustomerName("张三"+i);
        		req.setCertificateType(PetitloanConstant.PL_15_150001); //借款人证件类型	6	M	主借款人证件类型，参见“PL_15”
        		req.setConCertificateNo("36073118898585652"+i);//借款人证件号码	50	M	主借款人证件号
        		req.setContractAmount((float)10000.00+i);//合同金额	16,2	M	以元为单位，两位小数
        		String dateYYYYMMDD = DateUtils.strToDateFormat(DateUtils.formatDateTime(new Date()));
        		req.setContratSignDate(dateYYYYMMDD);//合同签订日期	8	M	YYYYMMDD
        		req.setIntRate((float)0.08+i);//月利率(‰)	14,8	M
        		reqList.add(req);
			}
        	ResPushStatus rs = service.pushNetbookInfo(reqList);
        	logger.info("batchNum="+rs.getBatchNo()+",dataTeyp="+rs.getDataType()+",code="+rs.getRetCode()+",msg="+rs.getRetMsg());
        }catch (Exception e) {
            System.out.println("exception occoured"+ e);
        }
    }
	/**
	 * 网签文件上报（PTLN107）
	 * @param req
	 * @return
	 */
	public ResPushStatus pushNetbookInfo(List<NetBookInfoReq> req) {
		logger.info(METHOD_NAMESPACE+"start");
		ResPushStatus rs = new ResPushStatus();
		//当前批次号
		String batchNo = UniqId.getInstance().getUniqID();
		rs.setBatchNo(batchNo);
		rs.setDataType(DATA_TYPE);//当前接口数据类型
		try {
			if(null == req){
				logger.info(METHOD_NAMESPACE+"req is null");
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
			// TODO Auto-generated method stub
			List<NetBookInfo> list = new ArrayList<NetBookInfo>();
			NetBookInfo obj = new NetBookInfo();
			obj.setBatch_no(batchNo);
			obj.setData_type(DATA_TYPE);
			obj.setRecord_count(req.size());
			//校验obj是否为空
			VlidationUtil.validate(obj);
			List<NetBookInfoList> _list = new ArrayList<NetBookInfoList>();
			
			List<NetBookInfoModel> infoList = new ArrayList<NetBookInfoModel>();
			for (NetBookInfoReq _req : req) {
				NetBookInfoList _obj = new NetBookInfoList();
				_obj.setOrg_code(ORG_CODE_KEY);
				_obj.setContract_no(_req.getContractNo());
				_obj.setLoan_cate(_req.getLoanCate());
				_obj.setCustomer_type(_req.getCustomerType());
				_obj.setCustomer_name(_req.getCustomerName());
				_obj.setCertificate_type(_req.getCertificateType());
				_obj.setCertificate_no(_req.getCertificateNo());
				_obj.setContract_amount(_req.getContractAmount());
				_obj.setContract_sign_date(_req.getContratSignDate());
				_obj.setInt_rate(_req.getIntRate());
				//校验obj否为空
				VlidationUtil.validate(_obj);
				_list.add(_obj);
				
				//组装model对象 插入db
				NetBookInfoModel model = new NetBookInfoModel();
				model.setNet_book_uuid(IdGen.uuid());
				model.setBatch_no(obj.getBatch_no());
				model.setData_type(obj.getData_type());
				model.setRecord_count(obj.getRecord_count());
				//info
				model.setOrg_code(ORG_CODE_KEY);
				model.setContract_no(_req.getContractNo());
				model.setLoan_cate(_req.getLoanCate());
				model.setCustomer_type(_req.getCustomerType());
				model.setCustomer_name(_req.getCustomerName());
				model.setCertificate_type(_req.getCertificateType());
				model.setCertificate_no(_req.getCertificateNo());
				model.setContract_amount(_req.getContractAmount());
				model.setContract_sign_date(_req.getContratSignDate());
				model.setInt_rate(_req.getIntRate());
				model.setPush_status(PetitloanConstant.PENDING_PUSH_STATUS);//推送状态 -1：未推送 0：推送成功 其它：失败
				infoList.add(model);
			}
			obj.setNetbook_info(_list);
			list.add(obj);
			//将请求记录批量存储到db
			insertBatch(infoList);
			
			String bodyJsonStr=JSON.toJSONString(obj);
			logger.info(METHOD_NAMESPACE+"NetBookInfo obj parse bodyJsonString: "+bodyJsonStr);
			TransactionBody<NetBookInfo> transaction = (TransactionBody<NetBookInfo>) JSON.parseObject(bodyJsonStr, new TypeReference<TransactionBody<NetBookInfo>>(){});
			transaction.setGettx(list);
			//将java对象转换为XML字符串                   
			JaxbUtil requestBinder = new JaxbUtil(TransactionBody.class,CollectionWrapper.class);  
			String retBodyXml = requestBinder.toXml(transaction, "utf-8"); 
			retBodyXml = JaxbUtil.trimStr(retBodyXml);
			logger.info(METHOD_NAMESPACE+"NetBookInfo obj parse retBodyXml: "+retBodyXml);
			
			//上传到FastDFS
			FileInfoVo fileInfo = CommonService.uploadFastDFSService(METHOD_NAMESPACE,ORG_CODE_KEY, retBodyXml,DATA_TYPE);
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
			String retHeaderXml = CommonService.xmlHeaderService(METHOD_NAMESPACE,PetitloanConstant.TRAN_CODE_107,PetitloanConstant.MESSAGE_CODE_0107,ORG_CODE_KEY,obj.getBatch_no(), fileName);
			//上传header xml到socket服务器
			if(null != retHeaderXml){
				String scoketRs = CommonService.getScoketClient(METHOD_NAMESPACE,retHeaderXml);
				//解析返回的xml状态
				rs = CommonService.rsultStatusXmlToBean(rs,METHOD_NAMESPACE,scoketRs);
				//批量更新db中当前批次号状态
				NetBookInfoModel updateModel = new NetBookInfoModel();
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
