/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlsearchweather;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/**
 *
 * @author Jacopo
 */
public class XMLSearchWeather {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, XPathExpressionException {
        // TODO code application logic here
        ReadingURL urlReader = new ReadingURL();
        
        Luogo brescia = urlReader.scaricaLuogo("brescia");
        Meteo meteo = urlReader.scaricaMeteo(brescia);
        System.out.println(meteo);
    }
    
}
