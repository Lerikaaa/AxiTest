package org.example.myapp.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "loan_applications")
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long applicationId; // Уникальный идентификатор заявки

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client; // Ссылка на клиента, который подал заявку

    @Column(name = "desired_amount", nullable = false)
    private BigDecimal desiredAmount; // Желаемая сумма кредита

    @Column(name = "employment_period")
    private String employmentPeriod; // Период работы клиента

    @Column(name = "position")
    private String position; // Должность клиента

    @Column(name = "organization_name")
    private String organizationName; // Название организации, где работает клиент

    @Column(name = "custom_field")
    private String customField; // Кастомное поле для дополнительных данных

    @Column(name = "application_date", nullable = false)
    private LocalDateTime applicationDate; // Дата подачи заявки

    @Column(name = "decision_status")
    private String decisionStatus; // Статус решения по заявке

    @Column(name = "approved_amount")
    private BigDecimal approvedAmount; // Одобренная сумма кредита

    @Column(name = "loan_term_days")
    private Integer loanTermDays; // Срок кредита в днях

    // Геттеры и сеттеры

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getDesiredAmount() {
        return desiredAmount;
    }

    public void setDesiredAmount(BigDecimal desiredAmount) {
        this.desiredAmount = desiredAmount;
    }

    public String getEmploymentPeriod() {
        return employmentPeriod;
    }
    public void setEmploymentPeriod(String employmentPeriod) {
        this.employmentPeriod = employmentPeriod;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getCustomField() {
        return customField;
    }

    public void setCustomField(String customField) {
        this.customField = customField;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String  getDecisionStatus() {
        return decisionStatus;
    }

    public void setDecisionStatus(String decisionStatus) {
        this.decisionStatus = decisionStatus;
    }

    public boolean isApproved(){
        return decisionStatus.equals("Одобрено");
    }


    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(BigDecimal approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public Integer getLoanTermDays() {
        return loanTermDays;
    }

    public void setLoanTermDays(Integer loanTermDays) {
        this.loanTermDays = loanTermDays;
    }
}
