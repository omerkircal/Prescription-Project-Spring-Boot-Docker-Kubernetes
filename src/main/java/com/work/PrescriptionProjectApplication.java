package com.work;

import com.work.exception.PrescriptionNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PrescriptionProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrescriptionProjectApplication.class, args);
    }

}
