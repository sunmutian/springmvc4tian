package com.xjw.zookeeper.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.LogManager;
import org.apache.zookeeper.server.ServerConfig;
import org.apache.zookeeper.server.ZooKeeperServerMain;
import org.apache.zookeeper.server.quorum.QuorumPeerConfig;
import org.apache.zookeeper.server.quorum.QuorumPeerConfig.ConfigException;
import org.apache.zookeeper.server.quorum.QuorumPeerMain;
import org.junit.Test;

/**      
 * 项目名称：zmc  
 * 实现功能：  
 * 类名称：MyTest   
 * 类描述：(该类的主要功能)
 * 创建人：徐纪伟 
 * E-mail: 289045706@qq.com
 * 创建时间：2016年12月23日下午10:24:15   
 * 修改人：   
 * 修改时间：   
 * 版权 :
 * 修改备注：   
 * @version    
 */
public class MyTest {
	
	@Test
	public void test1() throws UnknownHostException, IOException {
		String host = "127.0.0.1";
		int port = 2181;
		String cmd = "kill";
		Socket sock = new Socket(host, port);
		BufferedReader reader = null;
		try {
			OutputStream outstream = sock.getOutputStream();
			outstream.write(cmd.getBytes());
			outstream.flush();
			sock.shutdownOutput();
			reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} finally {
			sock.close();
			if (reader != null) {
				reader.close();
			}
		}

	}
	
	@Test
	public void serverMain() throws ConfigException, IOException{
		QuorumPeerConfig config = new QuorumPeerConfig();
		config.parse("E:\\zookeeper-3.4.9\\conf\\zoo1.cfg");
		String args[] = new String[]{"E:\\zookeeper-3.4.9\\conf\\zoo1.cfg"};
		QuorumPeerMain.main(args);
		
//		QuorumPeerMain peerMain = new QuorumPeerMain();
//		peerMain.runFromConfig(config);
		System.out.println(111);
		
	}
	

}
