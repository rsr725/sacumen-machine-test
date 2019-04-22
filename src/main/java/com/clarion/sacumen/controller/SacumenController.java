package com.clarion.sacumen.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.clarion.sacumen.service.SacumenService;

@RestController
public class SacumenController {
	
	@Autowired
	SacumenService sacumenService;
	
	@GetMapping("/")
	 public ModelAndView home(ModelAndView mav) {
		mav.setViewName("index");
		  return mav;
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getContent() {
		try {
			return new ResponseEntity<Map<String, List<String>>>(sacumenService.getFileIssueIdList(), HttpStatus.OK);
		} catch (IOException | JSONException e) {
			return new ResponseEntity<String>("Some error occurred while processing data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/v2/get")
	public ResponseEntity<?> getContentV2() {
		try {
			return new ResponseEntity<List<Map<String, Object>>>(sacumenService.getFileIssueIdListV2(), HttpStatus.OK);
		} catch (IOException | JSONException e) {
			return new ResponseEntity<String>("Some error occurred while processing data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
