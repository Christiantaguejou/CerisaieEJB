package com.projetcerisaie.metiers.dao;

import com.projetcerisaie.metiers.Entities.ActiviteEntity;
import com.projetcerisaie.metiers.Entities.SejoursProposesEntity;
import com.projetcerisaie.metiers.Entities.SejoursReservesEntity;

import javax.persistence.EntityTransaction;
import java.util.List;

public class SejourService extends EntityService{

    public SejoursReservesEntity getSejourEntity(int id) {
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        SejoursReservesEntity sejour = entitymanager.find(SejoursReservesEntity.class, id);
        transaction.commit();
        entitymanager.close();
        return sejour;
    }

    public List<SejoursProposesEntity> geSejoursProposes() {
        List<SejoursProposesEntity> activities = null;
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        activities = (List<SejoursProposesEntity>) entitymanager.createQuery("select a from SejoursProposesEntity a ").getResultList();
        entitymanager.close();
        return activities;
    }

}
