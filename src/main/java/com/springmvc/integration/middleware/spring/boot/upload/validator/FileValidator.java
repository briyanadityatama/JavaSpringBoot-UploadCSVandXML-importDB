package com.springmvc.integration.middleware.spring.boot.upload.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.springmvc.integration.middleware.spring.boot.upload.model.FileUpload;
import com.springmvc.integration.middleware.spring.boot.upload.utils.CommonUtils;

@Component
public class FileValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return FileUpload.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		FileUpload fileUpload = (FileUpload) target;
		
		CommonsMultipartFile[] multipartFiles = fileUpload.getFiles();
		
		for(CommonsMultipartFile multipartFile: multipartFiles) {
			
			//check file size
			if(multipartFile.getSize() == 0) {
				errors.rejectValue("files", "required.file");
				break;
			}
			//check file extension
			
			String fileExtension = CommonUtils.getFileExtension(multipartFile.getOriginalFilename().toLowerCase());
			if(fileExtension.equals("xml") && !fileExtension.equals("csv") ) {
				errors.rejectValue("files", "file.extension.allowed");
				break;
			}
		}
		
	}
	
}