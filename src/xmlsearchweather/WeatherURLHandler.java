/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlsearchweather;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Jacopo
 * @Nella classe WeatherURLHandler inserisco tutto ciò che mi serve per la connessione ad una stazione meteo. Devo generare
 * l'URL passandoli come parametro il luogo che scelgo e inoltre passansoli all'interno i parametri utili per la ricerca di quel
 * determinato posto.
 */
public class WeatherURLHandler {
    private static final String URL_PREFIX = "http://api.openweathermap.org/data/2.5/weather?";
    private static final String LATITUDE_PREFIX = "lat=";
    private static final String LONGITUDE_PREFIX = "&lon=";
    private static final String METRIC_UNITS = "&units=metric";
    private static final String APP_ID ="&appid=2de143494c0b295cca9337e1e96b00e0";
    private static final String XML_MODE = "&mode=xml";
    
    private static URL URL;
    
    

   
    public static URL generateURL(Luogo location) {
        //create URL String
        StringBuilder URLBuilder = new StringBuilder(URL_PREFIX);
        URLBuilder.append(LATITUDE_PREFIX);
        URLBuilder.append(location.getLat());
        URLBuilder.append(LONGITUDE_PREFIX);
        URLBuilder.append(location.getLng());
        URLBuilder.append(METRIC_UNITS);
        URLBuilder.append(APP_ID);
        URLBuilder.append(XML_MODE);
        
        try {
            //conversione a URL
            URL = new URL(URLBuilder.toString());
        } catch (MalformedURLException ex) {
            System.out.println("URL conversion error");
            return null;
        }       
        return URL;
    }
    
}
