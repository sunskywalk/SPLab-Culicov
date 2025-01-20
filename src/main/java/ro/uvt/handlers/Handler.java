package ro.uvt.handlers;

public interface Handler {
    void setNext(Handler nextHandler);
    void handleRequest(String request);
}