package org.example.myapp.repository;

import org.example.myapp.model.Client;
import org.example.myapp.model.LoanAgreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanAgreementRepository extends JpaRepository<LoanAgreement, Long> {
    LoanAgreement findLoanAgreementByApplicationApplicationId(Long id);
}