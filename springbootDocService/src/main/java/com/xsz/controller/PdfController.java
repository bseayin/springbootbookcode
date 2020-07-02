package com.xsz.controller;


import com.xsz.util.PDFDataTest;
import com.xsz.util.PDFTemplateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/pdf")
public class PdfController {

    @RequestMapping("/export")
    public void exportPdf(HttpServletResponse response) throws Exception{
        ByteArrayOutputStream baos = null;
        OutputStream out = null;
        try {
            // 模板中的数据，实际运用从数据库中查询
            Map<String,Object> data = new HashMap<>();
            data.put("curr", 1);
            data.put("one", 2);
            data.put("two", 1);
            data.put("three", 6);

            List<PDFDataTest> detailList = new ArrayList<>();
            detailList.add(new PDFDataTest(123456,"测试","测试","测试","测试"));
            detailList.add(new PDFDataTest(111111,"测试","测试","测试","测试"));
            detailList.add(new PDFDataTest(222222,"测试","测试","测试","测试"));
            data.put("detailList", detailList);

            baos = PDFTemplateUtil.createPDF(data, "pdf.ftl");;
            // 设置响应消息头，告诉浏览器当前响应是一个下载文件
            response.setContentType( "application/x-msdownload");
            // 告诉浏览器，当前响应数据要求用户干预保存到文件中，以及文件名是什么 如果文件名有中文，必须URL编码
            String fileName = URLEncoder.encode("月度报告.pdf", "UTF-8");
            response.setHeader( "Content-Disposition", "attachment;filename=" + fileName);
            out = response.getOutputStream();
            baos.writeTo(out);
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("导出失败：" + e.getMessage());
        } finally{
            if(baos != null){
                baos.close();
            }
            if(out != null){
                out.close();
            }
        }
    }



    @RequestMapping("/export1")
    public void exportPdf1(HttpServletResponse response) throws Exception{
        ByteArrayOutputStream baos = null;
        OutputStream out = null;
        try {
            // 模板中的数据，实际运用从数据库中查询
            Map<String,Object> data = new HashMap<>();
//            data.put("curr", 1);
//            data.put("one", 2);
//            data.put("two", 1);
//            data.put("three", 6);
//
//            List<PDFDataTest> detailList = new ArrayList<>();
//            detailList.add(new PDFDataTest(123456,"测试","测试","测试","测试"));
//            detailList.add(new PDFDataTest(111111,"测试","测试","测试","测试"));
//            detailList.add(new PDFDataTest(222222,"测试","测试","测试","测试"));
//            data.put("detailList", detailList);

            baos = PDFTemplateUtil.createPDF(data, "hello.ftl");;
            // 设置响应消息头，告诉浏览器当前响应是一个下载文件
            response.setContentType( "application/x-msdownload");
            // 告诉浏览器，当前响应数据要求用户干预保存到文件中，以及文件名是什么 如果文件名有中文，必须URL编码
            String fileName = URLEncoder.encode("export1.pdf", "UTF-8");
            response.setHeader( "Content-Disposition", "attachment;filename=" + fileName);
            out = response.getOutputStream();
            baos.writeTo(out);
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("导出失败：" + e.getMessage());
        } finally{
            if(baos != null){
                baos.close();
            }
            if(out != null){
                out.close();
            }
        }
    }
}

