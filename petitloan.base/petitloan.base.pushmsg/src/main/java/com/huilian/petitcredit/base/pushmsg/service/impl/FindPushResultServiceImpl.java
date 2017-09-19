package com.huilian.petitcredit.base.pushmsg.service.impl;
import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huilian.hlej.market.constant.RetCode;
import com.huilian.petitcredit.base.pushmsg.dao.BaseDao;
import com.huilian.petitcredit.base.pushmsg.dao.NetBookInfoDao;
import com.huilian.petitcredit.base.pushmsg.model.NetBookInfoModel;
import com.huilian.petitcredit.base.pushmsg.utils.DateUtils;
import com.huilian.petitcredit.base.pushmsg.utils.PetitloanConstant;
import com.huilian.petitcredit.base.pushmsg.utils.SystemResource;
import com.huilian.petitloan.pushmsg.ResPushStatus;

public class FindPushResultServiceImpl extends BaseServiceImpl<NetBookInfoModel> {
	private static Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
	private static String METHOD_NAMESPACE = "【findPushResult】";

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
        	FindPushResultServiceImpl service = new FindPushResultServiceImpl();
        	String batchNo="342692078723";
        	String dataType="NETBOOK_INFO";
        	ResPushStatus rs = service.findPushResult(batchNo, dataType);
        	logger.info("batchNum="+rs.getBatchNo()+",dataTeyp="+rs.getDataType()+",code="+rs.getRetCode()+",msg="+rs.getRetMsg());
        }catch (Exception e) {
            System.out.println("exception occoured"+ e);
        }
    }
	/**
	 * 上报结果查询（PTLN199）
	 * @param req
	 * @return
	 */
	public ResPushStatus findPushResult(String batchNo, String dataType) {
		logger.info(METHOD_NAMESPACE+"start");
		ResPushStatus rs = new ResPushStatus();
		rs.setBatchNo(batchNo);
		rs.setDataType(dataType);
		try {
			if(null == batchNo){
				logger.info(METHOD_NAMESPACE+"batchNo is null");
				rs.setRetCode(RetCode.BUS_ARG_INVALID+"");
				rs.setRetMsg(RetCode.retMsg.get(RetCode.BUS_ARG_INVALID));
				return rs;
			}
			if(null == dataType){
				logger.info(METHOD_NAMESPACE+"dataType is null");
				rs.setRetCode(RetCode.BUS_ARG_INVALID+"");
				rs.setRetMsg(RetCode.retMsg.get(RetCode.BUS_ARG_INVALID));
				return rs;
			}
			String bodyxml = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><transaction><body><gettx><batch_no>"+batchNo+"</batch_no><data_type>"+dataType+"</data_type></gettx></body></transaction>";
			logger.info(METHOD_NAMESPACE+"bodyxml:"+bodyxml);

			String dateYYYYMMDD = DateUtils.strToDateFormat(DateUtils.formatDateTime(new Date()));
			int randomKey = (int)((Math.random()*9+1)*10000);
			String orgCode = SystemResource.getConfigValue(SystemResource.ORG_CODE_KEY);
			String fileName = orgCode+"-"+dateYYYYMMDD+"-"+dataType+"-"+randomKey+".xml";//91500000072322375D-20170913-NETBOOK_INFO-08.xml
			
			//上传业务body数据到重庆SFTP服务器
			boolean rst = CommonService.pushSftpService(METHOD_NAMESPACE,bodyxml, fileName);
			if(!rst){
				logger.error(METHOD_NAMESPACE+"pushSftpService failed");
				rs.setRetCode(RetCode.SYS_ERROR+"");
				rs.setRetMsg(RetCode.retMsg.get(RetCode.SYS_ERROR)+", pushSftpService failed");
				return rs;
			}
			
			//header对象转换成xml报文
			String retHeaderXml = CommonService.xmlHeaderService(METHOD_NAMESPACE,PetitloanConstant.TRAN_CODE_199,PetitloanConstant.MESSAGE_CODE_0199,orgCode,batchNo, fileName);
			//上传header xml到socket服务器
			if(null != retHeaderXml){
				String scoketRs = CommonService.getScoketClient(METHOD_NAMESPACE,retHeaderXml);
				logger.info(METHOD_NAMESPACE+"scoketRs:"+scoketRs);
				//解析返回的xml状态
				rs = CommonService.rsultStatusXmlToBean(rs,METHOD_NAMESPACE,scoketRs);
			}else{
				logger.error(METHOD_NAMESPACE+" retHeaderXml is null");
				rs.setRetCode(RetCode.SYS_ERROR+"");
				rs.setRetMsg(RetCode.retMsg.get(RetCode.SYS_ERROR)+": retHeaderXml is null");
				return rs;
			}
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
