package com.xsz.vote.domain;

import com.xsz.common.annotation.ExportConfig;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_d_vote_topic_options")
public class VoteTopicOption  implements Serializable {

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
     * 投票题目ID
     */
    @ExportConfig(value = "主题ID")
    @Column(name = "TOPICID")
    private Integer topicid;

    /**
     * 选项类型,冗余字段
     */
    @ExportConfig(value = "选项类型")
    @Column(name = "KINDS")
    private Integer kinds;

    /**
     * 选项
     */
    @Column(name = "OPTIONS")
    private String options;

    /**
     * 选项图示
     */
    @Column(name = "OPTIONSIMG")
    private String optionsimg;

    /**
     * 排序,正序
     */
    @Column(name = "SORTCODE")
    private Integer sortcode;

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
     * 备注
     */
    @ExportConfig(value = "备注")
    @Column(name = "REMARKS")
    private String remarks;

    /**
     * 选项的页面HTML代码[保留]
     */
    @Column(name = "OPTIONHTML")
    private String optionhtml;

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
     * 获取投票题目ID
     *
     * @return TOPICID - 投票题目ID
     */
    public Integer getTopicid() {
        return topicid;
    }

    /**
     * 设置投票题目ID
     *
     * @param topicid 投票题目ID
     */
    public void setTopicid(Integer topicid) {
        this.topicid = topicid;
    }

    /**
     * 获取选项类型,冗余字段
     *
     * @return KINDS - 选项类型,冗余字段
     */
    public Integer getKinds() {
        return kinds;
    }

    /**
     * 设置选项类型,冗余字段
     *
     * @param kinds 选项类型,冗余字段
     */
    public void setKinds(Integer kinds) {
        this.kinds = kinds;
    }

    /**
     * 获取选项
     *
     * @return OPTIONS - 选项
     */
    public String getOptions() {
        return options;
    }

    /**
     * 设置选项
     *
     * @param options 选项
     */
    public void setOptions(String options) {
        this.options = options == null ? null : options.trim();
    }

    /**
     * 获取选项图示
     *
     * @return OPTIONSIMG - 选项图示
     */
    public String getOptionsimg() {
        return optionsimg;
    }

    /**
     * 设置选项图示
     *
     * @param optionsimg 选项图示
     */
    public void setOptionsimg(String optionsimg) {
        this.optionsimg = optionsimg == null ? null : optionsimg.trim();
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
     * 获取选项的页面HTML代码[保留]
     *
     * @return OPTIONHTML - 选项的页面HTML代码[保留]
     */
    public String getOptionhtml() {
        return optionhtml;
    }

    /**
     * 设置选项的页面HTML代码[保留]
     *
     * @param optionhtml 选项的页面HTML代码[保留]
     */
    public void setOptionhtml(String optionhtml) {
        this.optionhtml = optionhtml == null ? null : optionhtml.trim();
    }
}