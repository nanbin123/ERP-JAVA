package com.efss.entity.user;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.efss.utils.JsonUtils;
import com.github.pagehelper.Page;

/**
 * @ClassName: JsonResult 
 * @Description: 响应结果类
 * @author: lcz
 * @date: 2018年4月9日 下午7:49:33
 */
public class JsonResult {
	
	/**
	 * 状态码
	 */
	private int code;
	
	/**
	 * 成功或失败信息
	 */
	private String msg;

	/**
	 * 分页总记录数
	 */
	private long count; //总记录数
	/**
	 * 输出数据
	 */
	private Object data;


	
	public JsonResult() {
	}

	public JsonResult(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public JsonResult(int  code,String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public JsonResult(int  code, String msg,  Page page) {
			this.count = page.getTotal();
			this.data = page;
			this.code = code;
			this.msg = msg;
	}



	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
}
