package org.example.myapp.service;

import org.example.myapp.model.LoanAgreement;
import org.example.myapp.repository.LoanAgreementRepositoryH;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoanAgreementService {

    LoanAgreementRepositoryH loanAgreementRepositoryH = new LoanAgreementRepositoryH();

    public List<LoanAgreement> getAllAgreements() {
        return loanAgreementRepositoryH.findAll();
    }

    public LoanAgreement getAgreementById(Long id) {
        return loanAgreementRepositoryH.findById(id).orElse(null);
    }

    public LoanAgreement saveAgreement(LoanAgreement agreement) {
        return loanAgreementRepositoryH.save(agreement);
    }

    public LoanAgreement signAgreement(Long id) {
        LoanAgreement agreement = getAgreementById(id);

        agreement.setSigningDate(LocalDateTime.now());
        agreement.setSignatureStatus("Подписан");

        return loanAgreementRepositoryH.save(agreement);
    }

    public LoanAgreement getAgreementByApplicationId(Long id) {
        return loanAgreementRepositoryH.findLoanAgreementByApplicationApplicationId(id);
    }
}
