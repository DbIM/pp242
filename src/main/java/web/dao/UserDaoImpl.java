package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User updateUser(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void removeUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User saveUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class)
                .getResultList();
    }

    @Override
    public User getUserByName(String name) {
        Query query = entityManager.createQuery("SELECT id FROM User WHERE name = :name");
        query.setParameter("name", name);
        Long id = (Long) query.getResultList().get(0);
        return entityManager.find(User.class, id);
    }
}
