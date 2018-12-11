package com.elmorabit.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DislikedShop {
    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String reference;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
