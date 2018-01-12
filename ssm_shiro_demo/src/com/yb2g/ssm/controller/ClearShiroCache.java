package com.yb2g.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yb2g.ssm.shiro.CustomRealm;

/**
 * 
 * @ClassName: ClearShiroCache 
 * @Description: 手动调用controller清除shiro的缓存
 * @author: Administrator
 * @date: 2017年12月17日 下午11:16:16
 */
@Controller
public class ClearShiroCache {
	
	//注入realm
	@Autowired
	private CustomRealm customRealm;
	
	@RequestMapping("/clearShiroCache")
	public String clearShiroCache(){
		
		//清除缓存，将来正常开发要在service调用customRealm.clearCached()
		customRealm.clearCached();
		
		return "success";
	}

}
