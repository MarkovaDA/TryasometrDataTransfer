package su.vistar.tryasometrdatatransfer.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.vistar.tryasometrdatatransfer.model.Section;
import su.vistar.tryasometrdatatransfer.mapper.TryasometrMapper;

@Service
public class PathService {
    
    @Autowired
    TryasometrMapper tryasometrWebMapper;
    private static final double MAX_DISTANCE = 0.001;
     
    //вычисление азимута между двумя точками
    public int evaluateAzimuth(double lat1, double lat2, double lon1, double lon2){
        double phi1 = lat1 * Math.PI/180;
        double phi2 = lat2 * Math.PI /180;
        double delta = (lon2 - lon1) * Math.PI/180;
        double y = Math.sin(delta) * Math.cos(phi2);
        double x = Math.cos(phi1) * Math.sin(phi2) 
                - Math.sin(phi1) * Math.cos(phi2) * Math.cos(delta);
        double sigma = Math.atan2(y, x);
        return (int)((sigma * 180/Math.PI + 360) % 360);
    }
    
    //рассчет евклидова расстояния
    public double euclideanDistance(Double[] point1, Double[] point2){
        return Math.sqrt((point1[0] - point2[0])*(point1[0] - point2[0]) 
               +  (point1[1] - point2[1])*(point1[1] - point2[1]));
    }
       
    public List<Section> getSectionsIntoRectangle(Double[] prevPoint, Double[] nextPoint){
        Double[] bottomPoint = new Double[2];
        Double[] topPoint = new Double[2];
        bottomPoint[0] = Math.min(prevPoint[0], nextPoint[0]) - MAX_DISTANCE;
        bottomPoint[1] = Math.min(prevPoint[1], nextPoint[1]) - MAX_DISTANCE;
        topPoint[0] = Math.max(prevPoint[0], nextPoint[0]) + MAX_DISTANCE;
        topPoint[1] = Math.max(prevPoint[1], nextPoint[1]) + MAX_DISTANCE;
        return tryasometrWebMapper.selectSectionsByBounds(bottomPoint[0], bottomPoint[1], topPoint[0], topPoint[1]);
    }
}
