package com.elmorabit.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DislikeShopModel {
    @NotBlank
    private String reference;
    @DateTimeFormat
    private Date date;
}
