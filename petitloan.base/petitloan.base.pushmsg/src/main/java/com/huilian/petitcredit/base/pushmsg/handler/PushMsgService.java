package com.huilian.petitcredit.base.pushmsg.handler;

import com.huilian.hlej.base.ice.server.AbstractIceBoxService;

import Ice.Identity;
import Ice.Object;
import Ice.ObjectAdapter;

public class PushMsgService extends AbstractIceBoxService {

	@Override
	public void addMyIceServiceObjFacets(ObjectAdapter adapter, Identity id) {

	}

	@Override
	public Object createMyIceServiceObj(String[] args) {
		return new PushMsgHandler();
	}
}
