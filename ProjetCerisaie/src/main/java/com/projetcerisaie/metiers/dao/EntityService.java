package com.projetcerisaie.metiers.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by Valentin on 06/04/2016.
 */
public abstract class EntityService {

    protected EntityManager entitymanager;
    protected EntityManagerFactory emf;

    public EntityTransaction startTransaction() {
        emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        entitymanager = emf.createEntityManager();

        return entitymanager.getTransaction();
    }

}