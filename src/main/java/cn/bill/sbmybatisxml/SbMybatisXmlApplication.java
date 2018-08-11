package cn.bill.sbmybatisxml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages={"cn.bill.sbmybatisxml.mapper"})
@EnableCaching
public class SbMybatisXmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMybatisXmlApplication.class, args);
	}
}
