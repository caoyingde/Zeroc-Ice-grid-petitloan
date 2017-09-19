[["java:package:com.huilian.petitloan"]]
module pushmsg {
	["java:getset"]
	struct NetSignedReq {
		/**
 		 * 合同编号
		 */

		string contractNo;
		/**
 		 * 贷款类别
		 */
		 string loanCate; 
		 
		/**
 		 * 借款人姓名
		 */
		 string customerName;
		 /**
 		 * 借款人类别
		 */
		 string customerType;
		 /**
 		 * 借款人证件类型
		 */
		 string certificateType;
		 /**
 		 * 借款人证件号码
		 */
		 string certificateNo;
		 /**
 		 * 委托人类别
		 */
		 string conCustomerType;
		 /**
 		 * 委托人
		 */
		 string conCustomerName;
		 /**
 		 * 委托人证件类型
		 */
		 string conCertificateType;
		 /**
 		 * 委托人证件号码
		 */
		 string conCertificateNo;
		 /**
 		 * 委托代理费
		 */
		 float conFee;
		 /**
 		 *合同金额
		 */
		 float contractAmount;
		 /**
 		 * 月利率(‰)
		 */
		 float intRate;
		 /**
 		 * 合同签订日期
		 */
		 string contractSignDate;
		 /**
 		 * 保留域1
		 */
		 string reservedField1;
		 /**
 		 * 保留域2
		 */
		 string reservedField2;
		 /**
 		 * 保留域3
		 */
		 string reservedField3;
	};
	
	["java:getset"]
	struct QuotaInfoReq{
		 /**
 		 * 上报类型
		 */
		 string reportType;
		  /**
 		 * 额度协议编号
		 */
		 string contractNo;
		  /**
 		 * 额度协议名称
		 */
		 string contractName;
		  /**
 		 * 借款人类别
		 */
		 string customerType;
		  /**
 		 * 借款人姓名
		 */
		 string customerName;
		  /**
 		 * 借款人证件类型
		 */
		 string certificateType;
		  /**
 		 * 借款人证件号码
		 */
		 string certificateNo;
		  /**
 		 * 额度协议签订日期
		 */
		 string contractSignDate;
		  /**
 		 * 额度协议起期
		 */
		 string contractBeginDate;
		  /**
 		 * 额度协议止期
		 */
		 string contractEndDate;
		  /**
 		 * 额度协议金额
		 */
		 float contractAmount;
		  /**
 		 * 币种
		 */
		 string ccy;
		  /**
 		 * 已用额度
		 */
		 float usedAmount;
		  /**
 		 * 剩余额度
		 */
		 float remainAmount;
		  /**
 		 * 担保方式
		 */
		 string guarType;
		  /**
 		 * 是否循环额度
		 */
		 string isCircle;
		  /**
 		 *协议状态
		 */
		 string contractStatus;
		  /**
 		 * 客户经理
		 */
		 string relationManager;
		  /**
 		 * 备注
		 */
		 string remark;
		 /**
 		 * 保留域1
		 */
		 string reservedField1;
		  /**
 		 * 保留域2
		 */
		 string reservedField2;
		   /**
 		 * 保留域3
		 */
		 string reservedField3;
	};
	["java:type:java.util.ArrayList<QuotaInfoReq>"] sequence<QuotaInfoReq> QuotaInfoReqList;
	["java:getset"]
	struct CoCustomerInfoReq{
	 /**
 		 * 借款人类别
		 */
		 string customerType;
		 /**
 		 * 借款人证件类型
		 */
		 string certificateType;
		 /**
 		 * 借款人证件号码
		 */
		 string certificateNo;
		   /**
 		 * 联系人
		 */
		 string linkman;
		    /** 
 		 * 联系电话
		 */
		 string telephone;
	};
	["java:type:java.util.ArrayList<CoCustomerInfoReq>"] sequence<CoCustomerInfoReq> CoCustomerInfoReqList;
	["java:getset"]
	struct ContractInfoReq{
	 /**
 		 * 上报类型
		 */
		 string reportType;
		   /**
 		 * 合同编号
		 */
		 string contractNo;
		 /**
 		 * 借款人姓名
		 */
		 string customerName;
		 /**
 		 * 贷款类别
		 */
		 string loanCate; 
		   /**
 		 * 额度协议名称
		 */
		 string contractName;
		 /**
 		 * 借款人类别
		 */
		 string customerType;
		 /**
 		 * 借款人证件类型
		 */
		 string certificateType;
		 /**
 		 * 借款人证件号码
		 */
		 string certificateNo;
		   /**
 		 * 联系人
		 */
		 string linkman;
		    /** 
 		 * 联系电话
		 */
		 string telephone;
		    /**
 		 * 贷款对象
		 */
		 string loanObject;
		    /**
 		 * 贷款对象规模
		 */
		 string loanObjectSize;
		   /**
 		 * 额度协议签订日期
		 */
		 string contractSignDate;
		  /**
 		 * 额度协议起期
		 */
		 string contractBeginDate;
		  /**
 		 * 额度协议止期
		 */
		 string contractEndDate;
		 /**
 		 * 合同金额
		 */
		 float contractAmount;
		 /**
 		 * 贷款余额
		 */
		 float outstanding;
		  /**
 		 * 担保方式
		 */
		 string guarType;
		  /**
 		 * 币种
		 */
		 string ccy;
		    /**
 		 * 是否额度项下贷款
		 */
		 string isRealQuotaLoan;
		    /**
 		 * 授信额度协议编号
		 */
		 string realQuotaNo;
		  /**
 		 * 月利率(‰)
		 */
		 float intRate;
		    /**
 		 * 逾期月利率(‰)
		 */
		 float priPltyRate;
		  /**
 		 *合同状态
		 */
		 string contractStatus;
		  /**
 		 * 客户经理
		 */
		 string relationManager;
		    /**
 		 * 争议解决方式
		 */
		 string disputeScheme;
		    /**
 		 * 备注
		 */
		 string remark;
		  /**
 		 * 委托人类别
		 */
		 string conCustomerType;
		 /**
 		 * 委托人
		 */
		 string conCustomerName;
		 /**
 		 * 委托人证件类型
		 */
		 string conCertificateType;
		 /**
 		 * 委托人证件号码
		 */
		 string conCertificateNo;
		    /**
 		 * 委托方法定代表人/负责人
		 */
		 string conJurisitc;
		    /**
 		 * 委托人联系电话
		 */
		 string conTelephone;
		    /**
 		 * 委托人地址
		 */
		 string conLocus;
		    /**
 		 * 委托人邮编
		 */
		 string conPostalcode;
		    /**
 		 * 委托人开户金融机构
		 */
		 string conFincalOrg;
		    /**
 		 * 委托人账户
		 */
		 string conAccountNo;
		    /**
 		 * 受托人
		 */
		 string assCustomerName;
		    /**
 		 * 受托人法定代表人/负责人
		 */
		 string assJuristic;
		    /**
 		 * 受托人联系电话
		 */
		 string assTelephone;
		    /**
 		 * 受托人地址
		 */
		 string assLocus;
		    /**
 		 * 受托人邮编
		 */
		 string assPostalcode;
		    /**
 		 * 代理费
		 */
		 float conFee;
		   /**
 		 * 保留域1
		 */
		 string reservedField1;
		  /**
 		 * 保留域2
		 */
		 string reservedField2;
		   /**
 		 * 保留域3
		 */
		 string reservedField3;
		    /**
 		 * 共同借款人数组
		 */
		 CoCustomerInfoReqList coCustomerInfoReqList;
		 
	}; 
	
	
	["java:type:java.util.ArrayList<ContractInfoReq>"] sequence<ContractInfoReq> ContractInfoReqList;
	
	["java:getset"]
	struct HypopledgeInfoReq{
	  /**
 		 * 担保合同号
		 */
		 string guarContractNo;
		   /**
 		 * 权证号
		 */
		 string warrantNo;
		   /**
 		 *押品类型
		 */
		 string collateralType;
		   /**
 		 * 抵质押金额
		 */
		 float hypopledgeAmount;
		   /**
 		 * 是否注销
		 */
		 string isWriteOff;
		   /**
 		 * 注销日期
		 */
		 string writeOffDate;
	};
	
	["java:type:java.util.ArrayList<HypopledgeInfoReq>"] sequence<HypopledgeInfoReq> HypopledgeInfoReqList;
	["java:getset"]
	struct IssueInfoReq{
	 /**
 		 * 上报类型
		 */
		 string reportType;
		  /**
 		 *合同编号
		 */
		 string contractNo;
		   /**
 		 *发放编号
		 */
		 string dueBillNo;
		 /**
 		 * 借款人姓名
		 */
		 string customerName;
		 /**
 		 * 借款人类别
		 */
		 string customerType;
		 /**
 		 * 借款人证件类型
		 */
		 string certificateType;
		 /**
 		 * 借款人证件号码
		 */
		 string certificateNo;
		   /**
 		 *发放金额
		 */
		 float ddAmt;
		 /**
 		 * 贷款类别
		 */
		 string loanCate; 
		   /**
 		 * 月利率(‰)
		 */
		 float intRate;
		    /**
 		 * 逾期月利率(‰)
		 */
		 float priPltyRate;
		   /**
 		 *利率性质
		 */
		 string rateType;
		   /**
 		 *签约日期
		 */
		 string signDate;
		   /**
 		 *发放日期
		 */
		 string ddDate;
		   /**
 		 *到期日期
		 */
		 string matureDate;     
		   /**
 		 *展期开始日期
		 */
		 string extStartDate;
		   /**
 		 *展期到期日期
		 */
		 string extEndDate;
		   /**
 		 *展期余额
		 */
		 float extOutstanding;
		   /**
 		 *投放区域
		 */
		 string zone;
		   /**
 		 *担保方式
		 */
		 string guarType;
		   /**
 		 *贷款期限
		 */
		 string term;
		   /**
 		 *贷款用途
		 */
		 string purpose;
		   /**
 		 *贷款对象
		 */
		 string loanObject;
		   /**
 		 *贷款对象规模
		 */
		 string loanObjectSize;
		   /**
 		 *计息方式
		 */
		 string rateCalcMode;
		   /**
 		 *还款方式
		 */
		 string repayMode;
		   /**
 		 *投放行业
		 */
		 string industry;
		   /**
 		 *五级分类
		 */
		 string riskLevel;
		   /**
 		 *发放状态
		 */
		 string issueStatus;
		   /**
 		 *抵质押信息数组
		 */
		 HypopledgeInfoReqList hypopledgeInfoReqList;
		 string writeOffDate;
		   /**
 		 *备注
		 */
		 string remark;
		   /**
 		 * 公允价值
		 */
		 string fairAmt;
		 /**
 		 * 保留域1
		 */
		 string reservedField1;
		  /**
 		 * 保留域2
		 */
		 string reservedField2;
		   /**
 		 * 保留域3
		 */
		 string reservedField3;
	};
	["java:type:java.util.ArrayList<IssueInfoReq>"] sequence<IssueInfoReq> IssueInfoReqList;
	
	["java:getset"]
	struct RepayInfoReq{
	/**
		  * 上报类型
		 */
		 string reportType;
		  /**
 		 *合同编号
		 */
		 string contractNo;
		   /**
 		 *发放编号
		 */
		 string dueBillNo;
		  /**
 		 * 还款日期
		 */
		 string repayDate;
		  /**
 		 * 还款期数
		 */
		 int counter;
		  /**
 		 * 借款人姓名
		 */
		 string customerName;
		 /**
 		 * 借款人类别
		 */
		 string customerType;
		 /**
 		 * 借款人证件类型
		 */
		 string certificateType;
		 /**
 		 * 借款人证件号码
		 */
		 string certificateNo;
		  /**
 		 * 扣款方式
		 */
		 string gatherMode;
		  /**
 		 * 收回本金(元)
		 */
		 float repayPriAmt;
		  /**
 		 * 收回利息(元)
		 */
		 float repayIntAmt;
		  /**
 		 * 起息日期
		 */
		 string startDate;
		  /**
 		 * 止息日期
		 */
		 string endDate;
		  /**
 		 * 回收类型
		 */
		 string receiptType;
		  /**
 		 * 逾期天数
		 */
		 int delayDays;
		  /**
 		 * 逾期本金（元）
		 */
		 float delayAmt;
		  /**
 		 * 逾期利息（元）
		 */
		 float delayInterest;
		  /**
 		 * 逾期滞纳金（元）
		 */
		 float delayFee;
		  /**
 		 * 逾期月利率(‰)
		 */
		 float priPltyRate;
		 
		  /**
 		 * 备注
		 */
		 string remark;
		   /**
 		 * 保留域1
		 */
		 string reservedField1;
		  /**
 		 * 保留域2
		 */
		 string reservedField2;
		   /**
 		 * 保留域3
		 */
		 string reservedField3;
	};
	["java:type:java.util.ArrayList<RepayInfoReq>"] sequence<RepayInfoReq> RepayInfoReqList;
	["java:getset"]
	struct AbNormalInfoReq{
	  /**
 		 * 上报类型
		 */
		 string reportType;
		 /**
 		 * 借款人姓名
		 */
		 string customerName;
		 /**
 		 * 借款人类别
		 */
		 string customerType;
		 /**
 		 * 借款人证件类型
		 */
		 string certificateType;
		 /**
 		 * 借款人证件号码
		 */
		 string certificateNo;
		 /**
 		 *非正常原因
		 */
		 string reason;
		 /**
 		 *客户所属行业：
		 */
		 string industry;
		 /**
 		 *客户所属区域
		 */
		 string zone;
		 /**
 		 *有效起始日期
		 */
		 string startDate;
		 /**
 		 *有效终止日期
		 */
		 string endDate;
		 /**
 		 *备注
		 */
		 string remark;
		  /**
 		 * 保留域1
		 */
		 string reservedField1;
		  /**
 		 * 保留域2
		 */
		 string reservedField2;
		   /**
 		 * 保留域3
		 */
		 string reservedField3;
	};
	["java:type:java.util.ArrayList<AbNormalInfoReq>"] sequence<AbNormalInfoReq> AbNormalInfoReqList;
	
	["java:getset"]
	struct PayplanInfoReq{
	 /**
		  * 上报类型
		 */
		 string reportType;
		  /**
 		 *合同编号
		 */
		 string contractNo;
		   /**
 		 *发放编号
		 */
		 string dueBillNo;
		   /**
 		 * 还款期数
		 */
		 int counter;
		   /**
 		 * 应还日期：YYYYMMDD
		 */
		 string repayDate;
		   /**
 		 * 应还本金
		 */
		 float repayPriAmt;
		   /**
 		 * 应还利息
		 */
		 float repayIntAmt;
		   /**
 		 * 起息日期：YYYYMMDD
		 */
		 string startDate;
		   /**
 		 * 止息日期：YYYYMMDD
		 */
		 string endDate;
		  /**
 		 * 保留域1
		 */
		 string reservedField1;
		  /**
 		 * 保留域2
		 */
		 string reservedField2;
		   /**
 		 * 保留域3
		 */
		 string reservedField3;
		
	};
	["java:type:java.util.ArrayList<PayplanInfoReq>"] sequence<PayplanInfoReq> PayplanInfoReqList;
	
	["java:getset"]
	struct NetBookInfoReq{
		   /**
 		 * 合同编号
		 */
		 string contractNo;
		 /**
 		 * 贷款类别
		 */
		 string loanCate; 
		 /**
 		 * 借款人姓名
		 */
		 string customerName;
		  /**
 		 * 借款人类别
		 */
		 string customerType;
		 /**
 		 * 借款人证件类型
		 */
		 string certificateType;
		 /**
 		 * 借款人证件号码
		 */
		 string certificateNo;
		 /**
 		 * 委托人类别
		 */
		 string conCustomerType;
		 /**
 		 * 委托人
		 */
		 string conCustomerName;
		 /**
 		 * 委托人证件类型
		 */
		 string conCertificateType;
		 /**
 		 * 委托人证件号码
		 */
		 string conCertificateNo;
		 /**
 		 * 委托代理费
		 */
		 float conFee;
		   /**
 		 * 合同金额,以元为单位，两位小数
		 */
		 float contractAmount;
		   /**
 		 * 合同签订日期,YYYYMMDD
		 */
		 string contratSignDate;
		   /**
 		 * 月利率(‰)
		 */
		 float intRate;
		  /**
 		 * 保留域1
		 */
		 string reservedField1;
		  /**
 		 * 保留域2
		 */
		 string reservedField2;
		   /**
 		 * 保留域3
		 */
		 string reservedField3;
	};
	["java:type:java.util.ArrayList<NetBookInfoReq>"] sequence<NetBookInfoReq> NetBookInfoReqList;
	["java:getset"]
	struct ResPushStatus {
		string batchNo;
		string dataType;
		string retCode;
		string retMsg;
	};
	
	interface BasePushmsgHandler{
		//实时网签（PTLN001）
		ResPushStatus pushNetSigned(NetSignedReq req);
		//贷款回收信息上报(PTLN104)
		ResPushStatus pushLoanRecoveryReq(RepayInfoReqList req);
		//网签文件上报（PTLN107）
		ResPushStatus pushNetbookInfo(NetBookInfoReqList req);
		//还款计划信息上报
		ResPushStatus pushRepayPlanInfoReq(PayplanInfoReqList req);
		//非正常用户信息上报
		ResPushStatus pushNonNormalCustmerReq(AbNormalInfoReqList req);
		//贷款发放信息上报
		ResPushStatus pushLoanLaunchReq(IssueInfoReqList req);
		//授信额度信息上报
		ResPushStatus pushCreditLineReq(QuotaInfoReqList req);
		//合同信息上报
		ResPushStatus pushContractInfoReq(ContractInfoReqList req);
		//上报结果查询（PTLN199）
		ResPushStatus findPushResult(string batchNo,string dataType);
		
	};
};	