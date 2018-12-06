package com.brotuny.proj;

import com.brotuny.proj.storege.AmazonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProjApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }

}
