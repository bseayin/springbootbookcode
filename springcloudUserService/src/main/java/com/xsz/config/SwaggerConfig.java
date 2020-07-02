package com.xsz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(buildApiInf())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.xsz.controller"))
            .paths(PathSelectors.any())
            .build();
    }
    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
            .title("系统RESTful API文档")
            .contact(new Contact("Bsea", "https://me.csdn.net/h356363", "yinyouhai@aliyun.com"))
            .version("1.0")
            .build();
    }
}


/**
*
*
* Swagger常用注解
@Api：修饰整个类，描述Controller的作用；
@ApiOperation：描述一个类的一个方法，或者说一个接口；
@ApiParam：单个参数描述；
@ApiModel：用对象来接收参数；
@ApiProperty：用对象接收参数时，描述对象的一个字段；
@ApiResponse：HTTP响应其中1个描述；
@ApiResponses：HTTP响应整体描述；
@ApiIgnore：使用该注解忽略这个API；
@ApiError ：发生错误返回的信息；
@ApiImplicitParam：一个请求参数；
@ApiImplicitParams：多个请求参数。
编写RESTful API接口
Spring Boot中包含了一些注解，对应于HTTP协议中的方法：
@GetMapping对应HTTP中的GET方法；
@PostMapping对应HTTP中的POST方法；
@PutMapping对应HTTP中的PUT方法；
@DeleteMapping对应HTTP中的DELETE方法；
@PatchMapping对应HTTP中的PATCH方法。
8**

http://localhost:9013/report/swagger-ui.html
**/

