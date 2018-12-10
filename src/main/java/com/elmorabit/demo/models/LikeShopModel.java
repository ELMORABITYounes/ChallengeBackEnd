package com.elmorabit.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class LikeShopModel {
    @Email
    private String username;
    @NotBlank
    private String reference;
}
