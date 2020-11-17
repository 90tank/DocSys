package com.bode.docsys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bode.docsys.entity.User;
import com.bode.docsys.mapper.UserMapper;
import com.bode.docsys.service.LoginService;
import com.bode.docsys.util.CommonUtil;
import com.bode.docsys.util.constants.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserMapper userMapper;
/*	@Autowired
	private PermissionService permissionService;*/
	/**
	 * 根据用户名和密码查询对应的用户
	 */
	@Override
	public JSONObject getUser(String userName, String password) {
		User user = new User();
		user.setUserName(userName);
        Wrapper queryWrapper = new QueryWrapper(user);
		User userInDb = userMapper.selectOne(queryWrapper);
		JSONObject jsonObject = (JSONObject) JSONObject.toJSON(userInDb);
		return jsonObject;
	}

	/**
	 * 查询当前登录用户的权限等信息
	 */
	@Override
	public JSONObject getInfo(String userName) {
        // TODO 获取权限
		JSONObject info = new JSONObject();
/*		JSONObject userPermission = permissionService.getUserPermission(username);
		session.setAttribute(Constants.SESSION_USER_PERMISSION, userPermission);
		info.put("userPermission", userPermission);*/
		return CommonUtil.successJson(info);
	}
}
