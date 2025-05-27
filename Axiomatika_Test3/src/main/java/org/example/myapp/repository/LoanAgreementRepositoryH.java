package org.example.myapp.repository;
import org.example.myapp.model.LoanAgreement;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class LoanAgreementRepositoryH {

    public LoanAgreement findLoanAgreementByApplicationApplicationId(Long applicationId){
        try (Session session = LocalSessionFactory.sessionFactory.openSession()) {
            Query<LoanAgreement> query = session.createQuery("FROM LoanAgreement WHERE application_id = :applicationId", LoanAgreement.class);
            query.setParameter("applicationId", applicationId);
            List<LoanAgreement> list = query.getResultList();
            if (list.isEmpty()) {
                return null;
            }
            else{
                return list.get(list.size()-1);
            }
        }
    }

    public List<LoanAgreement> findAll(){
        try (Session session = LocalSessionFactory.sessionFactory.openSession()) {
            return session.createQuery("from LoanAgreement ", LoanAgreement.class).list();
        }
    }

    public Optional<LoanAgreement> findById(Long id){
        try (Session session = LocalSessionFactory.sessionFactory.openSession()) {
            Query<LoanAgreement> query = session.createQuery("FROM LoanAgreement WHERE agreement_id = :id", LoanAgreement.class);
            query.setParameter("id", id);
            return query.uniqueResultOptional();
        }
    }

    public LoanAgreement save(LoanAgreement loanAgreement){
        try (Session session = LocalSessionFactory.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Long loanAgreementId = (Long) session.save(loanAgreement);

            session.flush();
            transaction.commit();
        }
        return loanAgreement;
    }
}
