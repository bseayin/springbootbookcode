package com.zz.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="TestXuesongDemo对象", description="")
public class TestXuesongDemo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "test_xuesong_id", type = IdType.AUTO)
    private Integer testXuesongId;

    private String testXuesongName;


}
