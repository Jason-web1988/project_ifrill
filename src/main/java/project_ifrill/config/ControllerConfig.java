package project_ifrill.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({ ContextDataSource.class, ContextSqlSession.class })
@ComponentScan(basePackages = {"project_ifrill.controller", 
		/*
		 * "gradle_spring_webmvc_study.service", "gradle_spring_webmvc_study.spring",
		 * "gradle_spring_webmvc_study.survey", "gradle_spring_webmvc_study.common"
		 */})
public class ControllerConfig {

}
