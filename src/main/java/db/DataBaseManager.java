package db;

import jakarta.persistence.*;

import java.util.List;
import models.PointData;


public class DataBaseManager {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private static final String PERSISTENCE_UNIT_NAME = "WebLab";

    public DataBaseManager()
    {
        connection();
        loadPoints();
    }
    private void connection(){
       entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        entityManager = entityManagerFactory.createEntityManager();
        transaction=entityManager.getTransaction();
    }
    public List<PointData> loadPoints() {
        try {
            transaction.begin();
            Query query = entityManager.createQuery("SELECT e FROM PointData e");
            transaction.commit();
            return query.getResultList();
        } catch (RuntimeException exception) {
            System.out.println("error:" + exception.getMessage());
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw exception;
        }
    }
    public void savePoint(PointData pointData){
        try {
            transaction.begin();
            entityManager.persist(pointData);
            transaction.commit();
        }catch (RuntimeException exception) {
            System.out.println("error:" + exception.getMessage());
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }

    }
    public void clearPoints() {
        try {
            transaction.begin();
            Query query = entityManager.createQuery("DELETE FROM PointData");
            query.executeUpdate();
            transaction.commit();
        }catch (RuntimeException exception){
            System.out.println("error:" + exception.getMessage());
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
}
