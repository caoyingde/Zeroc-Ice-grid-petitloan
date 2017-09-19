package com.huilian.petitcredit.base.pushmsg.model.xmlvo;

import java.io.Serializable;

public class RetList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String RET_CODE;
	private String RET_MSG;
	public String getRET_CODE() {
		return RET_CODE;
	}
	public void setRET_CODE(String rET_CODE) {
		RET_CODE = rET_CODE;
	}
	public String getRET_MSG() {
		return RET_MSG;
	}
	public void setRET_MSG(String rET_MSG) {
		RET_MSG = rET_MSG;
	}
	@Override
	public String toString() {
		return "Ret [RET_CODE=" + RET_CODE + ", RET_MSG=" + RET_MSG + "]";
	}
	
}
