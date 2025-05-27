package org.example.myapp.repository;
import org.example.myapp.model.Client;
import org.example.myapp.model.LoanAgreement;
import org.example.myapp.model.LoanApplication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ClientRepositoryH {

    public List<Client> findAll() {
        try (Session session = LocalSessionFactory.sessionFactory.openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }

    public List<Client> findClientByPhoneLikeAndFullNameLikeAndPassportLike(String phone, String fullName, String passport) {
        try (Session session = LocalSessionFactory.sessionFactory.openSession()) {
            Query<Client> query = session.createQuery("FROM Client WHERE phone LIKE :phone AND fullName LIKE :fullName AND passport LIKE :passport", Client.class);
            query.setParameter("phone", phone);
            query.setParameter("fullName", fullName);
            query.setParameter("passport", passport);
            return query.list();
        }
    }

    public List<Client> findClientByPhoneLikeAndFullNameLike(String phone, String fullName) {
        try (Session session = LocalSessionFactory.sessionFactory.openSession()) {
            Query<Client> query = session.createQuery("FROM Client WHERE phone LIKE :phone AND fullName LIKE :fullName", Client.class);
            query.setParameter("phone", phone);
            query.setParameter("fullName", fullName);
            return query.list();
        }
    }

    public List<Client> findClientByPhoneLikeAndPassportLike(String phone, String passport) {
        try (Session session = LocalSessionFactory.sessionFactory.openSession()) {
            Query<Client> query = session.createQuery("FROM Client WHERE phone LIKE :phone AND passport LIKE :passport", Client.class);
            query.setParameter("phone", phone);
            query.setParameter("passport", passport);
            return query.list();
        }
    }

    public List<Client> findClientByFullNameLikeAndPassportLike(String fullName, String passport) {
        try (Session session = LocalSessionFactory.sessionFactory.openSession()) {
            Query<Client> query = session.createQuery("FROM Client WHERE fullName LIKE :fullName AND passport LIKE :passport", Client.class);
            query.setParameter("fullName", fullName);
            query.setParameter("passport", passport);
            return query.list();
        }
    }

    public List<Client> findClientByPhoneLike(String phone) {
        try (Session session = LocalSessionFactory.sessionFactory.openSession()) {
            Query<Client> query = session.createQuery("FROM Client WHERE phone LIKE :phone", Client.class);
            query.setParameter("phone", phone);
            return query.list();
        }
    }

    public List<Client> findClientByFullNameLike(String fullName) {
        try (Session session = LocalSessionFactory.sessionFactory.openSession()) {
            Query<Client> query = session.createQuery("FROM Client WHERE fullName LIKE :fullName", Client.class);
            query.setParameter("fullName", fullName);
            return query.list();
        }
    }

    public List<Client> findClientByPassportLike(String passport) {
        try (Session session = LocalSessionFactory.sessionFactory.openSession()) {
            Query<Client> query = session.createQuery("FROM Client WHERE passport LIKE :passport", Client.class);
            query.setParameter("passport", passport);
            return query.list();
        }
    }

    public Optional<Client> findClientByPhone(String phone) {
        try (Session session = LocalSessionFactory.sessionFactory.openSession()) {
            Query<Client> query = session.createQuery("FROM Client WHERE phone LIKE :phone", Client.class);
            query.setParameter("phone", phone);
            return query.uniqueResultOptional();
        }
    }

    public Optional<Client> findById(Long id) {
        try (Session session = LocalSessionFactory.sessionFactory.openSession()) {
            Query<Client> query = session.createQuery("FROM Client WHERE id = :id", Client.class);
            query.setParameter("id", id);
            return query.uniqueResultOptional();
        }
    }

    public Client save(Client client) {
        try (Session session = LocalSessionFactory.sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Long clientId = (Long) session.save(client);

            session.flush();
            transaction.commit();
        }
        return client;
    }
}