package com.projetcerisaie.metiers.models;
import com.projetcerisaie.metiers.Entities.*;

public class Activity {
    private ActiviteEntity activityEntity;
    private SejoursReservesEntity sejourEntity;
    private SportEntity sportEntity;

    public Activity() {

    }

    public Activity(ActiviteEntity activityEntity, SejoursReservesEntity sejourEntity, SportEntity sportEntity) {
        this.activityEntity = activityEntity;
        this.sejourEntity = sejourEntity;
        this.sportEntity = sportEntity;
    }

    /**
     * Accesseurs
     */
    public ActiviteEntity getActivityEntity() {
        return activityEntity;
    }

    public void setActivityEntity(ActiviteEntity activityEntity) {
        this.activityEntity = activityEntity;
    }

    public SejoursReservesEntity getSejourEntity() {
        return sejourEntity;
    }

    public void setSejourEntity(SejoursReservesEntity sejourEntity) {
        this.sejourEntity = sejourEntity;
    }

    public SportEntity getSportEntity() {
        return sportEntity;
    }

    public void setSportEntity(SportEntity sportEntity) {
        this.sportEntity = sportEntity;
    }
}
