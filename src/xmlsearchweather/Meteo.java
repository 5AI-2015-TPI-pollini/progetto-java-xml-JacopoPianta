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
public class Meteo {
    private String minima, massima, temperatura;

    public Meteo(String minima, String massima, String temperatura) {
        this.minima = minima;
        this.massima = massima;
        this.temperatura = temperatura;
    }

    public String getMinima() {
        return minima;
    }

    public void setMinima(String minima) {
        this.minima = minima;
    }

    public String getMassima() {
        return massima;
    }

    public void setMassima(String massima) {
        this.massima = massima;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "Meteo{" + "minima=" + minima + ", massima=" + massima + ", temperatura=" + temperatura + '}';
    }
    
}
