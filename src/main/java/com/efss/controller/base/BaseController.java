package com.efss.controller.base;
import com.efss.entity.user.JsonResult;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 控制器支持类
 * @author lcz
 * @version 2018-3-15
 */
public abstract class BaseController {
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * <b>方法描述：成功会写json</b>
	 */
	protected JsonResult buildInsterSuccess() {
		JsonResult jsonResult = new JsonResult(0,"数据添加成功");
		return jsonResult;
	}


	/**
	 * <b>方法描述：成功会写json</b>
	 * @param object
	 */
	protected JsonResult buildJsonSuccess(Object object) {
		JsonResult jsonResult = new JsonResult(0,"数据加载成功", object);
		return jsonResult;
	}

	/**
	 * <b>方法描述：成功会写json</b>	 *
	 */
	protected JsonResult buildPageSuccess(Page page) {
		JsonResult jsonResult = new JsonResult(0,"数据加载成功", page);
		return jsonResult;
	}



	public static void main(String[] args) {
		String[] s = {"1","2"};
		String[] ss = {"3"};
		List<String> aaa1 = new ArrayList<String>();
		List<String> aaa2 = new ArrayList<String>();
		aaa1.addAll(Arrays.asList(s));

	}


	/**
	 * <b>方法描述：失败回写json</b>
	 */
	protected JsonResult buildJsonWrapErr() {
		JsonResult jsonResult = new JsonResult(-1,"失败");
		return jsonResult;
	}
	/**
	 * <b>方法描述：失败回写json</b>
	 * @param object
	 */
	protected JsonResult buildJsonWrapErr(Object object) {
		JsonResult jsonResult = new JsonResult(-1,"失败", object);
		return jsonResult;
	}
}
