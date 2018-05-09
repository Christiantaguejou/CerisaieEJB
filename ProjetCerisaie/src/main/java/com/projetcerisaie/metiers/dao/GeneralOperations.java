package com.projetcerisaie.metiers.dao;

import com.projetcerisaie.metiers.meserreurs.MonException;

import javax.persistence.EntityTransaction;

public class GeneralOperations extends EntityService {
    public void insert(Object object) throws MonException {
        EntityTransaction transac = startTransaction();
        transac.begin();
        entitymanager.persist(object);
        transac.commit();
        entitymanager.close();
    }

    public void modify(Object object) throws MonException {
        EntityTransaction transac = startTransaction();
        transac.begin();
        entitymanager.merge(object);
        transac.commit();
        entitymanager.close();
    }

    public boolean delete(Object object) {
        EntityTransaction transac = startTransaction();
        transac.begin();
        entitymanager.remove(entitymanager.merge(object));
        transac.commit();
        entitymanager.close();
        return true;
    }
}
