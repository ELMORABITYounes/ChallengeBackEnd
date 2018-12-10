package com.elmorabit.demo.web;

import com.elmorabit.demo.dao.LikedShopRepository;
import com.elmorabit.demo.dao.UserRepository;
import com.elmorabit.demo.entities.AppUser;
import com.elmorabit.demo.entities.LikedShop;
import com.elmorabit.demo.models.LikeShopModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
@Transactional
@RestController
public class ShopsRestController {
    @Autowired
    private UserRepository userRepository;


    private LikedShopRepository likedShopRepository;
    public ShopsRestController(LikedShopRepository likedShopRepository) {
        this.likedShopRepository=likedShopRepository;
    }

    @GetMapping("/likedShops")
    public List<LikedShop> listLikedShops(@RequestParam("username") String username){
        return  this.userRepository.findByUsername(username).getLikedShops();
    }

    @PostMapping("/likedShops")
    public void save(@Valid @RequestBody LikeShopModel t){
        AppUser appUser=this.userRepository.findByUsername(t.getUsername());
        if (appUser!=null){
            LikedShop likedShop=new LikedShop(null,t.getReference());
            likedShopRepository.save(likedShop);
            appUser.getLikedShops().add(likedShop);
            this.userRepository.save(appUser);
        }else
            throw new RuntimeException("user not found");
    }

    @DeleteMapping("likedShops")
    public Integer delete(@RequestParam("reference") String reference){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username= (String) auth.getPrincipal();
        AppUser appUser=userRepository.findByUsername(username);
        appUser.deleteLikedShop(reference);
        userRepository.save(appUser);
        return likedShopRepository.removeByReference(reference);
    }

}
