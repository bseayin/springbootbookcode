package com.xsz.vote.domain;

import com.xsz.common.annotation.ExportConfig;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_d_vote_result")
public class VoteResult  implements Serializable {

    private static final long serialVersionUID = 7780820231535870010L;

    @Id
    @Column(name = "ID")
    @ExportConfig(value = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 投票ID
     */
    @ExportConfig(value = "投票ID")
    @Column(name = "VOTEID")
    private Integer voteid;

    /**
     * 话题ID
     */
    @ExportConfig(value = "主题ID")
    @Column(name = "TOPICID")
    private Integer topicid;

    /**
     * 项ID
     */
    @ExportConfig(value = "选项ID")
    @Column(name = "OPTIONID")
    private Integer optionid;

    /**
     * 用户自定义项ID
     */
    @Column(name = "OPTIONEXTID")
    private Integer optionextid;

    /**
     * 是否匿名投票,0:否,1:是
     */
    @Column(name = "ALLOWANONYMITY")
    private Byte allowanonymity;

    /**
     * 投票人ID
     */
    @Column(name = "VOTEUSERID")
    private Integer voteuserid;
    @ExportConfig(value = "备注")
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
     * 获取话题ID
     *
     * @return TOPICID - 话题ID
     */
    public Integer getTopicid() {
        return topicid;
    }

    /**
     * 设置话题ID
     *
     * @param topicid 话题ID
     */
    public void setTopicid(Integer topicid) {
        this.topicid = topicid;
    }

    /**
     * 获取项ID
     *
     * @return OPTIONID - 项ID
     */
    public Integer getOptionid() {
        return optionid;
    }

    /**
     * 设置项ID
     *
     * @param optionid 项ID
     */
    public void setOptionid(Integer optionid) {
        this.optionid = optionid;
    }

    /**
     * 获取用户自定义项ID
     *
     * @return OPTIONEXTID - 用户自定义项ID
     */
    public Integer getOptionextid() {
        return optionextid;
    }

    /**
     * 设置用户自定义项ID
     *
     * @param optionextid 用户自定义项ID
     */
    public void setOptionextid(Integer optionextid) {
        this.optionextid = optionextid;
    }

    /**
     * 获取是否匿名投票,0:否,1:是
     *
     * @return ALLOWANONYMITY - 是否匿名投票,0:否,1:是
     */
    public Byte getAllowanonymity() {
        return allowanonymity;
    }

    /**
     * 设置是否匿名投票,0:否,1:是
     *
     * @param allowanonymity 是否匿名投票,0:否,1:是
     */
    public void setAllowanonymity(Byte allowanonymity) {
        this.allowanonymity = allowanonymity;
    }

    /**
     * 获取投票人ID
     *
     * @return VOTEUSERID - 投票人ID
     */
    public Integer getVoteuserid() {
        return voteuserid;
    }

    /**
     * 设置投票人ID
     *
     * @param voteuserid 投票人ID
     */
    public void setVoteuserid(Integer voteuserid) {
        this.voteuserid = voteuserid;
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
}