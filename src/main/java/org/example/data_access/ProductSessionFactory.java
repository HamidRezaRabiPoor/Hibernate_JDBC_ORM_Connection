package org.example.data_access;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ProductSessionFactory {

    private static SessionFactory sessionFactory;

    private static SessionFactory getHibernateSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        System.out.println("Hibernate configuration built");
        configuration.addAnnotatedClass(org.example.data_access.Product.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        System.out.println("Service registry built");
        return configuration.buildSessionFactory(serviceRegistry);
    }
    public static SessionFactory getSelectedHibernateSessionFactory(){
        return  sessionFactory = (sessionFactory == null)? getHibernateSessionFactory():sessionFactory;
    }
}
