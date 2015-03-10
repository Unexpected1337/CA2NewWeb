/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Hobby;
import entity.InfoEntity;
import entity.Person;
import facade.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Afrooz
 */
public class EntityFacade implements Serializable {

    public EntityFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Person createPerson(Person person) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return person;
    }

    public List<Person> getPersons() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<Person> q = em.createQuery("select persons from Person persons", Person.class); //JPQL hedder sproget 
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Person addHobby(Person person, Hobby h) {
        person.addHobby(h);
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return person;
    }
    
    public Person addHobbyFromId(int personId, Hobby h) {

        EntityManager em = null;

        try {
            em = getEntityManager();
            Person p = em.find(Person.class, personId); //nullpointerException
            p.addHobby(h);
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            return p;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
    }
 

    public void edit(InfoEntity infoEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            infoEntity = em.merge(infoEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = infoEntity.getId();
                if (findInfoEntity(id) == null) {
                    throw new NonexistentEntityException("The infoEntity with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            InfoEntity infoEntity;
            try {
                infoEntity = em.getReference(InfoEntity.class, id);
                infoEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The infoEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(infoEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InfoEntity> findInfoEntityEntities() {
        return findInfoEntityEntities(true, -1, -1);
    }

    public List<InfoEntity> findInfoEntityEntities(int maxResults, int firstResult) {
        return findInfoEntityEntities(false, maxResults, firstResult);
    }

    private List<InfoEntity> findInfoEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InfoEntity.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public InfoEntity findInfoEntity(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InfoEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getInfoEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InfoEntity> rt = cq.from(InfoEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
