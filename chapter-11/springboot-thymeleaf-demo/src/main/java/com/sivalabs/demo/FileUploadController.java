/**
 * 
 */
package com.sivalabs.demo;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Siva
 *
 */
@Controller
public class FileUploadController implements HandlerExceptionResolver
{
	private static final String UPLOADS_DIR = "D:/uploads/";

	@RequestMapping({ "/fileUpload"})
	public String home(Model model) {
		return "fileUpload";
	}
	
	@RequestMapping(value = "/uploadMyFile", method = RequestMethod.POST)
	public String handleFileUpload(@RequestParam("myFile") MultipartFile file, 
			RedirectAttributes redirectAtttributes) {
		if (!file.isEmpty()) {
			String name = file.getOriginalFilename();
			try {
				byte[] bytes = file.getBytes();
				File uploadingDir = new File(UPLOADS_DIR);
				if(!uploadingDir.exists()){
					uploadingDir.mkdirs();
				}
				Files.write(new File(UPLOADS_DIR + name).toPath(), bytes);				
				redirectAtttributes.addFlashAttribute("msg", "File " + name + " uploaded successfully");
			} catch (Exception e) {
				redirectAtttributes.addFlashAttribute("msg", "Failed to upload file" + name + ". Cause: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return "redirect:/fileUpload";
	}
	
	/*
	@ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView handleMaxUploadException(MaxUploadSizeExceededException e, 
    		HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("msg", e.getMessage());
        return new ModelAndView("fileUpload", model);
    }
	*/
	
	public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception exception)
    {        
        Map<String, Object> model = new HashMap<String, Object>();
        if (exception instanceof MultipartException)
        {
            model.put("msg", "MultipartException: "+exception.getMessage());
        } else
        {
            model.put("msg", "Unexpected error: " + exception.getMessage());
        }
        
        return new ModelAndView("fileUpload", model);
    }


}
