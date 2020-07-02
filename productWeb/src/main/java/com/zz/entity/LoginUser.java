package com.zz.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zz.user.entity.SysUsers;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * LoginUser:登录注册LoginUser传参实体
 *
 * @author Bsea
 * @date: 2019/05/23
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class LoginUser implements Serializable {

    /**
     * 验证码
     */
    private String phoneCode;
    /**
     * 用户
     */
    private SysUsers user;

    /**
     * 用户token验证(header的键名)
     */
    private String token;




}
