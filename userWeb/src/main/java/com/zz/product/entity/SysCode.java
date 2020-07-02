package com.zz.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysCode对象", description="")
public class SysCode implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("codeId")
    private String codeId;

    @TableField("codeName")
    private String codeName;

    @TableField("opNo")
    private String opNo;

    @TableField("opName")
    private String opName;

    private String attribute1;

    private String attribute2;

    private String attribute3;


}
