package com.bode.docsys.service;

import com.alibaba.fastjson.JSONObject;

public interface LoginService {

	/**
	 * 根据用户名和密码查询对应的用户
	 *
	 * @param username 用户名
	 * @param password 密码
	 */
	JSONObject getUser(String username, String password);

	/**
	 * 查询当前登录用户的权限等信息
	 */
	JSONObject getInfo(String username);

	/**
	 * 退出登录 JWT Token的登出方式在前台 remove 掉Token 即可
	 */
//	JSONObject logout(String username);
}
