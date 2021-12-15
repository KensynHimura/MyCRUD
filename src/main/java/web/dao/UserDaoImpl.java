package web.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import web.model.Account;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUserByID(id));
    }

    @Override
    public User getUserByID(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public UserDetails getUserByName(String username) {
        return entityManager.createQuery("from Accounts user where user.username =: username", Account.class)
                .setParameter("acc_username", username).getSingleResult();
    }


//    Util util = new Util();

//    private SessionFactory sessionFactory;
//    private EntityManagerFactory entityManagerFactory;

//    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
//        this.entityManagerFactory = entityManagerFactory;
//    }
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }



//    @Override
//    public void addUser(User user) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        em.persist(user);
//        util.getSessionFactory().getCurrentSession().persist(user);
//        Session session = this.sessionFactory.getCurrentSession();
//        session.persist(user);
//    }

//    @Override
//    public void editUser(User user) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        em.merge(user);
//        util.getSessionFactory().getCurrentSession().update(user);
//        Session session = this.sessionFactory.getCurrentSession();
//        session.update(user);
//    }
//
//    @Override
//    public void deleteUser(int id) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        em.remove(getUserByID(id));
//        Session session = util.getSessionFactory().getCurrentSession();
//        User user = session.load(User.class, id);
//        if (user!=null){
//            session.delete(user);
//        }
//    }

//    @Override
//    public User getUserByID(int id) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        Session session = util.getSessionFactory().getCurrentSession();
//        User user = session.load(User.class, id);
//        return user;
//    }

//    @Override
//    public List<User> listUsers() {
//        Session session = util.getSessionFactory().getCurrentSession();
//        List<User> userList = session.createQuery("from User, User.class").getResultList();
//        return userList;
//    }
}
