package co.edu.uptc.model;

import org.json.simple.JSONObject;

import co.edu.uptc.ejercicio1.models.UptcList;

public class JMObject {
    private UptcList<JMPair> pairs;

    public JMObject() {
        this.pairs = new UptcList<>();
    }

    public void put(String key, Object value) {
        this.pairs.add(new JMPair(key, value));
    }

    public Object get(String key) {
        for (JMPair pair : this.pairs) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        return null;
    }

    // Método para obtener un objeto JMObject interno
    public JMObject getInnerJMObject(String key) {
        JSONObject obj = (JSONObject) get(key);
        JMObject jmObject = new JMObject();

        for (Object entry : obj.keySet()) {
            key = (String) entry;
            Object value = obj.get(key);
            jmObject.put(key, value);
        }
        return jmObject;    
    }

    @Override
    public String toString() {
        StringBuilder json = new StringBuilder("{");
        for (int i = 0; i < this.pairs.size(); i++) {
            JMPair pair = this.pairs.get(i);
            json.append("\"").append(pair.getKey()).append("\":");
            json.append(toJSONString(pair.getValue()));
            if (i < this.pairs.size() - 1) {
                json.append(",");
            }
        }
        json.append("}");
        return json.toString();
    }

    private String toJSONString(Object obj) {
        if (obj instanceof String) {
            return "\"" + obj + "\"";
        } else {
            return obj.toString();
        }
    }

}