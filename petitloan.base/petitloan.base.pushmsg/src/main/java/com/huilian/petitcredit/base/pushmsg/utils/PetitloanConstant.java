package com.huilian.petitcredit.base.pushmsg.utils;

import java.util.HashMap;
import java.util.Map;

public class PetitloanConstant {
	public static final String PENDING_PUSH_STATUS = "-1";//推送状态 -1：未推送 0：推送成功 其它：失败
	/**
	 *报文清单
	 */
	public static final String MESSAGE_TYPE = "1220";//报文类型
	public static final String TRAN_CODE_107 = "PTLN107";//网签文件上报 交易码
	public static final String TRAN_CODE_106 = "PTLN106";//非正常用户信息上报  交易码
	public static final String TRAN_CODE_105 = "PTLN105";//还款计划信息上报  交易码
	public static final String TRAN_CODE_104 = "PTLN104";//贷款回收信息上报  交易码
	public static final String TRAN_CODE_103 = "PTLN103";//贷款发放信息上报  交易码
	public static final String TRAN_CODE_101 = "PTLN101";//授信额度信息上报  交易码
	public static final String TRAN_CODE_102 = "PTLN102";//合同信息上报  交易码
	public static final String TRAN_CODE_199 = "PTLN199";//合同信息上报  交易码
	
	public static final String MESSAGE_CODE_0107 = "0107";//网签文件上报 报文代码
	public static final String MESSAGE_CODE_0106 = "0106";//非正常用户信息上报报文代码
	public static final String MESSAGE_CODE_0105 = "0105";//还款计划信息上报 报文代码
	public static final String MESSAGE_CODE_0104 = "0104";//贷款回收信息上报 报文代码
	public static final String MESSAGE_CODE_0103 = "0103";//贷款发放信息上报 报文代码
	public static final String MESSAGE_CODE_0101 = "0101";//授信额度信息上报 报文代码
	public static final String MESSAGE_CODE_0102 = "0102";//合同信息上报 报文代码
	public static final String MESSAGE_CODE_0199 = "0199";//上报信息查询
	
	//网签文件上报（PTLN107）
	public static final String DATA_TYPE_NETBOOK_INFO = "NETBOOK_INFO";
	//贷款回收信息
	public static final String REPAY_INFO = "REPAY_INFO";
	//还款计划信息
	public static final String PAYPLAN_INFO = "PAYPLAN_INFO";
	//非正常用户信息上报
	public static final String ABNORMAL_INFO = "ABNORMAL_INFO";
	//贷款发放信息上报
	public static final String ISSUE_INFO = "ISSUE_INFO";
	//授信额度信息上报
	public static final String QUOTA_INFO = "QUOTA_INFO";
	//合同信息上报
	public static final String CONTRACT_INFO = "CONTRACT_INFO";
	
	/**
	 * 服务代码
	 * 实时：SVR_PTLN  文件：SVR_FILE
	 */
	public static final String SERVICE_CODE_SVR_PTLN = "SVR_PTLN";
	public static final String SERVICE_CODE_SVR_FILE = "SVR_FILE";
	/**
	 * 交易模式
	 * 实时：ONLINE文件：ASYNC
	 */
	public static final String TRAN_MODE_ONLINE = "ONLINE";
	public static final String TRAN_MODE_ASYNC = "ASYNC";
	/**
	 * 用户语言
	 * 取值范围：中文：CHINESE  英文：AMERICAN/ENGLISH
	 */
	public static final String USER_LANG_CHINESE = "CHINESE";
	public static final String USER_LANG_AMERICAN = "AMERICAN";
	public static final String USER_LANG_ENGLISH = "ENGLISH";
	
	/**
	 * 模块标识
	 */
	public static final String MODULE_ID = "CL";

	public static final String PL_10_100001 = "100001";
	public static final String PL_10_100002 = "100002";
	public static final String PL_10_100003 = "100003";
	public static final Map<String, String> PL_10 = new HashMap<String, String>(){{
		put(PL_10_100001, "新增记录");
		put(PL_10_100002, "修改记录");
		put(PL_10_100003, "删除记录");
		
	}};
	public static final String PL_15_150001 = "150001";
	public static final String PL_15_150002 = "150002";
	public static final String PL_15_150003 = "150003";
	public static final String PL_15_150004 = "150004";
	public static final Map<String, String> PL_15 = new HashMap<String, String>(){{
		put(PL_15_150001, "身份证");
		put(PL_15_150002, "组织机构代码");
		put(PL_15_150003, "护照");
		put(PL_15_150004, "其它");
	}};
	public static final String PL_23_230001 = "230001";
	public static final String PL_23_230002 = "230002";
	public static final String PL_23_230003 = "230003";
	public static final String PL_23_230004 = "230004";
	public static final String PL_23_230005 = "230005";
	public static final String PL_23_230006 = "230006";
	public static final String PL_23_230007 = "230007";
	public static final String PL_23_230008 = "230008";
	public static final String PL_23_230009 = "230009";
	public static final String PL_23_230010 = "230010";
	public static final String PL_23_230011 = "230011";
	public static final String PL_23_230012 = "230012";
	public static final String PL_23_230013 = "230013";
	public static final String PL_23_230014 = "230014";
	public static final String PL_23_230015 = "230015";
	public static final String PL_23_230016 = "230016";
	public static final String PL_23_230017 = "230017";
	public static final String PL_23_230018 = "230018";
	public static final String PL_23_230019 = "230019";
	public static final String PL_23_230020 = "230020";
	public static final String PL_23_230021 = "230021";
	public static final String PL_23_230022 = "230022";
	public static final String PL_23_230023 = "230023";
	public static final String PL_23_230024 = "230024";
	public static final String PL_23_230025 = "230025";
	public static final String PL_23_230026 = "230026";
	public static final String PL_23_230027 = "230027";
	public static final String PL_23_230028 = "230028";
	public static final String PL_23_230029 = "230029";
	public static final String PL_23_230030 = "230030";
	public static final String PL_23_230031 = "230031";
	public static final String PL_23_230032 = "230032";
	public static final String PL_23_230033 = "230033";
	public static final String PL_23_230034 = "230034";
	public static final String PL_23_230035 = "230035";
	public static final String PL_23_230036 = "230036";
	public static final String PL_23_230037 = "230037";
	public static final String PL_23_230038 = "230038";
	public static final String PL_23_230039 = "230039";
	public static final String PL_23_230040 = "230040";
	public static final String PL_23_230041 = "230041";
	public static final String PL_23_230042 = "230042";
	public static final String PL_23_230043 = "230043";
	public static final String PL_23_230044 = "230044";
	public static final Map<String, String> PL_23 = new HashMap<String, String>(){{
		put(PL_23_230001, "渝中区");
		put(PL_23_230002, "大渡口区");
		put(PL_23_230003, "江北区");
		put(PL_23_230004, "沙坪坝区");
		put(PL_23_230005, "九龙坡区");
		put(PL_23_230006, "南岸区");
		put(PL_23_230007, "北碚区");
		put(PL_23_230008, "万盛区");
		put(PL_23_230009, "双桥区");
		put(PL_23_230010, "渝北区");
		put(PL_23_230011, "巴南区");
		put(PL_23_230012, "万州区");
		put(PL_23_230013, "涪陵区");
		put(PL_23_230014, "黔江区");
		put(PL_23_230015, "长寿区");
		put(PL_23_230016, "合川区");
		put(PL_23_230017, "永川区");
		put(PL_23_230018, "江津区");
		put(PL_23_230019, "南川区");
		put(PL_23_230020, "綦江县");
		put(PL_23_230021, "潼南县");
		put(PL_23_230022, "铜梁县");
		put(PL_23_230023, "大足县");
		put(PL_23_230024, "荣昌县");
		put(PL_23_230025, "璧山县");
		put(PL_23_230026, "垫江县");
		put(PL_23_230027, "武隆县");
		put(PL_23_230028, "丰都县");
		put(PL_23_230029, "城口县");
		put(PL_23_230030, "梁平县");
		put(PL_23_230031, "开县");
		put(PL_23_230032, "巫溪县");
		put(PL_23_230033, "巫山县");
		put(PL_23_230034, "奉节县");
		put(PL_23_230035, "云阳县");
		put(PL_23_230036, "忠县");
		put(PL_23_230037, "石柱县");
		put(PL_23_230038, "彭水县");
		put(PL_23_230039, "酉阳县");
		put(PL_23_230040, "秀山县");
		put(PL_23_230041, "北部新区");
		put(PL_23_230042, "高新区");
		put(PL_23_230043, "两江新区");
		put(PL_23_230044, "其它");
	}};
	public static final String PL_24_240001 = "240001";
	public static final String PL_24_240002 = "240002";
	public static final String PL_24_240003 = "240003";
	public static final String PL_24_240004 = "240004";
	public static final Map<String, String> PL_24 = new HashMap<String, String>(){{
		put(PL_24_240001, "信用");
		put(PL_24_240002, "抵押");
		put(PL_24_240003, "质押");
		put(PL_24_240004, "保证");
	}};
	public static final String PL_25_250001 = "250001";
	public static final String PL_25_250002 = "250002";
	public static final String PL_25_250003 = "250003";
	public static final String PL_25_250004 = "250004";
	public static final String PL_25_250005 = "250005";
	public static final Map<String, String> PL_25 = new HashMap<String, String>(){{
		put(PL_25_250001, "1个月内");
		put(PL_25_250002, "1～3个月");
		put(PL_25_250003, "3～6个月");
		put(PL_25_250004, "半年以上");
		put(PL_25_250005, "1年以上");
	}};
	public static final String PL_26_260001 = "260001";
	public static final String PL_26_260002 = "260002";
	public static final Map<String, String> PL_26 = new HashMap<String, String>(){{
		put(PL_26_260001, "生产");
		put(PL_26_260002, "消费");
	}};
	public static final String PL_27_270001 = "270001";
	public static final String PL_27_270002 = "270002";
	public static final String PL_27_270003 = "270003";
	public static final String PL_27_270004 = "270004";
	public static final String PL_27_270005 = "270005";
	public static final String PL_27_270006 = "270006";
	public static final String PL_27_270007 = "270007";
	public static final String PL_27_270008 = "270008";
	
	public static final Map<String, String> PL_27 = new HashMap<String, String>(){{
		put(PL_27_270001, "一次性还本付息");
		put(PL_27_270002, "分期还本付息");
		put(PL_27_270003, "按期还息到期还本");
		put(PL_27_270004, "预收利息分期还本");
		put(PL_27_270005, "预收利息到期还本");
		put(PL_27_270006, "等额本息");
		put(PL_27_270007, "等额本金");
		put(PL_27_270008, "任意还本付息");
	}};
	public static final String PL_28_280001 = "280001";
	public static final String PL_28_280002 = "280002";
	public static final String PL_28_280003 = "280003";
	public static final String PL_28_280004 = "280004";
	public static final String PL_28_280005 = "280005";
	public static final String PL_28_280006 = "280006";
	public static final String PL_28_280007 = "280007";
	public static final Map<String, String> PL_28 = new HashMap<String, String>(){{
		put(PL_28_280001, "大型企业贷款");
		put(PL_28_280002, "小型企业贷款");
		put(PL_28_280003, "个人消费贷款");
		put(PL_28_280004, "微型企业贷款");
		put(PL_28_280005, "个体工商户贷款");
		put(PL_28_280006, "其他");
		put(PL_28_280007, "中型企业贷款");
	}};
	public static final String PL_29_290001 = "290001";
	public static final String PL_29_290002 = "290002";
	public static final String PL_29_290003 = "290003";
	public static final String PL_29_290004 = "290004";
	public static final String PL_29_290005 = "290005";
	public static final String PL_29_290006 = "290006";
	public static final String PL_29_290007 = "290007";
	public static final String PL_29_290008 = "290008";
	public static final String PL_29_290009 = "290009";
	public static final String PL_29_290010 = "290010";
	public static final String PL_29_290011 = "290011";
	public static final Map<String, String> PL_29 = new HashMap<String, String>(){{
		put(PL_29_290001, "农业");
		put(PL_29_290002, "工业");
		put(PL_29_290003, "建筑业");
		put(PL_29_290004, "房地产业");
		put(PL_29_290005, "商贸流通业");
		put(PL_29_290006, "交通运输");
		put(PL_29_290007, "仓储业");
		put(PL_29_290008, "住宿和餐饮业");
		put(PL_29_290009, "其他");
		put(PL_29_290010, "农村");
		put(PL_29_290011, "农民");
	}};
	public static final String PL_37_370001 = "370001";
	public static final String PL_37_370002 = "370002";
	public static final String PL_37_370003 = "370003";
	public static final String PL_37_370004 = "370004";
	public static final Map<String, String> PL_37 = new HashMap<String, String>(){{
		put(PL_37_370001, "房产");
		put(PL_37_370002, "车辆");
		put(PL_37_370003, "办公设备");
		put(PL_37_370004, "其它");
	}};
	public static final String PL_40_400001 = "400001";
	public static final String PL_40_400002 = "400002";
	public static final Map<String, String> PL_40 = new HashMap<String, String>(){{
		put(PL_40_400001, "法院");
		put(PL_40_400002, "仲裁");
	}};
	public static final String PL_41_410001 = "410001";
	public static final String PL_41_410002 = "410002";
	public static final String PL_41_410003 = "410003";
	public static final String PL_41_410004 = "410004";
	public static final String PL_41_410005 = "410005";
	public static final String PL_41_410006 = "410006";
	public static final Map<String, String> PL_41 = new HashMap<String, String>(){{
		put(PL_41_410001, "个人贷款");
		put(PL_41_410002, "个人贷款-农户贷款");
		put(PL_41_410003, "农村企业贷款");
		put(PL_41_410004, "城市企业贷款");
		put(PL_41_410005, "农村其他各类组织贷款");
		put(PL_41_410006, "城市其他各类组织贷款");
	}};
	public static final String PL_43_430001 = "430001";
	public static final String PL_43_430002 = "430002";
	public static final String PL_43_430003 = "430003";
	public static final String PL_43_430004 = "430004";
	public static final String PL_43_430005 = "430005";
	public static final Map<String, String> PL_43 = new HashMap<String, String>(){{
		put(PL_43_430001, "银行代扣");
		put(PL_43_430002, "银联代扣");
		put(PL_43_430003, "现金");
		put(PL_43_430004, "银行转帐");
		put(PL_43_430005, "其它");
	}};
	public static final String PL_48_480001 = "480001";
	public static final String PL_48_480002 = "480002";
	public static final Map<String, String> PL_48 = new HashMap<String, String>(){{
		put(PL_48_480001, "个人");
		put(PL_48_480002, "企业");
	}};
	public static final String PL_49_490001 = "490001";
	public static final String PL_49_490002 = "490002";
	public static final String PL_49_490003 = "490003";
	public static final Map<String, String> PL_49 = new HashMap<String, String>(){{
		put(PL_49_490001, "有效");
		put(PL_49_490002, "合同终止");
		put(PL_49_490003, "无效");
	}};
	public static final String PL_50_500001 = "500001";
	public static final String PL_50_500002 = "500002";
	public static final String PL_50_500003 = "500003";
	public static final Map<String, String> PL_50 = new HashMap<String, String>(){{
		put(PL_50_500001, "个人");
		put(PL_50_500002, "企业");
		put(PL_50_500003, "金融机构");
	}};
	public static final String PL_51_510001 = "510001";
	public static final String PL_51_510002 = "510002";
	public static final String PL_51_510003 = "510003";
	public static final String PL_51_510004 = "510004";
	public static final String PL_51_510005 = "510005";
	public static final Map<String, String> PL_51 = new HashMap<String, String>(){{
		put(PL_51_510001, "正常");
		put(PL_51_510002, "关注");
		put(PL_51_510003, "次级");
		put(PL_51_510004, "可疑");
		put(PL_51_510005, "损失");
	}};
	public static final String PL_52_520001 = "520001";
	public static final String PL_52_520002 = "520002";
	public static final Map<String, String> PL_52 = new HashMap<String, String>(){{
		put(PL_52_520001, "固定利率");
		put(PL_52_520002, "浮动利率");
	}};
	public static final String PL_53_530001 = "530001";
	public static final String PL_53_530002 = "530002";
	public static final Map<String, String> PL_53 = new HashMap<String, String>(){{
		put(PL_53_530001, "自营贷款");
		put(PL_53_530002, "委托贷款");
	}};
	public static final String PL_54_540001 = "540001";
	public static final String PL_54_540002 = "540002";
	public static final String PL_54_540003 = "540003";
	public static final String PL_54_540004 = "540004";
	public static final String PL_54_540005 = "540005";
	public static final Map<String, String> PL_54 = new HashMap<String, String>(){{
		put(PL_54_540001, "未放款");
		put(PL_54_540002, "已放款");
		put(PL_54_540003, "回款中");
		put(PL_54_540004, "已结清");
		put(PL_54_540005, "转表外");
	}};
	public static final String PL_55_550001 = "550001";
	public static final String PL_55_550002 = "550002";
	public static final String PL_55_550003 = "550003";
	public static final String PL_55_550004 = "550004";
	public static final String PL_55_550005 = "550005";
	public static final Map<String, String> PL_55 = new HashMap<String, String>(){/**
		 * 
		 */
		private static final long serialVersionUID = 8268292945062954251L;

	{
		put(PL_55_550001, "正常回款");
		put(PL_55_550002, "逾期回款");
		put(PL_55_550003, "提前结清");
		put(PL_55_550004, "不良核销");
		put(PL_55_550005, "资产转让");
	}};
	public static final String PL_73_730001 = "730001";
	public static final Map<String, String> PL_73 = new HashMap<String, String>(){{
		put(PL_73_730001, "CNY 人民币");
	}};
	public static final String PL_74_740001 = "740001";
	public static final String PL_74_740002 = "740002";
	public static final Map<String, String> PL_74 = new HashMap<String, String>(){{
		put(PL_74_740001, "是");
		put(PL_74_740002, "否");
	}};
}
