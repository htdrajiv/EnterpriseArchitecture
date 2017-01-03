package com.cuisine_mart.aop;

import com.cuisine_mart.configuration.JmsConfig;
import com.cuisine_mart.messaging.JMSSender;
import com.cuisine_mart.restaurant.domain.Restaurant;
import com.cuisine_mart.user.domain.Address;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import javax.naming.NamingException;

/**
 * Created by Rajiv on 8/31/2016.
 */
@Aspect
@Component
public class MessageAdvice {
   ApplicationContext context = new AnnotationConfigApplicationContext(
            JmsConfig.class);

    @After("execution(* com.cuisine_mart.restaurant.service.implementation.RestaurantServiceImpl.save(..)) && args(restaurant)")
    public void broadCastMessageAfterAddingRestaurant(Restaurant restaurant) throws MessagingException, NamingException {
        printMessage("Broadcasting message to all restaurants ....");
        String msgBody = "New member restaurant : "+restaurant.getName()+" has been added to our portal cuisine_mart\n";
        msgBody += "Details: ";
        msgBody += " \nName: "+restaurant.getName();
        msgBody += " \nDescription: "+restaurant.getDescription();
        for(Address address : restaurant.getAddressList()){
            msgBody += "\n State: "+address.getState();
            msgBody += "\n City: "+address.getCity();
            msgBody += "\n Street: "+address.getStreet();
            msgBody += "\n Zip: "+address.getZip();
            msgBody += "\n Email: "+restaurant.getEmail();
            msgBody += "\n Phone: "+address.getPhoneNo();
        }
        JMSSender jmsSender = context.getBean("jmsSender", JMSSender.class);
        jmsSender.send(msgBody);
        printMessage("Complete broadcasting the message..");
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}
