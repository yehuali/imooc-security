/**
 * 
 */
package com.imooc.web.controller;


import com.imooc.exception.UserNotExistException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangjie
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/hello")
	public String hello() {
//		throw new UserNotExistException("5");
        return "hello spring security";
	}
}
