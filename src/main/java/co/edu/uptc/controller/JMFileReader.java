package co.edu.uptc.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import co.edu.uptc.model.JMArray;
import co.edu.uptc.model.JMObject;

public class JMFileReader {

    public static JSONObject convertStringToJSONObject(String jsonString) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static JMObject getJMObjectFromString(String jsonString) {
        JSONObject jsonObject = convertStringToJSONObject(jsonString);
        JMObject jmObject = new JMObject();

        for (Object entry : jsonObject.keySet()) {
            String key = (String) entry;
            Object value = jsonObject.get(key);

            jmObject.put(key, value);
        }

        return jmObject;
    }

    public static JSONArray convertStringToJSONArray(String jsonString) {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) parser.parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    public JMArray<JMObject> getJMArrayfromString(String jsonString) {
        JMArray<JMObject> array = new JMArray<>();
        JSONParser parser = new JSONParser();

        try {
            JSONArray jsonArray = (JSONArray) parser.parse(jsonString);

            for (Object obj : jsonArray) {
                JSONObject jsonObj = (JSONObject) obj;
                JMObject jmObject = new JMObject();

                for (Object key : jsonObj.keySet()) {
                    String k = (String) key;
                    Object v = jsonObj.get(k);
                    jmObject.put(k, v);
                }

                array.add(jmObject);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return array;
    }

    public JMObject parseJMObject(JSONObject jsonObject) {
        JMObject jmObject = new JMObject();

        for (Object entry : jsonObject.keySet()) {
            String key = (String) entry;
            Object value = jsonObject.get(key);
            jmObject.put(key, value);
        }

        return jmObject;
    }
}