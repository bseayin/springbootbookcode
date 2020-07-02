package com.zz.product.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 发件箱 草稿箱
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="IimMailCompose对象", description="发件箱 草稿箱")
public class IimMailCompose implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    @ApiModelProperty(value = "状态 0 草稿 1 已发送")
    private String status;

    @ApiModelProperty(value = "状态 0 未读 1 已读")
    private String readstatus;

    @ApiModelProperty(value = "发送者")
    @TableField("senderId")
    private String senderId;

    @ApiModelProperty(value = "接收者")
    @TableField("receiverId")
    private String receiverId;

    @ApiModelProperty(value = "发送时间")
    private LocalDateTime sendtime;

    @ApiModelProperty(value = "邮件id")
    @TableField("mailId")
    private String mailId;


}
