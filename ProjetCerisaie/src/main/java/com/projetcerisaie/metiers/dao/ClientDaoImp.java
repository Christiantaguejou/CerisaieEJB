package com.projetcerisaie.metiers.dao;

import com.projetcerisaie.metiers.Entities.ClientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public class ClientDaoImp implements ClientDao{
    /*@PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;*/

    protected EntityManager entitymanager;
    protected EntityManagerFactory emf;
    public EntityTransaction startTransaction() {
        emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        entitymanager = emf.createEntityManager();

        return entitymanager.getTransaction();
    }

    @Override
    public void add(ClientEntity clientEntity) {
        EntityTransaction transac = startTransaction();
        transac.begin();
        entitymanager.persist(clientEntity);
        transac.commit();
        entitymanager.close();
        //em.persist(clientEntity);
    }

    @Override
    public List<ClientEntity> listClients() {
        /*CriteriaQuery<ClientEntity> criteriaQuery = em.getCriteriaBuilder().createQuery(ClientEntity.class);
        @SuppressWarnings("unused")
        Root<ClientEntity> root = criteriaQuery.from(ClientEntity.class);
        return em.createQuery(criteriaQuery).getResultList();*/
        EntityTransaction transac = startTransaction();
        transac.begin();
        CriteriaQuery<ClientEntity> criteriaQuery = entitymanager.getCriteriaBuilder().createQuery(ClientEntity.class);
        @SuppressWarnings("unused")
        Root<ClientEntity> root = criteriaQuery.from(ClientEntity.class);
        transac.commit();
        entitymanager.close();
        return entitymanager.createQuery(criteriaQuery).getResultList();
    }
}
