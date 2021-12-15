package web.dao;

import org.springframework.security.core.userdetails.UserDetails;
import web.model.User;

import java.util.List;

public interface UserDao {
    public void saveUser(User user);

    public void deleteUser(int id);

    public User getUserByID(int id);

    public List<User> listUsers();

    UserDetails getUserByName(String username);
}
