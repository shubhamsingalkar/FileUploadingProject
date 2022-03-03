package com.jbk.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	public final String UploadDirectory="C:\\Users\\Lenovo\\Documents\\workspace-spring-tool-suite-4-4.13.0.RELEASE.01\\DemoProject\\src\\main\\resources\\static\\image";

	
	
	public boolean uploadFile(MultipartFile multipart) {
		
		boolean f=false;
		
		try {
			
			// to read data 
			InputStream is = multipart.getInputStream();
			
			byte data []=new byte [is.available()];
			is.read(data);
			
			// to write data
			FileOutputStream fos=new FileOutputStream(UploadDirectory+"\\"+multipart.getOriginalFilename());//concatinated path & file name 
		    fos.write(data);
		    fos.flush();
		    fos.close();
		    
		    //OR (Simple one line)
		    //Files.copy(is,Paths.get(UploadDirectory+File.separator+multipart.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		    
		    f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
