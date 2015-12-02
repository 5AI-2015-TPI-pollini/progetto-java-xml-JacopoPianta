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
public class Forecast {
      
    private String nome;
    private String temperatura;
    private String massima;
    private String minima;
    private String clouds;

    public Forecast(String nome, String temperatura, String massima, String manima, String clouds) {
        this.nome = nome;
        this.temperatura = temperatura;
        this.massima = massima;
        this.minima = minima;
        this.clouds = clouds;
    }

    public String getNome() {
        return nome;
    }

    public String getTemperatura() {
        return temperatura.substring(0,temperatura.indexOf(".")+1) + "°C";
    }

    public String getMassima() {
        return massima.substring(0,massima.indexOf(".")+1) + "°C";
    }

    public String getMinima() {
        return minima.substring(0,minima.indexOf(".")+1) + "°C";
    }

    public String getClouds() {
        return clouds;
    }

    @Override
    public String toString() {
        return "Forecast (" + "Name = " + nome + ", Temperature = " + temperatura + "°C" + ", Min = " + minima + "°C" + ", Max = " + massima + "°C" + ", Clouds = " + clouds + ")" ;
    }
    
    
}

