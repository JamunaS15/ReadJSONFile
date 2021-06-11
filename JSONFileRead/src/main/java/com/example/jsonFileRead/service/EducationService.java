package com.example.jsonFileRead.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jsonFileRead.model.Education;
import com.example.jsonFileRead.repository.EducationRepository;

@Service
public class EducationService {
	@Autowired
	EducationRepository educationRepo;
	
	
	public JSONArray insertEducationDetails(JSONArray eduArr) {
		JSONArray responseArr = new JSONArray();
		try {
			for(int idx = 0; idx < eduArr.size(); idx++) {
				JSONObject eduObj = (JSONObject)eduArr.get(idx);
				Education edu = new Education();
				edu.setEduid(eduObj.get("edu_id").toString());
				edu.setName(eduObj.get("name").toString());
				edu.setType(eduObj.get("type").toString());
				edu.setId(eduObj.get("id").toString());
				edu.setLinkedin_url(eduObj.get("linkedin_url").toString());
				edu.setFacebook_url(eduObj.get("facebook_url").toString());
				edu.setTwitter_url(eduObj.get("twitter_url").toString());
				edu.setLinkedin_id(eduObj.get("linkedin_id").toString());
				edu.setWebsite(eduObj.get("website").toString());
				edu.setDomain(eduObj.get("domain").toString());
				edu.setLocation(eduObj.get("location").toString());
				edu.setDegrees(eduObj.get("degrees").toString());
				edu.setMajors(eduObj.get("majors").toString());
				edu.setMinors(eduObj.get("minors").toString());
				edu.setStart_date(eduObj.get("start_date").toString());
				edu.setEnd_date(eduObj.get("end_date").toString());
				edu.setGpa(eduObj.get("gpa").toString());
				edu.setSummary(eduObj.get("summary").toString());
				educationRepo.save(edu);
				responseArr.add(edu);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return responseArr;
	}
}
