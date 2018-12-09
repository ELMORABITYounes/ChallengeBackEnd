package com.elmorabit.demo.dao;

import com.elmorabit.demo.entities.LikedShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikedShopRepository extends JpaRepository<LikedShop,Long> {
}
