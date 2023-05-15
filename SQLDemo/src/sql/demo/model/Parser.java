package sql.demo.model;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final String TAG_ID = "id";
    private static final String TAG_NUMBER = "number";
    private static final String TAG_LATITUDE = "latitude";
    private static final String TAG_LONGTUDE = "longtude";
    public Root parse() {
        Root root = new Root();
        Document doc;          //блок кода до 19 строки открывает файл для парсинга
        try {
            doc = buildDocument();
        } catch (Exception e) {
            System.out.println("Возникла ошибка при парсинге" + e.toString());
            return null;
        }

        Node rootNode = doc.getFirstChild();
        //System.out.println("AAA " + rootNode.getNodeName());
        NodeList rootChilds = rootNode.getChildNodes();
        Node busesNode = null;
        for (int i = 0; i < rootChilds.getLength(); i++) {
            if (rootChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            switch (rootChilds.item(i).getNodeName()) {
                case TAG_ID: {
                    busesNode = rootChilds.item(i);
                    break;
                }
            }
        }
        if (busesNode == null) {
            return null;
        }
        List<Bus> busesList = parsBuses(busesNode);
        root.setBuses(busesList);
        System.out.println(root.toString());
        return root;
        /*root.getBuses().stream().filter(buses -> {
            return buses.getNumber() == 2;
        }).forEach(buses -> {
            System.out.println("Buses " + buses.toString());
        });*/  //если хотите вытащить данные об автобусах с номером 2
    }
    private Document buildDocument() throws Exception {
        File file = new File("bus.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance(); //блок кода до 19 строки открывает файл для парсинга
        Document doc = null;
        return doc = dbf.newDocumentBuilder().parse(file);

    }

    private List<Bus> parsBuses(Node busesNode) {
        List<Bus> busesList = new ArrayList<>();
        NodeList busesChilds = busesNode.getChildNodes();
        for (int i = 0; i < busesChilds.getLength(); i++) {
            if (busesChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (!busesChilds.item(i).getNodeName().equals(TAG_NUMBER)) {
                continue;
            }
            NodeList elementChilds = busesChilds.item(i).getChildNodes();
            Bus bus = parsElement(busesChilds.item(i));
            busesList.add(bus);
        }
        return busesList;
    }
    private Bus parsElement(Node elementNode) {
        int id = 0;
        int number = 0;
        long latitude = 0;
        long longtude = 0;
        NodeList elementChilds = elementNode.getChildNodes();
        for (int j = 0; j < elementChilds.getLength(); j++) {
            if (elementChilds.item(j).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            switch (elementChilds.item(j).getNodeName()) {
                case TAG_LATITUDE: {
                    latitude = Long.parseLong(elementChilds.item(j).getTextContent());
                    break;
                }
                case TAG_LONGTUDE: {
                    longtude = Integer.valueOf(elementChilds.item(j).getTextContent());
                    break;
                }
            }
        }
        Bus bus = new Bus(45,6,3,3);
        return bus;
    }
}