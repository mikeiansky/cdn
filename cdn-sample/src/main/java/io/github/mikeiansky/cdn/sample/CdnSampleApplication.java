package io.github.mikeiansky.cdn.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CdnSampleApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(CdnSampleApplication.class, args);
        CdnQiniuSampleService cdnQiniuSampleService = applicationContext.getBean(CdnQiniuSampleService.class);
        String qiniuToken = cdnQiniuSampleService.createToken();
        System.out.println(qiniuToken);
    }

}
