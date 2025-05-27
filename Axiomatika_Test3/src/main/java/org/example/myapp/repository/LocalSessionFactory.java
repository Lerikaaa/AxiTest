package org.example.myapp.repository;

import org.example.myapp.model.Client;
import org.example.myapp.model.LoanAgreement;
import org.example.myapp.model.LoanApplication;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LocalSessionFactory {
    public static SessionFactory sessionFactory = new Configuration().configure()
            .addAnnotatedClass(Client.class)
            .addAnnotatedClass(LoanAgreement.class)
            .addAnnotatedClass(LoanApplication.class).buildSessionFactory();
}
