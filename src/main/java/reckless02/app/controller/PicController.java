package reckless02.app.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import reckless02.app.model.Pic;
import reckless02.app.service.AppService;

@Controller
@RequestMapping("/pic")
public class PicController {

	private AppService appService;
	
	@Autowired
	public PicController(AppService theAppService) {
		appService = theAppService;
	}
	
	@GetMapping("/hey")
	public String hey(Model theModel) {
		theModel.addAttribute("theDate",new java.util.Date());
		return "hey";
	}
	
	//post+get
	@RequestMapping("/list")
	public String picList(Model theModel) {
		List<Pic> thePicturesList = appService.getAllPicList();
		theModel.addAttribute("pictures",thePicturesList);
		System.out.println("PicController /list");
		return "list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Pic pic = new Pic();
		theModel.addAttribute("pictures",pic);
		System.out.println("PicController /showFormForAdd");
		return "picture-detection";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate 
	(@RequestParam("picId") int theId,Model theModel) {
		Pic thePicture = appService.findById(theId);
		theModel.addAttribute("pictures",thePicture);
		System.out.println("PicController /showFormForUpdate");
		return "picture-detection";
	}

	@PostMapping("/savedetection")
	public String saveDetection(
			//不用@ModelAttribute因為不是一包要分開寫
			@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("content") MultipartFile picFile
			) throws IOException {
		
		System.out.println("Enter PicController /savedetection...");
		
		//這裡是表格手寫資料 id和名字
		Pic pic = new Pic();
		pic.setId(id);
		pic.setName(name);
		System.out.println("PicController /savedetection"+id);
		
		//檔案資料 使用content標抓近來上面取的picFile來設置
		//使用spring的getBytes():Return the contents of the file as an array of bytes.
		//檔案內容的陣列 >> 記憶體位置
		byte[] fileContentArry = picFile.getBytes();
		pic.setContent(fileContentArry);
		System.out.println("fileContentArry:"+fileContentArry);
		
		//檔案名抓取 
		//立字串然後使用spring getOriginalFilename():Return the original filename in the client's filesystem.
		//getName():Return the name of the parameter in the multipart form.
		//set到bean裡面
		String picProfileName = picFile.getName();
		pic.setProfileName(picProfileName);
		System.out.println("picProfileName:"+picProfileName);

		//檔案大小抓取 使用spring
		//	getSize() Return the size of the file in bytes.
		pic.setWhatSize(picFile.getSize());
		
		appService.save(pic);

		System.out.println("PicController /savedetection"+pic);
		
		//有redirect時候 console會一閃而過被洗掉重製
		return "redirect:/pic/list";
	}

	@RequestMapping("/deletepicture")
	public String deletePicture 
	(@RequestParam("picId")int theId) {
		appService.deletebyId(theId);
		System.out.println("PicController /deletepicture :"+theId);
		return "redirect:/pic/list";
	}
 
	@RequestMapping("/image")
	public void showImage(
			@Param("id") int id,
			HttpServletResponse response,
			Optional<Pic> result
			) throws ServletException, IOException {
		
		// java8 才有的 class, 一樣是用容器 (container) 
		//來封裝一個 value-base 的 class, 需要透過 .get() 的方式取得, 或是透過 .isPresent() 是否 non-null。
		//在 JPA select 資料的時候超好用的。
		
		result = appService.findPicById(id);
		
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif, image/pdf");
		response.getOutputStream().write(result.get().getContent());
		response.getOutputStream().close();
		System.out.println("PicController /image:" +" id:"+id+"\n result"+result);
	}

}
