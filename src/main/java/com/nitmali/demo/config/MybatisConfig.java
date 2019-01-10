package com.nitmali.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author nitmali
 * @date 2019/1/10 16:04
 */
@Slf4j
public class MybatisConfig {
    /**
     * this first SqlSessionFactory and SqlSessionTemplate  build .
     */
    @Configuration
    @MapperScan(basePackages = {"com.nitmali.demo.mapper.first"},
            sqlSessionFactoryRef = "firstSqlSessionFactory",
            sqlSessionTemplateRef = "firstSqlSessionTemplate")
    public static class FirstDB {
        @Resource
        DataSource firstDataSource;

        @Bean
        public SqlSessionFactory firstSqlSessionFactory() throws Exception {
            log.info("firstSqlSessionFactory build success.");
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(firstDataSource);
            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/first/*.xml"));
            return factoryBean.getObject();
        }

        @Bean
        public SqlSessionTemplate firstSqlSessionTemplate() throws Exception {
            return new SqlSessionTemplate(firstSqlSessionFactory());
        }
    }

    /**
     * the second SqlSessionFactory and SqlSessionTemplate  build
     */
    @Configuration
    @MapperScan(basePackages = {"com.nitmali.demo.mapper.second"},
            sqlSessionFactoryRef = "secondSqlSessionFactory",
            sqlSessionTemplateRef = "secondSqlSessionTemplate")
    public static class SecondDB {
        @Resource
        DataSource secondDataSource;

        @Bean
        public SqlSessionFactory secondSqlSessionFactory() throws Exception {
            log.info("secondSqlSessionFactory build success.");
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(secondDataSource);
            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/second/*.xml"));
            return factoryBean.getObject();
        }

        @Bean
        public SqlSessionTemplate secondSqlSessionTemplate() throws Exception {
            return new SqlSessionTemplate(secondSqlSessionFactory());
        }
    }
}