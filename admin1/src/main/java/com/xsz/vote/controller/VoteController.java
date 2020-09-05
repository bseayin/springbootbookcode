package com.xsz.vote.controller;


import com.xsz.common.annotation.Log;
import com.xsz.common.controller.BaseController;
import com.xsz.common.domain.QueryRequest;
import com.xsz.common.domain.ResponseBo;
import com.xsz.common.domain.Tree;
import com.xsz.common.util.FileUtil;
import com.xsz.common.util.MD5Utils;
import com.xsz.system.domain.Menu;
import com.xsz.system.domain.User;
import com.xsz.system.service.UserService;
import com.xsz.vote.domain.Vote;
import com.xsz.vote.service.VoteService;
import org.apache.commons.lang3.StringUtils;
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

@Controller
@RequestMapping("vote")
public class VoteController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private VoteService voteService;

    private static final String ON = "on";

    @RequestMapping("")
    @RequiresPermissions("vote:list")
    public String index(Model model) {
        User user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "vote/vote";
    }



    @RequestMapping("getVote")
    @ResponseBody
    public ResponseBo getVote(Long id) {
        try {
            Vote vote = this.voteService.findById(id);
            return ResponseBo.ok(vote);
        } catch (Exception e) {
            log.error("获取投票项目失败", e);
            return ResponseBo.error("获取投票项目失败，请联系网站管理员！");
        }
    }

    @Log("获取投票项目信息")
    @RequestMapping("list")
    @RequiresPermissions("vote:list")
    @ResponseBody
    public Map<String, Object> voteList(QueryRequest request, Vote vote) {
        return super.selectByPageNumSize(request, () -> this.voteService.findAllVotes(vote, request));
    }

    @RequestMapping("excel")
    @ResponseBody
    public ResponseBo voteExcel(Vote vote) {
        try {
            List<Vote> list = this.voteService.findAllVotes(vote, null);
            return FileUtil.createExcelByPOIKit("投票项目表", list, Vote.class);
        } catch (Exception e) {
            log.error("导出投票项目信息Excel失败", e);
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("csv")
    @ResponseBody
    public ResponseBo voteCsv(Vote vote) {
        try {
            List<Vote> list = this.voteService.findAllVotes(vote, null);
            return FileUtil.createCsv("投票项目表", list, Vote.class);
        } catch (Exception e) {
            log.error("导出投票项目信息Csv失败", e);
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }

    



    @Log("新增投票项目")
    @RequiresPermissions("vote:add")
    @RequestMapping("add")
    @ResponseBody
    public ResponseBo addVote(Vote vote) {
        try {
            this.voteService.addVote(vote);
            return ResponseBo.ok("新增投票项目成功！");
        } catch (Exception e) {
            log.error("新增投票项目失败", e);
            return ResponseBo.error("新增投票项目失败，请联系网站管理员！");
        }
    }

    @Log("修改投票项目")
    @RequiresPermissions("vote:update")
    @RequestMapping("update")
    @ResponseBody
    public ResponseBo updateUser(Vote vote) {
        try {

            this.voteService.updateVote(vote);
            return ResponseBo.ok("修改投票项目成功！");
        } catch (Exception e) {
            log.error("修改投票项目失败", e);
            return ResponseBo.error("修改投票项目失败，请联系网站管理员！");
        }
    }

    @Log("删除投票项目")
    @RequiresPermissions("vote:delete")
    @RequestMapping("delete")
    @ResponseBody
    public ResponseBo deleteVotes(String ids) {
        try {
            this.voteService.deleteVotes(ids);
            return ResponseBo.ok("删除投票项目成功！");
        } catch (Exception e) {
            log.error("删除投票项目失败", e);
            return ResponseBo.error("删除投票项目失败，请联系网站管理员！");
        }
    }


    @RequestMapping("voteButtonTree")
    @ResponseBody
    public ResponseBo getVoteButtonTree() {
        try {
            Tree<Vote> tree = this.voteService.getVoteButtonTree();
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            log.error("获取投票项目表失败", e);
            return ResponseBo.error("获取投票项目列表失败！");
        }
    }

}
