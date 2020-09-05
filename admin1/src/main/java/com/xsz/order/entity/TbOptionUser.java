package com.xsz.order.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Bsea
 * @since 2020-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbOptionUser对象", description="")
public class TbOptionUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer optionId;

    private Integer id;


}
