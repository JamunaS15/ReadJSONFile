package com.example.jsonFileRead.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jsonFileRead.model.Main1;
import com.example.jsonFileRead.repository.Main1Repository;

@Service
public class MainService {
	@Autowired
	Main1Repository mainRepo;
	
	public JSONObject insertMainDetails(JSONObject mainObj) {
		JSONObject responseObj = new JSONObject();
		try {
			String phoneNumbers = "", interests = "", skills = "", countries = "", locationNames = "", streetAddresses = "", regions = "";
			Main1 main = new Main1();
			main.setJob_company_location_geo(mainObj.get("job_company_location_geo").toString());
			main.setJob_company_name(mainObj.get("job_company_name").toString());
			if(mainObj.get("birth_date") != null && mainObj.get("birth_date").toString().length() > 0)
				main.setBirth_date(mainObj.get("birth_date").toString());
			if(mainObj.get("middle_initial") != null && mainObj.get("middle_initial") != "")
				main.setMiddle_initial(mainObj.get("middle_initial").toString());
			main.setJob_company_size(mainObj.get("job_company_size").toString());
			main.setLinkedin_username(mainObj.get("linkedin_username").toString());
			if(mainObj.get("birth_year") != null && mainObj.get("birth_year") != "")
				main.setBirth_year(mainObj.get("birth_year").toString());
			main.setJob_company_location_locality(mainObj.get("job_company_location_locality").toString());
			main.setId(mainObj.get("id").toString());
			main.setJob_title(mainObj.get("job_title").toString());
			if(mainObj.get("facebook_url") != null && mainObj.get("facebook_url") != "")
				main.setFacebook_url(mainObj.get("facebook_url").toString());
			main.setJob_company_id(mainObj.get("job_company_id").toString());
			main.setLocation_region(mainObj.get("location_region").toString());
			if(mainObj.get("location_street_address") != null && mainObj.get("location_street_address").toString().length() > 0)
				main.setLocation_street_address(mainObj.get("location_street_address").toString());
			if(mainObj.get("location_address_line_2") != null && mainObj.get("location_address_line_2").toString().length() > 0)
				main.setLocation_address_line_2(mainObj.get("location_address_line_2").toString());
			if(mainObj.get("job_company_location_postal_code") != null && mainObj.get("job_company_location_postal_code").toString().length() > 0)
				main.setJob_company_location_postal_code(mainObj.get("job_company_location_postal_code").toString());
			if(mainObj.get("facebook_id") != null && mainObj.get("facebook_id") != "")
				main.setFacebook_id(mainObj.get("facebook_id").toString());
			main.setLocation_name(mainObj.get("location_name").toString());
			main.setFull_name(mainObj.get("full_name").toString());
			main.setLocation_last_updated(mainObj.get("location_last_updated").toString());
			JSONObject version = (JSONObject)mainObj.get("version_status");
			JSONArray versionContains = (JSONArray)version.get("contains");
			if(versionContains.size() > 0)
				main.setVersion_contains(versionContains.toString());
			main.setPrevious_version(version.get("previous_version").toString());
			main.setCurrent_version(version.get("current_version").toString());
			main.setVersion_status(version.get("status").toString());
			if(mainObj.get("job_company_location_street_address") != null && mainObj.get("job_company_location_street_address").toString().length() > 0)
				main.setJob_company_location_street_address(mainObj.get("job_company_location_street_address").toString());
			main.setJob_company_founded(mainObj.get("job_company_founded").toString());
			main.setLinkedin_url(mainObj.get("linkedin_url").toString());
			main.setWork_email(mainObj.get("work_email").toString());
			main.setJob_company_location_region(mainObj.get("job_company_location_region").toString());
			main.setJob_company_website(mainObj.get("job_company_website").toString());
			main.setGender(mainObj.get("gender").toString());
			main.setLocation_country(mainObj.get("location_country").toString());
			if(mainObj.get("facebook_username") != null && mainObj.get("facebook_username") != "")
				main.setFacebook_username(mainObj.get("facebook_username").toString());
			if(mainObj.get("twitter_username") != null && mainObj.get("twitter_username") != "")
				main.setTwitter_username(mainObj.get("twitter_username").toString());
			main.setJob_company_location_country(mainObj.get("job_company_location_country").toString());
			if(mainObj.get("github_username") != null && mainObj.get("github_username") != "")
				main.setGithub_username(mainObj.get("github_username").toString());
			main.setIndustry(mainObj.get("industry").toString());
			main.setLocation_geo(mainObj.get("location_geo").toString());
			if(mainObj.get("job_company_location_address_line_2") != null && mainObj.get("job_company_location_address_line_2").toString().length() > 0)
				main.setJob_company_location_address_line_2(mainObj.get("job_company_location_address_line_2").toString());
			if(mainObj.get("location_postal_code") != null && mainObj.get("location_postal_code").toString().length() > 0)
				main.setLocation_postal_code(mainObj.get("location_postal_code").toString());
			if(mainObj.get("mobile_phone") != null && mainObj.get("mobile_phone").toString().length() > 0)
				main.setMobile_phone(mainObj.get("mobile_phone").toString());
			main.setLocation_continent(mainObj.get("location_continent").toString());
			main.setLocation_locality(mainObj.get("location_locality").toString());
			main.setFirst_name(mainObj.get("first_name").toString());
			if(mainObj.get("twitter_url") != null && mainObj.get("twitter_url") != "")
				main.setTwitter_url(mainObj.get("twitter_url").toString());
			main.setJob_company_location_continent(mainObj.get("job_company_location_continent").toString());
			main.setJob_company_facebook_url(mainObj.get("job_company_facebook_url").toString());
			main.setJob_company_linkedin_url(mainObj.get("job_company_linkedin_url").toString());
			main.setLast_name(mainObj.get("last_name").toString());
			main.setLinkedin_id(mainObj.get("linkedin_id").toString());
			main.setJob_last_updated(mainObj.get("job_last_updated").toString());
			if(mainObj.get("middle_name") != null && mainObj.get("middle_name") != "")
				main.setMiddle_name(mainObj.get("middle_name").toString());
			main.setJob_company_twitter_url(mainObj.get("job_company_twitter_url").toString());
			if(mainObj.get("job_title_role") != null && mainObj.get("job_title_role").toString().length() > 0)
				main.setJob_title_role(mainObj.get("job_title_role").toString());
			main.setJob_company_linkedin_id(mainObj.get("job_company_linkedin_id").toString());
			if(mainObj.get("github_url") != null && mainObj.get("github_url") != "")
				main.setGithub_url(mainObj.get("github_url").toString());
			main.setJob_company_industry(mainObj.get("job_company_industry").toString());
			main.setJob_company_location_name(mainObj.get("job_company_location_name").toString());
			skills = jsonToString((JSONArray)mainObj.get("skills"));
			main.setSkills(skills);
			JSONArray jobTitleArr = (JSONArray) mainObj.get("job_title_levels");
			String jobTitleLevels = jsonToString(jobTitleArr);
			main.setJob_title_levels(jobTitleLevels);
			countries = jsonToString((JSONArray)mainObj.get("countries"));
			main.setCountries(countries);
			locationNames = jsonToString((JSONArray)mainObj.get("location_names"));
			main.setLocation_names(locationNames);
			regions = jsonToString((JSONArray)mainObj.get("regions"));
			main.setRegions(regions);
			if(mainObj.get("street_addresses") != null)
				streetAddresses = jsonToString((JSONArray)mainObj.get("street_addresses"));
				main.setStreet_addresses(streetAddresses);
			
			if(mainObj.get("phone_numbers") != null)
				 phoneNumbers = jsonToString((JSONArray)mainObj.get("phone_number"));
				main.setPhone_numbers(phoneNumbers);
			if(mainObj.get("interests") != null)
				interests = jsonToString((JSONArray)mainObj.get("interests"));
				main.setInterests(interests);
			if(mainObj.get("inferred_salary") != null && mainObj.get("inferred_salary").toString().length() > 0)
				main.setInferred_salary(mainObj.get("inferred_salary").toString());
			main.setInferred_years_experience(mainObj.get("inferred_years_experience").toString());
			main.setSummary(mainObj.get("summary").toString());
			mainRepo.save(main);
			responseObj.put("details", main);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return responseObj;
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
