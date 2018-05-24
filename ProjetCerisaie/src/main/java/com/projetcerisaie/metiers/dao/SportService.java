package com.projetcerisaie.metiers.dao;

import com.projetcerisaie.metiers.Entities.SportEntity;

import javax.persistence.EntityTransaction;

public class SportService  extends EntityService{

    public SportEntity getSportEntity(int id) {
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        SportEntity sport = entitymanager.find(SportEntity.class, id);
        transaction.commit();
        entitymanager.close();
        return sport;
    }
}
