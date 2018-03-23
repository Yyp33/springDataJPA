package com.yyp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.log.LogUtils;
import com.yyp.model.User;
import com.yyp.service.UserService;

@Controller
@RequestMapping("/")
public class demoController {

	private static final Logger logger =Logger.getLogger(demoController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	@ResponseBody
	public String index(){
		logger.info("springdatajpa");
		return "index";
	}
	
	
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser(@RequestParam(value="ids") Integer id){
		return userService.findOne(id);
	}
	@RequestMapping("/findByName")
	@ResponseBody
	public User findByName(@RequestParam(value="name") String username){
		System.out.println(username);
		logger.info("**************springJPADemo***********************");
		return userService.findByName(username);
	}
	
	@RequestMapping("/findByPassword")
	@ResponseBody
	public User findByPassword(@RequestParam(value="password")String password){
		logger.info("******************findByPassword************");
		return userService.findByPassword(password);
	}
	@RequestMapping("/findByUserName")
	@ResponseBody
	public User findByUserNameNativeQuery(String userName){
		logger.info("**********************findByUserNameNativeQuery**********");
		return userService.findByUserNameNativeQuery(userName);
	}
	
	@RequestMapping("/updateUserName")
	@ResponseBody
	public Integer updateUserName(@RequestParam("id")Integer id){
		logger.info("********************updateUserName****************");
		logger.info("********************参数："+id+"***********");
		return userService.updateUser(id);
	}
}
