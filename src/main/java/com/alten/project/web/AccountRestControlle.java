package com.alten.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alten.project.entities.AppUser;
import com.alten.project.service.AccountService;

@RestController
public class AccountRestControlle {
	
	


	    @Autowired
	    private AccountService accountService;
	    @PostMapping("/register")
	    public AppUser register(@RequestBody  AppUser user){
	        System.out.println("I am here");
	    return accountService.saveUser(user);
	}


}
