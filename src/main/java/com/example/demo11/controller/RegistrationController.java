package com.example.demo11.controller;

import com.example.demo11.DtoModel.UserDtoModel;
import com.example.demo11.entity.Message;
import com.example.demo11.entity.User;
import com.example.demo11.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/registration/add")
    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE},
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Message> createUser(@RequestBody UserDtoModel userDTO) {
        User newUserr = new User();
        newUserr.setUserName(userDTO.getUsername());
        newUserr.setPassword(userDTO.getPassword());
        newUserr.setRoles("ROLE_USER");
        newUserr.setActive(true);


        logger.info("reg Acces");
        logger.info(userDTO.getUsername());
        logger.info("Password: "+userDTO.getPassword());

        if(userRepository.findByUserName(newUserr.getUserName())==null) {
            userRepository.save(newUserr);
            return new ResponseEntity<Message>(new Message(1,"Hello "+userDTO.getUsername(),userDTO.getPassword()),HttpStatus.OK);
        }
        else return new ResponseEntity<Message>(new Message(1,"User "+userDTO.getUsername(),"   Already Exists"),HttpStatus.OK);



    }


}
