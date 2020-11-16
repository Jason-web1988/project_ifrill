package project_ifrill.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({ ContextDataSource.class, ContextSqlSession.class })
@ComponentScan(basePackages = {"project_ifrill.controller",
								"project_ifrill.mapper",
								"project_ifrill.service"})
public class ControllerConfig {

}
