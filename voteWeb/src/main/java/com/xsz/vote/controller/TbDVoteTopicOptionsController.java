package com.xsz.vote.controller;


import com.xsz.common.annotation.Log;
import com.xsz.common.controller.BaseController;
import com.xsz.common.domain.QueryRequest;
import com.xsz.common.domain.ResponseBo;
import com.xsz.common.util.FileUtil;
import com.xsz.system.domain.User;
import com.xsz.vote.domain.VoteTopic;
import com.xsz.vote.domain.VoteTopicOption;

import com.xsz.vote.service.TbDVoteTopicOptionsService;
import com.xsz.vote.service.TbDVoteTopicService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bsea
 * @since 2020-06-17
 */
@Controller
@RequestMapping("voteTopicOption")
public class TbDVoteTopicOptionsController extends BaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbDVoteTopicOptionsService voteTopicOptionsService;

    @Autowired
    private TbDVoteTopicService VoteTopicService;

    @RequestMapping("")
    @RequiresPermissions("voteTopicOption:list")
    public String index(Model model) {
        User user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "voteTopicOption/voteTopicOption";
    }






    @RequestMapping("getVoteTopicOption")
    @ResponseBody
    public ResponseBo getVoteTopicOption(Long id) {
        try {
            VoteTopicOption VoteTopicOption = this.voteTopicOptionsService.findById(id);
            return ResponseBo.ok(VoteTopicOption);
        } catch (Exception e) {
            log.error("获取投票选项失败", e);
            return ResponseBo.error("获取投票选项失败，请联系网站管理员！");
        }
    }

    @Log("获取投票选项信息")
    @RequestMapping("list")
    @RequiresPermissions("voteTopicOption:list")
    @ResponseBody
    public Map<String, Object> VoteTopicOptionList(QueryRequest request, VoteTopicOption VoteTopicOption) {
        return super.selectByPageNumSize(request, () -> this.voteTopicOptionsService.findAllVoteTopicOptions(VoteTopicOption, request));
    }



    @RequestMapping("excel")
    @ResponseBody
    public ResponseBo VoteTopicOptionExcel(VoteTopicOption VoteTopicOption) {
        try {
            List<VoteTopicOption> list = this.voteTopicOptionsService.findAllVoteTopicOptions(VoteTopicOption, null);
            return FileUtil.createExcelByPOIKit("投票选项表", list, VoteTopicOption.class);
        } catch (Exception e) {
            log.error("导出投票选项信息Excel失败", e);
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("csv")
    @ResponseBody
    public ResponseBo VoteTopicOptionCsv(VoteTopicOption VoteTopicOption) {
        try {
            List<VoteTopicOption> list = this.voteTopicOptionsService.findAllVoteTopicOptions(VoteTopicOption, null);
            return FileUtil.createCsv("投票选项表", list, VoteTopicOption.class);
        } catch (Exception e) {
            log.error("导出投票选项信息Csv失败", e);
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }





    @Log("新增投票选项")
    @RequiresPermissions("voteTopicOption:add")
    @RequestMapping("add")
    @ResponseBody
    public ResponseBo addVoteTopicOption(VoteTopicOption voteTopicOption) {
        try {
            voteTopicOption.setCreatetime(new Date());
            VoteTopic voteTopic=VoteTopicService.findById((voteTopicOption.getTopicid().longValue()));
            voteTopicOption.setVoteid(voteTopic.getVoteid());
            //更新主题的选项数量
            int optcount=voteTopic.getOptioncount()==null?0:voteTopic.getOptioncount();
            if(voteTopic.getKinds()==0&&optcount==1){
                log.error("新增投票选项失败");
                return ResponseBo.error("新增投票选项失败，单选主题，选项不能超过1个！");
            }else{
                optcount++;
                voteTopic.setOptioncount(optcount);
                VoteTopicService.updateVoteTopic(voteTopic);
                this.voteTopicOptionsService.addVoteTopicOption(voteTopicOption);
                return ResponseBo.ok("新增投票选项成功！");
            }
           
        } catch (Exception e) {
            log.error("新增投票选项失败", e);
            return ResponseBo.error("新增投票选项失败，请联系网站管理员！");
        }
    }

    @Log("修改投票选项")
    @RequiresPermissions("voteTopicOption:update")
    @RequestMapping("update")
    @ResponseBody
    public ResponseBo updateUser(VoteTopicOption VoteTopicOption) {
        try {

            this.voteTopicOptionsService.updateVoteTopicOption(VoteTopicOption);
            return ResponseBo.ok("修改投票选项成功！");
        } catch (Exception e) {
            log.error("修改投票选项失败", e);
            return ResponseBo.error("修改投票选项失败，请联系网站管理员！");
        }
    }

    @Log("删除投票选项")
    @RequiresPermissions("voteTopicOption:delete")
    @RequestMapping("delete")
    @ResponseBody
    public ResponseBo deleteVoteTopicOptions(String ids) {
        try {
            this.voteTopicOptionsService.deleteVoteTopicOptions(ids);
            return ResponseBo.ok("删除投票选项成功！");
        } catch (Exception e) {
            log.error("删除投票选项失败", e);
            return ResponseBo.error("删除投票选项失败，请联系网站管理员！");
        }
    }

}

