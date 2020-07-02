package com.xsz.controller;

//import com.xsz.entity.Template;
//import com.xsz.service.TemplateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RestController
public class FileController {
		//@Value 获取配置文件里面的属性值，并且赋值给下面的属性
	
	 	@Value("${fileUpLoadPath}")
	    String filePath;
//	@Resource
//	TemplateService templateService;
	 	
	 	/**
	 	 * @RequestMapping 表示同时支持接收post和get请求。
	 	 * 如果加上method=RequestMethod.POST， 表示只接收post请求
	 	 * 其实有一个注解可以直接指定，只接收post请求---@PostMapping
	 	 * @param req
	 	 * @param multiReq
	 	 * @throws IOException
	 	 */
	 	@PostMapping("/templteUpload")
	   // @RequestMapping(value="/testUpload3",method=RequestMethod.POST)
	    public void  testUploadFile(HttpServletRequest req, MultipartHttpServletRequest multiReq, HttpServletResponse response) throws IOException, ServletException {
	        MultipartFile multipartFile= multiReq.getFile("file");
	        String filename=multipartFile.getOriginalFilename();
	        System.out.println("文件名字："+multipartFile.getOriginalFilename());
	        File file=new File(filePath+filename);
	        multipartFile.transferTo(file);
	        String mname=req.getParameter("mname");
	        System.out.println("模板名字："+mname);
//			Template template=new Template();
//			template.setName(req.getParameter("mname"));
//			template.setPath(file.getPath());
//			String mtype=req.getParameter("mtype");
//			template.setType(Integer.parseInt(mtype));
//			templateService.add(template);
			response.sendRedirect("/report/template.html");
	        
	    }

}