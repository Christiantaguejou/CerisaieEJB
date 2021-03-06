package dao;



import Entities.ActiviteEntity;
import Entities.SejoursReservesEntity;
import Entities.SportEntity;
import models.Activity;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityService extends EntityService {

    SportService sportService = new SportService();
    SejourService sejourService = new SejourService();
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
                sejour = sejourService.getSejourReservesEntity(idSejour);
                sejourEntityMap.put(idSejour, sejour);
            }
            if (sportEntityMap.containsKey(idSport)) {
                sport = sportEntityMap.get(idSport);
            } else {
                sport = sportService.getSportEntity(idSport);
                sportEntityMap.put(idSport, sport);
            }
            activities.add(new Activity(entity, sejour, sport));
        }
        return activities;
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

    public  ActiviteEntity getSpecificEntities(int codeSport, Date dateInscription, int numSejRes){
        ActiviteEntity activities = null;
        try{

            EntityTransaction transaction = startTransaction();
            transaction.begin();
            activities = (ActiviteEntity) entitymanager.createQuery("select a from ActiviteEntity a where a.sport.codeSport = " + codeSport + " and a.dateJour = "+ dateInscription + " and a.sejoursReservesEntity.numResa = "+ numSejRes).getSingleResult();
            entitymanager.close();
        }catch (NoResultException e){
            return null;
        }

        return activities;
    }

}
