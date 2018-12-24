package com.xjw.zookeeper.enums;


/**      
 * 项目名称：zmc  
 * 实现功能：  
 * 类名称：ServerRoleEnum   
 * 类描述：(该类的主要功能)
 * 创建人：徐纪伟 
 * E-mail: 289045706@qq.com
 * 创建时间：2016年12月27日下午10:38:30   
 * 修改人：   
 * 修改时间：   
 * 版权 :
 * 修改备注：   
 * @version    
 */
public enum ServerModelEnum {

	/**
	 * LEADER
	 */
	LEADER("leader","主"),
    /**
     * FLOWER
     */
	FOLLOWER("follower","从"),
    
    ;
    /**
     * 值
     */
    private String val;
    /**
     * 描述
     */
    private String msg;

    private ServerModelEnum(String val, String msg) {
        this.val = val;
        this.msg = msg;
    }
   
    public String getVal() {
        return val;
    }
    
    public void setVal(String val) {
        this.val = val;
    }
   
    public String getMsg() {
        return msg;
    }
   
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String getString(){
        return this.val.toString();
    }
    public static ServerModelEnum getInstance(String val) {
        for (ServerModelEnum buss : ServerModelEnum.values()) {
            if (buss.getVal().equals(val)) {
                return buss;
            }
        }
        return null;
    }
}
