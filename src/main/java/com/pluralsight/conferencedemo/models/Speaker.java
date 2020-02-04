package com.pluralsight.conferencedemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import java.util.*;

@Entity(name="speakers")
public class Speaker {

	@Id
	@GeneratedValue()
	private long speaker_id; 
	private String first_name;
	private String last_name;
	private String title;
	private String company;
	private String Speakers_bio;
	
	//to handle the binary data 
	@Lob
	@org.hibernate.annotations.Type(type="org.hibernate.type.BinaryType")
	private byte[] speaker_photo;
	
	@ManyToMany(mappedBy="speakers")
	private List<Session> sessions;
	
	public byte[] getSpeaker_photo() {
		return speaker_photo;
	}

	public void setSpeaker_photo(byte[] speaker_photo) {
		this.speaker_photo = speaker_photo;
	}

	public Speaker() {
		
	}
}
