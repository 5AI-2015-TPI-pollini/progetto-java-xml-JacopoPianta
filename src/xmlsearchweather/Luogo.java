/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlsearchweather;

/**
 *
 * @author Jacopo
 */
public class Luogo {
    private double lat, lng;
    private String stringaFromattata;

    public Luogo(double lat, double lng, String stringaFromattata) {
        this.lat = lat;
        this.lng = lng;
        this.stringaFromattata = stringaFromattata;
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
