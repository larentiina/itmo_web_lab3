import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.inject.Named;

import javax.xml.namespace.QName;
import java.io.Serializable;
@Named
@RequestScoped
public class PointData implements Serializable {
    private double coordinateY;
    private double coordinateX;
    private double scaleR;
    private  boolean isHit;
    private  String currentDate;
    private  double scriptRunningTime;

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
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
