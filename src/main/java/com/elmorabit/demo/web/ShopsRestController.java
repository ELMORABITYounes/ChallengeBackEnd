package com.elmorabit.demo.web;

import com.elmorabit.demo.dao.LikedShopRepository;
import com.elmorabit.demo.entities.LikedShop;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopsRestController {
    private LikedShopRepository likedShopRepository;
    public ShopsRestController(LikedShopRepository likedShopRepository) {
        this.likedShopRepository=likedShopRepository;
    }
    @GetMapping("/likedShops")
    public List<LikedShop> listLikedShops(){
        return  likedShopRepository.findAll();
    }

    @PostMapping("/likedShops")
    public LikedShop save(@RequestBody LikedShop t){
        return this.likedShopRepository.save(t);
    }
}
