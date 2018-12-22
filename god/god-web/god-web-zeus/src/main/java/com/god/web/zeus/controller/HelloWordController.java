package com.god.web.zeus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author H__D
 * @date 2018-12-07 00:46:57
 *
 */
@Controller
@RequestMapping("/helloWorld")
public class HelloWordController {

	@RequestMapping(value="/get")
    @ResponseBody
    public String get(HttpServletRequest request){
		
        return "你好：abc";
    }
	
}
