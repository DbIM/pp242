package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import javax.annotation.PostConstruct;
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
        Role adminRole = new Role("ROLE_ADMIN");
        roleService.saveRole(adminRole);

        Role userRole = new Role("ROLE_USER");
        roleService.saveRole(userRole);

        Set<Role> adminRoles = new HashSet<Role>(Collections.singleton(adminRole));
        User adminUser = new User("admin", "admin", "admin", adminRoles);
        userService.saveUser(adminUser);

        Set<Role> userRoles = new HashSet<Role>(Collections.singleton(userRole));
        User userUser = new User("user", "user", "user", userRoles);
        userService.saveUser(userUser);
    }



}
