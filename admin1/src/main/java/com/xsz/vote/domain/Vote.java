package com.xsz.vote.domain;

import com.xsz.common.annotation.ExportConfig;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_d_vote")
public class Vote implements Serializable {

    private static final long serialVersionUID = 7780820231535870010L;

    @Id
    @Column(name = "ID")
    @ExportConfig(value = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 标题
     */
    @ExportConfig(value = "标题")
    @Column(name = "TITLE")
    private String title;
    /**
     * 用户投票次数统计
     */
    @ExportConfig(value = "投票总数")
    @Column(name = "VOTECOUNT")
    private Integer votecount;
    /**
     * 截止日期
     */
    @Column(name = "DEADLINETIME")
    private Date deadlinetime;

    /**
     * 是否ALL，0：否，1：@ALL
     */
    @Column(name = "ISALL")
    private Byte isall;

    /**
     * 首语
     */
    @Column(name = "HEADCONTENT")
    private String headcontent;

    /**
     * 尾语
     */
    @Column(name = "FOOTERCONTENT")
    private String footercontent;

    /**
     * 是否允许成员查看投票结果,0:否,1:是
     */
    @Column(name = "ALLOWSHOWRESULT")
    private Byte allowshowresult;

    /**
     * 是否允许成员匿名投票
     */
    @Column(name = "ALLOWANONYMAT")
    private Byte allowanonymat;

    /**
     * 创建投票的成员系统ID
     */
    @Column(name = "FROMUSERID")
    private Integer fromuserid;



    /**
     * 备注
     */
    @ExportConfig(value = "备注")
    @Column(name = "REMARKS")
    private String remarks;

    /**
     * 删除标记，0：存在，1：删除
     */
    @Column(name = "DELMARK")
    private Byte delmark;

    @ExportConfig(value = "修改时间")
    @Column(name = "CREATETIME")
    private Date createtime;

    @Column(name = "MODIFYTIME")
    private Date modifytime;

    @Column(name = "CREATEUSERID")
    private Integer createuserid;

    /**
     * 状态,0:草稿,1:已发布,2:已结束,
     */
    @ExportConfig(value = "状态")
    @Column(name = "STATUS")
    private Byte status;

    @Column(name = "MODIFYUSERID")
    private Integer modifyuserid;

    /**
     * 用户ID列表
     */
    @Column(name = "TO_USER")
    private String toUser;

    /**
     * 部门ID列表
     */
    @Column(name = "TO_PARTY")
    private String toParty;

    /**
     * 标签ID列表
     */
    @Column(name = "TO_TAG")
    private String toTag;

    /**
     * 图文消息对应的图片URL
     */
    @Column(name = "PIC_URL")
    private String picUrl;

    /**
     * 投票静态URL
     */
    @Column(name = "VOTEURL")
    private String voteurl;



    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取标题
     *
     * @return TITLE - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取截止日期
     *
     * @return DEADLINETIME - 截止日期
     */
    public Date getDeadlinetime() {
        return deadlinetime;
    }

    /**
     * 设置截止日期
     *
     * @param deadlinetime 截止日期
     */
    public void setDeadlinetime(Date deadlinetime) {
        this.deadlinetime = deadlinetime;
    }

    /**
     * 获取是否ALL，0：否，1：@ALL
     *
     * @return ISALL - 是否ALL，0：否，1：@ALL
     */
    public Byte getIsall() {
        return isall;
    }

    /**
     * 设置是否ALL，0：否，1：@ALL
     *
     * @param isall 是否ALL，0：否，1：@ALL
     */
    public void setIsall(Byte isall) {
        this.isall = isall;
    }

    /**
     * 获取首语
     *
     * @return HEADCONTENT - 首语
     */
    public String getHeadcontent() {
        return headcontent;
    }

    /**
     * 设置首语
     *
     * @param headcontent 首语
     */
    public void setHeadcontent(String headcontent) {
        this.headcontent = headcontent == null ? null : headcontent.trim();
    }

    /**
     * 获取尾语
     *
     * @return FOOTERCONTENT - 尾语
     */
    public String getFootercontent() {
        return footercontent;
    }

    /**
     * 设置尾语
     *
     * @param footercontent 尾语
     */
    public void setFootercontent(String footercontent) {
        this.footercontent = footercontent == null ? null : footercontent.trim();
    }

    /**
     * 获取是否允许成员查看投票结果,0:否,1:是
     *
     * @return ALLOWSHOWRESULT - 是否允许成员查看投票结果,0:否,1:是
     */
    public Byte getAllowshowresult() {
        return allowshowresult;
    }

    /**
     * 设置是否允许成员查看投票结果,0:否,1:是
     *
     * @param allowshowresult 是否允许成员查看投票结果,0:否,1:是
     */
    public void setAllowshowresult(Byte allowshowresult) {
        this.allowshowresult = allowshowresult;
    }

    /**
     * 获取是否允许成员匿名投票
     *
     * @return ALLOWANONYMAT - 是否允许成员匿名投票
     */
    public Byte getAllowanonymat() {
        return allowanonymat;
    }

    /**
     * 设置是否允许成员匿名投票
     *
     * @param allowanonymat 是否允许成员匿名投票
     */
    public void setAllowanonymat(Byte allowanonymat) {
        this.allowanonymat = allowanonymat;
    }

    /**
     * 获取创建投票的成员系统ID
     *
     * @return FROMUSERID - 创建投票的成员系统ID
     */
    public Integer getFromuserid() {
        return fromuserid;
    }

    /**
     * 设置创建投票的成员系统ID
     *
     * @param fromuserid 创建投票的成员系统ID
     */
    public void setFromuserid(Integer fromuserid) {
        this.fromuserid = fromuserid;
    }

    /**
     * 获取状态,0:草稿,1:已发布,2:收集中,3:已结束,
     *
     * @return STATUS - 状态,0:草稿,1:已发布,2:收集中,3:已结束,
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态,0:草稿,1:已发布,2:收集中,3:已结束,
     *
     * @param status 状态,0:草稿,1:已发布,2:收集中,3:已结束,
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取备注
     *
     * @return REMARKS - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标记，0：存在，1：删除
     *
     * @return DELMARK - 删除标记，0：存在，1：删除
     */
    public Byte getDelmark() {
        return delmark;
    }

    /**
     * 设置删除标记，0：存在，1：删除
     *
     * @param delmark 删除标记，0：存在，1：删除
     */
    public void setDelmark(Byte delmark) {
        this.delmark = delmark;
    }

    /**
     * @return CREATETIME
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return MODIFYTIME
     */
    public Date getModifytime() {
        return modifytime;
    }

    /**
     * @param modifytime
     */
    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    /**
     * @return CREATEUSERID
     */
    public Integer getCreateuserid() {
        return createuserid;
    }

    /**
     * @param createuserid
     */
    public void setCreateuserid(Integer createuserid) {
        this.createuserid = createuserid;
    }

    /**
     * @return MODIFYUSERID
     */
    public Integer getModifyuserid() {
        return modifyuserid;
    }

    /**
     * @param modifyuserid
     */
    public void setModifyuserid(Integer modifyuserid) {
        this.modifyuserid = modifyuserid;
    }

    /**
     * 获取用户ID列表
     *
     * @return TO_USER - 用户ID列表
     */
    public String getToUser() {
        return toUser;
    }

    /**
     * 设置用户ID列表
     *
     * @param toUser 用户ID列表
     */
    public void setToUser(String toUser) {
        this.toUser = toUser == null ? null : toUser.trim();
    }

    /**
     * 获取部门ID列表
     *
     * @return TO_PARTY - 部门ID列表
     */
    public String getToParty() {
        return toParty;
    }

    /**
     * 设置部门ID列表
     *
     * @param toParty 部门ID列表
     */
    public void setToParty(String toParty) {
        this.toParty = toParty == null ? null : toParty.trim();
    }

    /**
     * 获取标签ID列表
     *
     * @return TO_TAG - 标签ID列表
     */
    public String getToTag() {
        return toTag;
    }

    /**
     * 设置标签ID列表
     *
     * @param toTag 标签ID列表
     */
    public void setToTag(String toTag) {
        this.toTag = toTag == null ? null : toTag.trim();
    }

    /**
     * 获取图文消息对应的图片URL
     *
     * @return PIC_URL - 图文消息对应的图片URL
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 设置图文消息对应的图片URL
     *
     * @param picUrl 图文消息对应的图片URL
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    /**
     * 获取投票静态URL
     *
     * @return VOTEURL - 投票静态URL
     */
    public String getVoteurl() {
        return voteurl;
    }

    /**
     * 设置投票静态URL
     *
     * @param voteurl 投票静态URL
     */
    public void setVoteurl(String voteurl) {
        this.voteurl = voteurl == null ? null : voteurl.trim();
    }

    /**
     * 获取用户投票次数统计
     *
     * @return VOTECOUNT - 用户投票次数统计
     */
    public Integer getVotecount() {
        return votecount;
    }

    /**
     * 设置用户投票次数统计
     *
     * @param votecount 用户投票次数统计
     */
    public void setVotecount(Integer votecount) {
        this.votecount = votecount;
    }
}