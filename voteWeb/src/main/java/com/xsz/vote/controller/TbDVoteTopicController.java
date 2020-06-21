package com.xsz.vote.controller;


import com.xsz.common.annotation.Log;
import com.xsz.common.controller.BaseController;
import com.xsz.common.domain.QueryRequest;
import com.xsz.common.domain.ResponseBo;
import com.xsz.common.domain.Tree;
import com.xsz.common.util.FileUtil;
import com.xsz.system.domain.User;
import com.xsz.system.service.UserService;
import com.xsz.vote.domain.Vote;
import com.xsz.vote.domain.VoteTopic;
import com.xsz.vote.service.TbDVoteTopicService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("voteTopic")
public class TbDVoteTopicController  extends BaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbDVoteTopicService VoteTopicService;

    @RequestMapping("")
    @RequiresPermissions("voteTopic:list")
    public String index(Model model) {
        User user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "voteTopic/voteTopic";
    }



    @RequestMapping("getVoteTopic")
    @ResponseBody
    public ResponseBo getVoteTopic(Long id) {
        try {
            VoteTopic VoteTopic = this.VoteTopicService.findById(id);
            return ResponseBo.ok(VoteTopic);
        } catch (Exception e) {
            log.error("获取投票项目失败", e);
            return ResponseBo.error("获取投票项目失败，请联系网站管理员！");
        }
    }

    @Log("获取投票项目信息")
    @RequestMapping("list")
    @RequiresPermissions("voteTopic:list")
    @ResponseBody
    public Map<String, Object> VoteTopicList(QueryRequest request, VoteTopic voteTopic) {
        return super.selectByPageNumSize(request, () -> this.VoteTopicService.findAllVoteTopics(voteTopic, request));
    }

    @RequestMapping("excel")
    @ResponseBody
    public ResponseBo VoteTopicExcel(VoteTopic VoteTopic) {
        try {
            List<VoteTopic> list = this.VoteTopicService.findAllVoteTopics(VoteTopic, null);
            return FileUtil.createExcelByPOIKit("投票项目表", list, VoteTopic.class);
        } catch (Exception e) {
            log.error("导出投票项目信息Excel失败", e);
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("csv")
    @ResponseBody
    public ResponseBo VoteTopicCsv(VoteTopic VoteTopic) {
        try {
            List<VoteTopic> list = this.VoteTopicService.findAllVoteTopics(VoteTopic, null);
            return FileUtil.createCsv("投票项目表", list, VoteTopic.class);
        } catch (Exception e) {
            log.error("导出投票项目信息Csv失败", e);
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }





    @Log("新增投票项目")
    @RequiresPermissions("voteTopic:add")
    @RequestMapping("add")
    @ResponseBody
    public ResponseBo addVoteTopic(VoteTopic VoteTopic) {
        try {

            this.VoteTopicService.addVoteTopic(VoteTopic);
            return ResponseBo.ok("新增投票项目成功！");
        } catch (Exception e) {
            log.error("新增投票项目失败", e);
            return ResponseBo.error("新增投票项目失败，请联系网站管理员！");
        }
    }

    @Log("修改投票项目")
    @RequiresPermissions("voteTopic:update")
    @RequestMapping("update")
    @ResponseBody
    public ResponseBo updateUser(VoteTopic voteTopic) {
        try {

            this.VoteTopicService.updateVoteTopic(voteTopic);
            return ResponseBo.ok("修改投票项目成功！");
        } catch (Exception e) {
            log.error("修改投票项目失败", e);
            return ResponseBo.error("修改投票项目失败，请联系网站管理员！");
        }
    }

    @Log("删除投票项目")
    @RequiresPermissions("voteTopic:delete")
    @RequestMapping("delete")
    @ResponseBody
    public ResponseBo deleteVoteTopics(String ids) {
        try {
            this.VoteTopicService.deleteVoteTopics(ids);
            return ResponseBo.ok("删除投票项目成功！");
        } catch (Exception e) {
            log.error("删除投票项目失败", e);
            return ResponseBo.error("删除投票项目失败，请联系网站管理员！");
        }
    }


    @RequestMapping("voteTopicButtonTree")
    @ResponseBody
    public ResponseBo getVoteButtonTree() {
        try {
            Tree<VoteTopic> tree = this.VoteTopicService.getVoteTopicButtonTree();
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            log.error("获取投票项目表失败", e);
            return ResponseBo.error("获取投票项目列表失败！");
        }
    }

}

