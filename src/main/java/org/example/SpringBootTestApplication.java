package org.example;

import org.example.data_access.Product;
import org.example.data_access.ProductSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTestApplication {

    public static void main(String[] args) {
        Product product = new Product();
        product.setName("ROSE");
        product.setPrice(2560);
        SessionFactory sessionFactory = ProductSessionFactory.getSelectedHibernateSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(product);
        session.getTransaction().commit();
        System.out.println(product.getId());
        session.close();
        SpringApplication.run(SpringBootTestApplication.class);
    }
}
