package com.xsz.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**企业查看到申请人的编号和所申请的职位**/
@Data
public class ResumePostionDto {

    /**职位名称**/
    private String positionName;

    /**申请人姓名**/
    private String applicantName;

    /**简历地址**/
    private String wordPath;

}
