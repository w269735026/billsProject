package com.wwl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 跳转页面
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/wwl/")
public class SkipPageController {
	
	@RequestMapping("/{page}")
	public String skipWelcome(@PathVariable String page) {
		return page;
	}
	
}
