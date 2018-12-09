import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherEntry{

    //fields to be used from input files

    public String toString(){
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
        return ("Data for: " + format.format(when)
            + " Barometric Pressure: " 
            + Float.toString(pressure) 
            + " Humidity: " + Float.toString(humidity) );
    }
}