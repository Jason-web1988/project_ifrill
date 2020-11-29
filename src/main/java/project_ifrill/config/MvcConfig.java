package project_ifrill.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import project_ifrill.interceptor.AuthCheckInterceptor;


@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{
	
	/** DispatcherServlet의 매핑경로를 '/'주었을 때, JSP/HTML/CSS 등을 올바르게 처리하기 위한 설정 추가 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	/** JSP를 통해서 컨트롤러의 실행 결과를 보여주기 위한 설정 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/", ".jsp");
	}
	
	/*컨트롤러 구현 없는 경로 매핑
	 * 
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/main").setViewName("/main");
		registry.addViewController("/productDetail").setViewName("/product/productDetail");
		registry.addViewController("/productKind").setViewName("/product/productKind");

		registry.addViewController("/login").setViewName("/member/login");
		registry.addViewController("/join").setViewName("/member/join");
		registry.addViewController("/contract").setViewName("/member/contract");

		registry.addViewController("/mypage").setViewName("/mypage/confirmPass");
		registry.addViewController("/checked").setViewName("/mypage/mypage");
		
		registry.addViewController("/qnaList").setViewName("/qna/qnaList");
		registry.addViewController("/qnaWrite").setViewName("/qna/qnaWrite");
		registry.addViewController("/continue").setViewName("/main");

		registry.addViewController("/adminMain").setViewName("/admin/main");
		registry.addViewController("/adminProductDetail").setViewName("/admin/product/productDetail");
		registry.addViewController("/adminProductList").setViewName("/admin/product/productList");
		registry.addViewController("/adminOrderList").setViewName("/admin/order/orderList");
		registry.addViewController("/adminMemberList").setViewName("/admin/member/memberList");
		registry.addViewController("/adminMemberList").setViewName("/admin/member/memberList");
		registry.addViewController("/adminQnAList").setViewName("/admin/qna/qnaList");
		
		
	}
	
	
	/*다국어 설정*/
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasename("message.label");
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authCheckInterceptor()).addPathPatterns("/edit/**");
	}

	@Bean
	public AuthCheckInterceptor authCheckInterceptor() {
		return new AuthCheckInterceptor();
	}

	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
				.featuresToEnable(SerializationFeature.INDENT_OUTPUT)
				.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(formatter))
				.simpleDateFormat("yyyy-MM-dd HH:mm:ss").build();
		converters.add(0, new MappingJackson2HttpMessageConverter(objectMapper));
	}

	
	

	/*
	 * 객체를 글로벌 범위 Validator로 사용
	 * 글로벌 범위 Validator를지정하면
	 * @Valid 애노테이션을 사용해서 Validator를 적용
	 */
	/*
	 * @Override public Validator getValidator() { 
	 * return new RegisterRequestValidator(); 
	 * }
	 */
	

}
