package ro.uvt.models;

public interface Element {
    void print();

    default void add(Element element) {
        throw new UnsupportedOperationException("Not supported");
    }

    default void remove(Element element) {
        throw new UnsupportedOperationException("Not supported");
    }

    default Element get(int index) {
        throw new UnsupportedOperationException("Not supported");
    }
}