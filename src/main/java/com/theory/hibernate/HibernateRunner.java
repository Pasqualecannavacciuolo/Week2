package com.theory.hibernate;

import com.utility.LOG;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateRunner {
    LOG L = LOG.getInstance();

    public void run() {
        SessionFactory sessionFactory = null; // Serve per creare oggetti di tipo sessione
        Session session = null; // Nella sessione avvengono tutte le transazioni hibernate


        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder serviceRegistry =  new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(serviceRegistry.build());
        session = sessionFactory.openSession();
        persistPerson(session);


        try {

        }catch (Exception e) {
            L.info(e.getMessage());
        }

    }
    public void persistPerson(Session session) {
        try {
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Person person = new Person();
            person.setFirstName("Pasquale");
            person.setLastName("Cannavacciuolo");
            session.save(person);
            transaction.commit(); // Nell'hibernate config autocommit=false
        }catch (Exception e) {
            if(session.getTransaction().isActive())
                session.getTransaction().rollback();
            L.info(e.getMessage());
        }
    }

    public static void main(String[] args) {
        HibernateRunner hibernateRunner = new HibernateRunner();
        hibernateRunner.run();
    }
}
