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
 * 多数据源配置,aiidb(航班数据库)
 */
@Configuration
@MapperScan("com.minisheep.mapper.aiidbDataSourceMapper")
public class AiidbDataSourceConfig {
    @Bean(name = "primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "mapper.aiidbDataSourceMapper")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        return sessionFactory.getObject();
    }
}
