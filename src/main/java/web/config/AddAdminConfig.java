package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Component
public class AddAdminConfig {
    private UserService userService;

    @Autowired
    public AddAdminConfig(UserService userService) {
        this.userService = userService;
    }

    Set<Role> roles = new HashSet<Role>();

    @PostConstruct
    public void Init() {


        User user = new User("admin", "admin", 10, "12345", roles);
        userService.saveUser(user);
    }



}
