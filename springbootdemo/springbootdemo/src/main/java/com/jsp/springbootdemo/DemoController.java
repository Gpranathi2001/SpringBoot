package com.jsp.springbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController
{
	@GetMapping("/test")
	public String test()
	{
		return "my first spring boot project";
	}

}
