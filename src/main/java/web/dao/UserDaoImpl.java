package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

@PersistenceContext
@Repository
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;
//    private EntityManagerFactory entityManagerFactory;

//    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
//        this.entityManagerFactory = entityManagerFactory;
//    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    @Override
    public void addUser(User user) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        em.persist(user);
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void editUser(User user) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        em.merge(user);
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void deleteUser(int id) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        em.remove(getUserByID(id));
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        if (user!=null){
            session.delete(user);
        }
    }

    @Override
    public User getUserByID(int id) {
//        EntityManager em = entityManagerFactory.createEntityManager();
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        return user;
    }

    @Override
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        return userList;
    }
}
