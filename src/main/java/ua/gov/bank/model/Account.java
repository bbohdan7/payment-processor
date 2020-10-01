package ua.gov.bank.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "balance")
    private Float balance;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
