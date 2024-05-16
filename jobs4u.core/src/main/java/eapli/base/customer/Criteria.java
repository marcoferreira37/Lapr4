package eapli.base.customer;

public class Criteria<T> {
    String description;
    T value;
    Class<T> type;

    public Criteria(String description, Class<T> clazz) {
        this.description = description;
        this.type = clazz;
    }

    public String description() {
        return description;
    }

    public T value() {
        return value;
    }

    public void value(T value) {
        this.value = value;
    }

    public Class<T> getGenericType() {
        return type;
    }
}
