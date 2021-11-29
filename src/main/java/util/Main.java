package util;

import web.model.User;

public class Main {
    public static void main(String[] args) {
        Util util = new Util();
        util.getFactory().getCurrentSession().beginTransaction();
        util.getFactory().getCurrentSession().save(new User(1, "Sasha", "Male", 10));
        util.getFactory().getCurrentSession().save(new User(2, "Saswser", "Male", 18));
        util.getFactory().getCurrentSession().save(new User(3, "Sssgs", "Male", 15));
        util.getFactory().getCurrentSession().getTransaction().commit();

    }
}
