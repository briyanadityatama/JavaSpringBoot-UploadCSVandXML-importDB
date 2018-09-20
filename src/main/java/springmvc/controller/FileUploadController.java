package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value="/doUpload", method=RequestMethod.POST)
	public String doUpload(@ModelAttribute("formUpload") FileUpload fileupload, BindingResult result ){
	
		if(result.hasErrors()) {
			return "uploadPage";
		} else {
			//doUpload
			return "redirect:/success";
		}
	}

	@RequestMapping(value="/success", method=RequestMethod.GET)
	public ModelAndView success() {
		ModelAndView model = new ModelAndView("success");
		return model;
		
	}
}
