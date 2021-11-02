package web.service;

import org.springframework.stereotype.Service;
import web.dao.RoleDao;
import web.dao.UserDao;
import web.model.Role;

import javax.transaction.Transactional;

@Service
public class RoleServiceImpl implements RoleService{
    RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public Role saveRole(Role role) {
        return roleDao.save(role);
    }
}
