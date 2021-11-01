package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;


@Component
public class AddAdminConfig {
    private UserServiceImpl userService;

    @Autowired
    public AddAdminConfig(UserServiceImpl userService){
        this.userService = userService;
    }

    List<String> roles = Arrays.asList("ADMIN");
    @PostConstruct
    public void Init(){
        User user = new User("admin", "admin", 10, "12345", roles);
    }

}
