package ifpb.edu.br.celebinoandroidapp.Entities;

/**
 * Created by gabri on 15/04/2017.
 */
public class Garden {

    private Long id;
    private User user;
    private int soilHumidity;
    private int sunLight;
    private int airHumidity;
    private int airTemperature;

    public Garden(){}

    public Garden(Long id, User user, int soilHumidity, int sunLight, int airHumidity, int airTemperature) {
        super();
        this.id = id;
        this.user = user;
        this.soilHumidity = soilHumidity;
        this.sunLight = sunLight;
        this.airHumidity = airHumidity;
        this.airTemperature = airTemperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSoilHumidity() {
        return soilHumidity;
    }

    public void setSoilHumidity(int soilHumidity) {
        this.soilHumidity = soilHumidity;
    }

    public int getSunLight() {
        return sunLight;
    }

    public void setSunLight(int sunLight) {
        this.sunLight = sunLight;
    }

    public int getAirHumidity() {
        return airHumidity;
    }

    public void setAirHumidity(int airHumidity) {
        this.airHumidity = airHumidity;
    }

    public int getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(int airTemperature) {
        this.airTemperature = airTemperature;
    }

    public String toString() {
        return "Garden " + id+ ": Soil Humidity=" + soilHumidity + ", Sun Light=" + sunLight
                + ", Air Humidity=" + airHumidity + ", Air Temperature=" + airTemperature ;
    }
}
