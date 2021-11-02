package web.dao;

import org.springframework.stereotype.Component;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class RoleDaoImpl implements RoleDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public Role getById(long id) {
        return null;
    }

    @Override
    public Role getByName(String roleName) {
        return null;
    }

    @Override
    public Role save(Role role) {
        entityManager.persist(role);
        return role;
    }

    @Override
    public void delete(Role role) {

    }

    @Override
    public void update(Role role) {

    }
}
