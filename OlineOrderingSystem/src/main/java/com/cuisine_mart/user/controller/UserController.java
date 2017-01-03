package com.cuisine_mart.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cuisine_mart.user.domain.User;
import com.cuisine_mart.user.service.Implementation.UserServiceImpl;

/**
 * @author Sadiksha
 *
 */

@Controller
public class UserController {
	@Autowired
	UserServiceImpl userService;

}
