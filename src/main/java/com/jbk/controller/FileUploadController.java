package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jbk.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper helper; 

	@PostMapping("/upload")
	public ResponseEntity<String> uploadfile(@RequestParam ("file") MultipartFile file){
		
		/*
		 * System.out.println(file.getName()); System.out.println(file.getSize());
		 * System.out.println(file.getContentType());
		 */
		
		System.out.println(file.getOriginalFilename());
		//Validation
		try {
		
		if(file.isEmpty()) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please select image");
		}
		
		if(!file.getContentType().equalsIgnoreCase("image/jpeg")) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG format supports");
			
		}
		
		//file uploading code
		
		boolean f = helper.uploadFile(file);
		
		if(f==true) {
			
			return ResponseEntity.ok("File uploaded successfully");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong, Try again..!!");
		
	}
}
