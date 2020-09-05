package com.xsz.vote.controller;

import com.xsz.common.annotation.Log;
import com.xsz.common.controller.BaseController;
import com.xsz.common.domain.QueryRequest;
import com.xsz.common.domain.ResponseBo;
import com.xsz.system.domain.User;
import com.xsz.system.service.UserService;
import com.xsz.vote.domain.Vote;
import com.xsz.vote.domain.VoteTopic;
import com.xsz.vote.domain.VoteTopicOption;
import com.xsz.vote.service.TbDVoteResultService;
import com.xsz.vote.service.TbDVoteTopicOptionsService;
import com.xsz.vote.service.TbDVoteTopicService;
import com.xsz.vote.service.VoteService;
import com.xsz.vote.vo.VoteVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("voteVO")
public class VoteVOController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private VoteService voteService;

    @Autowired
    private TbDVoteResultService voteResultService;
    
    @Autowired
    private TbDVoteTopicOptionsService voteTopicOptionsService;

    @Autowired
    private TbDVoteTopicService VoteTopicService;

    @RequestMapping("")
    @RequiresPermissions("voteVO:list")
    public String voteIndex(Model model) {
        User user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "voteVO/voteVO";
    }


    @RequestMapping("result")
    @RequiresPermissions("voteVO:list")
    public String voteResultIndex(Model model) {
        User user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "voteVO/voteResultVO";
    }


    @Log("获取投票项目信息")
    @RequestMapping("list")
    @RequiresPermissions("voteVO:list")
    @ResponseBody
    public Map<String, Object> voteList(QueryRequest request, Vote vote) {





        return super.selectByPageNumSize(request, () -> voteService.findVoteVOs(1));
    }

    @Log("获取投票项目信息")
    @RequestMapping("listResult")
    @RequiresPermissions("voteVO:list")
    @ResponseBody
    public Map<String, Object> voteResultList(QueryRequest request, Vote vote) {
        return super.selectByPageNumSize(request, () -> voteService.findResultVoteVOs());
    }

    @Log("提交投票项目")
    @RequestMapping("submitvote")
    @ResponseBody
    public ResponseBo submitvote(String ids) {
        try {
            User user = super.getCurrentUser();
            this.voteResultService.submitVoteResults(ids,user.getUserId().intValue());
            return ResponseBo.ok("提交投票项目成功！");
        } catch (Exception e) {
            log.error("提交投票项目失败", e);
            return ResponseBo.error("提交投票项目失败，请联系网站管理员！");
        }
    }
    
    
}
