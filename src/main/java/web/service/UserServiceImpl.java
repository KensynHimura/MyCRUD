package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        this.userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        this.userDao.deleteUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByID(Long id) {
        return this.userDao.getUserByID(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }
}
