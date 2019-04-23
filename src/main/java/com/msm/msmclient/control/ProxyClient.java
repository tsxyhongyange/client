package com.msm.msmclient.control;

import java.lang.reflect.Proxy;

//通过网络连接服务器端获取代理对象
public class ProxyClient {

	public static <T> T getClient(Class <T> clazz,String ip,int port){
		//1、当前对象的类加载器  2、客户端中介  3、实际代理端口
		return (T) Proxy.newProxyInstance(ProxyClient.class.getClassLoader(), new Class[]{clazz}, new ClientHandler(ip, port));
		
	}
}
