package com.projetcerisaie.metiers.dao;

import com.projetcerisaie.metiers.Entities.SejoursReservesEntity;

import javax.persistence.EntityTransaction;

public class SejourService extends EntityService{

    public SejoursReservesEntity getSejourEntity(int id) {
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        SejoursReservesEntity sejour = entitymanager.find(SejoursReservesEntity.class, id);
        transaction.commit();
        entitymanager.close();
        return sejour;
    }

}
