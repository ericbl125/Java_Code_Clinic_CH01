package com.eric.project;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherEntry {
    // date       time    	Air_Temp	Barometric_Press	Dew_Point	Relative_Humidity	Wind_Dir	Wind_Gust	Wind_Speed
    // These are all the headers from the file.  Will only need to keep a handful for calculating the barometric pressure coefficient

    private LocalDateTime ldt;
    private String airTemp;
    private String baroPress;
    private String dew;
    private String humidity;
    private String windDir;
    private String windGust;
    private String windSpeed;

    private DateTimeFormatter pattern =  DateTimeFormatter.ofPattern("yyyy_MM_dd HH:mm:ss");

    public WeatherEntry(String[] input) {
        int i = 0;
        this.ldt = LocalDateTime.parse(input[i++], pattern);
        this.airTemp = input[i++];
        this.baroPress = input[i++];
        this.dew = input[i++];
        this.humidity = input[i++];
        this.windDir= input[i++];
        this.windGust = input[i++];
        this.windSpeed = input[i];
    }

    public LocalDateTime getDateTime() { return ldt; }

    public void setDateTime(LocalDateTime date) {
        this.ldt = date;
    }

    public String getAirTemp() {
        return airTemp;
    }

    public void setAirTemp(String airTemp) {
        this.airTemp = airTemp;
    }

    public String getBaroPress() {
        return baroPress;
    }

    public void setBaroPress(String baroPress) {
        this.baroPress = baroPress;
    }

    public String getDew() {
        return dew;
    }

    public void setDew(String dew) {
        this.dew = dew;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public String getWindGust() {
        return windGust;
    }

    public void setWindGust(String windGust) {
        this.windGust = windGust;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
}
