package com.xsz.vote.domain;

import com.xsz.common.annotation.ExportConfig;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_d_vote_topic")
public class VoteTopic  implements Serializable {

    private static final long serialVersionUID = 7780820231535870010L;


    @ExportConfig(value = "ID")
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 投票ID
     */
    @ExportConfig(value = "投票ID")
    @Column(name = "VOTEID")
    private Integer voteid;

    /**
     * 类型,来源于字典表,0:单选,1:多选
     */
    @ExportConfig(value = "类型")
    @Column(name = "KINDS")
    private Byte kinds;

    /**
     * 题目
     */
    @ExportConfig(value = "标题")
    @Column(name = "TITLE")
    private String title;

    /**
     * 每人最多可投票数,对于单选项,该项值为1
     */
    @Column(name = "MAXVOTE")
    private Integer maxvote;

    /**
     * 每人最少可投票数,对于单选项,该项值为1
     */
    @Column(name = "MIXVOTE")
    private Integer mixvote;

    /**
     * 是否允许用户自定义答案,0:是,1:否
     */
    @Column(name = "ALLOWUSERDEFINE")
    private Byte allowuserdefine;

    /**
     * 排序,正序
     */
    @Column(name = "SORTCODE")
    private Integer sortcode;

    @Column(name = "REMARKS")
    private String remarks;

    /**
     * 删除标记，0：存在，1：删除
     */
    @Column(name = "DELMARK")
    private Byte delmark;

    @Column(name = "CREATETIME")
    private Date createtime;

    @Column(name = "MODIFYTIME")
    private Date modifytime;

    @Column(name = "CREATEUSERID")
    private Integer createuserid;

    @Column(name = "MODIFYUSERID")
    private Integer modifyuserid;

    /**
     * 选项个数
     */
    @ExportConfig(value = "选项个数")
    @Column(name = "OPTIONCOUNT")
    private Integer optioncount;

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
     * 获取投票ID
     *
     * @return VOTEID - 投票ID
     */
    public Integer getVoteid() {
        return voteid;
    }

    /**
     * 设置投票ID
     *
     * @param voteid 投票ID
     */
    public void setVoteid(Integer voteid) {
        this.voteid = voteid;
    }

    /**
     * 获取类型,来源于字典表,0:单选,1:多选
     *
     * @return KINDS - 类型,来源于字典表,0:单元,1:多选
     */
    public Byte getKinds() {
        return kinds;
    }

    /**
     * 设置类型,来源于字典表,0:单元,1:多选
     *
     * @param kinds 类型,来源于字典表,0:单元,1:多选
     */
    public void setKinds(Byte kinds) {
        this.kinds = kinds;
    }

    /**
     * 获取题目
     *
     * @return TITLE - 题目
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置题目
     *
     * @param title 题目
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取每人最多可投票数,对于单选项,该项值为1
     *
     * @return MAXVOTE - 每人最多可投票数,对于单选项,该项值为1
     */
    public Integer getMaxvote() {
        return maxvote;
    }

    /**
     * 设置每人最多可投票数,对于单选项,该项值为1
     *
     * @param maxvote 每人最多可投票数,对于单选项,该项值为1
     */
    public void setMaxvote(Integer maxvote) {
        this.maxvote = maxvote;
    }

    /**
     * 获取每人最少可投票数,对于单选项,该项值为1
     *
     * @return MIXVOTE - 每人最少可投票数,对于单选项,该项值为1
     */
    public Integer getMixvote() {
        return mixvote;
    }

    /**
     * 设置每人最少可投票数,对于单选项,该项值为1
     *
     * @param mixvote 每人最少可投票数,对于单选项,该项值为1
     */
    public void setMixvote(Integer mixvote) {
        this.mixvote = mixvote;
    }

    /**
     * 获取是否允许用户自定义答案,0:是,1:否
     *
     * @return ALLOWUSERDEFINE - 是否允许用户自定义答案,0:是,1:否
     */
    public Byte getAllowuserdefine() {
        return allowuserdefine;
    }

    /**
     * 设置是否允许用户自定义答案,0:是,1:否
     *
     * @param allowuserdefine 是否允许用户自定义答案,0:是,1:否
     */
    public void setAllowuserdefine(Byte allowuserdefine) {
        this.allowuserdefine = allowuserdefine;
    }

    /**
     * 获取排序,正序
     *
     * @return SORTCODE - 排序,正序
     */
    public Integer getSortcode() {
        return sortcode;
    }

    /**
     * 设置排序,正序
     *
     * @param sortcode 排序,正序
     */
    public void setSortcode(Integer sortcode) {
        this.sortcode = sortcode;
    }

    /**
     * @return REMARKS
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
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
     * 获取选项个数
     *
     * @return OPTIONCOUNT - 选项个数
     */
    public Integer getOptioncount() {
        return optioncount;
    }

    /**
     * 设置选项个数
     *
     * @param optioncount 选项个数
     */
    public void setOptioncount(Integer optioncount) {
        this.optioncount = optioncount;
    }
}