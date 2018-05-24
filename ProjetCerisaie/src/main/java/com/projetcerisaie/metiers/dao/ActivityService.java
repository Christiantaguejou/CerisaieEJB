package com.projetcerisaie.metiers.dao;

import com.projetcerisaie.metiers.Entities.ActiviteEntity;
import com.projetcerisaie.metiers.Entities.SejoursReservesEntity;
import com.projetcerisaie.metiers.Entities.SportEntity;
import com.projetcerisaie.metiers.models.Activity;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityService extends EntityService {

    /**
     * Liste toutes les activités
     * @return Activity
     */
    public List<Activity> listActivities() {
        List<Activity> activities = parseToActivity(getActiviteEntities());
        return activities;
    }

    /**
     * @param idSport identifiant du Sport
     * Liste toutes les activités du sport idSport
     * @return Activity
     */
    public List<Activity> listActivitiesBySport(int idSport) {
        List<Activity> activities = parseToActivity(getActiviteEntitiesBySport(idSport));
        return activities;
    }

    public List<Activity> parseToActivity(List<ActiviteEntity> entities) {
        List<Activity> activities = new ArrayList<>();
        // On fait des hashmap pour éviter d'aller chercher deux fois la même valeur dans la bd
        Map<Integer, SejoursReservesEntity> sejourEntityMap = new HashMap<>();
        Map<Integer, SportEntity> sportEntityMap = new HashMap<>();
        for (ActiviteEntity entity : entities) {
            int idSport = entity.getSport().getCodeSport();
            int idSejour = entity.getSejoursReservesEntity().getNumResa();
            SejoursReservesEntity sejour;
            SportEntity sport;
            if (sejourEntityMap.containsKey(idSejour)) {
                sejour = sejourEntityMap.get(idSejour);
            } else {
                sejour = getSejourEntity(idSejour);
                sejourEntityMap.put(idSejour, sejour);
            }
            if (sportEntityMap.containsKey(idSport)) {
                sport = sportEntityMap.get(idSport);
            } else {
                sport = getSportEntity(idSport);
                sportEntityMap.put(idSport, sport);
            }
            activities.add(new Activity(entity, sejour, sport));
        }
        return activities;
    }

    public SejoursReservesEntity getSejourEntity(int id) {
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        SejoursReservesEntity sejour = entitymanager.find(SejoursReservesEntity.class, id);
        transaction.commit();
        entitymanager.close();
        return sejour;
    }

    public SportEntity getSportEntity(int id) {
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        SportEntity sport = entitymanager.find(SportEntity.class, id);
        transaction.commit();
        entitymanager.close();
        return sport;
    }

    public List<ActiviteEntity> getActiviteEntities() {
        List<ActiviteEntity> activities = null;
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        activities = (List<ActiviteEntity>) entitymanager.createQuery("select a from ActiviteEntity a order by DateJour DESC ").getResultList();
        entitymanager.close();
        return activities;
    }
    public List<ActiviteEntity> getActiviteEntitiesBySport(int idSport) {
        List<ActiviteEntity> activities = null;
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        activities = (List<ActiviteEntity>) entitymanager.createQuery("select a from ActiviteEntity a where a.codeSport = " + idSport + "order by DateJour DESC ").getResultList();
        entitymanager.close();
        return activities;
    }

}
