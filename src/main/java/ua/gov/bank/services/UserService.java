package ua.gov.bank.services;

import ua.gov.bank.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserService extends Service<User> {

    @PersistenceContext(unitName = "PaymentsPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public UserService() {
        super(User.class);
    }

}
