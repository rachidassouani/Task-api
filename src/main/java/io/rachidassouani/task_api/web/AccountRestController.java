package io.rachidassouani.task_api.web;

import io.rachidassouani.task_api.entity.AppUser;
import io.rachidassouani.task_api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountRestController {
    @Autowired
    private AccountService accountService;

    @PostMapping("register")
    public AppUser register(@RequestBody RegisterForm userForm) {

        // check if password and repeated password are equals
        if (!userForm.getPassword().equals(userForm.getRePassword()))
            throw new RuntimeException("you must confirm your password");

        // check if username is already exist in database
        if (accountService.findUserByUsername(userForm.getUsername()) != null)
            throw new RuntimeException("this username is already exist");

        // new user object with username and password
        AppUser user = new AppUser(userForm.getUsername(), userForm.getPassword());

        // save user after making sure that it's not in db and 2 passwords are equals
        accountService.saveUser(user);

        // set USER_ROLE as default role
        accountService.addRoleToUser(user.getUsername(), "USER");

        return user;
    }
}
