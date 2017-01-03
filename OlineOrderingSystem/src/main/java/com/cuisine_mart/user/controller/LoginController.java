package com.cuisine_mart.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cuisine_mart.user.domain.Person;
import com.cuisine_mart.user.service.IServiceContract.IPersonService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Rajiv on 8/25/2016.
 */
@Controller
@SessionAttributes("person")
public class LoginController {
	@Autowired 
	IPersonService personService;
    @RequestMapping(value = "/handleLogin", method = RequestMethod.GET)
    public String handleLogin(HttpServletRequest request){
        String view = "";
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Person person = personService.findPersonByEmail(username);
		
		request.getSession().setAttribute("person", person);
		
        if (userHasAuthority("ROLE_ADMIN")) view = "/admin/dashboard";
        else if(userHasAuthority("ROLE_USER")) view = "/user/dashboard";
        return "redirect:"+view;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout ,HttpServletRequest request) {
    	
        ModelAndView model = new ModelAndView();
/*    	Person person = (Person) request.getSession().getAttribute("person");
    	if(person != null) {
       	 	model.setViewName("userDashBoard");
    	}*/
    	 //User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // String name = user.getUsername();

/*         if(user.getUsername() != null) {
        	 model.setViewName("userDashBoard");
         }*/
         
       
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");
        return model;

    }

    public boolean userHasAuthority(String authority)
    {
        List<GrantedAuthority> authorities = getUserAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (authority.equals(grantedAuthority.getAuthority())) {
                return true;
            }
        }
        return false;
    }

    public List<GrantedAuthority> getUserAuthorities(){
        return (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }

//    @RequestMapping(value="/logout", method = RequestMethod.GET)
//    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("inside logout");
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/login";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
//    }
}

