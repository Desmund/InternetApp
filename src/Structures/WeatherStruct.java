package Structures;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Denis on 20.10.2014.
 */
public class WeatherStruct {
    private double lon;
    private double lat;
    private String weather;
    private double temp;
    private double tempMin;
    private double tempMax;
    private double pressure;
    private byte humidity;
    private double windSpeed;
    private double windDeg;

    public WeatherStruct(double lon, double lat, String weather, double temp, double tempMin, double tempMax, double pressure, byte humidity, double windSpeed, double windDeg) {
        this.lon = lon;
        this.lat = lat;
        this.weather = weather;
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
    }

    public WeatherStruct() {
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public byte getHumidity() {
        return humidity;
    }

    public void setHumidity(byte humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(double windDeg) {
        this.windDeg = windDeg;
    }

    @Override
    public String toString() {
        SimpleDateFormat f = new SimpleDateFormat("hh.mm.ss");
        return  "Широта=" + lon + '\n' +
                "Долгота=" + lat + '\n' +
                "Погода=" + weather +  '\n' +
                "Темп.(в цельсиях)=" + (int)(temp-273.15) + '\n' +
                "Мин. темп. (в цельсиях)=" + (int)(tempMin-273.15) + '\n' +
                "Макс. темп. (в цельсиях)=" + (int)(tempMax-273.15) + '\n' +
                "Давление (hPa)=" + pressure + '\n' +
                "Влажность (%)=" + humidity + '\n' +
                "Скор. ветра (м/с)=" + windSpeed + '\n' +
                "Направл. ветра (в градусах)=" + windDeg;
    }
}
