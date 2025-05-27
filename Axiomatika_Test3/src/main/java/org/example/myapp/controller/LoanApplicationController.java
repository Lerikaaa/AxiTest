package org.example.myapp.controller;

import org.example.myapp.dto.ApplicationDto;
import org.example.myapp.model.Client;
import org.example.myapp.model.LoanAgreement;
import org.example.myapp.model.LoanApplication;
import org.example.myapp.service.ClientService;
import org.example.myapp.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/applications")
public class LoanApplicationController {

    @Autowired
    private LoanApplicationService loanApplicationService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/applications.html")
    public String getAllApplications(Model model) {
        model.addAttribute("listApplications", loanApplicationService.getAllApplications());
        return "applications";
    }

    @GetMapping("/apply.html")
    public String getApply() {
        return "apply";
    }

    @PostMapping(value = "/decision.html", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String createApplication(ApplicationDto application, Model model) {
        Client saveClient = clientService.saveClientFromApplication(application);
        LoanApplication save = loanApplicationService.createApplicationFromForm(saveClient, application);
        return getApplicationById(save.getApplicationId(), model);
    }

    @GetMapping("/decision.html")
    public String getApplicationById(@PathVariable Long id, Model model) {
        LoanApplication application = loanApplicationService.getApplicationById(id);
        model.addAttribute("application", application);
        return "decision";
    }
}