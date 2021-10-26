package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

@EnableJpaRepositories(basePackages="reposotories")
@EntityScan("entities")
@SpringBootApplication
@ComponentScan(basePackages={"services" , "main","controllers"})
public class APP {
    public static void main(String [] args)
    {
        SpringApplication.run(APP.class ,args);
    }
}
