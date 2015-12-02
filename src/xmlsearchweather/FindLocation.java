/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlsearchweather;

import java.awt.Point;

/**
 *
 * @author Jacopo
 */
public class FindLocation {

    private String indirizzo;
    private double latitudine, longitudine;
    private Forecast forecast;

    public FindLocation(String nome) {
        this.indirizzo = nome;
    }

    public FindLocation(String nome, double latitudine, double longitudine) {
        this.indirizzo = nome;
        latitudine = latitudine;
        longitudine = longitudine;
    }

    public String getNome() {
        return indirizzo;
    }

    public void setNome(String nome) {
        this.indirizzo = nome;
    }

    public String getLatitudine() {
        return String.valueOf(latitudine);
    }

    public String getLongitudine() {
        return String.valueOf(longitudine);
    }

    public Point.Double getCoordinate() {
        return new Point.Double(latitudine, longitudine);
    }

    public void setCoordinate(Point.Double coordinate) {
        latitudine = coordinate.getX();
        longitudine = coordinate.getY();
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public Forecast getForecast() {
        return forecast;
    }

    @Override
    public String toString() {
        return "Indirizzo: " + indirizzo + "\nLatitudine: " + latitudine + "\nLongitudine: " + longitudine;
    }
}
