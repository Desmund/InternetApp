package Structures;

/**
 * Created by Denis on 20.10.2014.
 */
public class WeatherStruct {
    private double lon;
    private double lat;
    private long sunrise;
    private long sunset;
    private String weather;
    private double temp;
    private double tempMin;
    private double tempMax;
    private double pressure;
    private byte humidity;
    private double windSpeed;
    private double windDeg;

    public WeatherStruct(double lon, double lat, long sunrise, long sunset, String weather, double temp, double tempMin, double tempMax, double pressure, byte humidity, double windSpeed, double windDeg) {
        this.lon = lon;
        this.lat = lat;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.weather = weather;
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
    }
}
