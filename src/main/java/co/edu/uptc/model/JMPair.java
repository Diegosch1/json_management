package co.edu.uptc.model;

class JMPair {
    private String key;
    private Object value;

    public JMPair(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}