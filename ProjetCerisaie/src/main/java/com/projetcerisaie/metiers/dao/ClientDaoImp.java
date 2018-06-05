package com.projetcerisaie.metiers.dao;

import com.projetcerisaie.metiers.Entities.ClientEntity;
import com.projetcerisaie.metiers.Entities.SejoursReservesEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public class ClientDaoImp extends EntityService implements ClientDao{
    /*@PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;*/


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

    public ClientEntity getClientEntity(int id) {
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        ClientEntity client = entitymanager.find(ClientEntity.class, id);
        transaction.commit();
        entitymanager.close();
        return client;
    }

    public ClientEntity autenticate(String user, String password){
        ClientEntity client = null;
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        client = (ClientEntity) entitymanager.createQuery("select c from ClientEntity c where c.username = " + user + " and c.password = " + password + " order by numCli DESC").getResultList().get(0);
        transaction.commit();
        entitymanager.close();
        return client;
    }
}
