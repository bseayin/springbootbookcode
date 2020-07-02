package com.zz.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Bsea
 * 2018-06-05 16:15
 */
@Component
@ConfigurationProperties("upyun")
@Data
public class UpYunConfig {

    private String bucketName;

    private String username;

    private String password;

    /**
     * http://xxx.com/
     */
    private String imageHost;
}
