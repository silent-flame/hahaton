package com.brotuny.proj;

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
        /*Post post = new Post(0, "Title", "Preview", "Body");
        postMapper.insert(post);
        System.out.println(post);
        post = postMapper.findById(post.getPostId());
        System.out.println(post);
        System.out.println();

        Post[] posts = postMapper.getAll();
        for (Post p : posts){
            System.out.println(p);
        }*/
    }

}
