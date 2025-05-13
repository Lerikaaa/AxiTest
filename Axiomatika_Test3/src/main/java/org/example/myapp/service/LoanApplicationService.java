package org.example.myapp.service;

import org.example.myapp.dto.ApplicationDto;
import org.example.myapp.model.Client;
import org.example.myapp.model.LoanAgreement;
import org.example.myapp.model.LoanApplication;
import org.example.myapp.repository.LoanAgreementRepository;
import org.example.myapp.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class LoanApplicationService {

    @Autowired
    private LoanApplicationRepository loanApplicationRepository;
    @Autowired
    private LoanAgreementRepository loanAgreementRepository;

    public List<LoanApplication> getAllApplications() {
        return loanApplicationRepository.findAll();
    }

    public LoanApplication getApplicationById(Long id) {
        return loanApplicationRepository.findById(id).orElse(null);
    }

    public LoanApplication createApplicationFromForm(Client client, ApplicationDto applicationDto){
        LoanApplication application = new LoanApplication();
        application.setClient(client);
        application.setDesiredAmount(new BigDecimal(applicationDto.getLoanAmount()));
        application.setEmploymentPeriod(applicationDto.getWorkPeriod());
        application.setPosition(applicationDto.getPosition());
        application.setOrganizationName(applicationDto.getOrganization());
        application.setCustomField(applicationDto.getAdditionalInfo());

        return saveApplication(application);
    }

    public LoanApplication saveApplication(LoanApplication application) {
        application.setApplicationDate(LocalDateTime.now());

        Random r = new Random();
        Boolean approved = r.nextBoolean();

        if (approved){
            application.setDecisionStatus("Одобрено");
            application.setLoanTermDays(r.nextInt(336) + 30);
            application.setApprovedAmount(new BigDecimal(r.nextInt(10000) + 1));
        } else{
            application.setDecisionStatus("Отказано");
        }

        LoanApplication save = loanApplicationRepository.save(application);

        if (approved){
            LoanAgreement agreement = new LoanAgreement();
            agreement.setSignatureStatus("Не подписан");
            agreement.setApplication(save);
            loanAgreementRepository.save(agreement);
        }
        return save;
    }

    public void deleteApplication(Long id) {
        loanApplicationRepository.deleteById(id);
    }
}