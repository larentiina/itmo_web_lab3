package models;

import db.DataBaseManager;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import models.PointData;
import utils.AreaChecker;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
@Named
@Model
public class PointsList implements Serializable {
    @Inject
    private PointData pointData;
    private final DataBaseManager dbManager;

    private List<PointData> pointsList;

    public PointsList() {
        pointData = new PointData();
        dbManager = new DataBaseManager();
        pointsList = Collections.synchronizedList(dbManager.loadPoints());
    }


    public synchronized void addPoint(){
        System.out.println("add");
        long startTime = System.currentTimeMillis();
        PointData point = new PointData();
        point.setCoordinateX(pointData.getCoordinateX());
        point.setCoordinateY(pointData.getCoordinateY());
        point.setScaleR(pointData.getScaleR());
        point.setIsHit(AreaChecker.areaCheck(point.getCoordinateX(), point.getCoordinateY(), point.getScaleR()));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        point.setCurrentDate(dateFormat.format(date));
        long endTime = System.currentTimeMillis();
        double totalTime = (double)(endTime - startTime)/1000;
        point.setScriptRunningTime(totalTime);
        pointsList.add(point);
        dbManager.savePoint(point);

    }
    public synchronized List<PointData> getPointsList() {
        return pointsList;
    }
    public String clearList(){
        System.out.println("clear");
        pointsList = Collections.synchronizedList(new LinkedList<>());
        dbManager.clearPoints();
        return null;
    }

}
