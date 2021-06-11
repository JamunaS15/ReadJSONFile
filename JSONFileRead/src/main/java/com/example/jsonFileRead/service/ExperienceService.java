package com.example.jsonFileRead.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jsonFileRead.model.Experience;
import com.example.jsonFileRead.repository.ExperienceRepository;

@Service
public class ExperienceService {
	@Autowired
	ExperienceRepository experienceRepo;
	
	public JSONArray insertExperienceDetails(JSONArray exArr) {
		JSONArray responseArr = new JSONArray();
		try {
			for(int idx = 0; idx < exArr.size(); idx++) {
				JSONObject exObj = (JSONObject)exArr.get(idx);
				Experience ex = new Experience();
				ex.setExpid(String.valueOf(idx));
				JSONObject companyObj = (JSONObject)exObj.get("company");
				ex.setName(companyObj.get("name").toString());
				ex.setSize(companyObj.get("size").toString());
				ex.setId(companyObj.get("id").toString());
				if(companyObj.get("founded") != null)
					ex.setFounded(companyObj.get("founded").toString());
				ex.setIndustry(companyObj.get("industry").toString());
				JSONObject locObj = (JSONObject)companyObj.get("location");
				ex.setLname(locObj.get("name").toString());
				if(locObj.get("locality") != null)
					ex.setLocality(locObj.get("locality").toString());
				if(locObj.get("region") != null)
					ex.setRegion(locObj.get("region").toString());
				ex.setCountry(locObj.get("country").toString());
				ex.setContinent(locObj.get("continent").toString());
				if(locObj.containsKey("street_address") && locObj.get("street_address") != null)
					ex.setStreet_address(locObj.get("street_address").toString());
				if(locObj.containsKey("address_line_2") && locObj.get("address_line_2") != null)
					ex.setAddress_line_2(locObj.get("address_line_2").toString());
				if(locObj.containsKey("postal_code") && locObj.get("postal_code") != null)
					ex.setPostal_code(locObj.get("postal_code").toString());
				if(locObj.get("geo") != null)
					ex.setGeo(locObj.get("geo").toString());
				ex.setLinkedin_id(companyObj.get("linkedin_id").toString());
				ex.setLinkedin_url(companyObj.get("linkedin_url").toString());
				if(companyObj.get("facebook_url") != null)
					ex.setFacebook_url(companyObj.get("facebook_url").toString());
				if(companyObj.get("twitter_url") != null)
					ex.setTwitter_url(companyObj.get("twitter_url").toString());
				if(companyObj.get("website") != null)
				ex.setWebsite(companyObj.get("website").toString());
				String locationNames = jsonToString((JSONArray)exObj.get("location_names"));
				ex.setLocation_names(locationNames);
				if(exObj.containsKey("end_date") && exObj.get("end_date") != null)
				ex.setEnd_date(exObj.get("end_date").toString());
				ex.setStart_date(exObj.get("start_date").toString());
				JSONObject titleObj = (JSONObject)exObj.get("title");
				ex.setTitle_name(titleObj.get("name").toString());
				if(titleObj.containsKey("role") && titleObj.get("role") != null)
					ex.setTitle_role(titleObj.get("role").toString());
				String levels = jsonToString((JSONArray)titleObj.get("levels"));
				ex.setTitle_level(levels);
				ex.setIs_primary(exObj.get("is_primary").toString());
				if(exObj.containsKey("summary") && exObj.get("summary") != null)
					ex.setSummary(exObj.get("summary").toString());
				
				experienceRepo.save(ex);
				responseArr.add(ex);
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return responseArr;
	}
	private String jsonToString(JSONArray jsonArr) {
		String res = "";
		try {
			if(jsonArr != null && jsonArr.size() > 0) {
			for(Object obj : jsonArr) {
				res += obj.toString() + ",";
			}
			res = res.substring(0,res.length() -1);
			}
			else
				res = "";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
