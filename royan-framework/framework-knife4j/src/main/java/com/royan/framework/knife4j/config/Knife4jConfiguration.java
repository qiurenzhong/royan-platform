package com.royan.framework.knife4j.config;

import cn.hutool.core.collection.CollectionUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import properties.Knife4jProperties;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qiurz
 * @date 2021/5/8 17:52
 */
@Configuration
@EnableSwagger2WebMvc
@Import(BeanValidatorPluginsConfiguration.class)
public class Knife4jConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Knife4jProperties knife4jProperties() {
        return new Knife4jProperties();
    }


    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "royan.knife4j.enabled", matchIfMissing = true)
    public Docket restApi(Knife4jProperties knife4jProperties) {
        //密码模式
        String passwordTokenUrl = knife4jProperties.getPasswordTokenUrl();

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(knife4jProperties.getBasePackage()))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(securityContexts())
                .securitySchemes(securitySchemes(passwordTokenUrl))
                .apiInfo(apiInfo(knife4jProperties));
    }

    /**
     * 安全模式，这里指定token通过头请求头传递
     */
    private List<SecurityScheme> securitySchemes(String passwordTokenUrl) {
        List<SecurityScheme> securitySchemes = new ArrayList<>();
        //schema
        List<GrantType> grantTypes = new ArrayList<>();
        ResourceOwnerPasswordCredentialsGrant resourceOwnerPasswordCredentialsGrant = new ResourceOwnerPasswordCredentialsGrant(passwordTokenUrl);
        grantTypes.add(resourceOwnerPasswordCredentialsGrant);
        securitySchemes.add(new OAuthBuilder().name("oauth2").grantTypes(grantTypes).build());
        return securitySchemes;
    }

    /**
     * 安全上下文
     */
    private List<SecurityContext> securityContexts() {
        //scope方位
        List<AuthorizationScope> scopes = new ArrayList<>();
        scopes.add(new AuthorizationScope("global", "accessEverything"));
        SecurityReference securityReference = new SecurityReference("token", scopes.toArray(new AuthorizationScope[]{}));
        SecurityContext securityContext = new SecurityContext(CollectionUtil.newArrayList(securityReference), PathSelectors.ant("/api/**"));
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(securityContext);
        return securityContexts;
    }

    private ApiInfo apiInfo(final Knife4jProperties knife4jProperties) {
        return new ApiInfoBuilder().title(knife4jProperties.getTitle())
                .description("<div style='font-size:14px;color:red;'>" + knife4jProperties.getDescription() + "</div>")
                .termsOfServiceUrl(knife4jProperties.getTermsOfServiceUrl())
                .contact(new Contact(knife4jProperties.getContact().getName(),
                        knife4jProperties.getContact().getUrl(),
                        knife4jProperties.getContact().getEmail()))
                .license(knife4jProperties.getLicense())
                .licenseUrl(knife4jProperties.getLicenseUrl())
                .version(knife4jProperties.getVersion())
                .build();
    }

}
