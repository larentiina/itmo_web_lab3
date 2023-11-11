import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.inject.Named;


import java.io.Serializable;
@Named
@RequestScoped
public class PointData implements Serializable {
    private Double coordinateY;
    private Double coordinateX;
    private double scaleR;
    private  boolean isHit;
    private  String currentDate;
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
}
