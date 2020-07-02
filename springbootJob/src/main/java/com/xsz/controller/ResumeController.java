package com.xsz.controller;

import com.xsz.entity.Position;
import com.xsz.entity.Resume;
import com.xsz.entity.User;
import com.xsz.service.ResumeService;
import com.xsz.util.KeyUtil;
import com.xsz.util.PDFTemplateUtil;
import com.xsz.util.ResultVOUtil;
import com.xsz.util.XSZUtil;
import com.xsz.vo.ResultVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

/**
 * @Date:2020/3/25 17:13
 * @Author:bsea
 * 简历
 */
@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Resource
    ResumeService resumeService;
    @Resource
    RestTemplate restTemplate;

    @Value("${imagesPath}")
    private String imagesPath;

    @Resource
    XSZUtil xszUtil;

    /**查询当前用户所有简历**/
    @GetMapping("/showBycreateBy/{page}/{limit}")
    public ResultVO showBycreateBy(@PathVariable("page") String page, @PathVariable("limit") String limit, HttpServletRequest request){
        User loginUser = (User)request.getSession().getAttribute("loginuser");

        return ResultVOUtil.success(resumeService.showBycreateBy(page, limit, loginUser.getId()));
    }

    /**添加简历**/
    @PostMapping(value = "/addResume")
    public void addResume(HttpServletRequest request, HttpServletResponse response) throws IOException {

        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;

        MultipartFile multipartFile = multipartHttpServletRequest.getFile("imageFile");

        Resume resume = new Resume();
        String uid = ((User)request.getSession().getAttribute("loginuser")).getId();

        String imagePath = "";
        if(!multipartFile.isEmpty()){
            String fileName = multipartFile.getOriginalFilename();
            imagePath = uid + "-" + fileName;

            File file = new File(imagesPath.substring(6) + imagePath);
            multipartFile.transferTo(file);

            resume.setImage(file.getPath());
        }

        resume.setAge(Integer.parseInt(request.getParameter("age")));
        resume.setSex(request.getParameter("sex"));
        resume.setMobile(request.getParameter("mobile"));
        resume.setMajor(request.getParameter("major"));
        resume.setResumeName(request.getParameter("resumeName"));
        resume.setName(request.getParameter("name"));
        resume.setEducation(request.getParameter("education"));
        resume.setAssessment(request.getParameter("assessment"));
        resume.setCertificate(request.getParameter("certificate"));
        resume.setWorkedyears(request.getParameter("workedyears"));
        resume.setProjectExp(request.getParameter("projectExp"));
        resume.setTrainExp(request.getParameter("trainExp"));
        resume.setId(KeyUtil.getId());
        resume.setCreateBy(uid);


        ResponseEntity<ResultVO> resultVO=xszUtil.callService("http://DOC/job/resume", XSZUtil.objectToMap(resume));

        if("成功".equals(resultVO.getBody().getMsg())){
            Map<String, Object> result = (LinkedHashMap)resultVO.getBody().getData();

            resume.setWordPath(request.getContextPath() + "/word/" + ((String) result.get("filePath")));

            if(!multipartFile.isEmpty()){
                resume.setImage(request.getContextPath() + "/images/" + imagePath);
            }

            resumeService.addResume(resume);
        }

        response.sendRedirect("/job/resumeList.html");


    }

    /**修改当前用户简历**/
    @PostMapping("editResume")
    public ResultVO editResume(@RequestBody Resume resume, HttpServletRequest request){
        resume.setCreateBy(((User) request.getSession().getAttribute("loginuser")).getId());
        return ResultVOUtil.success(resumeService.editResume(resume));
    }

    /**删除简历**/
    @PostMapping("deleteResume/{id}")
    public ResultVO deleteResume(@PathVariable("id") String id){
        resumeService.deleteResume(id);
        Map<String, String> result = new HashMap<>();
        result.put("result", "成功");
        return ResultVOUtil.success(result);
    }


}
