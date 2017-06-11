package su.vistar.tryasometrdatatransfer.model;


public class Acceleration {
    private Float accelX;
    private Float accelY;
    private Float accelZ;
    private String deviceImei;
    private String dataTime;
    private Double lat;
    private Double lon;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
    
    
    public Float getAccelX() {
        return accelX;
    }

    public void setAccelX(Float accelX) {
        this.accelX = accelX;
    }

    public Float getAccelY() {
        return accelY;
    }

    public void setAccelY(Float accelY) {
        this.accelY = accelY;
    }

    public Float getAccelZ() {
        return accelZ;
    }

    public void setAccelZ(Float accelZ) {
        this.accelZ = accelZ;
    }

    public String getDeviceImei() {
        return deviceImei;
    }

    public void setDeviceImei(String deviceImei) {
        this.deviceImei = deviceImei;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    } 
}
