package com.elmorabit.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AppUser {
    @Id @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles=new ArrayList<>();

    @OneToMany
    private List<LikedShop> likedShops=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @JsonSetter
    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public Collection<AppRole> getRoles() {
        return roles;
    }

    public List<LikedShop> getLikedShops() {
        return likedShops;
    }

    public void setLikedShops(List<LikedShop> likedShops) {
        this.likedShops = likedShops;
    }

    public void deleteLikedShop(String reference){
        for (LikedShop shop:this.likedShops)
            if (shop.getReference().equals(reference))
            {
                this.likedShops.remove(shop);
                return;
            }
    }
}
