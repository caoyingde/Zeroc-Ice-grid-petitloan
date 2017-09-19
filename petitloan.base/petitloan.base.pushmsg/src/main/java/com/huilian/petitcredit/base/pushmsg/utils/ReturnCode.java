/**
 * Copyright (c) 2011-2014, James Zhan 詹波 (jfinal@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */

package com.huilian.petitcredit.base.pushmsg.utils;


/**
 * 微信接口全局返回码
 */
public class ReturnCode {
    
	public enum PetiloanCode{
		
	
       TYPE_AND_CODE_NOT_MACTH("1907","报文类型和报文代码没有匹配上"),
       REMOTE_LINK_FAILD("1908","远程连接失败"),
       EOD_IN_HAND("1909","EOD处理中，不允许进行数据上报操作"),
       SOURCE_FILE_NOT_EXIST("991201","原文件不存在.文件未上传到sftp服务器"),
       XSD_CHECK_FAILD("991205","XSD校验失败,报文中有字段不满足报文标准的的要求，校验出错"),
       BACTH_NUM_REPEAT("991207","报文文件中的批次号与数据库有重复"),
       SUCCESS("000000","Success/文件传输成功/上报成功"),
       DATA_IN_HAND("000001","数据处理中/上报失败"),
       NO_INFO_ABOUT_ORG("100000","查找不到机构信息"),
       SERVICE_CODE_NOT_EXIST("100001","服务代码不存在"),
       DATA_ALREADY_EXIST("100002","新增时，数据已存在"),
       CUSTMER_DATA_NOT_EXIST("010101","报修改时，该额度数据对应的客户数据不存在"),
       QUOTA_DATA_NOT_EXIST("010102","报修改时，对应的额度是数据不存在"),
       CONTRACT_DATA_NOT_EXIST("010201","报修改时，该合同数据数据不存在"),
       INSUFFICIENT_QUOTA("010203","授信额度下贷款，对应的剩余额度不足"),
       PAYMENT_DATA_NOT_EXIST("010301","报修改时，该发放数据数据不存在"),
       CONTRACT_INFO_NOT_REPORT("010302","报新增时，该数据对应的合同信息未上报"),
       RECOVERY_DATA_NOT_EXIST("010401","贷款回收更新失败,报修改时，该回收数据数据不存在"),
       ISSUING_INFO_NOT_REPORT("010402","报新增时，该数据对应的发放信息未上报"),
       REPAYMENT_PLAN_UPDATE_FAILD("010501","还款计划更新失败,报修改时，该回收数据数据不存在"),
       LOAN_INFO_NOT_ENTERED("010502","贷款发放信息未录入,报新增时，该数据对应的发放信息未上报"),
       NONOMAL_CUSTOMER_UPDATE_FAILD("010601","非正常客户信息更新失败,报修改时，该回收数据数据不存在"),
		
		TRANSATION_FAILD("000001","交易失败"),
		TRANSATION_REPERT("000002","交易重复"),
		TRANSATION_EXPECT("000003","交易异常"),
		FAILURE("其他代码","其他代码均看作交易失败");
       private String value;
       private String desc;
       private PetiloanCode (String value,String desc){
    	   this.value=value;
    	   this.desc=desc;
       }
       public String getValue() {
			return value;
		}
		public String getDesc() {
			return desc;
		}

	}
    
    /**
     * 通过返回码获取返回信息
     * @param errCode 错误码
     * @return {String}
     */
    /*public static String get(int errCode){
        String result = PetiloanCode.get(errCode);
        return result != null ? result : "未知返回码：" + errCode;
    }*/
	public static void main(String[] args) {
		System.out.println(PetiloanCode.BACTH_NUM_REPEAT.getDesc());
	}
}




