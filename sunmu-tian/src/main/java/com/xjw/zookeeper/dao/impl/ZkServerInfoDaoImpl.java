package com.xjw.zookeeper.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.xjw.zookeeper.dao.ZkServerInfoDao;
import com.xjw.zookeeper.entity.ZkServerInfo;

/**      
 * 项目名称：zmc  
 * 实现功能：  
 * 类名称：ZkServerInfoDaoImpl   
 * 类描述：(该类的主要功能)
 * 创建人：徐纪伟 
 * E-mail: 289045706@qq.com
 * 创建时间：2016年12月25日下午8:50:00   
 * 修改人：   
 * 修改时间：   
 * 版权 :
 * 修改备注：   
 * @version    
 */
@Repository
public class ZkServerInfoDaoImpl implements ZkServerInfoDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private Map<Integer, ZkServerInfo> zkServerInfoMap = new HashMap<Integer, ZkServerInfo>();
	
	@Override
	public List<ZkServerInfo> getZkServerInfoByPage(int pageIndex, int pageSize)
			throws Exception {
		/*List<ZkServerInfo> serverInfos = new ArrayList<ZkServerInfo>();
		Collection<ZkServerInfo> collection =  zkServerInfoMap.values();
		Iterator<ZkServerInfo> iterator = collection.iterator();
		while (iterator.hasNext()) {
			ZkServerInfo info = iterator.next();
			serverInfos.add(info);
		}*/
		final List<ZkServerInfo> serverInfos = new ArrayList<ZkServerInfo>();
		jdbcTemplate.query("select * from t_server_info", new Object[]{}, new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				ZkServerInfo serverInfo = null;
				 do {
					serverInfo = new ZkServerInfo();
					serverInfo.setId(rs.getInt("id"));
					serverInfo.setIp(rs.getString("ip"));
					serverInfo.setPort(rs.getInt("port"));
					serverInfo.setConfigPath(rs.getString("config_path"));
					serverInfo.setDesc(rs.getString("remark"));
					serverInfos.add(serverInfo);
				}while (rs.next());
			}
		});
		return serverInfos;
	}

	
	@Override
	public ZkServerInfo getZkServerInfoById(int id) throws Exception {
		final ZkServerInfo serverInfo = new ZkServerInfo();
		jdbcTemplate.query("select * from t_server_info where id = ?", new Object[]{id}, new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				 do {
					serverInfo.setId(rs.getInt("id"));
					serverInfo.setIp(rs.getString("ip"));
					serverInfo.setPort(rs.getInt("port"));
					serverInfo.setConfigPath(rs.getString("config_path"));
					serverInfo.setDesc(rs.getString("remark"));
				}while (rs.next());
			}
		});
		return serverInfo;
	}


	@Override
	public int addZkServerInfo(ZkServerInfo zkServerInfo) throws Exception {
		int i = jdbcTemplate.update("insert into t_server_info (ip,port,config_path,remark) values(?,?,?,?)",new Object[]{zkServerInfo.getIp(),zkServerInfo.getPort(),zkServerInfo.getConfigPath(),zkServerInfo.getDesc()});
		return i;
	}


	@Override
	public int delZkServerInfoById(int id) throws Exception {
		int i = jdbcTemplate.update("delete from t_server_info where id=?",new Object[]{id});
		return i;
	}
	

	@Override
	public int updZkServerInfo(ZkServerInfo zkServerInfo) throws Exception {
		int i = jdbcTemplate.update("update t_server_info set ip=?,port=?,config_path=?,remark=? where id = ?",new Object[]{zkServerInfo.getIp(),zkServerInfo.getPort(),zkServerInfo.getConfigPath(),zkServerInfo.getDesc(),zkServerInfo.getId()});
		return i;
	}

}
