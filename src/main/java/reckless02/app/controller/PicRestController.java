package reckless02.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reckless02.app.controller.util.Constants;
import reckless02.app.model.Pic;
import reckless02.app.service.AppService;

public class PicRestController {

//	@Autowired
//	AppService appService;
	
//	@RequestMapping(value = Constants.INDEX_PAGE_URI, method = RequestMethod.GET)
//	public String indexPage() {
//		System.out.println("RestController indexPage() ");
//		System.out.println(Constants.INDEX_PAGE_URI);
//		System.out.println(Constants.INDEX_PAGE);
//		return Constants.INDEX_PAGE;
//	}
//	
//	@RequestMapping	(value = Constants.PIC_URI, method = RequestMethod.GET)
//	public List<Pic> getAllPicList(){
//		System.out.println("===RestController  List<Pic> getAllPicList() ===");
//		System.out.println(appService.getAllPicList());
//		return appService.getAllPicList();
//	}
}
