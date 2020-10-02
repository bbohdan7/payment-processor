package ua.gov.bank.services;

import ua.gov.bank.model.Payment;
import ua.gov.bank.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    public List<User> payerData(Integer payerId) {
        return getEntityManager()
                .createNamedQuery("Payment.findByPayer", User.class)
                .setParameter("id", payerId)
                .getResultList();
    }

    public List<User> payeeData(Integer payeeId) {
        return getEntityManager()
                .createNamedQuery("Payment.findByPayee", User.class)
                .setParameter("id", payeeId)
                .getResultList();
    }

}
