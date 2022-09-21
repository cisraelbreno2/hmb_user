package br.com.hmb_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HmbUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HmbUserApplication.class, args);
    }

}
