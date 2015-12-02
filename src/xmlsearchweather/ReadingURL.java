/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlsearchweather;

import com.sun.org.apache.xml.internal.security.transforms.params.XPath2FilterContainer;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Jacopo
 */
public class ReadingURL {
    private static final String FORMATTED_ADDRESS = "/GeocodeResponse/result/formatted_address/text()";
    private static final String LATITUDE = "/GeocodeResponse/result/geometry/location/lat/text()";
    private static final String LONGITUDE = "/GeocodeResponse/result/geometry/location/lng/text()";
    
    private static final String CURRENT_TEMPERATURE = "/current/temperature/@value";
    private static final String MIN_TEMPERATURE = "/current/temperature/@min";
    private static final String MAX_TEMPERATURE = "/current/temperature/@max";
    
    public ReadingURL(){}
    
    public Luogo scaricaLuogo (String posto) throws ParserConfigurationException, SAXException, XPathExpressionException {
        try {
            
            URL url = new URL("https://maps.googleapis.com/maps/api/geocode/xml?address" + URLEncoder.encode(posto, "UTF-8"));
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.0.1", 8080));
            URLConnection urlConnection = url.openConnection(proxy);
            InputStream in = urlConnection.getInputStream();
            
            
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xml = builder.parse(in);
            
            // Ora ho il documento xml
            // Devo quindi usare xpath per ricavare le coordinate
            
            XPath xpath = XPathFactory.newInstance().newXPath();
            
            //con xptah prendo la latitudine dal documento
            XPathExpression latExpression = (XPathExpression) xpath.compile(LATITUDE);
            NodeList lats = (NodeList) latExpression.evaluate(xml, XPathConstants.NODESET);
            double lat = Double.parseDouble(lats.item(0).getNodeValue());
            
            //con xptah prendo la longitudine dal documento
            XPathExpression lngExpression = (XPathExpression) xpath.compile(LONGITUDE);
            NodeList lngs = (NodeList) latExpression.evaluate(xml, XPathConstants.NODESET);
            double lng = Double.parseDouble(lats.item(0).getNodeValue());
            //ricavo la stringa formattata
            XPathExpression nameExpression= (XPathExpression) xpath.compile(FORMATTED_ADDRESS);
            NodeList names = (NodeList) latExpression.evaluate(xml, XPathConstants.NODESET);
            String name = names.item(0).getNodeValue();
            
            return new Luogo(lat, lng, name);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ReadingURL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadingURL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Meteo scaricaMeteo(Luogo posto) {
        try {
            URL url = WeatherURLHandler.generateURL(posto);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.0.1", 8080));
            URLConnection urlConnection = url.openConnection(proxy);
            InputStream in = urlConnection.getInputStream();
            
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xml = builder.parse(in);
            
            XPath xpath = XPathFactory.newInstance().newXPath();
            //prendo la temperatura attuale
            XPathExpression tempExpression= (XPathExpression) xpath.compile(CURRENT_TEMPERATURE);
            NodeList temps = (NodeList) tempExpression.evaluate(xml, XPathConstants.NODESET);
            String temp = temps.item(0).getNodeValue();
            
            //prendo la temperatura massima
            XPathExpression maxExpression = (XPathExpression) xpath.compile(MIN_TEMPERATURE);
            NodeList maxs = (NodeList) tempExpression.evaluate(xml, XPathConstants.NODESET);
            String max = maxs.item(0).getNodeValue();
            
            //prendo la temeperatura minima
            XPathExpression minExpression= (XPathExpression) xpath.compile(MAX_TEMPERATURE);
            NodeList mins = (NodeList) tempExpression.evaluate(xml, XPathConstants.NODESET);
            String min = mins.item(0).getNodeValue();
            
            return new Meteo(temp, max, min);
        } catch (Exception ex) {}
        return null;
    }
}
