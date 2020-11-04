package project_ifrill.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"project_ifrill.mapper"})
public class ContextSqlSession {
   @Autowired
   private ApplicationContext applicationContext;
   
   @Bean
   public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
      SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
      factoryBean.setDataSource(dataSource);
      factoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis-config.xml"));
      factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/*Mapper.xml"));
      
      return factoryBean;
   }
   
   @Bean
   public SqlSessionTemplate  sqlSession(SqlSessionFactory sqlSessionFactory) {
      
      return new SqlSessionTemplate(sqlSessionFactory);
   }
}