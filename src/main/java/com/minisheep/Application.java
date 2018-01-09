package com.minisheep;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by minisheep on 18/1/5.
 */
@SpringBootApplication(scanBasePackages="springboot.start",excludeName={"com.minisheep.mapper.aiidbDataSourceMapper","com.minisheep.mapper.knowledgeDataSourceMapper"})
//@MapperScan("com.minisheep.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
