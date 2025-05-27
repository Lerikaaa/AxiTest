package org.example.myapp;
import org.example.myapp.service.ClientService;
import org.example.myapp.service.LoanApplicationService;
import org.example.myapp.service.LoanAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApp {

    private final ClientService clientService;
    private final LoanApplicationService loanApplicationService;
    private final LoanAgreementService loanAgreementService;

    @Autowired
    public MyApp(ClientService clientService, LoanApplicationService loanApplicationService, LoanAgreementService loanAgreementService) {
        this.clientService = clientService;
        this.loanApplicationService = loanApplicationService;
        this.loanAgreementService = loanAgreementService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
