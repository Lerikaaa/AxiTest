package org.example.myapp.repository;

import org.example.myapp.model.LoanApplication;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class LoanApplicationRepositoryH {

    public List<LoanApplication> findAll(){
        try (Session session = LocalSessionFactory.sessionFactory.openSession()){
            return session.createQuery("from LoanApplication", LoanApplication.class).list();
        }
    }

    public Optional<LoanApplication> findById(Long id){
        try (Session session = LocalSessionFactory.sessionFactory.openSession()){
            Query<LoanApplication> query = session.createQuery("FROM LoanApplication WHERE application_id = :id", LoanApplication.class);
            query.setParameter("id", id);
            return query.uniqueResultOptional();
        }
    }

    public LoanApplication save(LoanApplication loanApplication){
        try (Session session = LocalSessionFactory.sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Long loanApplicationId = (Long) session.save(loanApplication);

            session.flush();
            transaction.commit();
        }
        return loanApplication;
    }
}
