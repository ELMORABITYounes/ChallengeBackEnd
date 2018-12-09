package com.elmorabit.demo;

import com.elmorabit.demo.dao.LikedShopRepository;
import com.elmorabit.demo.entities.AppRole;
import com.elmorabit.demo.entities.AppUser;
import com.elmorabit.demo.entities.LikedShop;
import com.elmorabit.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class ChallengeApplication implements ApplicationRunner {

    @Autowired
    private LikedShopRepository likedShopRepository;

    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder newBcrypt(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        accountService.saveUser(new AppUser(null,"user@gmail.com","1234",null));
        accountService.saveRole(new AppRole(null,"USER"));
        accountService.addRoleToUser("user@gmail.com","USER");

        Stream.of("shop1","shop2","shop3").forEach(t->
                likedShopRepository.save(new LikedShop(null,t))
        );
        likedShopRepository.findAll().forEach(likedShop->
                System.out.println(likedShop.getReference())
        );
    }
}
