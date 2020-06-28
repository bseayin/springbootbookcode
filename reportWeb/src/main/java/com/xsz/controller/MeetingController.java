package com.xsz.controller;

import com.xsz.entity.Meeting;
import com.xsz.entity.Template;
import com.xsz.enums.TypeEnum;
import com.xsz.service.MeetingService;
import com.xsz.service.PDFService;
import com.xsz.service.TemplateService;
import com.xsz.service.WordService;
import com.xsz.util.ResultVOUtil;
import com.xsz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 会议控制类
 */
@RestController
@RequestMapping("meeting")
@Api(value = "会议接口")
public class MeetingController {
    @Resource
    MeetingService meetingService;

    @Resource
    TemplateService templateService;

    @Resource
    PDFService pdfService;
    @Resource
    WordService wordService;



    @ApiOperation(value = "返回所有会议")
    @GetMapping("listAll")
    public ResultVO list(){
        return  ResultVOUtil.success(meetingService.getAll());
    }

    @ApiOperation(value = "创建会议")
    @PostMapping("add")
    public ResultVO add(@RequestBody Meeting meeting){

        return  ResultVOUtil.success(meetingService.add(meeting));
    }

    @ApiOperation(value = "绑定模板")
    @PostMapping("addTemplate/{meettingId}/{templateId}")
    public ResultVO addTemplate(@PathVariable("meettingId") String meettingId,@PathVariable("templateId") String templateId){
        System.out.println(meettingId);
        System.out.println(templateId);
        return  ResultVOUtil.success(meetingService.updateTemplate(templateId,meettingId));
    }


    @ApiOperation(value = "下载报告")
    @GetMapping("getReport/{meettingId}")
    public void addTemplate(@PathVariable("meettingId") String meettingId, HttpServletResponse response) throws Exception {
        Meeting meeting=meetingService.selectById(meettingId);
        Template template=templateService.selectById(meeting.getTemplateId());
        if(template.getType()== TypeEnum.WORD.getValue()){
            wordService.createTemplate1(meeting.getTile());
        }else if(template.getType()==TypeEnum.PDF.getValue()){
            pdfService.exportPdf(response,meeting.getTile());
        }

    }

}
