package com.bode.docsys.controller;

import com.alibaba.fastjson.JSONObject;

import com.bode.docsys.jwt.JwtUtil;
import com.bode.docsys.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
public class Login4JwtTestController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody JSONObject requestJson) {
		String username = requestJson.getString("username");
		String password = requestJson.getString("password");
		log.info("username:{},password:{}",username,password);
		Map<String, String> map = new HashMap<>();

		JSONObject user = loginService.getUser(username, password);

		if (user==null) {
			map.put("msg", "用户名密码错误");
			return ResponseEntity.ok(map);
		}
		log.info(user.toString());

		JwtUtil jwtUtil = new JwtUtil();
		Map<String, Object> chaim = new HashMap<>();
		chaim.put("username", username);
		// 注意入参 TOKEN 有效时常 当前为5min (注意 这里payload 里面没有存放密码信息，所以不必担心泄露)
		String jwtToken = jwtUtil.encode(username, 5 * 60 * 1000, chaim);
		map.put("msg", "登录成功");
		map.put("token", jwtToken);
		return ResponseEntity.ok(map);
	}

	/**
	 * 查询当前登录用户的信息
	 */
	@PostMapping("/getInfo")
	public JSONObject getInfo(@RequestBody JSONObject requestJson) {
		String username = requestJson.getString("username");
		return loginService.getInfo(username); // 包含了用户权限list的查询
	}
}
