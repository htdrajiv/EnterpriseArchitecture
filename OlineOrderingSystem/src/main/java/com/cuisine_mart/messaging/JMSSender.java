package com.cuisine_mart.messaging;

import org.springframework.jms.core.JmsTemplate;

/**
 * Created by Rajiv on 8/31/2016.
 */
public class JMSSender {

    private JmsTemplate jmsTemplate;

    public void send(final String restaurantMessage) {
        jmsTemplate.send(session -> session.createObjectMessage(restaurantMessage));
        System.out.println("Message has been broadcasted to all our portal members");
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
