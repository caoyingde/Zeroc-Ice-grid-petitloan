package com.huilian.petitcredit.base.pushmsg.utils;

import java.util.Iterator;
import java.util.Map;

public class MapUtil {

	@SuppressWarnings("rawtypes")
	public static String toString(Map map) {

		if (null == map || map.isEmpty()) {
			return null;
		}
		StringBuffer buffer = new StringBuffer();
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			Object key = (Object) iterator.next();
			buffer.append("[").append(key).append("=").append(map.get(key)).append("],");
		}
		buffer.delete(buffer.length() - 1, buffer.length());
		return buffer.toString();
	}

}
