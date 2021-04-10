package com.zz.common.controller;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz.common.config.BootdoConfig;

@RequestMapping("/files")
@Controller
public class FileDisplayController {

	@Autowired
	private BootdoConfig bootdoConfig;
	
	@GetMapping("/{fileName}")
	public void display(@PathVariable("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) {
		
		
		File file = new File(bootdoConfig.getUploadPath() + fileName);
		
		try {
			FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
			response.setHeader("Content-Type", "application/octet-stream");
			return;
		} catch (Exception e) {
//			request.setAttribute("exception", new FileNotFoundException("请求的文件不存在"));
//			request.getRequestDispatcher("/webpage/error/404.jsp").forward(request, response);
		}
	}
}
