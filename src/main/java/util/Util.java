package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import web.model.User;

import java.util.Properties;

public class Util {
    public static final String MY_HELL = "jdbc:mysql://localhost:3306/my_db?useUnicode=true&serverTimezone=UTC&useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "springcourse";
    private SessionFactory factory;

//    public SessionFactory getSessionFactory () {
//        return new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();


    public SessionFactory getFactory() {
        if (factory == null) {
            Configuration configuration = new Configuration();
            Properties properties = new Properties();
            properties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            properties.put("hibernate.connection.url", MY_HELL);
            properties.put("hibernate.connection.username", USERNAME);
            properties.put("hibernate.connection.password", PASSWORD);
            properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
            properties.put("hibernate.current_session_context_class", "thread");
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.hbm2ddl.auto", "update");
            configuration.setProperties(properties);
            configuration.addAnnotatedClass(User.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            factory = configuration.buildSessionFactory(serviceRegistry);
        }
        return factory;
    }
}
