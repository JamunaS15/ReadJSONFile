package com.example.jsonFileRead.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jsonFileRead.model.Profile;
import com.example.jsonFileRead.repository.ProfileRepository;

@Service
public class ProfileService {
	@Autowired
	ProfileRepository profileRepo;
	
	public JSONArray insertProfileDetails(JSONArray profileArr) {
		JSONArray responseArr = new JSONArray();
		try {
			for(int idx = 0; idx < profileArr.size(); idx++) {
				JSONObject profileObj = (JSONObject)profileArr.get(idx);
				Profile profile = new Profile();
				profile.setProid(String.valueOf(idx));
				profile.setId(profileObj.get("id").toString());
				profile.setUrl(profileObj.get("url").toString());
				profile.setNetwork(profileObj.get("network").toString());
				profile.setUsername(profileObj.get("username").toString());
				profileRepo.save(profile);
				responseArr.add(profile);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return responseArr;
	}
}
