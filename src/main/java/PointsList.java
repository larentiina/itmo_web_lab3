import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

@SessionScoped
@Named
public class PointsList implements Serializable {
    @Inject
    private PointData pointData;
    private LinkedList<PointData> pointsList = new LinkedList<>();

    public void addPoint(){
        long startTime = System.currentTimeMillis();
        PointData point = new PointData();
        point.setCoordinateX(pointData.getCoordinateX());
        point.setCoordinateY(pointData.getCoordinateY());
        point.setScaleR(pointData.getScaleR());
        point.setIsHit(AreaChecker.areaCheck(point.getCoordinateX(), point.getCoordinateY(), point.getScaleR()));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        point.setCurrentDate(dateFormat.format(date));
        System.out.println(2);
        System.out.println(dateFormat.format(date));
        long endTime = System.currentTimeMillis();
        double totalTime = (double)(endTime - startTime)/1000;
        point.setScriptRunningTime(totalTime);
        pointsList.add(point);
    }

    public LinkedList<PointData> getPointsList() {

        return pointsList;
    }
    public String clearList(){
        pointsList = new LinkedList<>();
        return null;
    }

}
