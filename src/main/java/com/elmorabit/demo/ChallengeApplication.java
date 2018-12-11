package com.elmorabit.demo;

import com.elmorabit.demo.dao.LikedShopRepository;
import com.elmorabit.demo.entities.AppRole;
import com.elmorabit.demo.entities.AppUser;
import com.elmorabit.demo.entities.DislikedShop;
import com.elmorabit.demo.entities.LikedShop;
import com.elmorabit.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
public class ChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder newBcrypt(){
        return new BCryptPasswordEncoder();
    }
}
