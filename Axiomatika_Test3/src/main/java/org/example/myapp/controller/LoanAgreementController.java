package org.example.myapp.controller;

import org.example.myapp.model.Client;
import org.example.myapp.model.LoanAgreement;
import org.example.myapp.model.LoanApplication;
import org.example.myapp.service.ClientService;
import org.example.myapp.service.LoanAgreementService;
import org.example.myapp.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/agreements")
public class LoanAgreementController {

    @Autowired
    private LoanAgreementService loanAgreementService;
    @Autowired
    private LoanApplicationService loanApplicationService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/agreements.html")
    public String getAllAgreements(Model model) {
        model.addAttribute("listAgreements", loanAgreementService.getAllAgreements());
        return "agreements";
    }

    /*@GetMapping("/{id}")
    public LoanAgreement getAgreementById(@PathVariable Long id) {
        return loanAgreementService.getAgreementById(id);
    }*/

    /*@PostMapping
    public LoanAgreement createAgreement(@RequestBody LoanAgreement agreement) {
        return loanAgreementService.saveAgreement(agreement);
    }*/

    @GetMapping("/sign/{id}")
    public LoanAgreement signAgreement(@PathVariable Long id){
        return loanAgreementService.signAgreement(id);
    }

    @PostMapping(value = "/signContract.html", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String createAgreement(@RequestBody LoanAgreement agreement, Model model) {
        LoanAgreement save = loanAgreementService.signAgreement(agreement.getAgreementId());
        return getSignContract(save.getAgreementId(), model);
    }

    @GetMapping("/{applicationId}/signContract.html")
    public String getSignContract(@PathVariable Long applicationId, Model model) {
        LoanApplication application = loanApplicationService.getApplicationById(applicationId);
        LoanAgreement agreement = loanAgreementService.getAgreementByApplicationId(applicationId);

        model.addAttribute("agreement", agreement);
        model.addAttribute("application", application);

        if (agreement.isSigned()){
            String signingDate = agreement.getSigningDate();
            model.addAttribute("signingDate", signingDate);
        }else{
            String date = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            model.addAttribute("signingDate", date);
        }
        return "signContract";
    }

    @PostMapping("/{agreementId}/signContract.html")
    public String signContract(@PathVariable Long agreementId, Model model){
        LoanAgreement agreement = loanAgreementService.signAgreement(agreementId);
        return getSignContract(agreement.getApplication().getApplicationId(), model);
    }

    @DeleteMapping("/{id}")
    public void deleteAgreement(@PathVariable Long id) {
        loanAgreementService.deleteAgreement(id);
    }
}
