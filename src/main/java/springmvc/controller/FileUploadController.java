package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.FileUpload;

@Controller
public class FileUploadController {
	
	@RequestMapping(value="uploadPage", method=RequestMethod.GET)
	public ModelAndView uploadPage() {
		ModelAndView model = new ModelAndView("upload_page");
		FileUpload formUpload = new FileUpload();
		model.addObject("formUpload", formUpload);
		
		return model;
	}

}
