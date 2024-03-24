package com.intern.fooddelivery.service;

import com.intern.fooddelivery.model.Station;
import com.intern.fooddelivery.repository.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
public class ImportServiceImpl implements ImportService{

    @Autowired
    private StationRepo stationRepo;

    /**
     * method to read in data from https://www.ilmateenistus.ee/ilma_andmed/xml/observations.php and store it in station repository
     * @throws Exception
     */
    @Override
    public void importData() throws Exception {
        URL url = new URL("https://www.ilmateenistus.ee/ilma_andmed/xml/observations.php");

        //stations in the scope
        List<String> stations = Arrays.asList("Tallinn-Harku", "Tartu-Tõravere", "Pärnu");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        URLConnection connection = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        Document document = builder.parse(new InputSource(reader));
        document.getDocumentElement().normalize();

        //parse the epoch seconds to date and time value which can be later compared with request values
        Long timestamp = Long.valueOf(document.getDocumentElement().getAttribute("timestamp"));
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneOffset.UTC);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        NodeList stationNodes = document.getElementsByTagName("station");

        for (int i = 0; i < stationNodes.getLength(); i++) {
            Node stationNode = stationNodes.item(i);
            if (stationNode.getNodeType() == Node.ELEMENT_NODE){
                Element stationElement = (Element) stationNode;
                String stationName = stationElement.getElementsByTagName("name").item(0).getTextContent();
                if (stations.contains(stationName)){
                    String wmo = stationElement.getElementsByTagName("wmocode").item(0).getTextContent();
                    String temperature = stationElement.getElementsByTagName("airtemperature").item(0).getTextContent();
                    String windspeed = stationElement.getElementsByTagName("windspeed").item(0).getTextContent();
                    String phenomenon = stationElement.getElementsByTagName("phenomenon").item(0).getTextContent();

                    Station weather = new Station();

                    //Simplify station names for easier comparison and data search for the context of this application
                    if(stationName.equals("Tallinn-Harku")){
                        stationName = "Tallinn";
                    }
                    if(stationName.equals("Tartu-Tõravere")){
                        stationName = "Tartu";
                    }
                    weather.setStation(stationName);
                    weather.setPhenomenon(phenomenon);
                    weather.setTemperature(Double.parseDouble(temperature));
                    weather.setTimestamp(formattedDateTime);
                    weather.setWindspeed(Double.parseDouble(windspeed));
                    weather.setWmo(Long.parseLong(wmo));

                    stationRepo.save(weather);
                }
            }
        }
    }
}
