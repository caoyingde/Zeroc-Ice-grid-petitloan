package com.huilian.petitcredit.base.pushmsg.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.huilian.hlej.base.utils.UniqId;
import com.huilian.hlej.market.constant.RetCode;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.HeaderRes;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.Msg;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.RetList;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.Transaction;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.XmlHeaderReq;
import com.huilian.petitcredit.base.pushmsg.utils.DateUtils;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil;
import com.huilian.petitcredit.base.pushmsg.utils.PetitloanConstant;
import com.huilian.petitcredit.base.pushmsg.utils.SFTPUtils;
import com.huilian.petitcredit.base.pushmsg.utils.SystemResource;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil.CollectionWrapper;
import com.huilian.petitcredit.base.pushmsg.utils.ReturnCode.PetiloanCode;
import com.huilian.petitcredit.base.pushmsg.utils.fastDFS.FileHandler;
import com.huilian.petitcredit.base.pushmsg.utils.fastDFS.FileInfoVo;
import com.huilian.petitloan.pushmsg.ResPushStatus;

public class CommonService {
	private static Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
	/**
	 * 上传到FastDFS
	 * @param orgCode
	 * @param retBodyXml
	 * @return
	 * @throws ParseException
	 * @throws Exception
	 */
	public static FileInfoVo uploadFastDFSService(String namespace,String orgCode, String retBodyXml,String dataType) throws ParseException, Exception {
		logger.info(namespace+"uploadFastDFSService start,orgCode: "+orgCode+"retBodyXml:"+retBodyXml);
		FileInfoVo fileInfo = new FileInfoVo();
		if(null != orgCode && null != retBodyXml){
			FileHandler util = new FileHandler();
			fileInfo.setFileFormat("xml");
			String dateYYYYMMDD = DateUtils.strToDateFormat(DateUtils.formatDateTime(new Date()));
			int randomKey = (int)((Math.random()*9+1)*1000);
			String fileName = orgCode+"-"+dateYYYYMMDD+"-"+dataType+"-"+randomKey;//91500000072322375D-20170913-NETBOOK_INFO-08.xml
			fileInfo.setFileName(fileName);
			fileInfo.setFileNo(UniqId.getInstance().getUniqID());
			fileInfo = util.upload(retBodyXml.getBytes(), fileInfo);
			//fastDfs返回文件名
		}else{
			logger.error(namespace+"uploadFastDFSService error,param is null ");
			return null;
		}
		logger.info(namespace+"uploadFastDFSService end,rs fileInfo: "+fileInfo);
		//从fastDFS下载
		//byte[] reportXml = util.downloadFile(filePath);
		return fileInfo;
	}
	
	/**
	 * 上传业务body数据到重庆SFTP服务器
	 * 
	 * @param retBodyXml
	 * @param fileName
	 * @return
	 */
	public static boolean pushSftpService(String namespace,String retBodyXml, String fileName) {
		long startTime = System.currentTimeMillis(); // 记录起始时间
		logger.info(namespace+"pushSftpService start,retBodyXml:" + retBodyXml+"fileName:"+fileName);
		boolean rs = false;
		SFTPUtils sftp = new SFTPUtils();
		try {
			if(null != retBodyXml && null != fileName){
				logger.info(namespace+"pushSftpService upload sftp start ");
				InputStream inputXml = new ByteArrayInputStream(retBodyXml.getBytes());
				sftp = new SFTPUtils(SystemResource.getConfigValue(SystemResource.SFTP_IP_KEY),
						Integer.parseInt(SystemResource.getConfigValue(SystemResource.SFTP_PORT_KEY)),
						SystemResource.getConfigValue(SystemResource.SFTP_USER_KEY),
						SystemResource.getConfigValue(SystemResource.SFTP_PASSWORD_KEY));
				sftp.connect();
				rs = sftp.uploadFileByByte("/", fileName, inputXml);
			}else{
				logger.error(namespace+"pushSftpService upload sftp error,param is null ");
				return rs;
			}
		} catch (Exception e) {
			logger.error(namespace+"pushSftpService upload sftp error: " + e.getMessage());
			e.printStackTrace();
			return rs;
		} finally {
			sftp.disconnect();
			logger.info(namespace+"pushSftpService upload sftp end,rs: "+rs);
		}
		long endTime=System.currentTimeMillis();
		float excTime=(float)(endTime-startTime)/1000;
		logger.info(namespace+"pushSftpService end,执行时间："+excTime+"s,rs: "+rs);
		return rs;
	}

	/**
	 * 封装Header报文
	 * 
	 * @param obj
	 * @param dateYYYYMMDD
	 * @param fileName
	 * @return
	 */
	public static String xmlHeaderService(String namespace,String TranCode,String messageCode,String orgCode, String seqNo ,String fileName) {
		logger.info(namespace+"xmlHeaderService start,orgCode: " + orgCode + ",seqNo:"+seqNo+",fileName:" + fileName);
		String retHeaderXml = null;
		try {
			if (null != orgCode && null != seqNo && null != fileName) {
				XmlHeaderReq xmlHeader = new XmlHeaderReq();
				xmlHeader.setSERVICE_CODE(PetitloanConstant.SERVICE_CODE_SVR_FILE);// 文件
				xmlHeader.setTRAN_CODE(TranCode);
				xmlHeader.setTRAN_MODE(PetitloanConstant.TRAN_MODE_ASYNC);
				xmlHeader.setBRANCH_ID(orgCode);// 组织机构代码
				xmlHeader.setTRAN_DATE(DateUtils.strToDateFormat(DateUtils.formatDateTime(new Date())));
				xmlHeader.setTRAN_TIMESTAMP(DateUtils.getTimeStampHMSN());
				xmlHeader.setUSER_LANG(PetitloanConstant.USER_LANG_CHINESE);
				xmlHeader.setSEQ_NO(seqNo);// 渠道流水号 小贷公司保证自身流水号不重复
				xmlHeader.setMODULE_ID(PetitloanConstant.MODULE_ID);
				xmlHeader.setMESSAGE_TYPE(PetitloanConstant.MESSAGE_TYPE);
				xmlHeader.setMESSAGE_CODE(messageCode);
				xmlHeader.setFILE_PATH(fileName);
				List<XmlHeaderReq> headerList = new ArrayList<XmlHeaderReq>();
				headerList.add(xmlHeader);
				String headerJsonStr = JSON.toJSONString(xmlHeader);
				logger.info(namespace+"pushNetbookInfo obj parse headerJsonStr: " + headerJsonStr);
				Transaction<XmlHeaderReq> transactionHeader = (Transaction<XmlHeaderReq>) 
						JSON.parseObject(headerJsonStr,new TypeReference<Transaction<XmlHeaderReq>>() {});
				transactionHeader.setMsg(headerList);
				// 将java对象转换为XML字符串
				JaxbUtil requestBinderHeader = new JaxbUtil(Transaction.class, CollectionWrapper.class);
				retHeaderXml = requestBinderHeader.toXml(transactionHeader, "utf-8");
				retHeaderXml = JaxbUtil.trimStr(retHeaderXml);
				//追加文件内容
				try {
		        	InputStream fileRead = new ByteArrayInputStream(retHeaderXml.getBytes());
		        	String fileSize = autoGenericCode(fileRead.available(),8);
					logger.info(namespace+"xmlHeaderService header fileSize:"+ fileSize);
		            BufferedWriter out = new BufferedWriter(new FileWriter("headerFileSize"));
		            out.write(fileSize);
		            out.close();
		            out = new BufferedWriter(new FileWriter("headerFileSize",true));
		            out.write(retHeaderXml);
		            out.close();
		            BufferedReader in = new BufferedReader(new FileReader("headerFileSize"));
		            String str;
		            while ((str = in.readLine()) != null) {
		            	retHeaderXml = str;
						logger.info(namespace+"xmlHeaderService  header append fileSize:"+ retHeaderXml);
		            }
		            in.close();
		        }catch (IOException e) {
					logger.info(namespace+"xmlHeaderService  header exception occoured,errMsg:"+ e.getMessage());
					e.printStackTrace();
					return retHeaderXml;
		        }
			}else{
				logger.info(namespace+"xmlHeaderService  header error, this param is null");
				return retHeaderXml;
			}
		} catch (ParseException e) {
			logger.error(namespace+"xmlHeaderService  header error,msg:"+e.getMessage());
			e.printStackTrace();
			return retHeaderXml;
		}
		logger.info(namespace+"xmlHeaderService  header end, rs retHeaderXml:" + retHeaderXml);
		return retHeaderXml;
	}
	/**
	 * 推送header报文到scoket服务器
	 * @param fileRead
	 * @return
	 * @throws Exception
	 */
	public static String getScoketClient(String namespace,String headerXml) throws Exception {
		logger.info(namespace+"getScoketClient,start" );
		String rs = "";
		if(null == headerXml){
			logger.info(namespace+"getScoketClient param headerXml is null " );
			return rs;
		}
		try {
			// 建立Socket服务
			Socket socket = new Socket(SystemResource.getConfigValue(SystemResource.SOCKET_IP_KEY), Integer.parseInt(SystemResource.getConfigValue(SystemResource.SOCKET_PORT_KEY)));
			// 从客户端本地读取文件,并写入socket的输出流中
			OutputStream out = socket.getOutputStream();
			// 建立数组
			byte[] buf = new byte[1024];
			int len = 0;
			InputStream fileRead = new ByteArrayInputStream(headerXml.getBytes());
			// 判断是否读到文件末尾
			while ((len = fileRead.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			logger.info(namespace+"getScoketClient,headerXml File size:" + fileRead.available()+",len:"+len);
			// 告诉服务端，文件已传输完毕
			socket.shutdownOutput();
			// 获取从服务端反馈的信息
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			rs = in.readLine();
			logger.info(namespace+"getScoketClient,rs:" + rs);
			// 资源关闭
			socket.close();
			fileRead.close();
		} catch (Exception e) {
			logger.info(namespace+"getScoketClient,can not listen to:" + e.getMessage());// 出错，打印出错信息
			e.printStackTrace();
		}
		logger.info(namespace+"getScoketClient,end rs:"+rs );
		return rs;
	}
	/**
	 * 解析返回的socket xml状态
	 * @param scoketRs
	 * @return
	 */
	public static ResPushStatus rsultStatusXmlToBean(ResPushStatus rs,String namespace,String scoketRs) {
		try {
			if(null != scoketRs){
				logger.info(namespace+"rsultStatusXmlToBean getScoketClient scoketRS return ："+scoketRs);
				//截取掉xml前8位长度
				scoketRs=scoketRs.substring(8);
				 HeaderRes headerRes = JaxbUtil.converyToJavaBean(scoketRs, HeaderRes.class);  
				if(null != headerRes){
					Msg msg = headerRes.getHeader().getMsg();
					if(null != msg.getRET()){
						List<RetList> retList =  msg.getRET();
						if(!retList.isEmpty()){
							for (RetList retObj : retList) {
								logger.info(namespace+"rsultStatusXmlToBean ret return retCode："+retObj.getRET_CODE()+"retMsg："+retObj.getRET_MSG());
								if(PetiloanCode.SUCCESS.getValue().equals(retObj.getRET_CODE())){
									logger.info(namespace+"================ rsultStatusXmlToBean SUCCESS ================");
									rs.setRetCode(retObj.getRET_CODE());
									rs.setRetMsg(retObj.getRET_MSG());
									return rs;
								}else{
									logger.info(namespace+"================ rsultStatusXmlToBean ERROR ================");
									rs.setRetCode(retObj.getRET_CODE());
									rs.setRetMsg(retObj.getRET_MSG());
									return rs;
								}
							}
						}
					}else{
						logger.error(namespace+"rsultStatusXmlToBean getScoketClient failed,scoketRS return null");
						rs.setRetCode(RetCode.SYS_FAILURE+"");
						rs.setRetMsg(RetCode.retMsg.get(RetCode.SYS_FAILURE)+":rsultStatusXmlToBean getScoketClient failed,scoketRS return null");
						return rs;
					}
				}
			}
		} catch (Exception e) {
			logger.error(namespace+"rsultStatusXmlToBean error,"+e.getMessage());
			rs.setRetCode(RetCode.SYS_ERROR+"");
			rs.setRetMsg(RetCode.retMsg.get(RetCode.SYS_ERROR));
			return rs;
		}
		return rs;
	}
	 /**
     * 不够位数的在前面补0，保留num的长度位数字
     * @param code
     * @return
     */
    private static String autoGenericCode(int code, int num) {
        String result = "";
        // 保留num的位数
        // num 代表长度为4     
        // d 代表参数为正数型 
        result = String.format("%0" + num + "d", code);
        return result;
    }
}
