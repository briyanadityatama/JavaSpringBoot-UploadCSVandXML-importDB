package springmvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import springmvc.model.FileUpload;

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
			
		}
		
	}
	
}
