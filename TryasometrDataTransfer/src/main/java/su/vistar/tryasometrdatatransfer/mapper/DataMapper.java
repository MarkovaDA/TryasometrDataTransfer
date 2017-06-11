
package su.vistar.tryasometrdatatransfer.mapper;

import java.util.List;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import su.vistar.tryasometrdatatransfer.model.Acceleration;
import su.vistar.tryasometrdatatransfer.model.Info;
import su.vistar.tryasometrdatatransfer.model.Location;


public interface DataMapper {
    
    @InsertProvider(type = su.vistar.tryasometrdatatransfer.mapper.SensorDataProvider.class, method="insertListOfLocations")
    void insertListOfLocations(@Param("list")List<Location> list);
    
    @InsertProvider(type = su.vistar.tryasometrdatatransfer.mapper.SensorDataProvider.class, method="insertListOfAccelerations")
    void insertListOfAcceleration(@Param("list")List<Acceleration> list);

    @InsertProvider(type = su.vistar.tryasometrdatatransfer.mapper.SensorDataProvider.class, method="insertListOfInfoObjects")
    void insertListOfInfoObjects(@Param("list")List<Info> list);   
}
