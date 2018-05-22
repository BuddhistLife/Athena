package com.test.Controller;


import java.util.HashMap;
import java.util.Map;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.Entity.BaseUser;
import com.test.Util.HttpUtil;




@RestController
public class BaseLoginController {

	
	
	@RequestMapping("/Login")
	public String test(String code,String flag){
		
		//调用微信授权接口所需的参数
		Map<String,String> cols = new HashMap<String, String>();
		cols.put("appid", "wxb13d60e9a950604f");
		cols.put("secret", "012405bd623e305bd5d75cee76fcf31c");
		cols.put("js_code", code);
		cols.put("grant_type", "authorization_code");
		String result = "";
		try {
			result = HttpUtil.sendPost(HttpUtil.getUserInfoUrl, cols);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(result);
		
		return result;
	}
	
}
