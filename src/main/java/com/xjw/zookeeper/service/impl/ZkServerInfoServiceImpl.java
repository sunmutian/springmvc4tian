package com.xjw.zookeeper.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.server.quorum.QuorumPeerConfig;
import org.apache.zookeeper.server.quorum.QuorumPeerMain;
import org.springframework.stereotype.Service;

import com.xjw.zookeeper.dao.ZkServerInfoDao;
import com.xjw.zookeeper.entity.ResultRuok;
import com.xjw.zookeeper.entity.ResultStat;
import com.xjw.zookeeper.entity.ZkServerInfo;
import com.xjw.zookeeper.enums.ServerModelEnum;
import com.xjw.zookeeper.enums.ServerStatusEnum;
import com.xjw.zookeeper.server.ZookeeperServer;
import com.xjw.zookeeper.service.ZkServerInfoService;
import com.xjw.zookeeper.wordscommand.WordsCommand;

/**      
 * 项目名称：zmc  
 * 实现功能：  
 * 类名称：ZkServerInfoServiceImpl   
 * 类描述：(该类的主要功能)
 * 创建人：徐纪伟 
 * E-mail: 289045706@qq.com
 * 创建时间：2016年12月25日下午8:52:35   
 * 修改人：   
 * 修改时间：   
 * 版权 :
 * 修改备注：   
 * @version    
 */
@Service
public class ZkServerInfoServiceImpl implements ZkServerInfoService {

	@Resource
	private ZkServerInfoDao zkServerInfoDao;
	
	@Override
	public List<ZkServerInfo> getZkServerInfoByPage(int pageIndex, int pageSize)
			throws Exception {
		List<ZkServerInfo> infos = zkServerInfoDao.getZkServerInfoByPage(pageIndex, pageSize);
		for (ZkServerInfo info : infos) {
			ResultStat resultStat = WordsCommand.stat(info);
			if (resultStat != null) {
				ResultRuok ruok  = WordsCommand.ruok(info);
				if (ruok == null) {
					info.setServerStatusEnum(ServerStatusEnum.OFFLINE);
					continue;
				}
				if (StringUtils.isNotBlank(ruok.getImok())) {
					info.setServerStatusEnum(ServerStatusEnum.ONLINE);
					info.setServerModelEnum(ServerModelEnum.getInstance(resultStat.getMode()));
				}else{
					info.setServerStatusEnum(ServerStatusEnum.EXCEPTIOM);
				}
			}else{
				info.setServerStatusEnum(ServerStatusEnum.OFFLINE);
			}
		}
		return infos;
	}

	@Override
	public boolean startServer(int id) throws Exception {
		ZkServerInfo zkServerInfo = zkServerInfoDao.getZkServerInfoById(id);
		if (zkServerInfo == null) {
			return false;
		}
		return ZookeeperServer.bootServer(zkServerInfo.getConfigPath());
	}

	@Override
	public int addZkServerInfo(ZkServerInfo zkServerInfo) throws Exception {
		
		return zkServerInfoDao.addZkServerInfo(zkServerInfo);
	}

	@Override
	public int delZkServerInfoById(int id) throws Exception {
		return zkServerInfoDao.delZkServerInfoById(id);
	}

	@Override
	public int updZkServerInfo(ZkServerInfo zkServerInfo) throws Exception {
		
		return zkServerInfoDao.updZkServerInfo(zkServerInfo);
	}

	@Override
	public ZkServerInfo getZkServerInfoById(int id) throws Exception {
		
		return zkServerInfoDao.getZkServerInfoById(id);
	}

	@Override
	public boolean startAllServer() throws Exception {
		List<ZkServerInfo> infos = zkServerInfoDao.getZkServerInfoByPage(1, 1);
		for (ZkServerInfo serverInfo : infos) {
			ZookeeperServer.bootServer(serverInfo.getConfigPath());
		}
		return true;
	}

}
