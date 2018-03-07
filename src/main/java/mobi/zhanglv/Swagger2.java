package mobi.zhanglv;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Author cuizhengwei
 * Date   2017/12/1
 * Description 开启swagger
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        ParameterBuilder versionParam = new ParameterBuilder();
        ParameterBuilder signParam = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        versionParam.name("api-version").defaultValue("6.0.0").description("app版本").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        signParam.name("sign").defaultValue("Bt9PUElXlif4gOmTdKZE/pUcNgzK/TAwzMk9UvWThfpDVVyYSDi4oRvDpFFdAte/CxhPXGTp4FbOZDHBgUjP/cGviNbFkIUtXRcB3XfitEXcvgQiVkjB7YLgm6gMoVg84yv+4Chhlwn5ety7ZrJL80pBNF4nNbCoJ2QkCYzjz5c=").description("签名")
                .modelRef(new ModelRef("string")).parameterType("header").required(false).build();

        pars.add(versionParam.build());
        pars.add(signParam.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("mobi.zhanglv.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("掌律 API")
                .description("Java版本接口 6.0.0开始投入使用")
                .termsOfServiceUrl("http://localhost:8080/swagger-ui.html")
                .contact("zwcui2017@163.com")
                .version("6.0.0")
                .build();
    }

//    private List<ApiKey> securitySchemes() {
//        return new ArrayList(
//                new ApiKey("Authorization", "Authorization", "header"));
//    }
//
//
//    private List<SecurityContext> securityContexts() {
//        return new ArrayList(
//                SecurityContext.builder()
//                        .securityReferences(defaultAuth())
//                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
//                        .build()
//        );
//    }


}