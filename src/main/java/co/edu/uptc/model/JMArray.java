package co.edu.uptc.model;

import co.edu.uptc.ejercicio1.models.UptcList;

public class JMArray<T> {
    private UptcList<T> elements;

    public JMArray() {
        this.elements = new UptcList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T get(int index) {
        if (index >= 0 && index < this.elements.size()) {
            return this.elements.get(index);
        }
        return null;
    }

    public int length() {
        return this.elements.size();
    }

    @Override
    public String toString() {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < this.elements.size(); i++) {
            T element = this.elements.get(i);
            json.append(toJSONString(element));
            if (i < this.elements.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");
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
