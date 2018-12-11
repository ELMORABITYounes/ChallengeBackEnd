package com.elmorabit.demo.dao;

import com.elmorabit.demo.entities.DislikedShop;
import com.elmorabit.demo.entities.LikedShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DislikedShopRepository extends JpaRepository<DislikedShop,Long> {
    public Integer removeByReference(String reference);
}
