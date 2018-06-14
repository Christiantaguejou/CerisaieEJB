package com.projetcerisaie.metiers.dao;

import com.projetcerisaie.metiers.Entities.ActiviteEntity;
import com.projetcerisaie.metiers.Entities.SejoursProposesEntity;
import com.projetcerisaie.metiers.Entities.SejoursReservesEntity;

import javax.persistence.EntityTransaction;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SejourService extends EntityService{

    public SejoursReservesEntity getSejourReservesEntity(int id) {
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        SejoursReservesEntity sejour = entitymanager.find(SejoursReservesEntity.class, id);
        transaction.commit();
        entitymanager.close();
        return sejour;
    }
    public SejoursProposesEntity getSejourProposesEntity(int id) {
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        SejoursProposesEntity sejour = entitymanager.find(SejoursProposesEntity.class, id);
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

    public  List<SejoursReservesEntity> getSejoursReservesByClient(int numCLi){
        List<SejoursReservesEntity> sejoursReservesEntity = null ;
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        sejoursReservesEntity = (List<SejoursReservesEntity>) entitymanager.createQuery("select a from SejoursReservesEntity a where a.clientEntity.numCli =" + String.valueOf(numCLi)).getResultList();
        entitymanager.close();
        return sejoursReservesEntity;
    }


    public SejoursReservesEntity getActiveSejour(int numCLi){
    List<SejoursReservesEntity> sejoursReservesEntities = getSejoursReservesByClient(numCLi);
    if(sejoursReservesEntities != null){
        for (SejoursReservesEntity sejour:sejoursReservesEntities) {
            java.util.Date dateFinSej = new java.util.Date(sejour.getDateFinSej().getTime());
            java.util.Date today = new java.util.Date();
            if(dateFinSej.compareTo(today) > 0) return sejour;
        }
    }
        return null;
    }

}
