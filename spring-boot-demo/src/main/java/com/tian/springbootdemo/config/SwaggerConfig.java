package com.tian.springbootdemo.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @auther: tianweichang
 * @date: 2018/10/9 21
 * @Description: swagger配置信息及相关注解说明
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(
                RequestHandlerSelectors.withMethodAnnotation(
                        ApiOperation.class)).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("springboot利用swagger构建api文档")
                .description("简单优雅的restfun风格，https://blog.csdn.net/o9109003234")
                .version("1.0").build();
    }
    /**
     * 访问：http://localhost:8080/swagger-ui.html#/
     * swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。
     *  @Api：修饰整个类，描述Controller的作用
     *  @ApiOperation：描述一个类的一个方法，或者说一个接口
     *  @ApiParam：单个参数描述@ApiModel：用对象来接收参数
     *  @ApiProperty：用对象接收参数时，描述对象的一个字段
     *  @ApiResponse：HTTP响应其中1个描述
     *  @ApiResponses：HTTP响应整体描述
     *  @ApiIgnore：使用该注解忽略这个API
     *  @ApiError ：发生错误返回的信息
     *  @ApiImplicitParam：一个请求参数
     *  @ApiImplicitParams：多个请求参数
     */
}
