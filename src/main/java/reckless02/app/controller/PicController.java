package reckless02.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import reckless02.app.controller.util.Constants;
import reckless02.app.model.Pic;
import reckless02.app.service.AppService;

@Controller
@RequestMapping("/pic")
public class PicController {

	@GetMapping("/hey")
	public String hey(Model theModel) {
		theModel.addAttribute("theDate",new java.util.Date());
		return "hey";
	}
	
	private AppService appService;
		
	@Autowired
	public PicController(AppService theAppService) {
		appService = theAppService;
	}
	
	@RequestMapping("/list")
	public String picList(Model theModel) {
		List<Pic> thePicturesList = appService.getAllPicList();
		theModel.addAttribute("pictures",thePicturesList);
		return "list";
	}
	
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		Pic thePicture = new Pic();
		//bind
		theModel.addAttribute("pictures",thePicture);
		return "picture-detection";
	}
	
	@RequestMapping("/savedetection")
	public String saveDetection(@ModelAttribute("pictures")Pic thePicture) {
		appService.save(thePicture);
		System.out.println("PicController"+thePicture);
		return "redirect:/pic/list";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate 
	(@RequestParam("picId") int theId,Model theModel) {
		Pic thePicture = appService.findById(theId);
		theModel.addAttribute("pictures",thePicture);
		return "picture-detection";
	}
}
