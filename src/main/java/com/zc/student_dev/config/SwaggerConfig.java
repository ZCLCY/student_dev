package com.zc.student_dev.config;

import com.google.common.collect.Sets;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/***
 * 日志配置文件
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${swagger.show}")
	private boolean swaggerShow;
	@Value("${swagger.version}")
	private String version;
	@Value("${swagger.basePackage}")
	private String basePackage;

	@Bean
	public Docket configSpringfoxDocketForAgent() {
		ParameterBuilder parameterBuilder = new ParameterBuilder();
		Parameter parameter = parameterBuilder.name("token").description("token认证").modelRef(new ModelRef("string"))
				.parameterType("header").required(false).build();
		List<Parameter> parameterList = new ArrayList<>();
		parameterList.add(parameter);
		return new Docket(DocumentationType.SWAGGER_2).groupName("学生管理系统 API接口文档").enable(swaggerShow)
				.protocols(Sets.newHashSet("http")).forCodeGeneration(true).select().paths(PathSelectors.any())
				// .paths(regex("/account/.*"))//只显示请求路径是account下的注释
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).build().apiInfo(apiInfo())
				.globalOperationParameters(parameterList);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("学生管理系统 Api")// 标题
				.description(
						"以下API根据默认配置生成，相关API及字段缺乏开发者的说明。如果在使用中有疑义，请联系服务端开发补全相关说明。补全时参考文档：http://springfox.github.io/springfox/docs/current/")// 描述
				// .termsOfServiceUrl("http://www.huojutech.com")//
				.contact(new Contact("zc", "", "zc080829@163.com"))// 联系，创建人
				.version(version)// 版本
				.build();
	}
}
