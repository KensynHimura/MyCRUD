package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        this.userDao.editUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        this.userDao.deleteUser(id);
    }

    @Override
    public User getUserByID(int id) {
        return this.userDao.getUserByID(id);
    }

    @Override
    public List<User> listUsers() {
//        List<User> userList = null;
//        if (userList != null) {
//            userList.add(new User());
//        }
//        return userList;
        return this.userDao.listUsers();
    }
}
