package com.springbootrest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	public static final String template = "Hello, %s!";
	public final AtomicLong count = new AtomicLong();
 	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(count.incrementAndGet() , String.format(template, name));
		
	}
	
}
