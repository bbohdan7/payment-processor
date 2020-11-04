package ua.gov.bank.services;

import ua.gov.bank.model.Payment;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PaymentService extends Service<Payment> {

    @PersistenceContext(unitName = "PaymentsPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public PaymentService() {
        super(Payment.class);
    }


}
