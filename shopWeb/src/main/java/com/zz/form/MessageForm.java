package com.zz.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Bsea
 * 2019-06-1
 */
@Data
public class MessageForm {

    /**
     * 目标 openid
     */
    @NotEmpty(message = "open id必填")
    private String openid;

    /**
     * 会议标题
     */
    @NotEmpty(message = "会议标题必填")
    private String title;

    /**
     * 姓名
     */
    @NotEmpty(message = "姓名必填")
    private String username;

    /**
     * 时间
     */

    private String meetingdate;


}
