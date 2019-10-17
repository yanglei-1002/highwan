package com.crazyplay.highwan.util.resp;


import java.util.HashMap;

/**
* @ClassName: JSONResult
* @Description: TODO
* @author yanglei 
* @date Sep 4, 2019 4:06:23 PM
* 
*/
public class JSONResult extends HashMap<String,Object>{
	
	private static final long serialVersionUID = 1547710092744562194L;
	public static final int SUCCEED=1;
    public static final int FAIL=0;
    public static final int UNAUTHORIZED=-1;

    public JSONResult(){
        this.put("state",SUCCEED);
        this.put("msg",null);
        this.put("data",null);
    }
    public JSONResult SUCCEED(){
        this.put("state",SUCCEED);
        this.put("msg","操作成功!");
        return this;
    }

    public JSONResult FAIL(){
        this.put("state",FAIL);
        this.put("msg","操作失败!");
        return this;
    }
    
    public JSONResult SUCCEED(String msg){
        this.put("state",SUCCEED);
        this.put("msg",msg);
        return this;
    }

    public JSONResult FAIL(String msg){
        this.put("state",FAIL);
        this.put("msg",msg);
        return this;
    }

    public JSONResult setData(Object data){
        this.put("data",data);
        return this;
    }
    
    public JSONResult setMsg(String msg){
        this.put("msg",msg);
        return this;
    }
    
    public static JSONResult successd(Object o){
    	return new JSONResult().SUCCEED().setData(o);
    }
    
}
