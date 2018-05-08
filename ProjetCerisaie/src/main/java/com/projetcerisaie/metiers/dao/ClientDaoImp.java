package com.projetcerisaie.metiers.dao;

import com.projetcerisaie.metiers.Entities.ClientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public class ClientDaoImp implements ClientDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(ClientEntity clientEntity) {
        em.persist(clientEntity);
    }

    @Override
    public List<ClientEntity> listClients() {
        CriteriaQuery<ClientEntity> criteriaQuery = em.getCriteriaBuilder().createQuery(ClientEntity.class);
        @SuppressWarnings("unused")
        Root<ClientEntity> root = criteriaQuery.from(ClientEntity.class);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
