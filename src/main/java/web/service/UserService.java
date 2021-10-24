package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User saveUser(User user);
    public User updateUser(User user);
    public User getUserById(Long id);
}
