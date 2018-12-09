package com.elmorabit.demo.web;

import com.elmorabit.demo.entities.AppUser;
import com.elmorabit.demo.models.RegisterForm;
import com.elmorabit.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class AccountRestController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public AppUser register(@Valid @RequestBody RegisterForm userForm){
        if (!userForm.getPassword().equals(userForm.getRepeatedPassword()))
            throw new RuntimeException("Passwords doesn't match");
        if (accountService.findUserByUsername(userForm.getUsername())!=null)
            throw new RuntimeException("username already in use");
        AppUser appUser=new AppUser(null,userForm.getUsername(),userForm.getPassword(),new ArrayList<>());
        accountService.saveUser(appUser);
        accountService.addRoleToUser(userForm.getUsername(),"USER");
        return appUser;
    }
}
