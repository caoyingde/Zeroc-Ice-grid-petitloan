package com.huilian.petitcredit.base.pushmsg.service.impl;

import com.huilian.petitcredit.base.pushmsg.dao.BaseDao;
import com.huilian.petitcredit.base.pushmsg.dao.NetSignedDao;
import com.huilian.petitcredit.base.pushmsg.model.xmlvo.NetSigned;
import com.huilian.petitloan.pushmsg.NetSignedReq;
import com.huilian.petitloan.pushmsg.ResPushStatus;

public class NetSignedServiceImpl extends BaseServiceImpl<NetSigned> {

	@Override
	public Class<? extends BaseDao<NetSigned>> getMapperClass() {
		return NetSignedDao.class;
	}

	public NetSignedDao getDaoImpl() {
		return (NetSignedDao) super.getDao();
	}

	public ResPushStatus pushNetSigned(NetSignedReq req) {
		return null;
	}
}
