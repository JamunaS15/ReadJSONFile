package com.example.jsonFileRead.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jsonFileRead.model.Emails;
import com.example.jsonFileRead.repository.EmailsRepository;

@Service
public class EmailService {
	@Autowired
	EmailsRepository emailRepo;
	
	public JSONArray insertEmailDetails(JSONArray emailArr) {
		JSONArray responseArr = new JSONArray();
		try {
			for(int idx = 0; idx < emailArr.size(); idx++) {
				JSONObject mailObj = (JSONObject)emailArr.get(idx);
				Emails email = new Emails();
				
				email.setMailid(mailObj.get("address").toString());
				email.setAddress(mailObj.get("address").toString());
				email.setType(mailObj.get("type").toString());
				emailRepo.save(email);
				responseArr.add(email);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return responseArr;
	}
}
