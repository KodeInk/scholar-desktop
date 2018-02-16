/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.config;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import main.java.com.scholar.desktop.config.entities.Engine;
import main.java.com.scholar.desktop.config.entities.SchoolConfig;
import main.java.com.scholar.desktop.config.entities.SchoolData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author mover 2/15/2018
 */
public class AppConfig {

    private File configuration_file;

    //todo: this is bound to change in the future to be read from the embedded database
    private String path = "C:\\scholar\\configuration\\scholar.xml";

    private static AppConfig instance;
    public AppConfig() {
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }


    public Document readFile(String filePath) throws ParserConfigurationException {
        try {
            configuration_file = new File(filePath);
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = builderFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(configuration_file);

            System.out.println("File Read");

            return doc;

        } catch (SAXException | IOException ex) {
            Logger.getLogger(AppConfig.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void convertSchoolData(Document doc) {
        NodeList config_list = doc.getElementsByTagName("SCHOLAR");
        System.out.println("-------------------------------");
        if (config_list.getLength() > 0) {
            for (int tmp = 0; tmp < config_list.getLength(); tmp++) {
                Node node = config_list.item(tmp);
                System.out.println("\nCurrent Element :" + node.getNodeName());
                Element eElement = (Element) node;

                SchoolConfig config = new SchoolConfig();
                config.setName(eElement.getAttribute("NAME"));

                Engine engine = new Engine();
                engine.setUrl(eElement.getAttribute("URL"));
                engine.setPort(eElement.getAttribute("PORT"));
                engine.setProtocol(eElement.getAttribute("PROTOCOL"));
            }
        }
    }
}
