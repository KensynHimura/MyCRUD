package web.service;

import org.springframework.security.core.userdetails.UserDetails;
import web.model.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);

    public void deleteUser(Long id);

    public User getUserByID(Long id);

    public List<User> listUsers();

}
