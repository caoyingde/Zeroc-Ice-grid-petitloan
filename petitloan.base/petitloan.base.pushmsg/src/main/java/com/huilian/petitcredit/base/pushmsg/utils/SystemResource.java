package com.huilian.petitcredit.base.pushmsg.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SystemResource {

	private SystemResource() {
	}
			
	public final static String HTTP_FILE_URL_KEY = "http.file.url";
	public final static String SFTP_IP_KEY = "sftp.ip";
	public final static String SFTP_PORT_KEY = "sftp.port";
	public final static String SFTP_USER_KEY = "sftp.user";
	public final static String SFTP_PASSWORD_KEY = "sftp.password";
	public final static String SOCKET_IP_KEY = "socket.ip";
	public final static String SOCKET_PORT_KEY = "socket.port";
	public final static String ORG_CODE_KEY = "org.code";
	
	private static Logger logger = LoggerFactory.getLogger(SystemResource.class);
	private static Map<String, Properties> proMap = new HashMap<>();
	private static String configFileName = "/config.properties";

	public static Properties getPropery(String fileName) {
		if (proMap.containsKey(fileName)) {
			return proMap.get(fileName);
		}
		Properties pro = new Properties();
		try {
			pro.load(SystemResource.class.getResourceAsStream(fileName));
			proMap.put(fileName, pro);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return pro;
	}

	public static String getConfigValue(String key) {
		return getPropery(configFileName).getProperty(key);
	}
	public static void main(String[] args) {
		System.out.println(getConfigValue(HTTP_FILE_URL_KEY));
	}
}
