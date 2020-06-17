package com.xsz.vote.controller;


import com.xsz.common.annotation.Log;
import com.xsz.common.controller.BaseController;
import com.xsz.common.domain.QueryRequest;
import com.xsz.common.domain.ResponseBo;
import com.xsz.common.util.FileUtil;
import com.xsz.common.util.MD5Utils;
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

    @RequestMapping("user/checkUserName")
    @ResponseBody
    public boolean checkUserName(String username, String oldusername) {
        if (StringUtils.isNotBlank(oldusername) && username.equalsIgnoreCase(oldusername)) {
            return true;
        }
        User result = this.userService.findByName(username);
        return result == null;
    }

    @RequestMapping("user/getUser")
    @ResponseBody
    public ResponseBo getUser(Long userId) {
        try {
            User user = this.userService.findById(userId);
            return ResponseBo.ok(user);
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

    @RequestMapping("user/excel")
    @ResponseBody
    public ResponseBo userExcel(User user) {
        try {
            List<User> list = this.userService.findUserWithDept(user, null);
            return FileUtil.createExcelByPOIKit("投票项目表", list, User.class);
        } catch (Exception e) {
            log.error("导出投票项目信息Excel失败", e);
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("user/csv")
    @ResponseBody
    public ResponseBo userCsv(User user) {
        try {
            List<User> list = this.userService.findUserWithDept(user, null);
            return FileUtil.createCsv("投票项目表", list, User.class);
        } catch (Exception e) {
            log.error("导出投票项目信息Csv失败", e);
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }

    @RequestMapping("user/regist")
    @ResponseBody
    public ResponseBo regist(User user) {
        try {
            User result = this.userService.findByName(user.getUsername());
            if (result != null) {
                return ResponseBo.warn("该投票项目名已被使用！");
            }
            this.userService.registUser(user);
            return ResponseBo.ok();
        } catch (Exception e) {
            log.error("注册失败", e);
            return ResponseBo.error("注册失败，请联系网站管理员！");
        }
    }

    @Log("更换主题")
    @RequestMapping("user/theme")
    @ResponseBody
    public ResponseBo updateTheme(User user) {
        try {
            this.userService.updateTheme(user.getTheme(), user.getUsername());
            return ResponseBo.ok();
        } catch (Exception e) {
            log.error("修改主题失败", e);
            return ResponseBo.error();
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
    @RequiresPermissions("user:update")
    @RequestMapping("user/update")
    @ResponseBody
    public ResponseBo updateUser(User user, Long[] rolesSelect) {
        try {
            if (ON.equalsIgnoreCase(user.getStatus()))
                user.setStatus(User.STATUS_VALID);
            else
                user.setStatus(User.STATUS_LOCK);
            this.userService.updateUser(user, rolesSelect);
            return ResponseBo.ok("修改投票项目成功！");
        } catch (Exception e) {
            log.error("修改投票项目失败", e);
            return ResponseBo.error("修改投票项目失败，请联系网站管理员！");
        }
    }

    @Log("删除投票项目")
    @RequiresPermissions("user:delete")
    @RequestMapping("user/delete")
    @ResponseBody
    public ResponseBo deleteUsers(String ids) {
        try {
            this.userService.deleteUsers(ids);
            return ResponseBo.ok("删除投票项目成功！");
        } catch (Exception e) {
            log.error("删除投票项目失败", e);
            return ResponseBo.error("删除投票项目失败，请联系网站管理员！");
        }
    }

    @RequestMapping("user/checkPassword")
    @ResponseBody
    public boolean checkPassword(String password) {
        User user = getCurrentUser();
        String encrypt = MD5Utils.encrypt(user.getUsername().toLowerCase(), password);
        return user.getPassword().equals(encrypt);
    }

    @RequestMapping("user/updatePassword")
    @ResponseBody
    public ResponseBo updatePassword(String newPassword) {
        try {
            this.userService.updatePassword(newPassword);
            return ResponseBo.ok("更改密码成功！");
        } catch (Exception e) {
            log.error("修改密码失败", e);
            return ResponseBo.error("更改密码失败，请联系网站管理员！");
        }
    }

    @RequestMapping("user/profile")
    public String profileIndex(Model model) {
        User user = super.getCurrentUser();
        user = this.userService.findUserProfile(user);
        String ssex = user.getSsex();
        if (User.SEX_MALE.equals(ssex)) {
            user.setSsex("性别：男");
        } else if (User.SEX_FEMALE.equals(ssex)) {
            user.setSsex("性别：女");
        } else {
            user.setSsex("性别：保密");
        }
        model.addAttribute("user", user);
        return "system/user/profile";
    }

    @RequestMapping("user/getUserProfile")
    @ResponseBody
    public ResponseBo getUserProfile(Long userId) {
        try {
            User user = new User();
            user.setUserId(userId);
            return ResponseBo.ok(this.userService.findUserProfile(user));
        } catch (Exception e) {
            log.error("获取投票项目信息失败", e);
            return ResponseBo.error("获取投票项目信息失败，请联系网站管理员！");
        }
    }

    @RequestMapping("user/updateUserProfile")
    @ResponseBody
    public ResponseBo updateUserProfile(User user) {
        try {
            this.userService.updateUserProfile(user);
            return ResponseBo.ok("更新个人信息成功！");
        } catch (Exception e) {
            log.error("更新投票项目信息失败", e);
            return ResponseBo.error("更新投票项目信息失败，请联系网站管理员！");
        }
    }

    @RequestMapping("user/changeAvatar")
    @ResponseBody
    public ResponseBo changeAvatar(String imgName) {
        try {
            String[] img = imgName.split("/");
            String realImgName = img[img.length - 1];
            User user = getCurrentUser();
            user.setAvatar(realImgName);
            this.userService.updateNotNull(user);
            return ResponseBo.ok("更新头像成功！");
        } catch (Exception e) {
            log.error("更换头像失败", e);
            return ResponseBo.error("更新头像失败，请联系网站管理员！");
        }
    }
}
