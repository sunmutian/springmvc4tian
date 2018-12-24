package com.xjw.zookeeper.wordscommand;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.client.FourLetterWordMain;

import com.xjw.zookeeper.entity.ResultRuok;
import com.xjw.zookeeper.entity.ResultStat;
import com.xjw.zookeeper.entity.ZkServerInfo;
import com.xjw.zookeeper.systemconst.CommandConstEnum;

/**      
 * 项目名称：zmc  
 * 实现功能： 四字命令处理 
 * 类名称：WordsCommand   
 * 类描述：(该类的主要功能)
 * 创建人：徐纪伟 
 * E-mail: 289045706@qq.com
 * 创建时间：2016年12月28日下午9:14:13   
 * 修改人：   
 * 修改时间：   
 * 版权 :
 * 修改备注：   
 * @version    
 */
public class WordsCommand {
	
	private static String[] getResultArray(ZkServerInfo serverInfo, CommandConstEnum commandConstEnum){
		String[] resultArray = null;
		try {
			String cmdResult = FourLetterWordMain.send4LetterWord(serverInfo.getIp(), serverInfo.getPort(), commandConstEnum.getVal());
			if (StringUtils.isNotBlank(cmdResult)) {
				resultArray = cmdResult.split("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultArray;
	}
	
	/**
	 * 四字命令stat
	 * @param serverInfo
	 * @return
	 * author ： 徐纪伟
	 */
	public static ResultStat stat(ZkServerInfo serverInfo){
		String[] resultArray = getResultArray(serverInfo, CommandConstEnum.STAT);
		if (resultArray != null) {
			ResultStat resultStat = new ResultStat();
			for (String rs : resultArray){
				if (rs.indexOf("Zookeeper version:") != -1) {
					resultStat.setZookeeperVersion(rs.replace("Zookeeper version:", "").trim());
				}else if (rs.indexOf("Mode:") != -1) {
					resultStat.setMode(StringUtils.deleteWhitespace(rs.replace("Mode:", "")));
				}
			}
			return resultStat;
		}
		return null;
	}
	/**
	 * 四字命令ruok
	 * @param serverInfo
	 * @return
	 * author ： 徐纪伟
	 */
	public static ResultRuok ruok(ZkServerInfo serverInfo){
		String[] resultArray = getResultArray(serverInfo, CommandConstEnum.RUOK);
		if (resultArray != null) {
			ResultRuok resultRuok = new ResultRuok();
			for (String rs : resultArray){
				if (rs.indexOf("imok") != -1) {
					resultRuok.setImok(rs.trim());
				}
			}
			return resultRuok;
		}
		return null;
	}
	/**
	 * 四字命令conf
	 * @param serverInfo
	 * @return
	 * author ： 徐纪伟
	 * @throws IOException 
	 */
	public static String conf(ZkServerInfo serverInfo) throws IOException{
		String cmdResult = FourLetterWordMain.send4LetterWord(serverInfo.getIp(), serverInfo.getPort(), CommandConstEnum.CONF.getVal());
		return cmdResult;
	}
	
}
