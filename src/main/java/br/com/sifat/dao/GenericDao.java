package br.com.sifat.dao;

import br.com.sifat.GsonUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class GenericDao<E, I extends Serializable> {

    @PersistenceContext
    private EntityManager em;

    private Class<E> entityClass;

    public GenericDao(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public List<E> listar() {

        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<E> criteria = builder.createQuery(entityClass);

        criteria.from(entityClass);

        return this.em.createQuery(criteria).getResultList();
    }

    public E criar(E e) {
        this.em.persist(e);
        return e;
    }

    public E atualizar(E e) {

        GsonUtil.toJson(e);
        System.out.println("merge");
        e = this.em.merge(e);
        return e;
    }

    public void remover(E e) {
        this.em.remove(e);
    }

    public E find(I id) {
        return this.em.find(entityClass, id);
    }

    public E find(E e) {
        return this.em.find(entityClass, e);
    }
}
