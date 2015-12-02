/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlsearchweather;

/**
 *
 * @author Jacopo
 * @La classe 'Luogo' viene utilizzata per ottenere la latitudine e la longitudine.L'attributo 'stringaFormattata' mi permette 
 * di vedere più informazioni rispetto al luogo che inserisco.
 * 
 */
public class Luogo {
    private double lat, lng;
    private String stringaFormattata;

    public Luogo(double lat, double lng, String stringaFormattata) {
        this.lat = lat;
        this.lng = lng;
        this.stringaFormattata = stringaFormattata;
    }


    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
    
    
}
