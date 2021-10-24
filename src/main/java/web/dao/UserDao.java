package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void dropUsersTable();

    User updateUser(User user);

    User getUserById(Long id);

    User saveUser(User user);

    void removeUser(Long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
