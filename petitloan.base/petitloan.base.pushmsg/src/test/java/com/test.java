package com;


import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.core.util.UuidUtil;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.huilian.hlej.base.mybatis.SqlSessionFactoryUtil;
import com.huilian.hlej.base.utils.UniqId;
import com.huilian.petitcredit.base.pushmsg.dao.RepayInfoDao;
import com.huilian.petitcredit.base.pushmsg.model.RepayInfoModel;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.IssueInfo;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.NetBookInfo;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.NetBookInfoList;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.Transaction;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.TransactionBody;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.XmlHeaderReq;
import com.huilian.petitcredit.base.pushmsg.service.impl.AbNormalInfoServiceImpl;
import com.huilian.petitcredit.base.pushmsg.service.impl.ContractInfoServiceImpl;
import com.huilian.petitcredit.base.pushmsg.service.impl.IssueInfoServiceImpl;
import com.huilian.petitcredit.base.pushmsg.service.impl.PayPlanInfoServiceImpl;
import com.huilian.petitcredit.base.pushmsg.service.impl.QuotaInfoServiceImpl;
import com.huilian.petitcredit.base.pushmsg.service.impl.RepayInfoServiceImpl;
import com.huilian.petitcredit.base.pushmsg.utils.DateUtils;
import com.huilian.petitcredit.base.pushmsg.utils.IdGen;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil;
import com.huilian.petitcredit.base.pushmsg.utils.JaxbUtil.CollectionWrapper;
import com.huilian.petitcredit.base.pushmsg.utils.PetitloanConstant;
import com.huilian.petitcredit.base.pushmsg.utils.SystemResource;
import com.huilian.petitcredit.base.pushmsg.utils.fastDFS.FileHandler;
import com.huilian.petitcredit.base.pushmsg.utils.fastDFS.FileInfoVo;
import com.huilian.petitloan.pushmsg.AbNormalInfoReq;
import com.huilian.petitloan.pushmsg.ContractInfoReq;
import com.huilian.petitloan.pushmsg.IssueInfoReq;
import com.huilian.petitloan.pushmsg.PayplanInfoReq;
import com.huilian.petitloan.pushmsg.QuotaInfoReq;
import com.huilian.petitloan.pushmsg.RepayInfoReq;


public class test {
	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void JavaToXml1() throws Exception{
		List<NetBookInfo> list = new ArrayList<NetBookInfo>();
		NetBookInfo obj = new NetBookInfo();
		obj.setBatch_no(UniqId.getInstance().getUniqID());
		obj.setData_type(PetitloanConstant.DATA_TYPE_NETBOOK_INFO);
		obj.setRecord_count(1);
		List<NetBookInfoList> _list = new ArrayList<NetBookInfoList>();
			NetBookInfoList _obj = new NetBookInfoList();
			_obj.setOrg_code("91500000072322375D");
			_obj.setContract_no("123456");
			_obj.setLoan_cate("530001");
			_obj.setCustomer_type("480001");
			_obj.setCustomer_name("张三");
			_obj.setCertificate_type("150001");
			_obj.setCertificate_no("360763188815236565");
			_obj.setContract_amount((float)10000.00);
			_obj.setContract_sign_date("20170913");
			_obj.setInt_rate((float)0.008);
			_list.add(_obj);
		obj.setNetbook_info(_list);
		list.add(obj);
		String js=JSON.toJSONString(obj);
		TransactionBody<NetBookInfo> transaction = (TransactionBody<NetBookInfo>) JSON.parseObject(js, new TypeReference<TransactionBody<NetBookInfo>>(){});
		transaction.setGettx(list);
		//将java对象转换为XML字符串                   
		JaxbUtil requestBinder = new JaxbUtil(TransactionBody.class,CollectionWrapper.class);  
		String retXml = requestBinder.toXml(transaction, "utf-8"); 
		System.out.println("xml:"+retXml);  
		retXml = trimStr(retXml);
		System.out.println("xml2:"+retXml); 
		FileHandler util = new FileHandler();
	    FileInfoVo fileInfo = new FileInfoVo();
        fileInfo.setFileFormat("xml");
        fileInfo.setFileName("fileInfoModelName");
        fileInfo.setFileNo(UuidUtil.UUID_SEQUENCE);
        fileInfo = util.upload(retXml.getBytes(), fileInfo);
        String FilePath = fileInfo.getFilePath();    
        System.out.println("FilePath:"+FilePath);
	   /*     
		String file = "D:\\91500000072322375D-20170913-NETBOOK_INFO-08.xml";
		FileOutputStream writerStream = new FileOutputStream(file);    
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(writerStream, "UTF-8")); 
		writer.write(retXml);
		writer.close();  */
		
          
        //将xml字符串转换为java对象  
        JaxbUtil resultBinder = new JaxbUtil(Transaction.class,  
                CollectionWrapper.class);  
        Transaction hotelObj = resultBinder.fromXml(retXml); 
        
        System.out.println("hotelObj"+hotelObj.getReqList().toString());
    
	}
	
	public static String trimStr(String xml){  
	    StringBuffer sb= new StringBuffer();  
	    for(String s:xml.split("\n")){  
	        sb.append(s.trim());  
	    }  
	    return  sb.toString();  
	}  
	@Test
	public void JavaToXml() throws ParserConfigurationException, SAXException, IOException{
		
		//Transaction<XmlHeaderReq> transaction = new Transaction<XmlHeaderReq>();
		XmlHeaderReq xmlHeaderReq = new XmlHeaderReq();
		xmlHeaderReq.setBRANCH_ID("123456");
		xmlHeaderReq.setFILE_PATH("17-09-1202Test.xml");
		List<XmlHeaderReq> reqList = new ArrayList<XmlHeaderReq>();
		reqList.add(xmlHeaderReq);
		System.out.println("xmlHeaderReq= "+xmlHeaderReq);
		String js=JSON.toJSONString(xmlHeaderReq);
		System.out.println("js="+js);
		Transaction<XmlHeaderReq> transaction = (Transaction<XmlHeaderReq>) JSON.parseObject(js, new TypeReference<Transaction<XmlHeaderReq>>(){});
		transaction.setMsg(reqList);
		System.out.println("reqList"+reqList);
		 //将java对象转换为XML字符串                   
        JaxbUtil requestBinder = new JaxbUtil(Transaction.class,  
                CollectionWrapper.class);  
        String retXml = requestBinder.toXml(transaction, "utf-8");  
        System.out.println("xml:"+retXml);  
          
        //将xml字符串转换为java对象  
        JaxbUtil resultBinder = new JaxbUtil(Transaction.class,  
                CollectionWrapper.class);  
		Transaction hotelObj = resultBinder.fromXml(retXml);  
        List<Transaction<XmlHeaderReq>> ss= hotelObj.getMsg();
        
        System.out.println("hotelObj"+ss.get(0));
    
	}
	/*@Test
	public void JavaToXml2() throws ParserConfigurationException, SAXException, IOException{
		
		//Transaction<XmlHeaderReq> transaction = new Transaction<XmlHeaderReq>();
		XmlHeaderRsp xmlHeaderRes = new XmlHeaderRsp();
		Ret ret = new Ret();
		ret.setRetCode(123);
		ret.setRetMsg("传输错误");
		xmlHeaderRes.setBRANCH_ID("123456");
		xmlHeaderRes.setFILE_PATH("17-09-1202Test.xml");
		List<XmlHeaderRsp> reqList = new ArrayList<XmlHeaderRsp>();
		List<Ret> RetList = new ArrayList<Ret>();
		RetList.add(ret);
		xmlHeaderRes.setRET(RetList);
		reqList.add(xmlHeaderRes);
		System.out.println("xmlHeaderRes= "+xmlHeaderRes);
		String js=JSON.toJSONString(xmlHeaderRes);
		System.out.println("js="+js);
		Transaction<XmlHeaderRsp> transaction = (Transaction<XmlHeaderRsp>) JSON.parseObject(js, new TypeReference<Transaction<XmlHeaderRsp>>(){});
		transaction.setMsg(reqList);
		System.out.println("reqList"+reqList);
		//将java对象转换为XML字符串                   
		JaxbUtil requestBinder = new JaxbUtil(Transaction.class,  
				CollectionWrapper.class);  
		String retXml = requestBinder.toXml(transaction, "utf-8");  
		System.out.println("xml:"+retXml);  
		
		//将xml字符串转换为java对象  
		String str="<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><transaction><header><msg xsi:type=\"xmlHeaderRsp\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><BRANCH_ID>123456</BRANCH_ID><FILE_PATH>17-09-1202Test.xml</FILE_PATH><RET><retCode>123</retCode><retMsg>传输错误</retMsg></RET></msg></header></transaction>";
		JaxbUtil resultBinder = new JaxbUtil(Transaction.class,  
				CollectionWrapper.class);  
		Transaction hotelObj = resultBinder.fromXml(str); 
		
		//List<Transaction<XmlHeaderReq>> ss= hotelObj.getMsg();
		
		System.out.println("hotelObj"+hotelObj.getMsg().get(0));
		
	}*/
	@Test
	public void JavaToXml3() throws ParserConfigurationException, SAXException, IOException{
		
		//Transaction<XmlHeaderReq> transaction = new Transaction<XmlHeaderReq>();
		IssueInfo xmlHeaderReq = new IssueInfo();
		xmlHeaderReq.setBatch_no("123456");
		xmlHeaderReq.setRecord_count(2);
		List<IssueInfo> reqList = new ArrayList<IssueInfo>();
		reqList.add(xmlHeaderReq);
		System.out.println("xmlHeaderReq= "+xmlHeaderReq);
		String js=JSON.toJSONString(xmlHeaderReq);
		System.out.println("js="+js);
		TransactionBody<IssueInfo> transaction = (TransactionBody<IssueInfo>) JSON.parseObject(js, new TypeReference<TransactionBody<IssueInfo>>(){});
		transaction.setGettx(reqList);
		System.out.println("reqList"+reqList);
		 //将java对象转换为XML字符串                   
        JaxbUtil requestBinder = new JaxbUtil(TransactionBody.class,  
                CollectionWrapper.class);  
        String retXml = requestBinder.toXml(transaction, "utf-8");  
        System.out.println("xml:"+retXml);  
          
        //将xml字符串转换为java对象  
        JaxbUtil resultBinder = new JaxbUtil(TransactionBody.class,  
                CollectionWrapper.class);  
        TransactionBody hotelObj = resultBinder.fromXml(retXml);  
        List<TransactionBody<XmlHeaderReq>> ss= hotelObj.getGettx();
        
        System.out.println("hotelObj"+ss.get(0));
    
	}
	@Test
	public void testDatabase(){
		List<RepayInfoModel> modelList=new ArrayList<RepayInfoModel>();
		RepayInfoModel model1 = new RepayInfoModel();
		RepayInfoModel model2 = new RepayInfoModel();
		model1.setLoan_recovery_uuid("45454");
		model1.setBatch_no("452123");
		model1.setData_type(PetitloanConstant.REPAY_INFO);
		
		model2.setLoan_recovery_uuid("4545489");
		model2.setBatch_no("452123");
		model2.setData_type(PetitloanConstant.REPAY_INFO);
		
		modelList.add(model1);
		modelList.add(model2);
		System.out.println("开始执行");
		
		SqlSession session=null;
		try {
			session=SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
			RepayInfoDao dao = session.getMapper(RepayInfoDao.class);
			dao.insertBatch(modelList);
			System.out.println("执行成功！！");
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		
	}
	@Test
	public void pushNonNormalCustmerReq() throws ParseException{
		AbNormalInfoServiceImpl service = new AbNormalInfoServiceImpl();
		AbNormalInfoReq req = new AbNormalInfoReq();
		List<AbNormalInfoReq> reqList = new ArrayList<AbNormalInfoReq>();
		req.setReportType("ASYNC");
		req.setCustomerType("480001");
		req.setCustomerName("张三");
		req.setCertificateType("150001");
		req.setCertificateNo("1123467989899");
		req.setReason("退款");
		req.setIndustry("290001");
		req.setZone("230006");
		String dateYYYYMMDD = DateUtils.strToDateFormat(DateUtils.formatDateTime(new Date()));
		req.setStartDate(dateYYYYMMDD);
		req.setEndDate(dateYYYYMMDD);
		reqList.add(req);
		service.pushNonNormalCustmerReq(reqList);
	}
	@Test
	public void pushContractInfoReq() throws ParseException{
		ContractInfoServiceImpl service = new ContractInfoServiceImpl();
		String dateYYYYMMDD = DateUtils.strToDateFormat(DateUtils.formatDateTime(new Date()));
		ContractInfoReq req = new ContractInfoReq();
		List<ContractInfoReq> reqList = new ArrayList<ContractInfoReq>();
		req.setReportType("ASYNC");
		req.setContractNo(IdGen.uuid());
		req.setLoanCate("530001");
		req.setContractName("贷款合同");
		req.setCustomerType("480001");
		req.setCustomerName("张三");
		req.setCertificateType("150001");
		req.setCertificateNo("1123467989899");
		req.setLoanObject("410001");
		req.setLoanObjectSize("280005");
		req.setContractSignDate(dateYYYYMMDD);
		req.setContractBeginDate(dateYYYYMMDD);
		req.setContractEndDate(dateYYYYMMDD);
		req.setContractAmount((float) 1600.00);
		req.setOutstanding(0);
		req.setGuarType("240001");
		req.setCcy("730001");
		req.setIsRealQuotaLoan("740001");
		req.setIntRate((float) 0.005);
		req.setPriPltyRate((float) 0.006);
		req.setContractStatus("490001");
		req.setRelationManager("程");
		req.setDisputeScheme("400002");
		reqList.add(req);
		service.pushContractInfoReq(reqList);
	}
	
	@Test
	public void pushIssueInfoReq() throws ParseException{
		String dateYYYYMMDD = DateUtils.strToDateFormat(DateUtils.formatDateTime(new Date()));
		IssueInfoReq req = new IssueInfoReq();
		List<IssueInfoReq> reqList = new ArrayList<IssueInfoReq>();
		req.setReportType("ASYNC");
		req.setContractNo(IdGen.uuid());
		req.setDueBillNo(IdGen.uuid());
		req.setCustomerType("480001");
		req.setCustomerName("张三");
		req.setCertificateType("150001");
		req.setCertificateNo("123456789456231102");
		req.setDdAmt((float) 4500.00);
		req.setLoanCate("530002");
		req.setIntRate((float) 0.005);
		req.setPriPltyRate((float) 0.006);
		req.setRateType("520001");
		req.setSignDate(dateYYYYMMDD);
		req.setDdDate(dateYYYYMMDD);
		req.setMatureDate(dateYYYYMMDD);
		req.setZone("230003");
		req.setGuarType("240002");
		req.setTerm("250003");
		req.setPurpose("260002");
		req.setLoanObject("410002");
		req.setLoanObjectSize("280002");
		req.setRateCalcMode("270001");
		req.setRepayMode("430002");
		req.setIndustry("290002");
		req.setRiskLevel("510001");
		req.setIssueStatus("540003");
		IssueInfoServiceImpl service = new IssueInfoServiceImpl();
		reqList.add(req);
		service.pushLoanLaunchReq(reqList);
	}
	@Test
	public void pushRepayPlanInfoReq() throws ParseException{
		String dateYYYYMMDD = DateUtils.strToDateFormat(DateUtils.formatDateTime(new Date()));
		PayplanInfoReq req = new PayplanInfoReq();
		
		req.setReportType("ASYNC");
		req.setContractNo(IdGen.uuid());
		req.setDueBillNo(IdGen.uuid());
		req.setCounter(5);
		req.setRepayDate(dateYYYYMMDD);
		req.setRepayPriAmt((float) 4500.00);
		req.setRepayIntAmt((float) 450.00);
		req.setStartDate(dateYYYYMMDD);
		req.setEndDate(dateYYYYMMDD);
		PayPlanInfoServiceImpl service = new PayPlanInfoServiceImpl();
		List<PayplanInfoReq> reqList = new ArrayList<PayplanInfoReq>();
		reqList.add(req);
		service.pushRepayPlanInfoReq(reqList);
	}
	
	@Test
	public void pushCreditLineReq() throws ParseException{
		String dateYYYYMMDD = DateUtils.strToDateFormat(DateUtils.formatDateTime(new Date()));
		QuotaInfoReq req = new QuotaInfoReq();
		req.setReportType("ASYNC");
		req.setContractNo(IdGen.uuid());
		req.setContractName("额度合同");
		req.setCustomerType(PetitloanConstant.PL_48.get(PetitloanConstant.PL_48_480001));
		req.setCustomerName("张三");
		req.setCertificateType("150001");
		req.setCertificateNo("123456789456231102");
		req.setContractSignDate(dateYYYYMMDD);
		req.setContractBeginDate(dateYYYYMMDD);
		req.setContractEndDate(dateYYYYMMDD);
		req.setContractAmount((float) 8000.00);
		req.setCcy(PetitloanConstant.PL_73.get(PetitloanConstant.PL_73_730001));
		req.setUsedAmount((float) 1500.00);
		req.setRemainAmount((float) 6500.00);
		req.setGuarType(PetitloanConstant.PL_24.get(PetitloanConstant.PL_24_240002));
		req.setIsCircle(PetitloanConstant.PL_74.get(PetitloanConstant.PL_74_740002));
		req.setContractStatus(PetitloanConstant.PL_49.get(PetitloanConstant.PL_49_490002));
		QuotaInfoReq req1 = new QuotaInfoReq();
		req1.setReportType("ASYNC");
		req1.setContractNo(IdGen.uuid());
		req1.setContractName("额度合同");
		req1.setCustomerType(PetitloanConstant.PL_48.get(PetitloanConstant.PL_48_480001));
		req1.setCustomerName("张三");
		req1.setCertificateType("150001");
		req1.setCertificateNo("123456789456231102");
		req1.setContractSignDate(dateYYYYMMDD);
		req1.setContractBeginDate(dateYYYYMMDD);
		req1.setContractEndDate(dateYYYYMMDD);
		req1.setContractAmount((float) 8000.00);
		req1.setCcy(PetitloanConstant.PL_73.get(PetitloanConstant.PL_73_730001));
		req1.setUsedAmount((float) 1500.00);
		req1.setRemainAmount((float) 6500.00);
		req1.setGuarType(PetitloanConstant.PL_24.get(PetitloanConstant.PL_24_240002));
		req1.setIsCircle(PetitloanConstant.PL_74.get(PetitloanConstant.PL_74_740002));
		req1.setContractStatus(PetitloanConstant.PL_49.get(PetitloanConstant.PL_49_490002));
		List<QuotaInfoReq> reqList = new ArrayList<QuotaInfoReq>();
		reqList.add(req);
		QuotaInfoServiceImpl service = new QuotaInfoServiceImpl();
		service.pushCreditLineReq(reqList);
	}
	@Test
	public void pushLoanRecoveryReq() throws ParseException{
		String dateYYYYMMDD = DateUtils.strToDateFormat(DateUtils.formatDateTime(new Date()));
		RepayInfoReq req = new RepayInfoReq();
		System.out.println(PetitloanConstant.PL_43.get(PetitloanConstant.PL_43_430002));
		System.out.println(PetitloanConstant.PL_55.get(PetitloanConstant.PL_55_550002));
		req.setReportType("ASYNC");
		req.setContractNo(IdGen.uuid());
		req.setDueBillNo(IdGen.uuid());
		req.setRepayDate(dateYYYYMMDD);
		req.setCounter(5);
		req.setCustomerType(PetitloanConstant.PL_48.get(PetitloanConstant.PL_48_480001));
		req.setCustomerName("张三");
		req.setCertificateType("150001");
		req.setCertificateNo("123456789456231102");
		req.setGatherMode(PetitloanConstant.PL_43.get(PetitloanConstant.PL_43_430002));
		req.setRepayPriAmt((float) 4500.00);
		req.setRepayIntAmt((float) 450.00);
		req.setStartDate(dateYYYYMMDD);
		req.setEndDate(dateYYYYMMDD);
		req.setReceiptType(PetitloanConstant.PL_55.get(PetitloanConstant.PL_55_550002));
		RepayInfoReq req1 = new RepayInfoReq();
		System.out.println(PetitloanConstant.PL_43.get(PetitloanConstant.PL_43_430002));
		System.out.println(PetitloanConstant.PL_55.get(PetitloanConstant.PL_55_550002));
		req1.setReportType("ASYNC");
		req1.setContractNo(IdGen.uuid());
		req1.setDueBillNo(IdGen.uuid());
		req1.setRepayDate(dateYYYYMMDD);
		req1.setCounter(5);
		req1.setCustomerType(PetitloanConstant.PL_48.get(PetitloanConstant.PL_48_480001));
		req1.setCustomerName("张三");
		req1.setCertificateType("150001");
		req1.setCertificateNo("123456789456231102");
		req1.setGatherMode(PetitloanConstant.PL_43.get(PetitloanConstant.PL_43_430002));
		req1.setRepayPriAmt((float) 4500.00);
		req1.setRepayIntAmt((float) 450.00);
		req1.setStartDate(dateYYYYMMDD);
		req1.setEndDate(dateYYYYMMDD);
		req1.setReceiptType(PetitloanConstant.PL_55.get(PetitloanConstant.PL_55_550002));
		List<RepayInfoReq> reqList = new ArrayList<RepayInfoReq>();
		reqList.add(req);
		reqList.add(req1);
		RepayInfoServiceImpl service = new RepayInfoServiceImpl();
		service.pushLoanRecoveryReq(reqList);
	}
}