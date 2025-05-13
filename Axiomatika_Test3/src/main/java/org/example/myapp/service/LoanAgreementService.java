package org.example.myapp.service;

import org.example.myapp.model.LoanAgreement;
import org.example.myapp.repository.LoanAgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoanAgreementService {

    @Autowired
    private LoanAgreementRepository loanAgreementRepository;

    public List<LoanAgreement> getAllAgreements() {
        return loanAgreementRepository.findAll();
    }

    public LoanAgreement getAgreementById(Long id) {
        return loanAgreementRepository.findById(id).orElse(null);
    }

    public LoanAgreement saveAgreement(LoanAgreement agreement) {
        return loanAgreementRepository.save(agreement);
    }

    public void deleteAgreement(Long id) {
        loanAgreementRepository.deleteById(id);
    }

    public LoanAgreement signAgreement(Long id) {
        LoanAgreement agreement = getAgreementById(id);

        agreement.setSigningDate(LocalDateTime.now());
        agreement.setSignatureStatus("Подписан");

        return loanAgreementRepository.save(agreement);
    }

    public LoanAgreement getAgreementByApplicationId(Long id) {
        return loanAgreementRepository.findLoanAgreementByApplicationApplicationId(id);
    }
}
