package com.utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author: Christian Chiama (c.chiama@silensec.com)
 * @project-Name: second-week
 * @date: 31-03-2022
 * @time: 13:48 min
 * @file: com.corso.java.db.utils.JPAUtils
 */

public class JPAUtils {
    private static final String PERSISTENCE_UNIT_NAME = "persistenceUnit";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}
