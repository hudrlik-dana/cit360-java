package com.dana.controller;

import com.dana.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;



@Controller
public class MessageController {

    // create the map class hashmap to hold a number of messages
    private static final Map<Integer, Message> hashMap = new HashMap<>();
    // map web requests (routing) onto handler methods in message path
    // using the request method get
    @RequestMapping(value="/message", method= RequestMethod.GET)

    // create the message form passing in the model and and path messageID
    public String messageForm(Model model, @RequestParam(value = "messageID", required = false) Integer messageID) {
        // messageId from hashMap passed into message
        Message message = hashMap.get(messageID);
        // returns the message with messageID
        return message.getMessageID();
    }

    // map web request (routing) to handler method in message path
    // using the request method post
    @RequestMapping(value="/message", method=RequestMethod.POST)

    // messageSubmitted method uses @ModelAttribute to filter messages in the form
    // constructing messageSubmitted from message and model
    public String messageSubmitted(@ModelAttribute Message message, Model model) {

        // add a new message to the original model
        model.addAttribute("message", message);

        // count the size of the hashmap - number of entries
        int count = hashMap.size();
        // add another count number to the message count in hashmap
        hashMap.put((count+1), message);

        // return the current number of entries in the hashmap
        return "result";
    }
}