import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.channels.ScatteringByteChannel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

// JAVA program to write JSON to a file

public class InventoryWriteJSON {

    public static void main(String[] args) throws FileNotFoundException {
        // wrap in try catch block
        try {
            // creating JSONObject
            JSONObject itemObject = new JSONObject();

            // putting data into JSONObject
            itemObject.put("inventoryItem", "Snow Shovel");
            itemObject.put("quantity", 3);
            itemObject.put("location", "maintenance yard");

            // location data, first create LinkedHashMap
            Map linkedHashMap = new LinkedHashMap(2);
            linkedHashMap.put("maintenanceShed", "A-1");
            linkedHashMap.put("condition", "used");

            // putting location data to JSONObject
            itemObject.put("onSitelocation", linkedHashMap);

            // stock information, first create JSONArray
            JSONArray inventoryArray = new JSONArray();

            linkedHashMap = new LinkedHashMap(2);
            linkedHashMap.put("item", "ice melt");
            linkedHashMap.put("quantityOnHand", 10);

            // add map to list
            inventoryArray.add(linkedHashMap);

            linkedHashMap = new LinkedHashMap(2);
            linkedHashMap.put("item", "ice melt");
            linkedHashMap.put("minimumWinterQuantity", 25);

            // adding map to list
            inventoryArray.add(linkedHashMap);

            // putting consumable items to JSONObject
            itemObject.put("consumableItems", inventoryArray);

            // writing JSON to file ItemInventoryJSON.json in cwd
            PrintWriter printWriter = new PrintWriter("ItemInventoryJSON.json");
            printWriter.write(itemObject.toJSONString());

            System.out.println("JSON Array " + inventoryArray);
            System.out.println("JSON Object " + itemObject);
            System.out.println(itemObject.toJSONString());

            printWriter.flush();
            printWriter.close();

        } catch (Throwable somethingWentWrong) {
            somethingWentWrong.printStackTrace();
        }
        }
}

// Java program to read JSON from a file

class InventoryReadJSON {
    public static void main(String[] args) throws Exception {
        // wrap in try catch block
        try {
            // parsing file ItemInventoryJSON.json
            Object parseObject = new JSONParser().parse(new FileReader("ItemInventoryJSON.json"));

            // typecast parseObject to JSONObject
            JSONObject itemObject = (JSONObject) parseObject;

            // getting inventoryItem and quantity
            String inventoryItem = (String) itemObject.get("inventoryItem");
            long quantity = (long) itemObject.get("quantity");

            System.out.println(inventoryItem);
            System.out.println(quantity);

            // get location
            String location = (String) itemObject.get("location");
            System.out.println(location);

            // get specific location
            Map onSiteLocation = ((Map) itemObject.get("onSiteLocation"));

            // iterating onSiteLocation Map using while loop
            Iterator iterator1 = onSiteLocation.entrySet().iterator();

            while (iterator1.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator1.next();
                System.out.println(pair.getKey() + " : " + pair.getValue());
            }

            // getting consumableItems
            JSONArray inventoryArray = (JSONArray) itemObject.get("consumableItems");

            // iterating consumableItems using while loop
            Iterator iterator2 = inventoryArray.iterator();

            while (iterator2.hasNext()) {
                iterator1 = ((Map) iterator2.next()).entrySet().iterator();

                while (iterator1.hasNext()) {
                    Map.Entry pair = (Map.Entry) iterator1.next();
                    System.out.println(pair.getKey() + " : " + pair.getValue());
                }
            }
        } catch (Throwable whatWentWrong) {
            whatWentWrong.printStackTrace();
        }
    }
}
