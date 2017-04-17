package ifpb.edu.br.celebinoandroidapp.Entities;

import java.security.Timestamp;

/**
 * Created by Ferrão on 17/04/2017.
 */

public class GardenStatus {

    private Long id;

    private Garden garden;


    private int sunLight;

    private int soilHumidity;


    private int airHumidity;


    private int airTemperature;

    private Timestamp time;

    public GardenStatus() {
    }


    public GardenStatus(Long id , Garden garden, int sunLight, int soilHumidity, int airHumidity, int airTemperature,
                        Timestamp time) {
        super();
        this.id = id;
        this.garden = garden;
        this.sunLight = sunLight;
        this.soilHumidity = soilHumidity;
        this.airHumidity = airHumidity;
        this.airTemperature = airTemperature;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Garden getGarden() {
        return garden;
    }

    public void setGarden(Garden garden) {
        this.garden = garden;
    }


    public int getSunLight() {
        return sunLight;
    }

    public void setSunLight(int sunLight) {
        this.sunLight = sunLight;
    }

    public int getSoilHumidity() {
        return soilHumidity;
    }

    public void setSoilHumidity(int soilHumidity) {
        this.soilHumidity = soilHumidity;
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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "garden " + garden.getId() + ": sunLight=" + sunLight + ", soilHumidity="
                + soilHumidity + ", airHumidity=" + airHumidity + ", airTemperature=" + airTemperature + ", time="
                + time ;
    }
}