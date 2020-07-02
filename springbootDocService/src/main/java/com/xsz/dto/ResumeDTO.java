package com.xsz.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ResumeDTO {

    private String id;

    /**姓名**/

    private String name;

    /**用户手机号码**/

    private String mobile;

    /**用户性别**/

    private String sex;

    /**自我评价**/
    private String assessment;

    /**证书**/
    private String certificate;

    /**工作经历**/
    private String workedyears;

    /**项目经历**/
    private String projectExp;

    /**培训经历**/
    private String trainExp;

    /**学历**/

    private String education;

    /**创建简历的求职用户Id**/
    private String createBy;

    /**专业**/

    private String major;

    /**照片地址**/
    private String image;

    /**word简历地址**/
    private String wordPath;

    /**简历名**/
    private String resumeName;

    /**年龄**/
    private String age;
}
