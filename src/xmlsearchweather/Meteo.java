/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlsearchweather;

/**
 *
 * @author Jacopo
 * @La classe meteo mi permette di ottere le varie temeperature e la previsione.
 */
public class Meteo {

    private String minima, massima, temperatura, previsione;

    public Meteo(String minima, String massima, String temperatura, String previsione) {
        this.minima = minima;
        this.massima = massima;
        this.temperatura = temperatura;
        this.previsione = previsione;
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

    public String getPrevisone() {
        return previsione;
    }

    public void setPrevisone(String previsone) {
        this.previsione = previsone;
    }

    @Override
    public String toString() {
        return previsione + "\nTemperatura: " + temperatura + " °C\n" + "Massima: " + massima + " °C\n" + "Minima: " + minima + " °C";
    }

}
