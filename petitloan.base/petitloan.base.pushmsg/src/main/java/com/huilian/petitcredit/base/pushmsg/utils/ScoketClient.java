package com.huilian.petitcredit.base.pushmsg.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ScoketClient {
	public static void main(String[] args) throws Exception {
		try {
			// 建立Socket服务
			Socket socket = new Socket("113.200.27.105", 7074);
			// 从客户端本地读取文件,并写入socket的输出流中
			OutputStream out = socket.getOutputStream();
			// 实例化对象fileReader
			InputStream fileRead = new FileInputStream("D:\\txtData\\HEADER\\HEADER-PTLN107-NETBOOK_INFO-08.xml");
			// 建立数组
			byte[] buf = new byte[1024];
			int len = 0;
			// 判断是否读到文件末尾
			while ((len = fileRead.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			// 告诉服务端，文件已传输完毕
			socket.shutdownOutput();
			// 获取从服务端反馈的信息
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String serverBack = in.readLine();
			System.out.println(serverBack);
			// 资源关闭
			socket.close();
			fileRead.close();
		} catch (Exception e) {
			System.out.println("can not listen to:" + e);// 出错，打印出错信息
		}
	}
}
