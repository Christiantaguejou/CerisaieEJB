

import Entities.ActiviteEntity;
import dao.ActivityService;
import meserreurs.MonException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class test {
    protected EntityManager entitymanager;
    protected EntityManagerFactory emf;

    public EntityTransaction startTransaction() {
        emf = Persistence.createEntityManagerFactory("PInscription");
        entitymanager = emf.createEntityManager();

        return entitymanager.getTransaction();
    }

    public static void main(String[] args) throws MonException, ParseException {
        ActivityService activityService = new ActivityService();
        ActiviteEntity activiteEntity =activityService.getSpecificEntities(1,convertStringToDate("10/02/2018"),1);
        System.out.println(activiteEntity);
    }

    public static Date convertStringToDate(String date) throws ParseException {
        java.util.Date initDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String parsedDate = formatter.format(initDate);
        initDate = formatter.parse(parsedDate);
        return new Date(initDate.getTime());
    }
}
