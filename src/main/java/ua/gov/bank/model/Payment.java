package ua.gov.bank.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "payments")
public class Payment implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "amount")
    private Float amount;

    @OneToOne
    @JoinColumn(name = "source_user_id", referencedColumnName = "id")
    private User payer;

    @OneToOne
    @JoinColumn(name = "destination_user_id", referencedColumnName = "id")
    private User payee;

    @OneToOne
    @JoinColumn(name = "source_account_id", referencedColumnName = "id")
    private Account payerAccount;

    @OneToOne
    @JoinColumn(name = "destination_account_id", referencedColumnName = "id")
    private Account payeeAccount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public User getPayee() {
        return payee;
    }

    public void setPayee(User payee) {
        this.payee = payee;
    }

    public Account getPayerAccount() {
        return payerAccount;
    }

    public void setPayerAccount(Account payerAccount) {
        this.payerAccount = payerAccount;
    }

    public Account getPayeeAccount() {
        return payeeAccount;
    }

    public void setPayeeAccount(Account payeeAccount) {
        this.payeeAccount = payeeAccount;
    }
}
