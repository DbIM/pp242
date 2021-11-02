package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Component
public class AddAdminConfig {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AddAdminConfig(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @PostConstruct
    public void Init() {
        Role role = new Role("ADMIN");
        roleService.saveRole(role);
        Set<Role> roles = new HashSet<Role>(Collections.singleton(role));
        User user = new User("admin", "admin", 10, "12345", roles);
        userService.saveUser(user);
    }



}
