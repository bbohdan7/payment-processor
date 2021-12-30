package ua.gov.bank.services;

import ua.gov.bank.model.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmployeeService extends Service<Employee> {

    @PersistenceContext
    private EntityManager em;

    public EmployeeService() {
        super(Employee.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
}
