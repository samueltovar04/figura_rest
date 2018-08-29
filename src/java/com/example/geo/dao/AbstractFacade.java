/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.geo.dao;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author stovar
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public Boolean create(T entity) {
        try{
             getEntityManager().persist(entity);
             return true;
        }catch(Exception ex){
            System.out.println("Error");
            System.out.println(ex);
            return false;
        }
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        System.out.println(getEntityManager().find(entityClass, id));
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        // System.out.println(getEntityManager().createQuery(cq).getResultList());
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public List<T> findWithNamedQuery(String namedQueryName) {
    return getEntityManager().createNamedQuery(namedQueryName).getResultList();
  }

  public List findWithNamedQuery(String namedQueryName, Map<String, Object> parameters, int resultLimit) {
    Set<Map.Entry<String, Object>> rawParameters = parameters.entrySet();
    Query query = getEntityManager().createNamedQuery(namedQueryName);
    if (resultLimit > 0) {
      query.setMaxResults(resultLimit);
    }
    for (Map.Entry<String, Object> entry : rawParameters) {
      query.setParameter(entry.getKey(), entry.getValue());
    }
    return query.getResultList();
  }

  public List<T> findWithQuery(String queryName) {
    return getEntityManager().createQuery(queryName).getResultList();
  }

  public List<T> findByNativeQuery(String sql) {
    return getEntityManager().createNativeQuery(sql, entityClass).getResultList();
  }

  public T findSingleWithNamedQuery(String namedQueryName) {
    T result = null;
    try {
      result = (T) getEntityManager().createNamedQuery(namedQueryName).getSingleResult();
    } catch (NoResultException e) {
    }
    return result;
  }

  public T findSingleWithNamedQuery(String namedQueryName, Map<String, Object> parameters) {
    Set<Map.Entry<String, Object>> rawParameters = parameters.entrySet();
    Query query = getEntityManager().createNamedQuery(namedQueryName);
    for (Map.Entry<String, Object> entry : rawParameters) {
      query.setParameter(entry.getKey(), entry.getValue());
    }
    T result = null;
    try {
      result = (T) query.getSingleResult();
    } catch (NoResultException e) {
    }
    return result;
}
    
}