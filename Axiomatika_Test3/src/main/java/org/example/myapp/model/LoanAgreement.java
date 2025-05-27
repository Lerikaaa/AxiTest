package org.example.myapp.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "loan_agreements")
public class LoanAgreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agreement_id", nullable = false)
    private Long agreementId; // Уникальный идентификатор кредитного договора

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private LoanApplication application; // Ссылка на заявку, к которой относится договор

    @Column(name = "signing_date")
    private LocalDateTime signingDate; // Дата подписания договора

    @Column(name = "signature_status")
    private String signatureStatus; // Статус подписи ('signed' или 'unsigned')

    // Геттеры и сеттеры
    public Long getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(Long agreementId) {
        this.agreementId = agreementId;
    }

    public LoanApplication getApplication() {
        return application;
    }

    public void setApplication(LoanApplication application) {
        this.application = application;
    }

    public String getSigningDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return signingDate.format(formatter);
    }

    public void setSigningDate(LocalDateTime signingDate) {
        this.signingDate = signingDate;
    }

    public String getSignatureStatus() {
        return signatureStatus;
    }

    public boolean isSigned(){
        return signatureStatus.equals("Подписан");
    }

    public void setSignatureStatus(String signatureStatus) {
        this.signatureStatus = signatureStatus;
    }
}
