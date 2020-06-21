package com.xsz.vote.controller;

import com.xsz.common.annotation.Log;
import com.xsz.common.controller.BaseController;
import com.xsz.common.domain.QueryRequest;
import com.xsz.system.domain.User;
import com.xsz.system.service.UserService;
import com.xsz.vote.domain.Vote;
import com.xsz.vote.domain.VoteTopic;
import com.xsz.vote.domain.VoteTopicOption;
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


    @Log("获取投票项目信息")
    @RequestMapping("list")
    @RequiresPermissions("voteVO:list")
    @ResponseBody
    public Map<String, Object> voteList(QueryRequest request, Vote vote) {

        vote.setStatus(new Byte("1"));
        List<VoteVO> voteVOList=new ArrayList<>();
        List<Vote> voteList=voteService.findAllVotes(vote, request);
        voteList.forEach(vote1 -> {
            VoteTopic voteTopic=new VoteTopic();
            voteTopic.setVoteid(vote1.getId());

            List<VoteTopic>  voteTopicList=VoteTopicService.findAllVoteTopics(voteTopic,request);
            voteTopicList.forEach(voteTopic1 -> {
                VoteTopicOption  voteTopicOption=new VoteTopicOption();
                voteTopicOption.setTopicid(voteTopic1.getId());
                List<VoteTopicOption>  voteTopicOptionList=voteTopicOptionsService.findAllVoteTopicOptions(voteTopicOption,request);
                voteTopicOptionList.forEach(voteTopicOption1 -> {
                    VoteVO  votevo1=new VoteVO();
                            votevo1.setKinds(voteTopic1.getKinds());
                            votevo1.setOption(voteTopicOption1.getOptions());
                            votevo1.setStatus(vote1.getStatus());
                            votevo1.setCreatetime(vote1.getCreatetime());
                            votevo1.setTopicName(voteTopic1.getTitle());
                            votevo1.setVoteName(vote1.getTitle());
                            voteVOList.add(votevo1);

                }



                );
            });

        });

        return super.selectByPageNumSize(request, () -> voteVOList);
    }
}
