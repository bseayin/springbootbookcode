package com.zz.product.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="IimChatHistory对象", description="")
public class IimChatHistory implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private String sender;

    private String receiver;

    private String msg;

    private String status;

    private LocalDateTime createDate;

    private String type;


}
