package models;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.inject.Named;
import jakarta.persistence.*;


import java.io.Serializable;
@Named
@ApplicationScoped
@Entity
public class PointData implements Serializable {
    @Id
    @GeneratedValue
    private int id;
   @Column(nullable = false)
    private Double coordinateY;
   @Column(nullable = false)
    private Double coordinateX;
   @Column(nullable = false)
    private double scaleR;
    @Column(nullable = false)
    private  boolean isHit;
    @Column(nullable = false)
    private  String currentDate;
    @Column(nullable = false)
    private  double scriptRunningTime;

    public Double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(Double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public Double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(Double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getScaleR() {
        return scaleR;
    }

    public void setScaleR(double scaleR) {
        this.scaleR = scaleR;
    }

    public boolean getIsHit() {
        return isHit;
    }

    public void setIsHit(boolean isHit) {
        this.isHit = isHit;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public double getScriptRunningTime() {
        return scriptRunningTime;
    }

    public void setScriptRunningTime(double scriptRunningTime) {
        this.scriptRunningTime = scriptRunningTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }
}
