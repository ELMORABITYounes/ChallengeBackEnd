package com.elmorabit.demo.web;

import com.elmorabit.demo.entities.AppUser;
import com.elmorabit.demo.models.RegisterForm;
import com.elmorabit.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class AccountRestController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public AppUser register(@Valid @RequestBody RegisterForm userForm){
        if (!userForm.getPassword().equals(userForm.getRepeatedPassword()))
            throw new RuntimeException("Passwords do not match");
        if (accountService.findUserByUsername(userForm.getUsername())!=null)
            throw new RuntimeException("username already in use");
        AppUser appUser=new AppUser(null,userForm.getUsername(),userForm.getPassword(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        accountService.saveUser(appUser);
        accountService.addRoleToUser(appUser.getUsername(),"USER");
        return appUser;
    }

    @GetMapping("/checkUsername")
    public boolean checkUsername(@RequestParam("value") String value) {
        return this.accountService.findUserByUsername(value)!=null;
    }
}
