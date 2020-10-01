package ua.gov.bank.services;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class Service<T extends Serializable> {

    private Class<T> entityClass;

    protected abstract EntityManager getEntityManager();

    public Service(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public List<T> all() {
        CriteriaQuery query = getEntityManager().getCriteriaBuilder().createQuery();
        query.select(query.from(entityClass));
        return getEntityManager().createQuery(query).getResultList();
    }

    public T find(Integer id) {
        return getEntityManager().find(entityClass, id);
    }

    public void create(T obj) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(obj);
        getEntityManager().getTransaction().commit();
    }

    public void update(T obj) {
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(obj);
        getEntityManager().getTransaction().commit();
    }

    public void delete(T obj) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(obj);
        getEntityManager().getTransaction().commit();
    }
}
