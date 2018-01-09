package com.minisheep.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by minisheep on 18/1/9.
 * 多数据源配置 知识库数据库
 */
@Configuration
@MapperScan(basePackages = "com.minisheep.mapper.knowledgeDataSourceMapper", sqlSessionFactoryRef="secondSqlSessionFactory")
public class KnowLedgeDataSourceConfig {
    @Bean(name = "secondDataSource")
    @ConfigurationProperties(prefix = "mapper.knowledgeDataSourceMapper")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        return sessionFactory.getObject();
    }
}
