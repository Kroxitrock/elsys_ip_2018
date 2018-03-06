package org.elsys.ip.rest.repository;

import org.elsys.ip.rest.config.HibernateUtil;
import org.elsys.ip.rest.model.Test;
import org.hibernate.Session;

public class TestRepositoryHibernate extends TestRepositoryJdbc {
    public void addEmpty(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(new Test());
        session.getTransaction().commit();
    }
}
