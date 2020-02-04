package com.pluralsight.conferencedemo.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;

import java.util.*;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

	@Autowired
	private SessionRepository sessionRepository;

	@GetMapping
	public List<Session> list(){
		return sessionRepository.findAll(); // JPA repository - go and call all the session and create object of that 
	}
	
    @GetMapping // http web when we call this method 
    @RequestMapping("{id}") //adding additional id on URL
    public Session get(@PathVariable Long id) {
    	return sessionRepository.getOne(id);
    }
    
    @PostMapping
    public Session create(@RequestBody final Session session) {
    	return sessionRepository.saveAndFlush(session);
    }
    
    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    	public void delete(@PathVariable Long id) {
    		sessionRepository.deleteById(id);
    	}
    
    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
    	
    	//becuase this is a put, we expect all attribute to be passedin.
    	
    	Session existingSession = sessionRepository.getOne(id);
    	BeanUtils.copyProperties(session, existingSession, "session_id"); // session_id is primary key 
        return sessionRepository.saveAndFlush(existingSession);
    }
    }

