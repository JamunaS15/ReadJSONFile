package com.example.jsonFileRead;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jsonFileRead.service.EducationService;
import com.example.jsonFileRead.service.EmailService;
import com.example.jsonFileRead.service.ExperienceService;
import com.example.jsonFileRead.service.MainService;
import com.example.jsonFileRead.service.ProfileService;


@SpringBootApplication
public class JsonFileReadApplication implements CommandLineRunner{
	
	@Autowired
	MainService mainService;
	
	@Autowired
	ExperienceService experienceService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	EducationService educationService;
	
	public static void main(String[] args) {
		SpringApplication.run(JsonFileReadApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JSONParser parser = new JSONParser();
		try {
			 Object obj = parser.parse(new FileReader(System.getProperty("user.dir")+"/src/main/resources/public/Bath&Bristol_Sample.json"));
	         JSONObject mainObj = (JSONObject)obj;
	         JSONArray resArr = new JSONArray();
	         
	         JSONObject resObj = mainService.insertMainDetails(mainObj);
	         System.out.println(" from main : "+resObj);
	         
	         JSONArray experienceArr = (JSONArray)mainObj.get("experience");
	         if(experienceArr != null && experienceArr.size() > 0) {
	        	 resArr = experienceService.insertExperienceDetails(experienceArr);
	         System.out.println(" from experience : "+resArr);
	         }
	         else
	        	 System.out.println(" Experience Details are empty");
	         
	         JSONArray emailArr = (JSONArray)mainObj.get("emails");
	         resArr = emailService.insertEmailDetails(emailArr);
	         System.out.println(" from emails : "+resArr);
	         
	         JSONArray profileArr = (JSONArray)mainObj.get("profiles");
	         if(profileArr != null && profileArr.size() > 0) {
	         resArr = profileService.insertProfileDetails(profileArr);
	         System.out.println(" from profiles : "+resArr);
	         }
	         else
	        	 System.out.print(" Profiles details are empty");
	         
	         JSONArray educationArr = (JSONArray)mainObj.get("education");
	         if(educationArr != null && educationArr.size() > 0)
	         {
	        	 resArr = educationService.insertEducationDetails(educationArr);
	        	 System.out.println(" from education : "+resArr);
	         }
	         else
	        	 System.out.println(" Education details are empty");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
