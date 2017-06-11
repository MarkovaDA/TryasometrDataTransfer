package su.vistar.tryasometrdatatransfer.mapper;

import java.util.List;
import java.util.Map;
import su.vistar.tryasometrdatatransfer.model.Acceleration;
import su.vistar.tryasometrdatatransfer.model.Info;
import su.vistar.tryasometrdatatransfer.model.Location;

public class SensorDataProvider {

    public String insertListOfLocations(Map params) {

        List<Location> locations = (List<Location>) params.get("list");
        StringBuilder query
                = new StringBuilder("INSERT INTO tryasometr_v2.current_locations (lon,lat,deviceImei,dateTime) VALUES ");
        String comma = ",";
        String leftBkt = "(";
        String rightBkt = ")";
        locations.forEach(point -> query
                .append(leftBkt)
                .append(point.getLon())
                .append(comma)
                .append(point.getLat())
                .append(comma)
                .append("'" + point.getDeviceImei() + "'")
                .append(comma)
                .append("'" + point.getDataTime() + "'")
                .append(rightBkt)
                .append(comma)
        );
        query.deleteCharAt(query.length() - 1);
        return query.toString();
    }
    
    //вставка набора ускорений
    public String insertListOfAccelerations(Map params) {
        List<Acceleration> accelerations = (List<Acceleration>) params.get("list");
        StringBuilder query
                = new StringBuilder("INSERT INTO tryasometr_v2.current_accelerations (accelX,accelY,accelZ,deviceImei,dateTime,lat,lon) VALUES ");
        String comma = ",";
        String leftBkt = "(";
        String rightBkt = ")";
        accelerations.forEach(point -> query
                .append(leftBkt)
                .append(point.getAccelX())
                .append(comma)
                .append(point.getAccelY())
                .append(comma)
                .append(point.getAccelZ())
                .append(comma)
                .append("'")
                .append(point.getDeviceImei())
                .append("'")
                .append(comma)
                .append("'")
                .append(point.getDataTime())
                .append("'")
                .append(comma)
                .append(point.getLat())
                .append(comma)
                .append(point.getLon())
                .append(rightBkt)
                .append(comma)
        );
        query.deleteCharAt(query.length() - 1);
        return query.toString();
    }

    //вставка набора служебной информации
    public String insertListOfInfoObjects(Map params) {
        List<Info> infoObjects = (List<Info>) params.get("list");
        StringBuilder query
                = new StringBuilder("INSERT INTO tryasometr_v2.useful_info (dataTime,type) VALUES ");
        String comma = ",";
        String leftBkt = "(";
        String rightBkt = ")";
        infoObjects.forEach(obj -> query
                .append(leftBkt)
                .append("'")
                .append(obj.getDataTime())
                .append("'")
                .append(comma)
                .append("'")
                .append(obj.getType())
                .append("'")
                .append(rightBkt)
                .append(comma)
        );
        query.deleteCharAt(query.length() - 1);
        return query.toString();
    }
}
