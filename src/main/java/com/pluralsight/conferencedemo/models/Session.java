package com.pluralsight.conferencedemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.*;

@Entity(name="sessions")
public class Session {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long session_id;
	private String session_name;
	private String session_description;
	private Integer session_lengh;
	
	@ManyToMany
	@JoinTable(name="session_speakers",
	joinColumns=@JoinColumn(name="session_id"), 
	inverseJoinColumns=@JoinColumn(name="speaker_id"))
	
	private List<Speaker> speakers;
	
	public List<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}

	public Session(){
		
	}

	public Long getSession_id() {
		return session_id;
	}

	public void setSession_id(Long session_id) {
		this.session_id = session_id;
	}

	public String getSession_name() {
		return session_name;
	}

	public void setSession_name(String session_name) {
		this.session_name = session_name;
	}

	public String getSession_description() {
		return session_description;
	}

	public void setSession_description(String session_description) {
		this.session_description = session_description;
	}

	public Integer getSession_lengh() {
		return session_lengh;
	}

	public void setSession_lengh(Integer session_lengh) {
		this.session_lengh = session_lengh;
	}
	
}
