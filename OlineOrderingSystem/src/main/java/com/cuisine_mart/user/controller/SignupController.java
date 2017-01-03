/**
 * 
 */
package com.cuisine_mart.user.controller;

import com.cuisine_mart.beans.UserInfoBean;
import com.cuisine_mart.email.SmtpGmailSender;
import com.cuisine_mart.user.domain.Address;
import com.cuisine_mart.user.domain.Person;
import com.cuisine_mart.user.domain.User;
import com.cuisine_mart.user.domain.UserRole;
import com.cuisine_mart.user.service.IServiceContract.IAddressService;
import com.cuisine_mart.user.service.IServiceContract.IPersonService;
import com.cuisine_mart.user.service.IServiceContract.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Sadiksha
 *
 */
@Controller
public class SignupController {
	@Autowired
    private IAddressService addressService;
    @Autowired
    private IPersonService personService;
    @Autowired
    private IUserService userService;
    
    @Autowired
	private SmtpGmailSender smtpGmailSender;
    
    @RequestMapping(value="/signup",method = RequestMethod.GET)
    public String getSignupForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userInfoBean", new UserInfoBean());
        return "signup";      
    }
    @RequestMapping(value="/thankyou", method=RequestMethod.GET)
    public String thankyouPage(){
    	return "thankyou";
    }
    
    @RequestMapping(value="/signup",method = RequestMethod.POST)
    public String proccessSignUp(@ModelAttribute("userInfoBean") @Valid UserInfoBean userInfoBean,
            Model model,BindingResult result) {
        if(result.hasErrors()) {
            return "signup";
        }
        Address address1 = new Address(userInfoBean.getStreet(),userInfoBean.getCity(),userInfoBean.getState(), userInfoBean.getZip(),userInfoBean.getPhoneNo());
        List<Address>addList = new ArrayList<>();
        addList.add(address1);
        Person person = new Person(userInfoBean.getFirstName(), userInfoBean.getLastName(),userInfoBean.getEmail(),addList);
        Person p = personService.create(person);
        User user = new User(userInfoBean.getEmail(),userInfoBean.getPassword(),userInfoBean.getEmail(),false,p.getPersonId());
//        user.setUsername(userInfoBean.getEmail());
        user.setCreatedDate(new Date());
        User savedUser =  userService.saveNewUser(user);	
        UserRole userRole = new UserRole(userService.getUserByUsername(userInfoBean.getEmail()),"ROLE_USER");
        //System.out.println(userInfoBean.getUserName());    
        userService.saveUserRole(userRole);
        savedUser.setUserRole(userRole);
        userService.updateNewUser(savedUser);
        model.addAttribute("user", new User());
        return "redirect:/thankyou";
    }
        
    @RequestMapping(value="/validateUser/{username:.+}", method= RequestMethod.GET)
	public String userValidation(@PathVariable("username") String username, Model model){
    	System.out.println(username);
		User usr = userService.getUserByUsername(username);
		System.out.println(usr.getUsername());
		usr.setEnabled(true);
		userService.saveNewUser(usr);
		return "redirect:/login";
	}
    
    @RequestMapping("/useredit/{name:.+}")
    public String editUserForm(@PathVariable String name,ModelMap modelMap) {
    	System.out.println(name);
    	User user = userService.getUserByUsername(name); 
    	 List<Address> addressList = addressService.getAllAddress();
    	 System.out.println(user.getPerson());
    	 Person person = personService.findPersonById(user.getPerson());
    	 System.out.println(person);
    	 System.out.println(addressList.get(0));
        UserInfoBean userInfoBean = new UserInfoBean(person.getFristName(), person.getLastName(),user.getEmail(),addressList.get(0).getPhoneNo(),addressList.get(0).getCity(),addressList.get(0).getStreet(),
        		addressList.get(0).getState(),addressList.get(0).getZip(),user.getEmail(),user.getPassword());
         modelMap.addAttribute("userInfoBean",userInfoBean);
        
        return "useredit";
        
    }
    
    @RequestMapping(value="/useredit")
    public String saveEditedUser(@ModelAttribute("userInfoBean") @Valid UserInfoBean userInfoBean,
            Model model,BindingResult result){
    	User user = userService.getUserByUsername(userInfoBean.getEmail());
    	Person person = personService.findPersonById(user.getPerson());
    	Address address = person.getAddress().get(0);
    	user = setUserValues(user,userInfoBean);
    	person = setPersonValues(person,userInfoBean);
    	address = setAddressValues(address,userInfoBean);
        User savedUser =  userService.updateNewUser(user);	
//        UserRole userRole = new UserRole(userService.getUserByUsername(userInfoBean.getEmail()),"ROLE_USER");
         //System.out.println(userInfoBean.getUserName());    
//         userService.saveUserRole(userRole);
//         savedUser.setUserRole(userRole);
         userService.updateNewUser(savedUser);
         personService.update(person);
         model.addAttribute("user", new User());
         return "redirect:/user/dashboard";
    }
    
    public User setUserValues(User user,UserInfoBean userInfoBean){
    	user.setEmail(userInfoBean.getEmail());
    	user.setUsername(userInfoBean.getEmail());
    	user.setPassword(userInfoBean.getPassword());
    	return user;
    }
    
    public Person setPersonValues(Person person, UserInfoBean userInfoBean){
    	person.setFristName(userInfoBean.getFirstName());
    	person.setLastName(userInfoBean.getLastName());
    	person.setEmail(userInfoBean.getEmail());
    	return person;
    }
    
    public Address setAddressValues(Address address , UserInfoBean userInfoBean){
    	address.setCity(userInfoBean.getCity());
    	address.setPhoneNo(userInfoBean.getPhoneNo());
    	address.setState(userInfoBean.getState());
    	address.setStreet(userInfoBean.getStreet());
    	address.setZip(userInfoBean.getZip());
    	return address;
    }
}
