package cn.langlang.langmovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Smileyan
 */
@EnableSwagger2
@SpringBootApplication
public class LangmovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(LangmovieApplication.class, args);
    }

}
