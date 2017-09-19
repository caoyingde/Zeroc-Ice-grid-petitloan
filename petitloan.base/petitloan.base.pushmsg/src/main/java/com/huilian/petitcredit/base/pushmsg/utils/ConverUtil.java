package com.huilian.petitcredit.base.pushmsg.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConverUtil {

	private static Logger logger = LoggerFactory.getLogger(ConverUtil.class);

	@SuppressWarnings("rawtypes")
	public static <T> T converToObj(Object obj, Class<T> clazz) {
		try {
			T clazzObj = clazz.newInstance();
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				Method method = null;
				Object value = null;
				field.getName();
				String name = field.getName();
				if("__nullMarshalValue".equals(name) || "serialVersionUID".equals(name) || "$assertionsDisabled".equals(name))
					continue;
				String upperName = name.substring(0, 1).toUpperCase() + name.substring(1);
				method = obj.getClass().getMethod("get" + upperName);
				value = method.invoke(obj);
				if (value == null) {
					continue;
				}
				Class type = null;
				if (value instanceof Integer) {
					type = int.class;
				} else if (value instanceof Double || value instanceof BigDecimal || value instanceof Float) {
					type = double.class;
				} else if (value instanceof String) {
					type = String.class;
				} else if (value instanceof Timestamp || value instanceof Date) {
					type = long.class;
				}
				if (null != type) {
					try {
						String methodName = "set" + upperName;
						Method[] methodArr = clazzObj.getClass().getMethods();
						for (Method method2 : methodArr) {
							if(method2.getName().equals(methodName)){
								Method setMethod = clazzObj.getClass().getDeclaredMethod(methodName, type);
								if (value instanceof Timestamp || value instanceof Date) {
									value = ((Date) value).getTime();
								}
								if (value instanceof BigDecimal) {
									value = ((BigDecimal) value).doubleValue();
								}
								setMethod.invoke(clazzObj, value);
								break;
							}
						}
					} catch (Exception e) {
						logger.error(e.getMessage(), e);
						continue;
					}
				}
			}
			return clazzObj;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
}
