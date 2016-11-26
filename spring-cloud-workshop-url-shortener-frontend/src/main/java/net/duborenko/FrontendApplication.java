package net.duborenko;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ServletContextRequestLoggingFilter;

import javax.servlet.Filter;

/**
 * @author Kiryl Dubarenka
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FrontendApplication {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Filter logFilter() {
        ServletContextRequestLoggingFilter filter = new ServletContextRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setIncludeClientInfo(true);
        filter.setMaxPayloadLength(5120);
        return filter;
    }

    public static void main(String[] args) {
        SpringApplication.run(FrontendApplication.class, args);
    }

}
