package com.eric.project;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherEntry {
    // date       time    	Air_Temp	Barometric_Press	Dew_Point	Relative_Humidity	Wind_Dir	Wind_Gust	Wind_Speed
    // These are all the headers from the file.  Will only need to keep a handful for calculating the barometric pressure coefficient

    private LocalDateTime dateTime;
    private Double airTemp;
    private Double baroPress;
    private Double dew;
    private Double humidity;
    private Double windDir;
    private Double windGust;
    private Double windSpeed;

    private DateTimeFormatter pattern =  DateTimeFormatter.ofPattern("yyyy_MM_dd HH:mm:ss");

    public WeatherEntry(String[] input) {
        int i = 0;
        this.dateTime = LocalDateTime.parse(input[i++], pattern);
        this.airTemp = Double.valueOf(input[i++]);
        this.baroPress = Double.valueOf(input[i++]);
        this.dew = Double.valueOf(input[i++]);
        this.humidity = Double.valueOf(input[i++]);
        this.windDir= Double.valueOf(input[i++]);
        this.windGust = Double.valueOf(input[i++]);
        this.windSpeed = Double.valueOf(input[i++]);
    }

    public LocalDateTime getDateTime() { return dateTime; }

    public Double getAirTemp() {
        return airTemp;
    }

    public void setAirTemp(Double airTemp) {
        this.airTemp = airTemp;
    }

    public Double getBaroPress() {
        return baroPress;
    }

    public void setBaroPress(Double baroPress) {
        this.baroPress = baroPress;
    }

    public Double getDew() {
        return dew;
    }

    public void setDew(Double dew) {
        this.dew = dew;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getWindDir() {
        return windDir;
    }

    public void setWindDir(Double windDir) {
        this.windDir = windDir;
    }

    public Double getWindGust() {
        return windGust;
    }

    public void setWindGust(Double windGust) {
        this.windGust = windGust;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public DateTimeFormatter getPattern() {
        return pattern;
    }

    public void setPattern(DateTimeFormatter pattern) {
        this.pattern = pattern;
    }
}
