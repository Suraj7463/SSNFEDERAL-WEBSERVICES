package com.professionalit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ssn-web-api")
public class SSNOperationController {

	@GetMapping("/find/{ssn}")
	public ResponseEntity<String>getStatebySSN(@PathVariable Long ssn){
		if(String.valueOf(ssn).length()!=9) {
			return new ResponseEntity<String>("Invalid SSN",HttpStatus.BAD_REQUEST);
			
		}
		
		long stateCode=ssn%100;
		String stateName=null;
		if(stateCode==01) {
			stateName="California";
		}else if(stateCode==02) {
			stateName="Texas";
		}else if(stateCode==03) {
			stateName="Florida";
		}else if(stateCode==04) {
			stateName="Alaska";
		}else {
			stateName="invalid ssn";
		}
		
		return new ResponseEntity<String>(stateName,HttpStatus.OK);
	}
}
